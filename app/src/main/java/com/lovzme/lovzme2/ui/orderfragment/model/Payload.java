package com.lovzme.lovzme2.ui.orderfragment.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class Payload implements Serializable {

    @SerializedName("message")
    @Expose
    public String message;
    @SerializedName("order")
    @Expose
    public List<TicketOrder> ticketOrder = null;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<TicketOrder> getOrder() {
        return ticketOrder;
    }

    public void setOrder(List<TicketOrder> ticketOrder) {
        this.ticketOrder = ticketOrder;
    }
}
