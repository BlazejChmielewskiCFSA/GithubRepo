package pl.chmielewski.GithubApi.Exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String username) {
        super("User with username " + username + " does not exist");
    }
}
