package com.lovzme.lovzme2.ui.orderfragment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.lovzme.lovzme2.R;
import com.lovzme.lovzme2.databinding.ItemLoadingBinding;
import com.lovzme.lovzme2.databinding.LayoutOrderIdBinding;
import com.lovzme.lovzme2.ui.orderfragment.model.TicketOrder;


import java.util.ArrayList;


public class OrderDetailsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    ArrayList<TicketOrder> list;
    final int VIEW_TYPE_ITEM = 0;
    final int VIEW_TYPE_LOADING = 1;

    public OrderDetailsAdapter(Context context, ArrayList<TicketOrder> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_ITEM) {
            LayoutOrderIdBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.layout_order_id
                    , parent, false);
            return new ItemViewHolder(binding);
        } else {
            ItemLoadingBinding itemLoadingBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_loading
                    , parent, false);
            return new LoadingViewHolder(itemLoadingBinding);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ItemViewHolder) {
            ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
            itemViewHolder.binding.TvOrderId.setText(list.get(position).getIdOrder());
            itemViewHolder.binding.TvOrderAmount.setText(list.get(position).getTotalpaid());
            itemViewHolder.binding.TvOrderPrice.setText(list.get(position).getTotalpaid());
            itemViewHolder.binding.TvOrderStatus.setText(list.get(position).getStatus());
            itemViewHolder.binding.TvBiddingPrice.setText(list.get(position).getOrderProducts().get(0).getBidValue());

            list.get(position).loadImage(itemViewHolder.binding.ivProductImage,
                    list.get(position).getOrderProducts().get(0).getProductImage());

        }else if (holder instanceof LoadingViewHolder) {
            showLoadingView((LoadingViewHolder) holder, position);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return list.get(position) == null ? VIEW_TYPE_LOADING : VIEW_TYPE_ITEM;
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }


    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        LayoutOrderIdBinding binding;

        public ItemViewHolder(LayoutOrderIdBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }

    }

    private static class LoadingViewHolder extends RecyclerView.ViewHolder {
        ItemLoadingBinding itemLoadingBinding;

        public LoadingViewHolder(ItemLoadingBinding itemLoadingBinding) {
            super(itemLoadingBinding.getRoot());
            this.itemLoadingBinding = itemLoadingBinding;
        }
    }
    private void showLoadingView(LoadingViewHolder viewHolder, int position) {
    }
}
