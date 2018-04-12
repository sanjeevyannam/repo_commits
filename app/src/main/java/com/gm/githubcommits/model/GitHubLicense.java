package com.gm.githubcommits.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ysanjeeva on 11/04/18.
 */

public class GitHubLicense {
    @SerializedName("key")
    public String key;

    @SerializedName("name")
    public String name;

    @SerializedName("default_branch")
    public String defaultBranch;

    @SerializedName("spdx_id")
    public String spdxId;

    @SerializedName("url")
    public String url;


}
