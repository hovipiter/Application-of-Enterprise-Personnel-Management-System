package com.example.dacn;

import android.net.ParseException;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Project {
    private String Projecttitle;


    public String getProjecttitle() {
        return Projecttitle;
    }

    public void setProjecttitle(String projecttitle) {
        Projecttitle = projecttitle;
    }


    public String getTextviewTimeleft() {
        return textviewTimeleft;
    }

    public void setTextviewTimeleft(String textviewTimeleft) {
        this.textviewTimeleft = textviewTimeleft;
    }

    public String getGetTimeleft() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        try {
            Date startDate = null;
            try {
                startDate = sdf.parse(this.startday);
            } catch (java.text.ParseException e) {
                throw new RuntimeException(e);
            }
            Date endDate = null;
            try {
                endDate = sdf.parse(this.endday);
            } catch (java.text.ParseException e) {
                throw new RuntimeException(e);
            }

            long diff = endDate.getTime() - startDate.getTime();
            long daysLeft = diff / (1000 * 60 * 60 * 24);

            return String.valueOf(daysLeft) + " days left";
        } catch (ParseException e) {
            e.printStackTrace();
            return "Error calculating time: " + e.getMessage();
        }
    }


    public void setGetTimeleft(String getTimeleft) {
        this.getTimeleft = getTimeleft;
    }

    private String textviewTimeleft;
    private String getTimeleft;

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }

    private String progress;

    public String getStartday() {
        return startday;
    }

    public void setStartday(String startday) {
        this.startday = startday;
    }

    public String getEndday() {
        return endday;
    }

    public void setEndday(String endday) {
        this.endday = endday;
    }

    private String startday;
    private String endday;


}
