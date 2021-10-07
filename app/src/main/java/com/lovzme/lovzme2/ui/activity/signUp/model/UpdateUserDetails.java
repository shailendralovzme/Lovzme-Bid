package com.lovzme.lovzme2.ui.activity.signUp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class UpdateUserDetails {

        @SerializedName("success")
        @Expose
        public Boolean success;
        @SerializedName("payload")
        @Expose
        public Payload payload;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Payload getPayload() {
        return payload;
    }

    public void setPayload(Payload payload) {
        this.payload = payload;
    }

    public class Payload {

        @SerializedName("firstname")
        @Expose
        public String firstname;
        @SerializedName("lastname")
        @Expose
        public String lastname;
        @SerializedName("id_gender")
        @Expose
        public String idGender;
        @SerializedName("birthday")
        @Expose
        public String birthday;
        @SerializedName("newsletter")
        @Expose
        public String newsletter;
        @SerializedName("phone")
        @Expose
        public String phone;

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

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }
    }
}
