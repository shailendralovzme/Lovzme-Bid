package com.lovzme.lovzme2.ui.mybagFragment.addToCart.body;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class AddToCartBody {
    @SerializedName("cart")
    @Expose
    public Cart cart;

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public static class Cart {
        @SerializedName("id_customer")
        @Expose
        public String idCustomer;
        @SerializedName("id_address_delivery")
        @Expose
        public String idAddressDelivery;
        @SerializedName("id_address_invoice")
        @Expose
        public String idAddressInvoice;
        @SerializedName("id_product")
        @Expose
        public String idProduct;
        @SerializedName("id_product_attribute")
        @Expose
        public String idProductAttribute;
        @SerializedName("quantity")
        @Expose
        public String quantity;
        @SerializedName("secure_key")
        @Expose
        public String secureKey;

        public Cart(String idCustomer, String idAddressDelivery, String idAddressInvoice, String idProduct, String idProductAttribute, String quantity, String secureKey) {
            this.idCustomer = idCustomer;
            this.idAddressDelivery = idAddressDelivery;
            this.idAddressInvoice = idAddressInvoice;
            this.idProduct = idProduct;
            this.idProductAttribute = idProductAttribute;
            this.quantity = quantity;
            this.secureKey = secureKey;
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

        public String getSecureKey() {
            return secureKey;
        }

        public void setSecureKey(String secureKey) {
            this.secureKey = secureKey;
        }
    }

}
