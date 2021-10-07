package com.lovzme.lovzme2.ui.mybagFragment.model.order;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class OrderProduct implements Serializable {
    @SerializedName("manufacturer")
    @Expose
    public String manufacturer;
    @SerializedName("id_manufacturer")
    @Expose
    public String idManufacturer;
    @SerializedName("id_product")
    @Expose
    public String idProduct;
    @SerializedName("reference")
    @Expose
    public String reference;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("id_product_attribute")
    @Expose
    public String idProductAttribute;
    @SerializedName("id_image")
    @Expose
    public String idImage;
    @SerializedName("price_tax_excl")
    @Expose
    public String priceTaxExcl;
    @SerializedName("price_tax_incl")
    @Expose
    public String priceTaxIncl;
    @SerializedName("price_reduction")
    @Expose
    public String priceReduction;
    @SerializedName("total_price_tax_incl")
    @Expose
    public String totalPriceTaxIncl;
    @SerializedName("total_price_tax_excl")
    @Expose
    public String totalPriceTaxExcl;
    @SerializedName("reduction_rate")
    @Expose
    public String reductionRate;
    @SerializedName("tax_rate")
    @Expose
    public String taxRate;
    @SerializedName("product_quantity")
    @Expose
    public String productQuantity;
    @SerializedName("product_image")
    @Expose
    public String productImage;
    @SerializedName("bid_value")
    @Expose
    public String bidValue;
    @SerializedName("color")
    @Expose
    public String color;
    @SerializedName("multicolor_image")
    @Expose
    public String multicolorImage;

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getIdManufacturer() {
        return idManufacturer;
    }

    public void setIdManufacturer(String idManufacturer) {
        this.idManufacturer = idManufacturer;
    }

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdProductAttribute() {
        return idProductAttribute;
    }

    public void setIdProductAttribute(String idProductAttribute) {
        this.idProductAttribute = idProductAttribute;
    }

    public String getIdImage() {
        return idImage;
    }

    public void setIdImage(String idImage) {
        this.idImage = idImage;
    }

    public String getPriceTaxExcl() {
        return priceTaxExcl;
    }

    public void setPriceTaxExcl(String priceTaxExcl) {
        this.priceTaxExcl = priceTaxExcl;
    }

    public String getPriceTaxIncl() {
        return priceTaxIncl;
    }

    public void setPriceTaxIncl(String priceTaxIncl) {
        this.priceTaxIncl = priceTaxIncl;
    }

    public String getPriceReduction() {
        return priceReduction;
    }

    public void setPriceReduction(String priceReduction) {
        this.priceReduction = priceReduction;
    }

    public String getTotalPriceTaxIncl() {
        return totalPriceTaxIncl;
    }

    public void setTotalPriceTaxIncl(String totalPriceTaxIncl) {
        this.totalPriceTaxIncl = totalPriceTaxIncl;
    }

    public String getTotalPriceTaxExcl() {
        return totalPriceTaxExcl;
    }

    public void setTotalPriceTaxExcl(String totalPriceTaxExcl) {
        this.totalPriceTaxExcl = totalPriceTaxExcl;
    }

    public String getReductionRate() {
        return reductionRate;
    }

    public void setReductionRate(String reductionRate) {
        this.reductionRate = reductionRate;
    }

    public String getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(String taxRate) {
        this.taxRate = taxRate;
    }

    public String getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(String productQuantity) {
        this.productQuantity = productQuantity;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getBidValue() {
        return bidValue;
    }

    public void setBidValue(String bidValue) {
        this.bidValue = bidValue;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMulticolorImage() {
        return multicolorImage;
    }

    public void setMulticolorImage(String multicolorImage) {
        this.multicolorImage = multicolorImage;
    }
}
