package pl.chmielewski.GithubApi.Model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "login", "id", "node_id", "avatar_url", "gravatar_id",
        "url", "html_url", "followers_url", "following_url", "gists_url",
        "starred_url", "subscriptions_url", "organizations_url", "repos_url",
        "events_url", "received_events_url", "type", "site_admin", "name",
        "company", "blog", "location", "email", "hireable", "bio",
        "twitter_username", "public_repos", "public_gists", "followers",
        "following", "created_at", "updated_at"
})
public record GithubUser(
        @JsonProperty("login") String login,
        @JsonProperty("id") int id,
        @JsonProperty("node_id") String nodeId,
        @JsonProperty("avatar_url") String avatarUrl,
        @JsonProperty("gravatar_id") String gravatarId,
        @JsonProperty("url") String url,
        @JsonProperty("html_url") String htmlUrl,
        @JsonProperty("followers_url") String followersUrl,
        @JsonProperty("following_url") String followingUrl,
        @JsonProperty("gists_url") String gistsUrl,
        @JsonProperty("starred_url") String starredUrl,
        @JsonProperty("subscriptions_url") String subscriptionsUrl,
        @JsonProperty("organizations_url") String organizationsUrl,
        @JsonProperty("repos_url") String reposUrl,
        @JsonProperty("events_url") String eventsUrl,
        @JsonProperty("received_events_url") String receivedEventsUrl,
        @JsonProperty("type") String type,
        @JsonProperty("site_admin") boolean siteAdmin,
        @JsonProperty("name") String name,
        @JsonProperty("company") String company,
        @JsonProperty("blog") String blog,
        @JsonProperty("location") String location,
        @JsonProperty("email") String email,
        @JsonProperty("hireable") String hireable,
        @JsonProperty("bio") String bio,
        @JsonProperty("twitter_username") String twitterUsername,
        @JsonProperty("public_repos") int publicRepos,
        @JsonProperty("public_gists") int publicGists,
        @JsonProperty("followers") int followers,
        @JsonProperty("following") int following,
        @JsonProperty("created_at") String createdAt,
        @JsonProperty("updated_at") String updatedAt
) {
}
