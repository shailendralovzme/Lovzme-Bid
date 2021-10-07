package com.lovzme.lovzme2.ui.homefragment.response.productdetaiils;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class ProductDetailsPayload implements Serializable {
    @SerializedName("product")
    @Expose
    public Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
