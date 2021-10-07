package com.lovzme.lovzme2.ui.homefragment.response.sallingresponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ProductPriceSort implements Serializable {
    @SerializedName("high_to_low")
    @Expose
    public HighToLow highToLow;
    @SerializedName("low_to_high")
    @Expose
    public LowToHigh lowToHigh;

    public HighToLow getHighToLow() {
        return highToLow;
    }

    public void setHighToLow(HighToLow highToLow) {
        this.highToLow = highToLow;
    }

    public LowToHigh getLowToHigh() {
        return lowToHigh;
    }

    public void setLowToHigh(LowToHigh lowToHigh) {
        this.lowToHigh = lowToHigh;
    }
}
