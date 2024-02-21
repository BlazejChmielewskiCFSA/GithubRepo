package pl.chmielewski.GithubApi.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.chmielewski.GithubApi.Model.GithubUser;
import pl.chmielewski.GithubApi.Service.MainService;


@RestController
@RequestMapping("/api")
public class RestApi {

    private final MainService mainService;

    public RestApi(MainService mainService) {
        this.mainService = mainService;
    }

    @GetMapping("/test")
    public GithubUser getUser(@RequestParam String username) {
        return mainService.getUsername(username);
    }

    @GetMapping("/user")
    public String buildJSON(@RequestParam String username) {
        return mainService.buildJSON(username);
    }
}
