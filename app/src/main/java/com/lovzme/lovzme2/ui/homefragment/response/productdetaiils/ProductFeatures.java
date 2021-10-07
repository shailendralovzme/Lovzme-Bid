package com.lovzme.lovzme2.ui.homefragment.response.productdetaiils;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class ProductFeatures implements Serializable {
    @SerializedName("product_features")
    @Expose
    public String productFeatures;
    @SerializedName("product_features_values")
    @Expose
    public String productFeaturesValues;

    public String getProductFeatures() {
        return productFeatures;
    }

    public void setProductFeatures(String productFeatures) {
        this.productFeatures = productFeatures;
    }

    public String getProductFeaturesValues() {
        return productFeaturesValues;
    }

    public void setProductFeaturesValues(String productFeaturesValues) {
        this.productFeaturesValues = productFeaturesValues;
    }
}
