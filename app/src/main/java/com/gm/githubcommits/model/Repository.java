package com.gm.githubcommits.model;

/**
 * Created by ysanjeeva on 11/04/18.
 */

public class Repository {
    private String name;
    private String commit;
    private String commitMsg;

    public Repository(String name, String commit, String commitMsg) {
        this.name = name;
        this.commit = commit;
        this.commitMsg = commitMsg;
    }

    public String getName() {
        return name;
    }

    public String getCommit() {
        return commit;
    }

    public String getCommitMsg() {
        return commitMsg;
    }
}
