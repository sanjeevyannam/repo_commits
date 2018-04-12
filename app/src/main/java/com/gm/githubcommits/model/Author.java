package com.gm.githubcommits.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ysanjeeva on 11/04/18.
 */

public class Author {
    @SerializedName("date")
    public String date;

    @SerializedName("name")
    public String name;

    @SerializedName("email")
    public String email;
}
