package com.lovzme.lovzme2.ui.mybagFragment.model.order;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class Razorpay implements Serializable {
    @SerializedName("razorpay_order_id")
    @Expose
    public String razorpayOrderId;
    @SerializedName("receipt")
    @Expose
    public String receipt;
    @SerializedName("amount")
    @Expose
    public Integer amount;
    @SerializedName("entity")
    @Expose
    public String entity;
    @SerializedName("status")
    @Expose
    public String status;

    public String getRazorpayOrderId() {
        return razorpayOrderId;
    }

    public void setRazorpayOrderId(String razorpayOrderId) {
        this.razorpayOrderId = razorpayOrderId;
    }

    public String getReceipt() {
        return receipt;
    }

    public void setReceipt(String receipt) {
        this.receipt = receipt;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
