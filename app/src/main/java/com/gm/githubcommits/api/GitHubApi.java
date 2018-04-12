package com.gm.githubcommits.api;

/**
 * Created by ysanjeeva on 11/04/18.
 */

import com.gm.githubcommits.model.GitHubCommitResponce;
import com.gm.githubcommits.model.GitHubResponce;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GitHubApi {

    @GET("/search/repositories")
    Call<GitHubResponce> getRepositories(@Query("q") String query,
                                         @Query("sort") String sort,
                                         @Query("order") String order,
                                         @Query("per_page") int pageLimit);

    @GET("/search/commits")
    Call<GitHubCommitResponce> getCommits(@Query("q") String query,
                                               @Query("sort") String sort,
                                               @Query("order") String order);

    @GET("/repos/{owner}/{repo}/commits")
    Call<GitHubCommitResponce> getRepCommits(@Query("sha") String sha,
                                             @Path("repo") String repo,
                                             @Path("owner") String owner,
                                             @Query("since") int since,
                                             @Query("until") int until);
}