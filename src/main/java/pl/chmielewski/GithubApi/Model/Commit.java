package pl.chmielewski.GithubApi.Model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


public record Commit(
        String sha,
        String url
) {
}
