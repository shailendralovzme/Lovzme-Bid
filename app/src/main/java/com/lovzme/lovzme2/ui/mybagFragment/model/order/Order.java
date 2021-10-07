package com.lovzme.lovzme2.ui.mybagFragment.model.order;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class Order implements Serializable {

    @SerializedName("order_details")
    @Expose
    public OrderDetails orderDetails;
    @SerializedName("address_details")
    @Expose
    public AddressDetails addressDetails;
    @SerializedName("order_coupon")
    @Expose
    public Object orderCoupon;
    @SerializedName("order_products")
    @Expose
    public List<OrderProduct> orderProducts = null;

    @SerializedName("payment_gateway")
    @Expose
    public PaymentGateway paymentGateway;

    public PaymentGateway getPaymentGateway() {
        return paymentGateway;
    }

    public void setPaymentGateway(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public OrderDetails getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(OrderDetails orderDetails) {
        this.orderDetails = orderDetails;
    }

    public AddressDetails getAddressDetails() {
        return addressDetails;
    }

    public void setAddressDetails(AddressDetails addressDetails) {
        this.addressDetails = addressDetails;
    }

    public Object getOrderCoupon() {
        return orderCoupon;
    }

    public void setOrderCoupon(Object orderCoupon) {
        this.orderCoupon = orderCoupon;
    }

    public List<OrderProduct> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(List<OrderProduct> orderProducts) {
        this.orderProducts = orderProducts;
    }
}
