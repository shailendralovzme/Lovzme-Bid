package com.lovzme.lovzme2.ui.profileFragment.addressmodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class UpdateAddressData {
    @SerializedName("success")
    @Expose
    public Boolean success;
    @SerializedName("payload")
    @Expose
    public Object payload;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Object getPayload() {
        return payload;
    }

    public void setPayload(Object payload) {
        this.payload = payload;
    }
}
