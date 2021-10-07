package com.lovzme.lovzme2.ui.orderfragment.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.lovzme.lovzme2.R;
import com.lovzme.lovzme2.databinding.LayoutAlertViewBinding;
import com.lovzme.lovzme2.ui.orderfragment.OrderDetailsActivity;
import com.lovzme.lovzme2.ui.orderfragment.model.TicketOrder;
import java.util.ArrayList;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder> {
    Context context;
    ArrayList<TicketOrder> ticketOrders;

    public OrderAdapter(Context context, ArrayList<TicketOrder> ticketOrders) {
        this.context = context;
        this.ticketOrders = ticketOrders;
    }

    @NonNull
    @Override
    public OrderAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutAlertViewBinding viewBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.layout_alert_view
                , parent, false);
        return new ViewHolder(viewBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderAdapter.ViewHolder holder, int position) {
        holder.viewBinding.TvTicketId.setText(ticketOrders.get(position).getIdOrder());
        holder.viewBinding.TvTicketTotalAmount.setText(String.format(" ₹ %s", ticketOrders.get(position).getTotalpaid()));
        holder.viewBinding.TvTicketOrderStatus.setText(ticketOrders.get(position).getStatus());
        holder.viewBinding.TvTicketPrice.setText(String.format(" ₹ %s", ticketOrders.get(position).getTotalpaid()));
        holder.viewBinding.TvBiddingPrice.setText(String.format(" ₹ %s",
                ticketOrders.get(position).getOrderProducts().get(0).getBidValue()));

        ticketOrders.get(position).loadImage(holder.viewBinding.ivProductImage,
                ticketOrders.get(position).getOrderProducts().get(0).getProductImage());
    }

    @Override
    public int getItemCount() {
        return ticketOrders.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        LayoutAlertViewBinding viewBinding;
        public ViewHolder(LayoutAlertViewBinding viewBinding) {
            super(viewBinding.getRoot());
            this.viewBinding = viewBinding;

            viewBinding.BTNView.setOnClickListener(v -> {
                Intent intent = new Intent(context, OrderDetailsActivity.class);
                intent.putExtra(OrderDetailsActivity.PRODUCT_ORDER,ticketOrders.get(getAdapterPosition()));
                context.startActivity(intent);
            });

        }
    } 
}
