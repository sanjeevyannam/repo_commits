package com.gm.githubcommits.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ysanjeeva on 11/04/18.
 */

public class GitHubRepository {
    @SerializedName("id")
    public long id;

    @SerializedName("name")
    public String name;

    @SerializedName("full_name")
    public String fullName;

    @SerializedName("owner")
    public GitHubUser owner;

    @SerializedName("private")
    public boolean isPrivate;

    @SerializedName("html_url")
    public String htmlUrl;

    @SerializedName("description")
    public String description;

    @SerializedName("fork")
    public boolean fork;

    @SerializedName("url")
    public String url;

    @SerializedName("forks_url")
    public String forksUrl;

    @SerializedName("keys_url")
    public String keysUrl;

    @SerializedName("collaborators_url")
    public String collaboratorsUrl;

    @SerializedName("teams_url")
    public String teamsUrl;

    @SerializedName("hooks_url")
    public String hooksUrl;

    @SerializedName("issue_events_url")
    public String issueEventsUrl;

    @SerializedName("events_url")
    public String eventsUrl;

    @SerializedName("assignees_url")
    public String assigneesUrl;

    @SerializedName("branches_url")
    public String branchesUrl;

    @SerializedName("tags_url")
    public String tagsUrl;

    @SerializedName("blobs_url")
    public String blobsUrl;

    @SerializedName("git_tags_url")
    public String gitTagsUrl;

    @SerializedName("git_refs_url")
    public String gitRefsUrl;

    @SerializedName("trees_url")
    public String treesUrl;

    @SerializedName("statuses_url")
    public String statusesUrl;

    @SerializedName("languages_url")
    public String languagesUrl;

    @SerializedName("stargazers_url")
    public String stargazersUrl;

    @SerializedName("contributors_url")
    public String contributorsUrl;

    @SerializedName("subscribers_url")
    public String subscribersUrl;

    @SerializedName("subscription_url")
    public String subscriptionUrl;

    @SerializedName("commits_url")
    public String commitsUrl;

    @SerializedName("git_commits_url")
    public String gitCommitsUrl;

    @SerializedName("comments_url")
    public String commentsUrl;

    @SerializedName("issue_comment_url")
    public String issueCommentUrl;

    @SerializedName("contents_url")
    public String contentsUrl;

    @SerializedName("compare_url")
    public String compareUrl;

    @SerializedName("merges_url")
    public String mergesUrl;


    @SerializedName("archive_url")
    public String archiveUrl;

    @SerializedName("downloads_url")
    public String downloadsUrl;

    @SerializedName("issues_url")
    public String issuesUrl;


    @SerializedName("pulls_url")
    public String pullsUrl;

    @SerializedName("milestones_url")
    public String milestonesUrl;

    @SerializedName("notifications_url")
    public String notificationsUrl;

    @SerializedName("labels_url")
    public String labelsUrl;

    @SerializedName("releases_url")
    public String releasesUrl;

    @SerializedName("deployments_url")
    public String deploymentsUrl;

    @SerializedName("created_at")
    public String createdAt;

    @SerializedName("updated_at")
    public String updatedAt;

    @SerializedName("pushed_at")
    public String pushedAt;

    @SerializedName("git_url")
    public String gitUrl;


    @SerializedName("ssh_url")
    public String sshUrl;

    @SerializedName("clone_url")
    public String cloneUrl;

    @SerializedName("svn_url")
    public String svnUrl;

    @SerializedName("homepage")
    public String homepage;

    @SerializedName("size")
    public int size;

    @SerializedName("stargazers_count")
    public int stargazersCount;


    @SerializedName("watchers_count")
    public int watchersCount;

    @SerializedName("language")
    public String language;

    @SerializedName("has_issues")
    public boolean hasIssues;

    @SerializedName("has_downloads")
    public boolean hasDownloads;

    @SerializedName("has_wiki")
    public boolean hasWiki;

    @SerializedName("has_pages")
    public boolean hasPages;

    @SerializedName("forks_count")
    public int forksCount;

    @SerializedName("mirror_url")
    public String mirrorUrl;

    @SerializedName("archived")
    public boolean archived;

    @SerializedName("open_issues_count")
    public int openIssuesCount;

    @SerializedName("license")
    public GitHubLicense license;

    @SerializedName("forks")
    public int forks;

    @SerializedName("open_issues")
    public int openIssues;

    @SerializedName("watchers")
    public int watchers;

    @SerializedName("default_branch")
    public String defaultBranch;

    @SerializedName("score")
    public double score;


    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFullName() {
        return fullName;
    }

    public GitHubUser getOwner() {
        return owner;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public String getDescription() {
        return description;
    }

    public boolean isFork() {
        return fork;
    }

    public String getUrl() {
        return url;
    }

    public String getForksUrl() {
        return forksUrl;
    }

    public String getKeysUrl() {
        return keysUrl;
    }

    public String getCollaboratorsUrl() {
        return collaboratorsUrl;
    }

    public String getTeamsUrl() {
        return teamsUrl;
    }

    public String getHooksUrl() {
        return hooksUrl;
    }

    public String getIssueEventsUrl() {
        return issueEventsUrl;
    }

    public String getEventsUrl() {
        return eventsUrl;
    }

    public String getAssigneesUrl() {
        return assigneesUrl;
    }

    public String getBranchesUrl() {
        return branchesUrl;
    }

    public String getTagsUrl() {
        return tagsUrl;
    }

    public String getBlobsUrl() {
        return blobsUrl;
    }

    public String getGitTagsUrl() {
        return gitTagsUrl;
    }

    public String getGitRefsUrl() {
        return gitRefsUrl;
    }

    public String getTreesUrl() {
        return treesUrl;
    }

    public String getStatusesUrl() {
        return statusesUrl;
    }

    public String getLanguagesUrl() {
        return languagesUrl;
    }

    public String getStargazersUrl() {
        return stargazersUrl;
    }

    public String getContributorsUrl() {
        return contributorsUrl;
    }

    public String getSubscribersUrl() {
        return subscribersUrl;
    }

    public String getSubscriptionUrl() {
        return subscriptionUrl;
    }

    public String getCommitsUrl() {
        return commitsUrl;
    }

    public String getGitCommitsUrl() {
        return gitCommitsUrl;
    }

    public String getCommentsUrl() {
        return commentsUrl;
    }

    public String getIssueCommentUrl() {
        return issueCommentUrl;
    }

    public String getContentsUrl() {
        return contentsUrl;
    }

    public String getCompareUrl() {
        return compareUrl;
    }

    public String getMergesUrl() {
        return mergesUrl;
    }

    public String getArchiveUrl() {
        return archiveUrl;
    }

    public String getDownloadsUrl() {
        return downloadsUrl;
    }

    public String getIssuesUrl() {
        return issuesUrl;
    }

    public String getPullsUrl() {
        return pullsUrl;
    }

    public String getMilestonesUrl() {
        return milestonesUrl;
    }

    public String getNotificationsUrl() {
        return notificationsUrl;
    }

    public String getLabelsUrl() {
        return labelsUrl;
    }

    public String getReleasesUrl() {
        return releasesUrl;
    }

    public String getDeploymentsUrl() {
        return deploymentsUrl;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public String getPushedAt() {
        return pushedAt;
    }

    public String getGitUrl() {
        return gitUrl;
    }

    public String getSshUrl() {
        return sshUrl;
    }

    public String getCloneUrl() {
        return cloneUrl;
    }

    public String getSvnUrl() {
        return svnUrl;
    }

    public String getHomepage() {
        return homepage;
    }

    public int getSize() {
        return size;
    }

    public int getStargazersCount() {
        return stargazersCount;
    }

    public int getWatchersCount() {
        return watchersCount;
    }

    public String getLanguage() {
        return language;
    }

    public boolean isHasIssues() {
        return hasIssues;
    }

    public boolean isHasDownloads() {
        return hasDownloads;
    }

    public boolean isHasWiki() {
        return hasWiki;
    }

    public boolean isHasPages() {
        return hasPages;
    }

    public int getForksCount() {
        return forksCount;
    }

    public String getMirrorUrl() {
        return mirrorUrl;
    }

    public boolean isArchived() {
        return archived;
    }

    public int getOpenIssuesCount() {
        return openIssuesCount;
    }

    public GitHubLicense getLicense() {
        return license;
    }

    public int getForks() {
        return forks;
    }

    public int getOpenIssues() {
        return openIssues;
    }

    public int getWatchers() {
        return watchers;
    }

    public String getDefaultBranch() {
        return defaultBranch;
    }

    public double getScore() {
        return score;
    }
}
