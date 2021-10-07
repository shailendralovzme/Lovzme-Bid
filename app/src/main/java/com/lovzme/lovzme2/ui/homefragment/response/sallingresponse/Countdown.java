package com.lovzme.lovzme2.ui.homefragment.response.sallingresponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class Countdown implements Serializable {
    @SerializedName("hasError")
    @Expose
    public Boolean hasError;
    @SerializedName("from")
    @Expose
    public String from;
    @SerializedName("to")
    @Expose
    public String to;
    @SerializedName("current_time")
    @Expose
    public String currentTime;
    @SerializedName("remaining_datetime")
    @Expose
    public String remainingDatetime;
    @SerializedName("timer")
    @Expose
    public SallingTimer sallingTimer;

    public Boolean getHasError() {
        return hasError;
    }

    public void setHasError(Boolean hasError) {
        this.hasError = hasError;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }

    public String getRemainingDatetime() {
        return remainingDatetime;
    }

    public void setRemainingDatetime(String remainingDatetime) {
        this.remainingDatetime = remainingDatetime;
    }

    public SallingTimer getSallingTimer() {
        return sallingTimer;
    }

    public void setSallingTimer(SallingTimer sallingTimer) {
        this.sallingTimer = sallingTimer;
    }
}
