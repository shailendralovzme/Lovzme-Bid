package com.lovzme.lovzme2.ui.homefragment.response.sallingresponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class SellingProduct implements Serializable {
    @SerializedName("row_index")
    @Expose
    public String rowIndex;
    @SerializedName("id_product")
    @Expose
    public String idProduct;
    @SerializedName("id_category_default")
    @Expose
    public String idCategoryDefault;
    @SerializedName("additional_shipping_cost")
    @Expose
    public String additionalShippingCost;
    @SerializedName("reference")
    @Expose
    public String reference;
    @SerializedName("cache_default_attribute")
    @Expose
    public String cacheDefaultAttribute;
    @SerializedName("state")
    @Expose
    public String state;
    @SerializedName("meta_title")
    @Expose
    public String metaTitle;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("id_image")
    @Expose
    public String idImage;
    @SerializedName("manufacturer_name")
    @Expose
    public String manufacturerName;
    @SerializedName("product_image")
    @Expose
    public String productImage;
    @SerializedName("price_tax_excl")
    @Expose
    public String priceTaxExcl;
    @SerializedName("price_tax_incl")
    @Expose
    public String priceTaxIncl;
    @SerializedName("price_reduction")
    @Expose
    public String priceReduction;
    @SerializedName("price_selling")
    @Expose
    public String priceSelling;
    @SerializedName("color_code")
    @Expose
    public String colorCode;
    @SerializedName("multicolor_image")
    @Expose
    public String multicolorImage;
    @SerializedName("reduction_rate")
    @Expose
    public String reductionRate;
    @SerializedName("rate")
    @Expose
    public Object rate;
    @SerializedName("stock_quantity")
    @Expose
    public String stockQuantity;
    @SerializedName("countdown")
    @Expose
    public Countdown countdown;
    @SerializedName("wishlist")
    @Expose
    public Wishlist wishlist;

    public String getRowIndex() {
        return rowIndex;
    }

    public void setRowIndex(String rowIndex) {
        this.rowIndex = rowIndex;
    }

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public String getIdCategoryDefault() {
        return idCategoryDefault;
    }

    public void setIdCategoryDefault(String idCategoryDefault) {
        this.idCategoryDefault = idCategoryDefault;
    }

    public String getAdditionalShippingCost() {
        return additionalShippingCost;
    }

    public void setAdditionalShippingCost(String additionalShippingCost) {
        this.additionalShippingCost = additionalShippingCost;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getCacheDefaultAttribute() {
        return cacheDefaultAttribute;
    }

    public void setCacheDefaultAttribute(String cacheDefaultAttribute) {
        this.cacheDefaultAttribute = cacheDefaultAttribute;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getMetaTitle() {
        return metaTitle;
    }

    public void setMetaTitle(String metaTitle) {
        this.metaTitle = metaTitle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdImage() {
        return idImage;
    }

    public void setIdImage(String idImage) {
        this.idImage = idImage;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
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

    public String getPriceSelling() {
        return priceSelling;
    }

    public void setPriceSelling(String priceSelling) {
        this.priceSelling = priceSelling;
    }

    public String getColorCode() {
        return colorCode;
    }

    public void setColorCode(String colorCode) {
        this.colorCode = colorCode;
    }

    public String getMulticolorImage() {
        return multicolorImage;
    }

    public void setMulticolorImage(String multicolorImage) {
        this.multicolorImage = multicolorImage;
    }

    public String getReductionRate() {
        return reductionRate;
    }

    public void setReductionRate(String reductionRate) {
        this.reductionRate = reductionRate;
    }

    public Object getRate() {
        return rate;
    }

    public void setRate(Object rate) {
        this.rate = rate;
    }

    public String getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(String stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public Countdown getCountdown() {
        return countdown;
    }

    public void setCountdown(Countdown countdown) {
        this.countdown = countdown;
    }

    public Wishlist getWishlist() {
        return wishlist;
    }

    public void setWishlist(Wishlist wishlist) {
        this.wishlist = wishlist;
    }
}
