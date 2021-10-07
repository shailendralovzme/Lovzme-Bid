package com.lovzme.lovzme2.ui.profileFragment.addressmodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class DeleteAddressData {
    @SerializedName("success")
    @Expose
    public Boolean success;
    @SerializedName("code")
    @Expose
    public Integer code;
    @SerializedName("payload")
    @Expose
    public Payload payload;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Payload getPayload() {
        return payload;
    }

    public void setPayload(Payload payload) {
        this.payload = payload;
    }
    @Generated("jsonschema2pojo")
    public class Payload {

        @SerializedName("message")
        @Expose
        public String message;

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
