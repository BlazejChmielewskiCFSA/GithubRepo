package pl.chmielewski.GithubApi.Service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import pl.chmielewski.GithubApi.Exception.UserNotFoundException;
import pl.chmielewski.GithubApi.Model.GitHubUser;

@Service
public class MainService {

    public GitHubUser getUsername(String username) {
        RestTemplate restTemplate = new RestTemplate();
        String apiUrl = "https://api.github.com/users/" + username;
        try {
            GitHubUser user = restTemplate.getForObject(apiUrl, GitHubUser.class);
            return ResponseEntity.ok(user).getBody();
        } catch (
                HttpClientErrorException.NotFound e) {
            throw new UserNotFoundException(username);
        }
    }
}
