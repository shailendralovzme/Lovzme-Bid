package com.lovzme.lovzme2.ui.mybagFragment.addToCart;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class Wallet implements Serializable {

    @SerializedName("isApplied")
    @Expose
    public Boolean isApplied;
    @SerializedName("customer_balance")
    @Expose
    public String customerBalance;
    @SerializedName("remaining_balance")
    @Expose
    public String remainingBalance;
    @SerializedName("redeem_amount_limit")
    @Expose
    public String redeemAmountLimit;
    @SerializedName("redeem_amount")
    @Expose
    public Integer redeemAmount;

    public Boolean getApplied() {
        return isApplied;
    }

    public void setApplied(Boolean applied) {
        isApplied = applied;
    }

    public String getCustomerBalance() {
        return customerBalance;
    }

    public void setCustomerBalance(String customerBalance) {
        this.customerBalance = customerBalance;
    }

    public String getRemainingBalance() {
        return remainingBalance;
    }

    public void setRemainingBalance(String remainingBalance) {
        this.remainingBalance = remainingBalance;
    }

    public String getRedeemAmountLimit() {
        return redeemAmountLimit;
    }

    public void setRedeemAmountLimit(String redeemAmountLimit) {
        this.redeemAmountLimit = redeemAmountLimit;
    }

    public Integer getRedeemAmount() {
        return redeemAmount;
    }

    public void setRedeemAmount(Integer redeemAmount) {
        this.redeemAmount = redeemAmount;
    }
}
