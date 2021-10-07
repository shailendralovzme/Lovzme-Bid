package com.lovzme.lovzme2.ui.profileFragment.addressmodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.lovzme.lovzme2.ui.profileFragment.addressmodel.body.UpdateAddressBody;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class AddresslistData  implements Serializable {
    @SerializedName("success")
    @Expose
    public Boolean success;
    @SerializedName("message")
    @Expose
    public String message;
    @SerializedName("payload")
    @Expose
    public List<Payload> payload = null;

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

    public List<Payload> getPayload() {
        return payload;
    }

    public void setPayload(List<Payload> payload) {
        this.payload = payload;
    }

    public static class Payload implements Serializable {

        @SerializedName("id_address")
        @Expose
        public String idAddress;
        @SerializedName("id_country")
        @Expose
        public String idCountry;
        @SerializedName("id_state")
        @Expose
        public String idState;
        @SerializedName("id_customer")
        @Expose
        public String idCustomer;
        @SerializedName("id_manufacturer")
        @Expose
        public String idManufacturer;
        @SerializedName("id_supplier")
        @Expose
        public String idSupplier;
        @SerializedName("id_warehouse")
        @Expose
        public String idWarehouse;
        @SerializedName("alias")
        @Expose
        public String alias;
        @SerializedName("company")
        @Expose
        public String company;
        @SerializedName("lastname")
        @Expose
        public String lastname;
        @SerializedName("firstname")
        @Expose
        public String firstname;
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
        @SerializedName("vat_number")
        @Expose
        public String vatNumber;
        @SerializedName("dni")
        @Expose
        public String dni;
        @SerializedName("date_add")
        @Expose
        public String dateAdd;
        @SerializedName("date_upd")
        @Expose
        public String dateUpd;
        @SerializedName("active")
        @Expose
        public String active;
        @SerializedName("deleted")
        @Expose
        public String deleted;
        @SerializedName("state")
        @Expose
        public String state;

        @SerializedName("comment_order")
        @Expose
        public String comment_order;

        public String getComment_order() {
            return comment_order;
        }

        public void setComment_order(String comment_order) {
            this.comment_order = comment_order;
        }

        public String getIdAddress() {
            return idAddress;
        }

        //ye kidhar use hua hai? // ye api se milta hai getID Address but me ise order krne pe post ke body me use kr rha hu bs call kru kya
        // choose AdreesFragment me milta hai
        public void setIdAddress(String idAddress) {
            this.idAddress = idAddress;
        }

        public String getIdCountry() {
            return idCountry;
        }

        public void setIdCountry(String idCountry) {
            this.idCountry = idCountry;
        }

        public String getIdState() {
            return idState;
        }

        public void setIdState(String idState) {
            this.idState = idState;
        }

        public String getIdCustomer() {
            return idCustomer;
        }

        public void setIdCustomer(String idCustomer) {
            this.idCustomer = idCustomer;
        }

        public String getIdManufacturer() {
            return idManufacturer;
        }

        public void setIdManufacturer(String idManufacturer) {
            this.idManufacturer = idManufacturer;
        }

        public String getIdSupplier() {
            return idSupplier;
        }

        public void setIdSupplier(String idSupplier) {
            this.idSupplier = idSupplier;
        }

        public String getIdWarehouse() {
            return idWarehouse;
        }

        public void setIdWarehouse(String idWarehouse) {
            this.idWarehouse = idWarehouse;
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

        public String getLastname() {
            return lastname;
        }

        public void setLastname(String lastname) {
            this.lastname = lastname;
        }

        public String getFirstname() {
            return firstname;
        }

        public void setFirstname(String firstname) {
            this.firstname = firstname;
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

        public String getVatNumber() {
            return vatNumber;
        }

        public void setVatNumber(String vatNumber) {
            this.vatNumber = vatNumber;
        }

        public String getDni() {
            return dni;
        }

        public void setDni(String dni) {
            this.dni = dni;
        }

        public String getDateAdd() {
            return dateAdd;
        }

        public void setDateAdd(String dateAdd) {
            this.dateAdd = dateAdd;
        }

        public String getDateUpd() {
            return dateUpd;
        }

        public void setDateUpd(String dateUpd) {
            this.dateUpd = dateUpd;
        }

        public String getActive() {
            return active;
        }

        public void setActive(String active) {
            this.active = active;
        }

        public String getDeleted() {
            return deleted;
        }

        public void setDeleted(String deleted) {
            this.deleted = deleted;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public UpdateAddressBody getUpdateAddress(){
            UpdateAddressBody body = new UpdateAddressBody();
            UpdateAddressBody.Address address = new UpdateAddressBody.Address(getIdAddress(),getIdCustomer(),getIdState(),getAlias(),getCompany(),
                    getFirstname(),getLastname(),getAddress1(),getAddress2(),getPostcode(),getCity(),getOther(),getPhone(),getPhoneMobile());
            body.address = address;
            return body;
        }
    }
}
