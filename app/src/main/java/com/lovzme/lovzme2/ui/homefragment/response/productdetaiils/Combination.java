package com.lovzme.lovzme2.ui.homefragment.response.productdetaiils;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class Combination implements Serializable {

    @SerializedName("bid_value")
    @Expose
    public String bidValue;
    @SerializedName("color")
    @Expose
    public String color;
    @SerializedName("color_code")
    @Expose
    public String colorCode;

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

    public String getColorCode() {
        return colorCode;
    }

    public void setColorCode(String colorCode) {
        this.colorCode = colorCode;
    }
}
