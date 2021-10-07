package com.lovzme.lovzme2.ui.mybagFragment.model.order;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class PaymentOrder {
    @SerializedName("order")
    @Expose
    public Order order;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
    public static class Order {

        @SerializedName("id_customer")
        @Expose
        public String idCustomer;
        @SerializedName("id_cart")
        @Expose
        public String idCart;
        @SerializedName("secure_key")
        @Expose
        public String secureKey;
        @SerializedName("payment")
        @Expose
        public String payment;
        @SerializedName("id_address_delivery")
        @Expose
        public String idAddressDelivery;
        @SerializedName("id_address_invoice")
        @Expose
        public String idAddressInvoice;
        @SerializedName("msg")
        @Expose
        public String msg;

        public Order(String idCustomer, String idCart, String secureKey, String payment, String idAddressDelivery, String idAddressInvoice, String msg) {
            this.idCustomer = idCustomer;
            this.idCart = idCart;
            this.secureKey = secureKey;
            this.payment = payment;
            this.idAddressDelivery = idAddressDelivery;
            this.idAddressInvoice = idAddressInvoice;
            this.msg = msg;
        }

        public String getIdCustomer() {
            return idCustomer;
        }

        public void setIdCustomer(String idCustomer) {
            this.idCustomer = idCustomer;
        }

        public String getIdCart() {
            return idCart;
        }

        public void setIdCart(String idCart) {
            this.idCart = idCart;
        }

        public String getSecureKey() {
            return secureKey;
        }

        public void setSecureKey(String secureKey) {
            this.secureKey = secureKey;
        }

        public String getPayment() {
            return payment;
        }

        public void setPayment(String payment) {
            this.payment = payment;
        }

        public String getIdAddressDelivery() {
            return idAddressDelivery;
        }

        public void setIdAddressDelivery(String idAddressDelivery) {
            this.idAddressDelivery = idAddressDelivery;
        }

        public String getIdAddressInvoice() {
            return idAddressInvoice;
        }

        public void setIdAddressInvoice(String idAddressInvoice) {
            this.idAddressInvoice = idAddressInvoice;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }
    }
}
