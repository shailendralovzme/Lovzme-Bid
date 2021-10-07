package com.lovzme.lovzme2.ui.activity.signUp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class SignupBody {
    @SerializedName("customer")
    @Expose
    public Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Generated("jsonschema2pojo")
    public static class Customer {

        @SerializedName("firstname")
        @Expose
        public String firstname;
        @SerializedName("lastname")
        @Expose
        public String lastname;
        @SerializedName("email")
        @Expose
        public String email;
        @SerializedName("passwd")
        @Expose
        public String passwd;
        @SerializedName("phone")
        @Expose
        public String phone;
        @SerializedName("id_gender")
        @Expose
        public String idGender;
        @SerializedName("birthday")
        @Expose
        public String birthday;
        @SerializedName("newsletter")
        @Expose
        public String newsletter;
        @SerializedName("devicetoken")
        @Expose
        public String devicetoken;

        public Customer(String firstname, String lastname, String email, String passwd, String phone, String idGender, String birthday, String newsletter, String devicetoken) {
            this.firstname = firstname;
            this.lastname = lastname;
            this.email = email;
            this.passwd = passwd;
            this.phone = phone;
            this.idGender = idGender;
            this.birthday = birthday;
            this.newsletter = newsletter;
            this.devicetoken = devicetoken;
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

        public String getPasswd() {
            return passwd;
        }

        public void setPasswd(String passwd) {
            this.passwd = passwd;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getIdGender() {
            return idGender;
        }

        public void setIdGender(String idGender) {
            this.idGender = idGender;
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

        public String getDevicetoken() {
            return devicetoken;
        }

        public void setDevicetoken(String devicetoken) {
            this.devicetoken = devicetoken;
        }
    }
}
