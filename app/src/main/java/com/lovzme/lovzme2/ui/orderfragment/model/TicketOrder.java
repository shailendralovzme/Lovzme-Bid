package com.lovzme.lovzme2.ui.orderfragment.model;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.lovzme.lovzme2.R;
import com.lovzme.lovzme2.ui.mybagFragment.model.order.AddressDetails;
import com.lovzme.lovzme2.ui.mybagFragment.model.order.OrderProduct;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class TicketOrder implements Serializable {

    @SerializedName("id_order")
    @Expose
    public String idOrder;
    @SerializedName("reference")
    @Expose
    public String reference;
    @SerializedName("id_cart")
    @Expose
    public String idCart;
    @SerializedName("date_add")
    @Expose
    public String dateAdd;
    @SerializedName("payment")
    @Expose
    public String payment;
    @SerializedName("delivery_date")
    @Expose
    public String deliveryDate;
    @SerializedName("products_count")
    @Expose
    public String productsCount;
    @SerializedName("quantity_total")
    @Expose
    public String quantityTotal;
    @SerializedName("totalpaid")
    @Expose
    public String totalpaid;
    @SerializedName("status")
    @Expose
    public String status;
    @SerializedName("status_id")
    @Expose
    public String statusId;
    @SerializedName("status_color")
    @Expose
    public String statusColor;
    @SerializedName("total_products")
    @Expose
    public String totalProducts;
    @SerializedName("shipping_cost")
    @Expose
    public String shippingCost;
    @SerializedName("shipping_cost_total")
    @Expose
    public String shippingCostTotal;
    @SerializedName("total_tax")
    @Expose
    public String totalTax;
    @SerializedName("total_discount")
    @Expose
    public String totalDiscount;
    @SerializedName("id_product")
    @Expose
    public String idProduct;
    @SerializedName("id_product_attribute")
    @Expose
    public String idProductAttribute;
    @SerializedName("row_index")
    @Expose
    public String rowIndex;
    @SerializedName("isReturnAvailable")
    @Expose
    public Boolean isReturnAvailable;
    @SerializedName("isExchangeAvailable")
    @Expose
    public Boolean isExchangeAvailable;
    @SerializedName("address_details")
    @Expose
    public AddressDetails addressDetails;
    @SerializedName("order_coupon")
    @Expose
    public Object orderCoupon;
    @SerializedName("invoice_download")
    @Expose
    public String invoiceDownload;
    @SerializedName("order_products")
    @Expose
    public List<OrderProduct> orderProducts = null;

    public String getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(String idOrder) {
        this.idOrder = idOrder;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getIdCart() {
        return idCart;
    }

    public void setIdCart(String idCart) {
        this.idCart = idCart;
    }

    public String getDateAdd() {
        return dateAdd;
    }

    public void setDateAdd(String dateAdd) {
        this.dateAdd = dateAdd;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getProductsCount() {
        return productsCount;
    }

    public void setProductsCount(String productsCount) {
        this.productsCount = productsCount;
    }

    public String getQuantityTotal() {
        return quantityTotal;
    }

    public void setQuantityTotal(String quantityTotal) {
        this.quantityTotal = quantityTotal;
    }

    public String getTotalpaid() {
        return totalpaid;
    }

    public void setTotalpaid(String totalpaid) {
        this.totalpaid = totalpaid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusId() {
        return statusId;
    }

    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }

    public String getStatusColor() {
        return statusColor;
    }

    public void setStatusColor(String statusColor) {
        this.statusColor = statusColor;
    }

    public String getTotalProducts() {
        return totalProducts;
    }

    public void setTotalProducts(String totalProducts) {
        this.totalProducts = totalProducts;
    }

    public String getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(String shippingCost) {
        this.shippingCost = shippingCost;
    }

    public String getShippingCostTotal() {
        return shippingCostTotal;
    }

    public void setShippingCostTotal(String shippingCostTotal) {
        this.shippingCostTotal = shippingCostTotal;
    }

    public String getTotalTax() {
        return totalTax;
    }

    public void setTotalTax(String totalTax) {
        this.totalTax = totalTax;
    }

    public String getTotalDiscount() {
        return totalDiscount;
    }

    public void setTotalDiscount(String totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public String getIdProductAttribute() {
        return idProductAttribute;
    }

    public void setIdProductAttribute(String idProductAttribute) {
        this.idProductAttribute = idProductAttribute;
    }

    public String getRowIndex() {
        return rowIndex;
    }

    public void setRowIndex(String rowIndex) {
        this.rowIndex = rowIndex;
    }

    public Boolean getReturnAvailable() {
        return isReturnAvailable;
    }

    public void setReturnAvailable(Boolean returnAvailable) {
        isReturnAvailable = returnAvailable;
    }

    public Boolean getExchangeAvailable() {
        return isExchangeAvailable;
    }

    public void setExchangeAvailable(Boolean exchangeAvailable) {
        isExchangeAvailable = exchangeAvailable;
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

    public String getInvoiceDownload() {
        return invoiceDownload;
    }

    public void setInvoiceDownload(String invoiceDownload) {
        this.invoiceDownload = invoiceDownload;
    }

    public List<OrderProduct> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(List<OrderProduct> orderProducts) {
        this.orderProducts = orderProducts;
    }

    @BindingAdapter("cartImage")
    public  void loadImage(ImageView view, String imageUrl) {
        Glide.with(view.getContext())
                .load(imageUrl).fitCenter().circleCrop().placeholder(R.mipmap.ic_launcher)
                .into(view);
    }
}

