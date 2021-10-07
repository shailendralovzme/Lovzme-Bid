package com.lovzme.lovzme2.ui.homefragment.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.lovzme.lovzme2.R;
import com.lovzme.lovzme2.databinding.ItemLoadingBinding;
import com.lovzme.lovzme2.ui.homefragment.activity.ProductDetailsActivity;
import com.lovzme.lovzme2.databinding.LayoutProductBinding;
import com.lovzme.lovzme2.ui.homefragment.response.sallingresponse.SellingProduct;

import java.util.ArrayList;

public class ProductHomeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    ArrayList<SellingProduct> list;
     final int VIEW_TYPE_ITEM = 0;
     final int VIEW_TYPE_LOADING = 1;

    public ProductHomeAdapter(Context context, ArrayList<SellingProduct> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_ITEM) {
            LayoutProductBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.layout_product
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
            itemViewHolder.binding.textViewProductName.setText(list.get(position).getName());
            itemViewHolder.binding.textViewAmount.setText(String.format(" ₹ %s", list.get(position).getPriceSelling()));
           /* itemViewHolder.binding.textViewOfferAmount.setText(list.get(position).getPriceTaxIncl());
            itemViewHolder.binding.textViewOfferAmount.setPaintFlags(itemViewHolder.binding.textViewOfferAmount.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);*/

            String[] splitTime = list.get(position).getCountdown().getSallingTimer().getRemainingTime().split(":");
            long hrs = (long) Integer.parseInt(splitTime[0]) * 60 * 60 * 1000;
            long mins = (long) Integer.parseInt(splitTime[1]) * 60 * 1000;
            long sec = Integer.parseInt(splitTime[2])  * 1000L;
            long counter = hrs+mins+sec;
            new CountDownTimer(counter, 1000) {
                @SuppressLint({"DefaultLocale", "SetTextI18n"})
                public void onTick(long millisUntilFinished) {
                    int hrs = 0;
                    try {
                        hrs = (int) ((millisUntilFinished / 1000)  / 60) / 60;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    long minutes = 0;
                    try {
                        minutes = ((millisUntilFinished / 1000)  / 60 ) % 60;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    int seconds = 0;
                    try {
                        seconds = (int)((millisUntilFinished / 1000) % 60);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    String format = "%1$02d"; // two digits
                    itemViewHolder.binding.textViewHours.setText(String.format(format,hrs)+"");
                    itemViewHolder.binding.TVMinut.setText(String.format(format,minutes)+"");
                    itemViewHolder.binding.TVSecound.setText(String.format(format,seconds)+"");
                }
                @SuppressLint("SetTextI18n")
                public  void onFinish(){

                    itemViewHolder.binding.textViewHours.setText(("00"));
                    itemViewHolder.binding.TVMinut.setText(("00"));
                    itemViewHolder.binding.TVSecound.setText(("00"));
                }
            }.start();


            Glide.with(context).load(list.get(position).getProductImage()).placeholder(R.mipmap.ic_launcher)
                    .into(itemViewHolder.binding.ImgProductDetails);
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
    public class ItemViewHolder extends RecyclerView.ViewHolder  {
        LayoutProductBinding binding;

        public ItemViewHolder(LayoutProductBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

            binding.textViewBidNow.setOnClickListener(v -> {
                Intent intent = new Intent(context, ProductDetailsActivity.class);
                intent.putExtra("Product_details", list.get(getAdapterPosition()));
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                context.startActivity(intent);
            });
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
