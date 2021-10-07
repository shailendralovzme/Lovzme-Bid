package com.lovzme.lovzme2.ui.wishlist.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;
@Generated("jsonschema2pojo")
public class WishlistBody {
    @SerializedName("wishlist")
    @Expose
    public Wishlist wishlist;

    public Wishlist getWishlist() {
        return wishlist;
    }

    public void setWishlist(Wishlist wishlist) {
        this.wishlist = wishlist;
    }

    public static class Wishlist {

        @SerializedName("id_customer")
        @Expose
        public String idCustomer;
        @SerializedName("secure_key")
        @Expose
        public String secureKey;
        @SerializedName("id_product")
        @Expose
        public String idProduct;
        @SerializedName("id_product_attribute")
        @Expose
        public String idProductAttribute;

        public Wishlist(String idCustomer, String secureKey, String idProduct, String idProductAttribute) {
            this.idCustomer = idCustomer;
            this.secureKey = secureKey;
            this.idProduct = idProduct;
            this.idProductAttribute = idProductAttribute;
        }

        public String getIdCustomer() {
            return idCustomer;
        }

        public void setIdCustomer(String idCustomer) {
            this.idCustomer = idCustomer;
        }

        public String getSecureKey() {
            return secureKey;
        }

        public void setSecureKey(String secureKey) {
            this.secureKey = secureKey;
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
    }
}
