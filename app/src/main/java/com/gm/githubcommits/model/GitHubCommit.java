package com.gm.githubcommits.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by ysanjeeva on 11/04/18.
 */

public class GitHubCommit {
    @SerializedName("url")
    public String url;

    @SerializedName("sha")
    public String sha;

    @SerializedName("html_url")
    public String htmlUrl;

    @SerializedName("comments_url")
    public String commentsUrl;

    @SerializedName("commit")
    public Commit commit;

    @SerializedName("author")
    public CommitAuthor author;

    @SerializedName("committer")
    public CommitCommitter committer;

    @SerializedName("parents")
    public List<Parent> parents;

    @SerializedName("repository")
    public CommitRepository repository;

    @SerializedName("score")
    public double score;
}
