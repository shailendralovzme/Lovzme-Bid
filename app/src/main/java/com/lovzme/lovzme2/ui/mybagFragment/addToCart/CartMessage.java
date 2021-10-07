package com.lovzme.lovzme2.ui.mybagFragment.addToCart;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class CartMessage implements Serializable {

    @SerializedName("cartwarnmsg")
    @Expose
    public Object cartwarnmsg;
    @SerializedName("codmsg")
    @Expose
    public Codmsg codmsg;
    @SerializedName("offermsg")
    @Expose
    public String offermsg;
    @SerializedName("walletmsg")
    @Expose
    public Walletmsg walletmsg;

    public Object getCartwarnmsg() {
        return cartwarnmsg;
    }

    public void setCartwarnmsg(Object cartwarnmsg) {
        this.cartwarnmsg = cartwarnmsg;
    }

    public Codmsg getCodmsg() {
        return codmsg;
    }

    public void setCodmsg(Codmsg codmsg) {
        this.codmsg = codmsg;
    }

    public String getOffermsg() {
        return offermsg;
    }

    public void setOffermsg(String offermsg) {
        this.offermsg = offermsg;
    }

    public Walletmsg getWalletmsg() {
        return walletmsg;
    }

    public void setWalletmsg(Walletmsg walletmsg) {
        this.walletmsg = walletmsg;
    }
}
