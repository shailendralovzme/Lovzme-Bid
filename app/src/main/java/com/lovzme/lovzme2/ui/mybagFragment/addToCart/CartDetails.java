package com.lovzme.lovzme2.ui.mybagFragment.addToCart;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class CartDetails implements Serializable {
    @SerializedName("id_cart")
    @Expose
    public String idCart;
    @SerializedName("id_customer")
    @Expose
    public String idCustomer;
    @SerializedName("id_address_delivery")
    @Expose
    public String idAddressDelivery;
    @SerializedName("id_address_invoice")
    @Expose
    public String idAddressInvoice;
    @SerializedName("secure_key")
    @Expose
    public String secureKey;
    @SerializedName("id_currency")
    @Expose
    public String idCurrency;
    @SerializedName("total_products")
    @Expose
    public String totalProducts;
    @SerializedName("total_products_wt")
    @Expose
    public String totalProductsWt;
    @SerializedName("product_count")
    @Expose
    public String productCount;
    @SerializedName("quantity_total")
    @Expose
    public String quantityTotal;
    @SerializedName("shipping_cost")
    @Expose
    public String shippingCost;
    @SerializedName("shipping_cost_total")
    @Expose
    public String shippingCostTotal;
    @SerializedName("cart_price_total")
    @Expose
    public String cartPriceTotal;
    @SerializedName("cart_total")
    @Expose
    public String cartTotal;
    @SerializedName("cart_total_tax_excl")
    @Expose
    public String cartTotalTaxExcl;
    @SerializedName("cart_total_tax_incl")
    @Expose
    public String cartTotalTaxIncl;
    @SerializedName("wallet_redeemed")
    @Expose
    public String walletRedeemed;
    @SerializedName("reduction_amount")
    @Expose
    public String reductionAmount;
    @SerializedName("cart_price_total_tax_excl")
    @Expose
    public String cartPriceTotalTaxExcl;
    @SerializedName("cart_price_total_tax_incl")
    @Expose
    public String cartPriceTotalTaxIncl;
    @SerializedName("total_tax")
    @Expose
    public String totalTax;
    @SerializedName("total_reduction")
    @Expose
    public String totalReduction;

    public String getIdCart() {
        return idCart;
    }

    public void setIdCart(String idCart) {
        this.idCart = idCart;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
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

    public String getSecureKey() {
        return secureKey;
    }

    public void setSecureKey(String secureKey) {
        this.secureKey = secureKey;
    }

    public String getIdCurrency() {
        return idCurrency;
    }

    public void setIdCurrency(String idCurrency) {
        this.idCurrency = idCurrency;
    }

    public String getTotalProducts() {
        return totalProducts;
    }

    public void setTotalProducts(String totalProducts) {
        this.totalProducts = totalProducts;
    }

    public String getTotalProductsWt() {
        return totalProductsWt;
    }

    public void setTotalProductsWt(String totalProductsWt) {
        this.totalProductsWt = totalProductsWt;
    }

    public String getProductCount() {
        return productCount;
    }

    public void setProductCount(String productCount) {
        this.productCount = productCount;
    }

    public String getQuantityTotal() {
        return quantityTotal;
    }

    public void setQuantityTotal(String quantityTotal) {
        this.quantityTotal = quantityTotal;
    }

    public String getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(String shippingCost) {
        this.shippingCost = shippingCost;
    }

    public String getShippingCostTotal() {
        return shippingCostTotal;
    }

    public void setShippingCostTotal(String shippingCostTotal) {
        this.shippingCostTotal = shippingCostTotal;
    }

    public String getCartPriceTotal() {
        return cartPriceTotal;
    }

    public void setCartPriceTotal(String cartPriceTotal) {
        this.cartPriceTotal = cartPriceTotal;
    }

    public String getCartTotal() {
        return cartTotal;
    }

    public void setCartTotal(String cartTotal) {
        this.cartTotal = cartTotal;
    }

    public String getCartTotalTaxExcl() {
        return cartTotalTaxExcl;
    }

    public void setCartTotalTaxExcl(String cartTotalTaxExcl) {
        this.cartTotalTaxExcl = cartTotalTaxExcl;
    }

    public String getCartTotalTaxIncl() {
        return cartTotalTaxIncl;
    }

    public void setCartTotalTaxIncl(String cartTotalTaxIncl) {
        this.cartTotalTaxIncl = cartTotalTaxIncl;
    }

    public String getWalletRedeemed() {
        return walletRedeemed;
    }

    public void setWalletRedeemed(String walletRedeemed) {
        this.walletRedeemed = walletRedeemed;
    }

    public String getReductionAmount() {
        return reductionAmount;
    }

    public void setReductionAmount(String reductionAmount) {
        this.reductionAmount = reductionAmount;
    }

    public String getCartPriceTotalTaxExcl() {
        return cartPriceTotalTaxExcl;
    }

    public void setCartPriceTotalTaxExcl(String cartPriceTotalTaxExcl) {
        this.cartPriceTotalTaxExcl = cartPriceTotalTaxExcl;
    }

    public String getCartPriceTotalTaxIncl() {
        return cartPriceTotalTaxIncl;
    }

    public void setCartPriceTotalTaxIncl(String cartPriceTotalTaxIncl) {
        this.cartPriceTotalTaxIncl = cartPriceTotalTaxIncl;
    }

    public String getTotalTax() {
        return totalTax;
    }

    public void setTotalTax(String totalTax) {
        this.totalTax = totalTax;
    }

    public String getTotalReduction() {
        return totalReduction;
    }

    public void setTotalReduction(String totalReduction) {
        this.totalReduction = totalReduction;
    }
}
