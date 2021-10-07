package com.lovzme.lovzme2.ui.homefragment.response.productdetaiils;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import javax.annotation.Generated;
@Generated("jsonschema2pojo")
public class ProductTimer implements Serializable {
        @SerializedName("remaining_days")
        @Expose
        public String remainingDays;
        @SerializedName("remaining_time")
        @Expose
        public String remainingTime;
        @SerializedName("remaining_hours")
        @Expose
        public String remainingHours;
        @SerializedName("remaining_minute")
        @Expose
        public String remainingMinute;
        @SerializedName("remaining_seconds")
        @Expose
        public String remainingSeconds;

    public String getRemainingDays() {
        return remainingDays;
    }

    public void setRemainingDays(String remainingDays) {
        this.remainingDays = remainingDays;
    }

    public String getRemainingTime() {
        return remainingTime;
    }

    public void setRemainingTime(String remainingTime) {
        this.remainingTime = remainingTime;
    }

    public String getRemainingHours() {
        return remainingHours;
    }

    public void setRemainingHours(String remainingHours) {
        this.remainingHours = remainingHours;
    }

    public String getRemainingMinute() {
        return remainingMinute;
    }

    public void setRemainingMinute(String remainingMinute) {
        this.remainingMinute = remainingMinute;
    }

    public String getRemainingSeconds() {
        return remainingSeconds;
    }

    public void setRemainingSeconds(String remainingSeconds) {
        this.remainingSeconds = remainingSeconds;
    }
}
