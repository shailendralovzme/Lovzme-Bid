package com.lovzme.lovzme2.ui.mybagFragment.model.order;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class SuccessPaymentGateway {
    @SerializedName("razorpay")
    @Expose
    public SuccessRazorpay razorpay;

    public SuccessPaymentGateway(SuccessRazorpay razorpay) {
        this.razorpay = razorpay;
    }

    public SuccessRazorpay getRazorpay() {
        return razorpay;
    }

    public void setRazorpay(SuccessRazorpay razorpay) {
        this.razorpay = razorpay;
    }
}
