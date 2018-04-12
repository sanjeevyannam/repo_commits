package com.gm.githubcommits.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ysanjeeva on 11/04/18.
 */

public class Parent {
    @SerializedName("url")
    public String url;

    @SerializedName("html_url")
    public String htmlUrl;

    @SerializedName("sha")
    public String sha;
}
