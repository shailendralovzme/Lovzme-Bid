package com.lovzme.lovzme2.ui.homefragment.response.productdetaiils;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class ProductSize implements Serializable {
    @SerializedName("id_product_attribute")
    @Expose
    public String idProductAttribute;
    @SerializedName("combination")
    @Expose
    public Combination combination;
    @SerializedName("quantity")
    @Expose
    public String quantity;

    public String getIdProductAttribute() {
        return idProductAttribute;
    }

    public void setIdProductAttribute(String idProductAttribute) {
        this.idProductAttribute = idProductAttribute;
    }

    public Combination getCombination() {
        return combination;
    }

    public void setCombination(Combination combination) {
        this.combination = combination;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
