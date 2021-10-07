package com.lovzme.lovzme2.ui.wishlist.model.wishlist;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")

public class Wishlistresponse {
    @SerializedName("success")
    @Expose
    public Boolean success;
    @SerializedName("message")
    @Expose
    public String message;
    @SerializedName("payload")
    @Expose
    public Payload payload;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Payload getPayload() {
        return payload;
    }

    public void setPayload(Payload payload) {
        this.payload = payload;
    }
}
