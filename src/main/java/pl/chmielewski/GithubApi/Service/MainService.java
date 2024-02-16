package pl.chmielewski.GithubApi.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.chmielewski.GithubApi.Model.GithubRepo;

@Service
public class MainService {

    RestTemplate restTemplate = new RestTemplate();

    public MainService(String username) {
        GithubRepo[] repositories = restTemplate.getForObject("https://api.github.com/users/" + username + "/repos", GithubRepo[].class);

        assert repositories != null;
        for (GithubRepo repository : repositories) {
            repository.getOwner();
        }
    }
}
