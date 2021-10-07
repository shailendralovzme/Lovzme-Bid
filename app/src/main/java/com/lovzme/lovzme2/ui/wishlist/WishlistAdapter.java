package com.lovzme.lovzme2.ui.wishlist;

import android.content.Context;
import android.graphics.Paint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.lovzme.lovzme2.R;
import com.lovzme.lovzme2.databinding.ItemLoadingBinding;
import com.lovzme.lovzme2.databinding.LayoutUpcomingBidBinding;
import com.lovzme.lovzme2.interFace.MyOnItemClickListner;
import com.lovzme.lovzme2.ui.homefragment.adapter.UpcomingAdapter;

import com.lovzme.lovzme2.ui.mybagFragment.addToCart.CartProduct;
import com.lovzme.lovzme2.ui.wishlist.model.wishlist.Wish;
import com.varunest.sparkbutton.SparkEventListener;


import java.util.ArrayList;

public class WishlistAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    ArrayList<Wish> wishes;
    final int VIEW_TYPE_WISH_ITEM = 0;
    final int VIEW_TYPE_WISH_LOADING = 1;
    MyOnItemClickListner listner;
    public WishlistAdapter(Context context, ArrayList<Wish> wishes) {
        this.context = context;
        this.wishes = wishes;
    }
    public void setListener(MyOnItemClickListner listener){
        this.listner= listener;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_WISH_ITEM) {
            LayoutUpcomingBidBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.layout_upcoming_bid
                    , parent, false);
            return new WishItemViewHolder(binding);
        } else {
            ItemLoadingBinding itemLoadingBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_loading
                    , parent, false);
            return new WishLoadingViewHolder(itemLoadingBinding);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof WishItemViewHolder) {
            WishItemViewHolder itemViewHolder = (WishItemViewHolder) holder;
            itemViewHolder.binding.TVProductName.setText(wishes.get(position).getName());
            itemViewHolder.binding.TVAmount.setText(wishes.get(position).getPriceSelling());
/*            itemViewHolder.binding.TVOfferAmount.setText(wishes.get(position).getPriceTaxIncl());
            itemViewHolder.binding.TVOfferAmount.setPaintFlags(itemViewHolder.binding.TVOfferAmount.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            itemViewHolder.binding.TVTime.setVisibility(View.GONE);
            itemViewHolder.binding.TVTimeZone.setVisibility(View.GONE);*/


            Glide.with(context).load(wishes.get(position).getProductImage()).placeholder(R.mipmap.ic_launcher)
                    .into(itemViewHolder.binding.ImgProductDetails);
        }else if (holder instanceof WishLoadingViewHolder) {
            showLoadingView((WishLoadingViewHolder) holder, position);
        }
    }
    @Override
    public int getItemViewType(int position) {
        return wishes.get(position) == null ? VIEW_TYPE_WISH_LOADING : VIEW_TYPE_WISH_ITEM;
    }

    public void removeCartItem(int adapterPosition) {
        wishes.remove(adapterPosition);
        notifyItemRemoved(adapterPosition);
        notifyItemRangeChanged(adapterPosition, wishes.size());
    }

    @Override
    public int getItemCount() {
        Log.e("jhdsajdsa", "getItemCount: "+wishes.size() );
        return wishes.size();
    }
    public class WishItemViewHolder extends RecyclerView.ViewHolder {
        LayoutUpcomingBidBinding binding;

        public WishItemViewHolder(LayoutUpcomingBidBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

          /*  binding.sparkButton.setEventListener(new SparkEventListener() {
                @Override
                public void onEvent(ImageView button, boolean buttonState) {
                    if (listner!=null){
                        listner.onRemoveClick(getAdapterPosition());
                    }else {
                        Log.e("listener", "onBindViewHolder: listner is null");
                    }
                }

                @Override
                public void onEventAnimationEnd(ImageView button, boolean buttonState) {

                }

                @Override
                public void onEventAnimationStart(ImageView button, boolean buttonState) {

                }
            });*/
        }



    }
    private class WishLoadingViewHolder extends RecyclerView.ViewHolder {
        ItemLoadingBinding itemLoadingBinding;

        public WishLoadingViewHolder(ItemLoadingBinding itemLoadingBinding) {
            super(itemLoadingBinding.getRoot());
            this.itemLoadingBinding = itemLoadingBinding;
        }
    }
    private void showLoadingView(WishLoadingViewHolder viewHolder, int position) {
    }
}
