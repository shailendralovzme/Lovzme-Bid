package com.lovzme.lovzme2.ui.activity.signUp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class UpdateUserDetailsBody {
        @SerializedName("customer")
        @Expose
        public Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public static class Customer {
        @SerializedName("id_customer")
        @Expose
        public String idCustomer;
        @SerializedName("secure_key")
        @Expose
        public String secureKey;
        @SerializedName("passwd")
        @Expose
        public String passwd;
        @SerializedName("firstname")
        @Expose
        public String firstname;
        @SerializedName("lastname")
        @Expose
        public String lastname;
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

        public Customer(String idCustomer, String secureKey, String passwd, String firstname, String lastname,
                        String phone, String idGender, String birthday, String newsletter) {
            this.idCustomer = idCustomer;
            this.secureKey = secureKey;
            this.passwd = passwd;
            this.firstname = firstname;
            this.lastname = lastname;
            this.phone = phone;
            this.idGender = idGender;
            this.birthday = birthday;
            this.newsletter = newsletter;
        }


        public String getIdCustomer() {
            return idCustomer;
        }

        public void setIdCustomer(String idCustomer) {
            this.idCustomer = idCustomer;
        }

        public String getSecureKey() {
            return secureKey;
        }

        public void setSecureKey(String secureKey) {
            this.secureKey = secureKey;
        }

        public String getPasswd() {
            return passwd;
        }

        public void setPasswd(String passwd) {
            this.passwd = passwd;
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
    }
}
