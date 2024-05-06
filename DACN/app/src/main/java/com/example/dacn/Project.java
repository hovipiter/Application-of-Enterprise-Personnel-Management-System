package com.example.dacn;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class Project {
    private String Projecttitle;
    private String Projectcontent;

    public String getProjecttitle() {
        return Projecttitle;
    }

    public void setProjecttitle(String projecttitle) {
        Projecttitle = projecttitle;
    }

    public String getProjectcontent() {
        return Projectcontent;
    }

    public void setProjectcontent(String projectcontent) {
        Projectcontent = projectcontent;
    }

    public String getTextviewTimeleft() {
        return textviewTimeleft;
    }

    public void setTextviewTimeleft(String textviewTimeleft) {
        this.textviewTimeleft = textviewTimeleft;
    }

    public String getGetTimeleft() {
        return getTimeleft;
    }

    public void setGetTimeleft(String getTimeleft) {
        this.getTimeleft = getTimeleft;
    }

    private String textviewTimeleft;
    private String getTimeleft;

    public Project(String projecttitle, String projectcontent, String textviewTimeleft, String getTimeleft) {
        Projecttitle = projecttitle;
        Projectcontent = projectcontent;
        this.textviewTimeleft = textviewTimeleft;
        this.getTimeleft = getTimeleft;
    }


}
