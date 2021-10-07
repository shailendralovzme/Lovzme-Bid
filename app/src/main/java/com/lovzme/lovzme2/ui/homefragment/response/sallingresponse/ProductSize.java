package com.lovzme.lovzme2.ui.homefragment.response.sallingresponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ProductSize implements Serializable {
    @SerializedName("id_attribute_size")
    @Expose
    public String idAttributeSize;
    @SerializedName("size")
    @Expose
    public String size;
    @SerializedName("isApplied")
    @Expose
    public String isApplied;

    public String getIdAttributeSize() {
        return idAttributeSize;
    }

    public void setIdAttributeSize(String idAttributeSize) {
        this.idAttributeSize = idAttributeSize;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getIsApplied() {
        return isApplied;
    }

    public void setIsApplied(String isApplied) {
        this.isApplied = isApplied;
    }
}
