package com.lovzme.lovzme2.ui.homefragment.response.pincode;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class PinDetails implements Serializable {

    @SerializedName("repl")
    @Expose
    public String repl;
    @SerializedName("inc")
    @Expose
    public String inc;
    @SerializedName("center")
    @Expose
    public List<Center> center = null;
    @SerializedName("pin")
    @Expose
    public Integer pin;
    @SerializedName("max_amount")
    @Expose
    public Integer maxAmount;
    @SerializedName("pre_paid")
    @Expose
    public String prePaid;
    @SerializedName("cash")
    @Expose
    public String cash;
    @SerializedName("max_weight")
    @Expose
    public Integer maxWeight;
    @SerializedName("pickup")
    @Expose
    public String pickup;
    @SerializedName("district")
    @Expose
    public String district;
    @SerializedName("covid_zone")
    @Expose
    public String covidZone;
    @SerializedName("country_code")
    @Expose
    public String countryCode;
    @SerializedName("is_oda")
    @Expose
    public String isOda;
    @SerializedName("sort_code")
    @Expose
    public String sortCode;
    @SerializedName("state_code")
    @Expose
    public String stateCode;
    @SerializedName("cod")
    @Expose
    public String cod;

    public String getRepl() {
        return repl;
    }

    public void setRepl(String repl) {
        this.repl = repl;
    }

    public String getInc() {
        return inc;
    }

    public void setInc(String inc) {
        this.inc = inc;
    }

    public List<Center> getCenter() {
        return center;
    }

    public void setCenter(List<Center> center) {
        this.center = center;
    }

    public Integer getPin() {
        return pin;
    }

    public void setPin(Integer pin) {
        this.pin = pin;
    }

    public Integer getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(Integer maxAmount) {
        this.maxAmount = maxAmount;
    }

    public String getPrePaid() {
        return prePaid;
    }

    public void setPrePaid(String prePaid) {
        this.prePaid = prePaid;
    }

    public String getCash() {
        return cash;
    }

    public void setCash(String cash) {
        this.cash = cash;
    }

    public Integer getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(Integer maxWeight) {
        this.maxWeight = maxWeight;
    }

    public String getPickup() {
        return pickup;
    }

    public void setPickup(String pickup) {
        this.pickup = pickup;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCovidZone() {
        return covidZone;
    }

    public void setCovidZone(String covidZone) {
        this.covidZone = covidZone;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getIsOda() {
        return isOda;
    }

    public void setIsOda(String isOda) {
        this.isOda = isOda;
    }

    public String getSortCode() {
        return sortCode;
    }

    public void setSortCode(String sortCode) {
        this.sortCode = sortCode;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }
}
