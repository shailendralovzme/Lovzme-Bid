package com.lovzme.lovzme2.ui.mybagFragment.addToCart;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class Cart implements Serializable {
    @SerializedName("cart_details")
    @Expose
    public CartDetails cartDetails;
    @SerializedName("cart_coupon")
    @Expose
    public CartCoupon cartCoupon;
    @SerializedName("wallet")
    @Expose
    public Wallet wallet;
    @SerializedName("cart_message")
    @Expose
    public CartMessage cartMessage;
    @SerializedName("cart_products")
    @Expose
    public List<CartProduct> cartProducts = null;

    public CartDetails getCartDetails() {
        return cartDetails;
    }

    public void setCartDetails(CartDetails cartDetails) {
        this.cartDetails = cartDetails;
    }

    public CartCoupon getCartCoupon() {
        return cartCoupon;
    }

    public void setCartCoupon(CartCoupon cartCoupon) {
        this.cartCoupon = cartCoupon;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public CartMessage getCartMessage() {
        return cartMessage;
    }

    public void setCartMessage(CartMessage cartMessage) {
        this.cartMessage = cartMessage;
    }

    public List<CartProduct> getCartProducts() {
        return cartProducts;
    }

    public void setCartProducts(List<CartProduct> cartProducts) {
        this.cartProducts = cartProducts;
    }
}
