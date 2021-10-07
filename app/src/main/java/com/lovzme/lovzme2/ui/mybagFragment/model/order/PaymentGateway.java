package com.lovzme.lovzme2.ui.mybagFragment.model.order;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class PaymentGateway implements Serializable {
    @SerializedName("isPrepaid")
    @Expose
    public Boolean isPrepaid;
    @SerializedName("razorpay")
    @Expose
    public Razorpay razorpay;

    public Boolean getPrepaid() {
        return isPrepaid;
    }

    public void setPrepaid(Boolean prepaid) {
        isPrepaid = prepaid;
    }

    public Razorpay getRazorpay() {
        return razorpay;
    }

    public void setRazorpay(Razorpay razorpay) {
        this.razorpay = razorpay;
    }
}
