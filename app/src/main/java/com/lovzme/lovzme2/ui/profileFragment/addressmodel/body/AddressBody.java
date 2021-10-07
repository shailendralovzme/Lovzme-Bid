package com.lovzme.lovzme2.ui.profileFragment.addressmodel.body;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AddressBody {
    @SerializedName("address")
    @Expose
    public Address address;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public static class Address {

        @SerializedName("id_customer")
        @Expose
        public String idCustomer;
        @SerializedName("id_state")
        @Expose
        public String idState;
        @SerializedName("alias")
        @Expose
        public String alias;
        @SerializedName("company")
        @Expose
        public String company;
        @SerializedName("firstname")
        @Expose
        public String firstname;
        @SerializedName("lastname")
        @Expose
        public String lastname;
        @SerializedName("address1")
        @Expose
        public String address1;
        @SerializedName("address2")
        @Expose
        public String address2;
        @SerializedName("postcode")
        @Expose
        public String postcode;
        @SerializedName("city")
        @Expose
        public String city;
        @SerializedName("other")
        @Expose
        public String other;
        @SerializedName("phone")
        @Expose
        public String phone;
        @SerializedName("phone_mobile")
        @Expose
        public String phoneMobile;

        public Address(String idCustomer, String idState, String alias, String company,
                       String firstname, String lastname, String address1, String address2,
                       String postcode, String city, String other, String phone, String phoneMobile) {
            this.idCustomer = idCustomer;
            this.idState = idState;
            this.alias = alias;
            this.company = company;
            this.firstname = firstname;
            this.lastname = lastname;
            this.address1 = address1;
            this.address2 = address2;
            this.postcode = postcode;
            this.city = city;
            this.other = other;
            this.phone = phone;
            this.phoneMobile = phoneMobile;
        }

        public String getIdCustomer() {
            return idCustomer;
        }

        public void setIdCustomer(String idCustomer) {
            this.idCustomer = idCustomer;
        }

        public String getIdState() {
            return idState;
        }

        public void setIdState(String idState) {
            this.idState = idState;
        }

        public String getAlias() {
            return alias;
        }

        public void setAlias(String alias) {
            this.alias = alias;
        }

        public String getCompany() {
            return company;
        }

        public void setCompany(String company) {
            this.company = company;
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

        public String getAddress1() {
            return address1;
        }

        public void setAddress1(String address1) {
            this.address1 = address1;
        }

        public String getAddress2() {
            return address2;
        }

        public void setAddress2(String address2) {
            this.address2 = address2;
        }

        public String getPostcode() {
            return postcode;
        }

        public void setPostcode(String postcode) {
            this.postcode = postcode;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getOther() {
            return other;
        }

        public void setOther(String other) {
            this.other = other;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getPhoneMobile() {
            return phoneMobile;
        }

        public void setPhoneMobile(String phoneMobile) {
            this.phoneMobile = phoneMobile;
        }
    }
}
