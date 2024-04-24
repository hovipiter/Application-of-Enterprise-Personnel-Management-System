package com.example.dacn;

import android.widget.ImageButton;

public class Forum {
    private String forumTitle;

    public String getForumTitle() {
        return forumTitle;
    }

    public void setForumTitle(String forumTitle) {
        this.forumTitle = forumTitle;
    }

    public String getForumContent() {
        return forumContent;
    }

    public void setForumContent(String forumContent) {
        this.forumContent = forumContent;
    }

    public String getForumLike() {
        return forumLike;
    }

    public void setForumLike(String forumLike) {
        this.forumLike = forumLike;
    }

    public String getForumComment() {
        return forumComment;
    }

    public void setForumComment(String forumComment) {
        this.forumComment = forumComment;
    }

    public String getForumShare() {
        return forumShare;
    }

    public void setForumShare(String forumShare) {
        this.forumShare = forumShare;
    }

    public int getIDimgbtnForumLike() {
        return IDimgbtnForumLike;
    }

    public void setIDimgbtnForumLike(int IDimgbtnForumLike) {
        this.IDimgbtnForumLike = IDimgbtnForumLike;
    }

    public int getIDimgbtnForumComment() {
        return IDimgbtnForumComment;
    }

    public void setIDimgbtnForumComment(int IDimgbtnForumComment) {
        this.IDimgbtnForumComment = IDimgbtnForumComment;
    }

    public int getIDimgbtnForumShare() {
        return IDimgbtnForumShare;
    }

    public void setIDimgbtnForumShare(int IDimgbtnForumShare) {
        this.IDimgbtnForumShare = IDimgbtnForumShare;
    }

    public String forumContent;

    public Forum(String forumTitle, String forumContent, int IDimgbtnForumLike,String forumLike, int IDimgbtnForumComment, String forumComment,int IDimgbtnForumShare, String forumShare) {
        this.forumTitle = forumTitle;
        this.forumContent = forumContent;
        this.forumLike = forumLike;
        this.forumComment = forumComment;
        this.forumShare = forumShare;
        this.IDimgbtnForumLike = IDimgbtnForumLike;
        this.IDimgbtnForumComment = IDimgbtnForumComment;
        this.IDimgbtnForumShare = IDimgbtnForumShare;
    }

    public String forumLike;
    public String forumComment;
    public String forumShare;
    public int IDimgbtnForumLike;
    public int IDimgbtnForumComment;
    public int IDimgbtnForumShare;

}
