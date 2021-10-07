package com.lovzme.lovzme2.ui.homefragment.response.productdetaiils;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class ProductDetails implements Serializable {
    @SerializedName("success")
    @Expose
    public Boolean success;
    @SerializedName("message")
    @Expose
    public String message;
    @SerializedName("payload")
    @Expose
    public ProductDetailsPayload payload;

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

    public ProductDetailsPayload getPayload() {
        return payload;
    }

    public void setPayload(ProductDetailsPayload payload) {
        this.payload = payload;
    }
}
