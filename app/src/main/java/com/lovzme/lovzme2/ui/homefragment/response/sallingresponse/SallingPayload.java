package com.lovzme.lovzme2.ui.homefragment.response.sallingresponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class SallingPayload implements Serializable {
    @SerializedName("filters")
    @Expose
    public Filters filters;
    @SerializedName("products")
    @Expose
    public List<SellingProduct> sellingProducts = null;

    public Filters getFilters() {
        return filters;
    }

    public void setFilters(Filters filters) {
        this.filters = filters;
    }

    public List<SellingProduct> getSellingProducts() {
        return sellingProducts;
    }

    public void setSellingProducts(List<SellingProduct> sellingProducts) {
        this.sellingProducts = sellingProducts;
    }
}
