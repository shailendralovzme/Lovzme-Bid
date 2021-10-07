package com.lovzme.lovzme2.ui.mybagFragment.addToCart;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.lovzme.lovzme2.R;

import java.io.Serializable;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class CartProduct implements Serializable {
    @SerializedName("id_cart")
    @Expose
    public String idCart;
    @SerializedName("id_shop_group")
    @Expose
    public String idShopGroup;
    @SerializedName("id_shop")
    @Expose
    public String idShop;
    @SerializedName("id_carrier")
    @Expose
    public String idCarrier;
    @SerializedName("delivery_option")
    @Expose
    public String deliveryOption;
    @SerializedName("id_lang")
    @Expose
    public String idLang;
    @SerializedName("id_address_delivery")
    @Expose
    public String idAddressDelivery;
    @SerializedName("id_address_invoice")
    @Expose
    public String idAddressInvoice;
    @SerializedName("id_currency")
    @Expose
    public String idCurrency;
    @SerializedName("id_customer")
    @Expose
    public String idCustomer;
    @SerializedName("id_guest")
    @Expose
    public String idGuest;
    @SerializedName("secure_key")
    @Expose
    public String secureKey;
    @SerializedName("recyclable")
    @Expose
    public String recyclable;
    @SerializedName("gift")
    @Expose
    public String gift;
    @SerializedName("gift_message")
    @Expose
    public String giftMessage;
    @SerializedName("mobile_theme")
    @Expose
    public String mobileTheme;
    @SerializedName("allow_seperated_package")
    @Expose
    public String allowSeperatedPackage;
    @SerializedName("date_add")
    @Expose
    public String dateAdd;
    @SerializedName("date_upd")
    @Expose
    public String dateUpd;
    @SerializedName("checkout_session_data")
    @Expose
    public Object checkoutSessionData;
    @SerializedName("id_product")
    @Expose
    public String idProduct;
    @SerializedName("id_product_attribute")
    @Expose
    public String idProductAttribute;
    @SerializedName("quantity")
    @Expose
    public String quantity;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("id_image")
    @Expose
    public String idImage;
    @SerializedName("legend")
    @Expose
    public String legend;
    @SerializedName("manufacturer_name")
    @Expose
    public String manufacturerName;
    @SerializedName("reference")
    @Expose
    public String reference;
    @SerializedName("category_name")
    @Expose
    public String categoryName;
    @SerializedName("type")
    @Expose
    public String type;
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
    public Object multicolorImage;
    @SerializedName("color_code")
    @Expose
    public String colorCode;
    @SerializedName("price_tax_excl")
    @Expose
    public String priceTaxExcl;
    @SerializedName("price_tax_incl")
    @Expose
    public String priceTaxIncl;
    @SerializedName("price_reduction")
    @Expose
    public String priceReduction;
    @SerializedName("reduction_rate")
    @Expose
    public String reductionRate;
    @SerializedName("price_selling")
    @Expose
    public String priceSelling;
    @SerializedName("rate")
    @Expose
    public Object rate;

    public String getIdCart() {
        return idCart;
    }

    public void setIdCart(String idCart) {
        this.idCart = idCart;
    }

    public String getIdShopGroup() {
        return idShopGroup;
    }

    public void setIdShopGroup(String idShopGroup) {
        this.idShopGroup = idShopGroup;
    }

    public String getIdShop() {
        return idShop;
    }

    public void setIdShop(String idShop) {
        this.idShop = idShop;
    }

    public String getIdCarrier() {
        return idCarrier;
    }

    public void setIdCarrier(String idCarrier) {
        this.idCarrier = idCarrier;
    }

    public String getDeliveryOption() {
        return deliveryOption;
    }

    public void setDeliveryOption(String deliveryOption) {
        this.deliveryOption = deliveryOption;
    }

    public String getIdLang() {
        return idLang;
    }

    public void setIdLang(String idLang) {
        this.idLang = idLang;
    }

    public String getIdAddressDelivery() {
        return idAddressDelivery;
    }

    public void setIdAddressDelivery(String idAddressDelivery) {
        this.idAddressDelivery = idAddressDelivery;
    }

    public String getIdAddressInvoice() {
        return idAddressInvoice;
    }

    public void setIdAddressInvoice(String idAddressInvoice) {
        this.idAddressInvoice = idAddressInvoice;
    }

    public String getIdCurrency() {
        return idCurrency;
    }

    public void setIdCurrency(String idCurrency) {
        this.idCurrency = idCurrency;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getIdGuest() {
        return idGuest;
    }

    public void setIdGuest(String idGuest) {
        this.idGuest = idGuest;
    }

    public String getSecureKey() {
        return secureKey;
    }

    public void setSecureKey(String secureKey) {
        this.secureKey = secureKey;
    }

    public String getRecyclable() {
        return recyclable;
    }

    public void setRecyclable(String recyclable) {
        this.recyclable = recyclable;
    }

    public String getGift() {
        return gift;
    }

    public void setGift(String gift) {
        this.gift = gift;
    }

    public String getGiftMessage() {
        return giftMessage;
    }

    public void setGiftMessage(String giftMessage) {
        this.giftMessage = giftMessage;
    }

    public String getMobileTheme() {
        return mobileTheme;
    }

    public void setMobileTheme(String mobileTheme) {
        this.mobileTheme = mobileTheme;
    }

    public String getAllowSeperatedPackage() {
        return allowSeperatedPackage;
    }

    public void setAllowSeperatedPackage(String allowSeperatedPackage) {
        this.allowSeperatedPackage = allowSeperatedPackage;
    }

    public String getDateAdd() {
        return dateAdd;
    }

    public void setDateAdd(String dateAdd) {
        this.dateAdd = dateAdd;
    }

    public String getDateUpd() {
        return dateUpd;
    }

    public void setDateUpd(String dateUpd) {
        this.dateUpd = dateUpd;
    }

    public Object getCheckoutSessionData() {
        return checkoutSessionData;
    }

    public void setCheckoutSessionData(Object checkoutSessionData) {
        this.checkoutSessionData = checkoutSessionData;
    }

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public String getIdProductAttribute() {
        return idProductAttribute;
    }

    public void setIdProductAttribute(String idProductAttribute) {
        this.idProductAttribute = idProductAttribute;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
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

    public String getLegend() {
        return legend;
    }

    public void setLegend(String legend) {
        this.legend = legend;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public Object getMulticolorImage() {
        return multicolorImage;
    }

    public void setMulticolorImage(Object multicolorImage) {
        this.multicolorImage = multicolorImage;
    }

    public String getColorCode() {
        return colorCode;
    }

    public void setColorCode(String colorCode) {
        this.colorCode = colorCode;
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

    public String getReductionRate() {
        return reductionRate;
    }

    public void setReductionRate(String reductionRate) {
        this.reductionRate = reductionRate;
    }

    public String getPriceSelling() {
        return priceSelling;
    }

    public void setPriceSelling(String priceSelling) {
        this.priceSelling = priceSelling;
    }

    public Object getRate() {
        return rate;
    }

    public void setRate(Object rate) {
        this.rate = rate;
    }

    @BindingAdapter("cartImage")
    public  void CartImage(ImageView view, String imageUrl) {
        Glide.with(view.getContext())
                .load(imageUrl).fitCenter().circleCrop().placeholder(R.mipmap.ic_launcher)
                .into(view);
    }

}
