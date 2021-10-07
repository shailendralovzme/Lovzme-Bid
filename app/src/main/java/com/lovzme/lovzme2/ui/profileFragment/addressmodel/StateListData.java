package com.lovzme.lovzme2.ui.profileFragment.addressmodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class StateListData {
    @SerializedName("success")
    @Expose
    public Boolean success;
    @SerializedName("payload")
    @Expose
    public List<Payload> payload = null;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public List<Payload> getPayload() {
        return payload;
    }

    public void setPayload(List<Payload> payload) {
        this.payload = payload;
    }
    @Generated("jsonschema2pojo")
    public class Payload {

        @SerializedName("id_state")
        @Expose
        public String idState;
        @SerializedName("id_country")
        @Expose
        public String idCountry;
        @SerializedName("id_zone")
        @Expose
        public String idZone;
        @SerializedName("name")
        @Expose
        public String name;
        @SerializedName("iso_code")
        @Expose
        public String isoCode;
        @SerializedName("tax_behavior")
        @Expose
        public String taxBehavior;
        @SerializedName("active")
        @Expose
        public String active;

        public String getIdState() {
            return idState;
        }

        public void setIdState(String idState) {
            this.idState = idState;
        }

        public String getIdCountry() {
            return idCountry;
        }

        public void setIdCountry(String idCountry) {
            this.idCountry = idCountry;
        }

        public String getIdZone() {
            return idZone;
        }

        public void setIdZone(String idZone) {
            this.idZone = idZone;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getIsoCode() {
            return isoCode;
        }

        public void setIsoCode(String isoCode) {
            this.isoCode = isoCode;
        }

        public String getTaxBehavior() {
            return taxBehavior;
        }

        public void setTaxBehavior(String taxBehavior) {
            this.taxBehavior = taxBehavior;
        }

        public String getActive() {
            return active;
        }

        public void setActive(String active) {
            this.active = active;
        }
    }
}
