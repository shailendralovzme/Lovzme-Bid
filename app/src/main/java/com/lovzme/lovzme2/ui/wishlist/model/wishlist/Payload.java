package com.lovzme.lovzme2.ui.wishlist.model.wishlist;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class Payload {

    @SerializedName("wishlist")
    @Expose
    public List<Wish> wishlist = null;

    public List<Wish> getWishlist() {
        return wishlist;
    }

    public void setWishlist(List<Wish> wishlist) {
        this.wishlist = wishlist;
    }
}
