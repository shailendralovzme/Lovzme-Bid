package com.lovzme.lovzme2.ui.homefragment.response.sallingresponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ProductOrder implements Serializable {
    @SerializedName("ascending_order")
    @Expose
    public AscendingOrder ascendingOrder;
    @SerializedName("descending_order")
    @Expose
    public DescendingOrder descendingOrder;

    public AscendingOrder getAscendingOrder() {
        return ascendingOrder;
    }

    public void setAscendingOrder(AscendingOrder ascendingOrder) {
        this.ascendingOrder = ascendingOrder;
    }

    public DescendingOrder getDescendingOrder() {
        return descendingOrder;
    }

    public void setDescendingOrder(DescendingOrder descendingOrder) {
        this.descendingOrder = descendingOrder;
    }
}
