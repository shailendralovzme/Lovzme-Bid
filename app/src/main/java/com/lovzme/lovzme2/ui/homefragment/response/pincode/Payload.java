package com.lovzme.lovzme2.ui.homefragment.response.pincode;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class Payload implements Serializable {

    @SerializedName("message")
    @Expose
    public String message;
    @SerializedName("message1")
    @Expose
    public String message1;
    @SerializedName("pin_details")
    @Expose
    public PinDetails pinDetails;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage1() {
        return message1;
    }

    public void setMessage1(String message1) {
        this.message1 = message1;
    }

    public PinDetails getPinDetails() {
        return pinDetails;
    }

    public void setPinDetails(PinDetails pinDetails) {
        this.pinDetails = pinDetails;
    }
}
