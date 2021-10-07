package com.lovzme.lovzme2.ui.homefragment.response.sallingresponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ProductBrand implements Serializable {
    @SerializedName("id_manufacturer")
    @Expose
    public String idManufacturer;
    @SerializedName("manufacturer_name")
    @Expose
    public String manufacturerName;
    @SerializedName("isApplied")
    @Expose
    public String isApplied;

    public String getIdManufacturer() {
        return idManufacturer;
    }

    public void setIdManufacturer(String idManufacturer) {
        this.idManufacturer = idManufacturer;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public String getIsApplied() {
        return isApplied;
    }

    public void setIsApplied(String isApplied) {
        this.isApplied = isApplied;
    }
}
