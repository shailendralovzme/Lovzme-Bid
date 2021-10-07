package com.lovzme.lovzme2.ui.profileFragment.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.lovzme.lovzme2.R;
import com.lovzme.lovzme2.databinding.ItemLoadingBinding;
import com.lovzme.lovzme2.databinding.LayoutWinnerProductBinding;
import com.lovzme.lovzme2.ui.homefragment.response.sallingresponse.SellingProduct;

import java.util.ArrayList;

public class WinnerProductAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    ArrayList<SellingProduct> winnerProducts;
    final int VIEW_TYPE_ITEM = 0;
    final int VIEW_TYPE_LOADING = 1;
    OnItemClickListener onitemClickListener;

    public WinnerProductAdapter(Context context, ArrayList<SellingProduct> winnerProducts,OnItemClickListener onitemClickListener ) {
        this.context = context;
        this.winnerProducts = winnerProducts;
        this.onitemClickListener = onitemClickListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_ITEM) {
            LayoutWinnerProductBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.layout_winner_product
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
            itemViewHolder.binding.textViewProductName.setText(winnerProducts.get(position).getName());
            itemViewHolder.binding.textViewAmount.setText(winnerProducts.get(position).getPriceSelling());
            itemViewHolder.binding.textViewOfferAmount.setText(winnerProducts.get(position).getPriceTaxExcl());
            itemViewHolder.binding.textViewOfferAmount.setPaintFlags(itemViewHolder.binding.textViewOfferAmount.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

            Glide.with(context).load(winnerProducts.get(position).getProductImage()).into(itemViewHolder.binding.ImgProductDetails);

        }else if (holder instanceof LoadingViewHolder) {
            showLoadingView((LoadingViewHolder) holder, position);
        }
    }
    @Override
    public int getItemViewType(int position) {
        return winnerProducts.get(position) == null ? VIEW_TYPE_LOADING : VIEW_TYPE_ITEM;
    }
    @Override
    public int getItemCount() {
        return winnerProducts == null ? 0 : winnerProducts.size();
    }


    public class ItemViewHolder extends RecyclerView.ViewHolder {
        LayoutWinnerProductBinding binding;

        public ItemViewHolder(LayoutWinnerProductBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

            binding.textViewAddToCart.setOnClickListener(v ->
                    onitemClickListener.onClick(winnerProducts.get(getAdapterPosition()), getAdapterPosition()));

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
    public interface OnItemClickListener{
        void onClick(SellingProduct product, int itemPosition);
    }
}
