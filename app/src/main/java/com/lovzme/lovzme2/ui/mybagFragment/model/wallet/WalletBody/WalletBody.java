package com.lovzme.lovzme2.ui.mybagFragment.model.wallet.WalletBody;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class WalletBody {
    @SerializedName("wallet")
    @Expose
    public Wallet wallet;

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public static class Wallet {

        @SerializedName("id_customer")
        @Expose
        public String idCustomer;
        @SerializedName("id_cart")
        @Expose
        public String idCart;
        @SerializedName("redeem_amount")
        @Expose
        public String redeemAmount;
        @SerializedName("secure_key")
        @Expose
        public String secureKey;

        public Wallet(String idCustomer, String idCart, String redeemAmount, String secureKey) {
            this.idCustomer = idCustomer;
            this.idCart = idCart;
            this.redeemAmount = redeemAmount;
            this.secureKey = secureKey;
        }

        public String getIdCustomer() {
            return idCustomer;
        }

        public void setIdCustomer(String idCustomer) {
            this.idCustomer = idCustomer;
        }

        public String getIdCart() {
            return idCart;
        }

        public void setIdCart(String idCart) {
            this.idCart = idCart;
        }

        public String getRedeemAmount() {
            return redeemAmount;
        }

        public void setRedeemAmount(String redeemAmount) {
            this.redeemAmount = redeemAmount;
        }

        public String getSecureKey() {
            return secureKey;
        }

        public void setSecureKey(String secureKey) {
            this.secureKey = secureKey;
        }
    }
}
