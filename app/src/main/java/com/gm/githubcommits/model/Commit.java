package com.gm.githubcommits.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ysanjeeva on 11/04/18.
 */

public class Commit {
    @SerializedName("url")
    public String url;

    @SerializedName("author")
    public Author author;

    @SerializedName("committer")
    public Committer committer;

    @SerializedName("message")
    public String message;

    @SerializedName("tree")
    public Tree tree;

    @SerializedName("comment_count")
    public int comment_count;
}
