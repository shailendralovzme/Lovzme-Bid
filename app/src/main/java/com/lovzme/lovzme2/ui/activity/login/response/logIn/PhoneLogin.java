package com.lovzme.lovzme2.ui.activity.login.response.logIn;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class PhoneLogin {
    @SerializedName("success")
    @Expose
    public Boolean success;
    @SerializedName("message")
    @Expose
    public String message;
    @SerializedName("hasError")
    @Expose
    public Boolean hasError;
    @SerializedName("payload")
    @Expose
    public Payload payload;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getHasError() {
        return hasError;
    }

    public void setHasError(Boolean hasError) {
        this.hasError = hasError;
    }

    public Payload getPayload() {
        return payload;
    }

    public void setPayload(Payload payload) {
        this.payload = payload;
    }

    public class Payload {

        @SerializedName("id_customer")
        @Expose
        public String idCustomer;
        @SerializedName("id_shop_group")
        @Expose
        public String idShopGroup;
        @SerializedName("id_shop")
        @Expose
        public String idShop;
        @SerializedName("id_gender")
        @Expose
        public String idGender;
        @SerializedName("id_default_group")
        @Expose
        public String idDefaultGroup;
        @SerializedName("id_lang")
        @Expose
        public String idLang;
        @SerializedName("id_risk")
        @Expose
        public String idRisk;
        @SerializedName("company")
        @Expose
        public Object company;
        @SerializedName("siret")
        @Expose
        public Object siret;
        @SerializedName("ape")
        @Expose
        public Object ape;
        @SerializedName("firstname")
        @Expose
        public String firstname;
        @SerializedName("lastname")
        @Expose
        public String lastname;
        @SerializedName("email")
        @Expose
        public String email;
        @SerializedName("secure_key")
        @Expose
        public String secureKey;
        @SerializedName("birthday")
        @Expose
        public String birthday;
        @SerializedName("newsletter")
        @Expose
        public String newsletter;
        @SerializedName("note")
        @Expose
        public Object note;
        @SerializedName("active")
        @Expose
        public String active;
        @SerializedName("is_guest")
        @Expose
        public String isGuest;
        @SerializedName("date_add")
        @Expose
        public String dateAdd;
        @SerializedName("phone")
        @Expose
        public String phone;


        public String getIdCustomer() {
            return idCustomer;
        }

        public void setIdCustomer(String idCustomer) {
            this.idCustomer = idCustomer;
        }

        public String getIdShopGroup() {
            return idShopGroup;
        }

        public void setIdShopGroup(String idShopGroup) {
            this.idShopGroup = idShopGroup;
        }

        public String getIdShop() {
            return idShop;
        }

        public void setIdShop(String idShop) {
            this.idShop = idShop;
        }

        public String getIdGender() {
            return idGender;
        }

        public void setIdGender(String idGender) {
            this.idGender = idGender;
        }

        public String getIdDefaultGroup() {
            return idDefaultGroup;
        }

        public void setIdDefaultGroup(String idDefaultGroup) {
            this.idDefaultGroup = idDefaultGroup;
        }

        public String getIdLang() {
            return idLang;
        }

        public void setIdLang(String idLang) {
            this.idLang = idLang;
        }

        public String getIdRisk() {
            return idRisk;
        }

        public void setIdRisk(String idRisk) {
            this.idRisk = idRisk;
        }

        public Object getCompany() {
            return company;
        }

        public void setCompany(Object company) {
            this.company = company;
        }

        public Object getSiret() {
            return siret;
        }

        public void setSiret(Object siret) {
            this.siret = siret;
        }

        public Object getApe() {
            return ape;
        }

        public void setApe(Object ape) {
            this.ape = ape;
        }

        public String getFirstname() {
            return firstname;
        }

        public void setFirstname(String firstname) {
            this.firstname = firstname;
        }

        public String getLastname() {
            return lastname;
        }

        public void setLastname(String lastname) {
            this.lastname = lastname;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getSecureKey() {
            return secureKey;
        }

        public void setSecureKey(String secureKey) {
            this.secureKey = secureKey;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public String getNewsletter() {
            return newsletter;
        }

        public void setNewsletter(String newsletter) {
            this.newsletter = newsletter;
        }

        public Object getNote() {
            return note;
        }

        public void setNote(Object note) {
            this.note = note;
        }

        public String getActive() {
            return active;
        }

        public void setActive(String active) {
            this.active = active;
        }

        public String getIsGuest() {
            return isGuest;
        }

        public void setIsGuest(String isGuest) {
            this.isGuest = isGuest;
        }

        public String getDateAdd() {
            return dateAdd;
        }

        public void setDateAdd(String dateAdd) {
            this.dateAdd = dateAdd;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }
    }
}
