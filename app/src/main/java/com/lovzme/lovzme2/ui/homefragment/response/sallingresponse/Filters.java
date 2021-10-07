package com.lovzme.lovzme2.ui.homefragment.response.sallingresponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.lovzme.lovzme2.ui.homefragment.response.productdetaiils.ProductSize;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class Filters implements Serializable {

    @SerializedName("product_order")
    @Expose
    public ProductOrder productOrder;
    @SerializedName("product_price_sort")
    @Expose
    public ProductPriceSort productPriceSort;
    @SerializedName("product_colors")
    @Expose
    public List<ProductColor> productColors = null;
    @SerializedName("product_sizes")
    @Expose
    public List<ProductSize> productSizes = null;
    @SerializedName("product_categories")
    @Expose
    public List<Object> productCategories = null;
    @SerializedName("product_brands")
    @Expose
    public List<ProductBrand> productBrands = null;

    public ProductOrder getProductOrder() {
        return productOrder;
    }

    public void setProductOrder(ProductOrder productOrder) {
        this.productOrder = productOrder;
    }

    public ProductPriceSort getProductPriceSort() {
        return productPriceSort;
    }

    public void setProductPriceSort(ProductPriceSort productPriceSort) {
        this.productPriceSort = productPriceSort;
    }

    public List<ProductColor> getProductColors() {
        return productColors;
    }

    public void setProductColors(List<ProductColor> productColors) {
        this.productColors = productColors;
    }

    public List<ProductSize> getProductSizes() {
        return productSizes;
    }

    public void setProductSizes(List<ProductSize> productSizes) {
        this.productSizes = productSizes;
    }

    public List<Object> getProductCategories() {
        return productCategories;
    }

    public void setProductCategories(List<Object> productCategories) {
        this.productCategories = productCategories;
    }

    public List<ProductBrand> getProductBrands() {
        return productBrands;
    }

    public void setProductBrands(List<ProductBrand> productBrands) {
        this.productBrands = productBrands;
    }
}
