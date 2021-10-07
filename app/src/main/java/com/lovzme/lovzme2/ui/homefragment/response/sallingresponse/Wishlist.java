package com.lovzme.lovzme2.ui.homefragment.response.sallingresponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Wishlist implements Serializable {
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
