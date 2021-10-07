package com.lovzme.lovzme2.ui.homefragment.response.pincode;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class Center implements Serializable {

    @SerializedName("code")
    @Expose
    public String code;
    @SerializedName("e")
    @Expose
    public String e;
    @SerializedName("cn")
    @Expose
    public String cn;
    @SerializedName("s")
    @Expose
    public String s;
    @SerializedName("u")
    @Expose
    public String u;
    @SerializedName("sort_code")
    @Expose
    public String sortCode;
    @SerializedName("ud")
    @Expose
    public String ud;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getE() {
        return e;
    }

    public void setE(String e) {
        this.e = e;
    }

    public String getCn() {
        return cn;
    }

    public void setCn(String cn) {
        this.cn = cn;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public String getU() {
        return u;
    }

    public void setU(String u) {
        this.u = u;
    }

    public String getSortCode() {
        return sortCode;
    }

    public void setSortCode(String sortCode) {
        this.sortCode = sortCode;
    }

    public String getUd() {
        return ud;
    }

    public void setUd(String ud) {
        this.ud = ud;
    }
}
