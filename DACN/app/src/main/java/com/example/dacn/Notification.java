package com.example.dacn;

import java.sql.Timestamp;

public class Notification {
    private String titleID;

    public String getTitleID() {
        return titleID;
    }

    public void setTitleID(String titleID) {
        this.titleID = titleID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Notification(String titleID, String title, String content, String day) {
        this.titleID = titleID;
        this.title = title;
        this.content = content;
        this.day = day;
    }

    private String title;
    private String content;
    private String day;

}
