package com.lovzme.lovzme2.ui.homefragment.response.sallingresponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ProductColor implements Serializable {
    @SerializedName("id_attribute_color")
    @Expose
    public String idAttributeColor;
    @SerializedName("color_code")
    @Expose
    public String colorCode;
    @SerializedName("color_name")
    @Expose
    public String colorName;
    @SerializedName("isApplied")
    @Expose
    public String isApplied;

    public String getIdAttributeColor() {
        return idAttributeColor;
    }

    public void setIdAttributeColor(String idAttributeColor) {
        this.idAttributeColor = idAttributeColor;
    }

    public String getColorCode() {
        return colorCode;
    }

    public void setColorCode(String colorCode) {
        this.colorCode = colorCode;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public String getIsApplied() {
        return isApplied;
    }

    public void setIsApplied(String isApplied) {
        this.isApplied = isApplied;
    }
}
