package com.gm.githubcommits.api;

/**
 * Created by ysanjeeva on 11/04/18.
 */

import com.gm.githubcommits.model.GitHubResponce;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GitHubController {
    public Call<GitHubResponce> start(String queryFilter, String sortType, String orderType,
                                      int pageLimit) {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        GitHubApi gitHubAPI = retrofit.create(GitHubApi.class);
        return gitHubAPI.getRepositories(queryFilter, sortType, orderType, pageLimit);
    }
}
