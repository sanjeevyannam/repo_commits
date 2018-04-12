package com.gm.githubcommits.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ysanjeeva on 11/04/18.
 */

public class Tree {
    @SerializedName("url")
    public String url;

    @SerializedName("sha")
    public String sha;
}
