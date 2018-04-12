package com.gm.githubcommits.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by ysanjeeva on 11/04/18.
 */

public class GitHubResponce {
    @SerializedName("total_count")
    public long totalCount;

    @SerializedName("incomplete_results")
    public boolean incompleteResults;

    @SerializedName("items")
    public List<GitHubRepository> items;

    public long getTotalCount() {
        return totalCount;
    }

    public boolean isIncompleteResults() {
        return incompleteResults;
    }

    public List<GitHubRepository> getItems() {
        return items;
    }
}
