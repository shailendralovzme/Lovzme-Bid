package com.lovzme.lovzme2.ui.mybagFragment.addToCart;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class Coupon implements Serializable {
    @SerializedName("id_cart_rule")
    @Expose
    public String idCartRule;
    @SerializedName("reduction_amount")
    @Expose
    public String reductionAmount;
    @SerializedName("description")
    @Expose
    public String description;
    @SerializedName("minimum_amount")
    @Expose
    public String minimumAmount;

    public String getIdCartRule() {
        return idCartRule;
    }

    public void setIdCartRule(String idCartRule) {
        this.idCartRule = idCartRule;
    }

    public String getReductionAmount() {
        return reductionAmount;
    }

    public void setReductionAmount(String reductionAmount) {
        this.reductionAmount = reductionAmount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMinimumAmount() {
        return minimumAmount;
    }

    public void setMinimumAmount(String minimumAmount) {
        this.minimumAmount = minimumAmount;
    }
}
