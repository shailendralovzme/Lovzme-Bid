package com.lovzme.lovzme2.ui.mybagFragment.model.order;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class OrderPaymentSuccess {
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
        @SerializedName("id_transaction")
        @Expose
        public String idTransaction;
        @SerializedName("payment_gateway")
        @Expose
        public SuccessPaymentGateway paymentGateway;

        public Order(String idCustomer, String idCart, String secureKey, String payment, String idTransaction, SuccessPaymentGateway paymentGateway) {
            this.idCustomer = idCustomer;
            this.idCart = idCart;
            this.secureKey = secureKey;
            this.payment = payment;
            this.idTransaction = idTransaction;
            this.paymentGateway = paymentGateway;
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

        public String getIdTransaction() {
            return idTransaction;
        }

        public void setIdTransaction(String idTransaction) {
            this.idTransaction = idTransaction;
        }

        public SuccessPaymentGateway getPaymentGateway() {
            return paymentGateway;
        }

        public void setPaymentGateway(SuccessPaymentGateway paymentGateway) {
            this.paymentGateway = paymentGateway;
        }
    }
}
