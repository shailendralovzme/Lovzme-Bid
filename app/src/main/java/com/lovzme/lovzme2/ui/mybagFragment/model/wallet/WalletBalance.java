package com.lovzme.lovzme2.ui.mybagFragment.model.wallet;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class WalletBalance {

    @SerializedName("success")
    @Expose
    public Boolean success;
    @SerializedName("message")
    @Expose
    public String message;
    @SerializedName("wallet")
    @Expose
    public Wallet wallet;


    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public static class Wallet {
        @SerializedName("balance")
        @Expose
        public String balance;

        public String getBalance() {
            return balance;
        }

        public void setBalance(String balance) {
            this.balance = balance;
        }
    }

}
