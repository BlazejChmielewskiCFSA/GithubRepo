package pl.chmielewski.GithubApi.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.chmielewski.GithubApi.Model.GitHubUser;
import pl.chmielewski.GithubApi.Service.MainService;


@RestController
@RequestMapping("/api")
public class RestApi {

    private final MainService mainService;

    public RestApi(MainService mainService) {
        this.mainService = mainService;
    }

    @GetMapping("/user")
    public GitHubUser getUser(@RequestParam String username) {
        return mainService.getUsername(username);
    }
}
