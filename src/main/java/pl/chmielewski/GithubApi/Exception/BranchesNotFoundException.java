package pl.chmielewski.GithubApi.Exception;

public class BranchesNotFoundException extends RuntimeException{

    public BranchesNotFoundException(String repo) {
        super("Could not find branches for '" + repo + "' repository");
    }
}
