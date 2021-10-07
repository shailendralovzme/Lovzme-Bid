package com.lovzme.lovzme2.ui.mybagFragment.addToCart;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class CartCoupon implements Serializable {
    @SerializedName("coupons_applied")
    @Expose
    public Object couponsApplied;
    @SerializedName("coupons_suggested")
    @Expose
    public CouponsSuggested couponsSuggested;
    @SerializedName("coupons_remark")
    @Expose
    public Object couponsRemark;

    public Object getCouponsApplied() {
        return couponsApplied;
    }

    public void setCouponsApplied(Object couponsApplied) {
        this.couponsApplied = couponsApplied;
    }

    public CouponsSuggested getCouponsSuggested() {
        return couponsSuggested;
    }

    public void setCouponsSuggested(CouponsSuggested couponsSuggested) {
        this.couponsSuggested = couponsSuggested;
    }

    public Object getCouponsRemark() {
        return couponsRemark;
    }

    public void setCouponsRemark(Object couponsRemark) {
        this.couponsRemark = couponsRemark;
    }
}
