package pl.chmielewski.GithubApi.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import pl.chmielewski.GithubApi.Exception.BranchesNotFoundException;
import pl.chmielewski.GithubApi.Exception.RepositoriesNotFoundException;
import pl.chmielewski.GithubApi.Exception.UserNotFoundException;
import pl.chmielewski.GithubApi.Model.Branch;
import pl.chmielewski.GithubApi.Model.Commit;
import pl.chmielewski.GithubApi.Model.GithubRepository;
import pl.chmielewski.GithubApi.Model.GithubUser;

import java.util.Arrays;
import java.util.Objects;

@Service
public class MainService {

    private static final String USER_AGENT = "blazejchmielewski";

    public String buildJSON(String username) {
        GithubUser user = getUsername(username);
        GithubRepository[] repositories = getGithubUserRepos(user);

        ObjectMapper mapper = new ObjectMapper();
        ObjectNode rootNode = mapper.createObjectNode();

        ArrayNode reposArrayNode = mapper.createArrayNode();
        for (GithubRepository repository : repositories) {
            ObjectNode repoNode = mapper.createObjectNode();
            repoNode.put("repo_name", repository.name());

            ArrayNode branchesArrayNode = mapper.createArrayNode();
            Branch[] branches = getRepositoryBranches(repository);
            for (Branch branch : branches) {
                ObjectNode branchNode = mapper.createObjectNode();
                branchNode.put("branch_name", branch.name());

                Commit commit = branch.commit();
                if (commit != null) {
                    ObjectNode commitNode = mapper.createObjectNode();
                    commitNode.put("sha", commit.sha());
                    branchNode.set("commit", commitNode);
                }
                branchesArrayNode.add(branchNode);
            }
            repoNode.set("branches", branchesArrayNode);
            reposArrayNode.add(repoNode);
        }
        rootNode.set("repositories", reposArrayNode);

        try {
            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(rootNode);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public GithubUser getUsername(String username) {
        RestTemplate restTemplate = new RestTemplate();
        String apiUrl = "https://api.github.com/users/" + username;
        try {
            GithubUser githubUser = restTemplate.getForObject(apiUrl, GithubUser.class);
            getGithubUserRepos(githubUser);
            return ResponseEntity.ok(githubUser).getBody();
        } catch (HttpClientErrorException.NotFound e) {
            throw new UserNotFoundException(username);
        }
    }

    public GithubRepository[] getGithubUserRepos(GithubUser user) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            String apiUrl = "https://api.github.com/users/" + user.login() + "/repos";
            GithubRepository[] githubRepository = restTemplate.getForObject(apiUrl, GithubRepository[].class);
            return Arrays.stream(Objects.requireNonNull(githubRepository)).filter(n -> !n.fork()).toArray(GithubRepository[]::new);
        } catch (HttpClientErrorException.NotFound e) {
            throw new RepositoriesNotFoundException(user.login());
        }
    }

    public Branch[] getRepositoryBranches(GithubRepository gitHubRepository) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            String apiUrl = "https://api.github.com/repos/blazejchmielewski/" + gitHubRepository.name() + "/branches";
            return restTemplate.getForObject(apiUrl, Branch[].class);
        } catch (HttpClientErrorException.NotFound e) {
            throw new BranchesNotFoundException(gitHubRepository.name());
        }
    }
}
