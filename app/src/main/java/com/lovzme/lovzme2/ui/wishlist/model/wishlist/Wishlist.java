package com.lovzme.lovzme2.ui.wishlist.model.wishlist;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class Wishlist {

    @SerializedName("isApplied")
    @Expose
    public Boolean isApplied;
    @SerializedName("id_product")
    @Expose
    public String idProduct;

    public Boolean getApplied() {
        return isApplied;
    }

    public void setApplied(Boolean applied) {
        isApplied = applied;
    }

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }
}
