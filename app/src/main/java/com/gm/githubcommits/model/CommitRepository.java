package com.gm.githubcommits.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ysanjeeva on 11/04/18.
 */

public class CommitRepository {
    @SerializedName("id")
    public long id;

    @SerializedName("name")
    public String name;

    @SerializedName("full_name")
    public String fullName;

    @SerializedName("owner")
    public CommitOwner owner;

    @SerializedName("private")
    public Boolean isPrivate;

    @SerializedName("html_url")
    public String htmlUrl;

    @SerializedName("description")
    public String description;

    @SerializedName("fork")
    public Boolean fork;

    @SerializedName("url")
    public String url;

    @SerializedName("forks_url")
    public String forksUrl;

    @SerializedName("keys_url")
    public String keysUrl;

    @SerializedName("collaborators_url")
    public String collaboratorsUrl;

    @SerializedName("teams_url")
    public String teamsUrl;

    @SerializedName("hooks_url")
    public String hooksUrl;

    @SerializedName("issue_events_url")
    public String issueEventsUrl;

    @SerializedName("events_url")
    public String eventsUrl;

    @SerializedName("assignees_url")
    public String assigneesUrl;

    @SerializedName("branches_url")
    public String branchesUrl;

    @SerializedName("tags_url")
    public String tagsUrl;

    @SerializedName("blobs_url")
    public String blobsUrl;

    @SerializedName("git_tags_url")
    public String gitTagsUrl;

    @SerializedName("git_refs_url")
    public String gitRefsUrl;

    @SerializedName("trees_url")
    public String treesUrl;

    @SerializedName("statuses_url")
    public String statusesUrl;

    @SerializedName("languagesUrl")
    public String languagesUrl;

    @SerializedName("stargazers_url")
    public String stargazersUrl;

    @SerializedName("contributors_url")
    public String contributorsUrl;

    @SerializedName("subscribers_url")
    public String subscribersUrl;

    @SerializedName("subscription_url")
    public String subscriptionUrl;

    @SerializedName("commits_url")
    public String commitsUrl;

    @SerializedName("git_commits_url")
    public String gitCommitsUrl;

    @SerializedName("comments_url")
    public String commentsUrl;

    @SerializedName("issue_comment_url")
    public String issueCommentUrl;

    @SerializedName("contents_url")
    public String contentsUrl;

    @SerializedName("compare_url")
    public String compareUrl;

    @SerializedName("merges_url")
    public String mergesUrl;

    @SerializedName("archive_url")
    public String archiveUrl;

    @SerializedName("downloads_url")
    public String downloadsUrl;

    @SerializedName("issues_url")
    public String issuesUrl;

    @SerializedName("pulls_url")
    public String pullsUrl;

    @SerializedName("milestones_url")
    public String milestonesUrl;

    @SerializedName("notifications_url")
    public String notificationsUrl;

    @SerializedName("labels_url")
    public String labelsUrl;

    @SerializedName("releases_url")
    public String releasesUrl;

    @SerializedName("deployments_url")
    public String deploymentsUrl;


}
