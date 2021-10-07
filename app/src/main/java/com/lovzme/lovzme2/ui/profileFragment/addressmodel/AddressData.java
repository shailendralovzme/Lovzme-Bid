package com.lovzme.lovzme2.ui.profileFragment.addressmodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class AddressData {
    @SerializedName("success")
    @Expose
    public Boolean success;
    @SerializedName("payload")
    @Expose
    public AddressPayload payload;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public AddressPayload getPayload() {
        return payload;
    }

    public void setPayload(AddressPayload payload) {
        this.payload = payload;
    }
}
