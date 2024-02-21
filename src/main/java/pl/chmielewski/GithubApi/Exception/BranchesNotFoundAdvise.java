package pl.chmielewski.GithubApi.Exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class BranchesNotFoundAdvise {

    @ResponseBody
    @ExceptionHandler(BranchesNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String BranchesNotFoundAdviseHandler(BranchesNotFoundException branchesNotFoundException) {
        return branchesNotFoundException.getMessage();
    }
}
