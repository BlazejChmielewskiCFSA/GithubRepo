package pl.chmielewski.GithubApi.Model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "name", "commit", "protected"
})
public record Branch(
        @JsonProperty("name") String name,
        @JsonProperty("commit") Commit commit,
        @JsonProperty("protected") boolean isProtected
) {
}
