package pl.chmielewski.GithubApi.Exception;

public class RepositoriesNotFoundException extends RuntimeException {

    public RepositoriesNotFoundException(String username) {
        super("User " + username + " does not have any repositories with no forks");
    }
}
