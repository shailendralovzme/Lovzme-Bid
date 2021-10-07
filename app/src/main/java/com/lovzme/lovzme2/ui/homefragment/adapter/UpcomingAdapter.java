package com.lovzme.lovzme2.ui.homefragment.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Paint;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.lovzme.lovzme2.R;
import com.lovzme.lovzme2.databinding.ItemLoadingBinding;
import com.lovzme.lovzme2.databinding.LayoutUpcomingBidBinding;
import com.lovzme.lovzme2.prefrence.ConstantHelper;
import com.lovzme.lovzme2.prefrence.SharedPrefs;
import com.lovzme.lovzme2.ui.homefragment.response.sallingresponse.SellingProduct;
import com.lovzme.lovzme2.ui.homefragment.viewModel.WishListViewModel;
import com.lovzme.lovzme2.ui.wishlist.model.WishlistBody;
import com.varunest.sparkbutton.SparkEventListener;

import java.util.ArrayList;

import es.dmoral.toasty.Toasty;

public class UpcomingAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    ArrayList<SellingProduct> upcominglist;
    final int VIEW_TYPE_ITEM = 0;
    final int VIEW_TYPE_LOADING = 1;
    public UpcomingAdapter(Context context, ArrayList<SellingProduct> upcominglist) {
        this.context = context;
        this.upcominglist = upcominglist;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_ITEM) {
            LayoutUpcomingBidBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.layout_upcoming_bid
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
            itemViewHolder.binding.TVProductName.setText(upcominglist.get(position).getName());
            itemViewHolder.binding.TVAmount.setText(upcominglist.get(position).getPriceSelling());

            Glide.with(context).load(upcominglist.get(position).getProductImage()).placeholder(R.mipmap.ic_launcher)
                    .into(itemViewHolder.binding.ImgProductDetails);
        }else if (holder instanceof LoadingViewHolder) {
            showLoadingView((LoadingViewHolder) holder, position);
        }
    }
    @Override
    public int getItemViewType(int position) {
        return upcominglist.get(position) == null ? VIEW_TYPE_LOADING : VIEW_TYPE_ITEM;
    }
    @Override
    public int getItemCount() {
        return upcominglist.size();
    }
    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        LayoutUpcomingBidBinding binding;

        public ItemViewHolder(LayoutUpcomingBidBinding binding) {
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

    private void setWishList(SellingProduct product) {
        WishlistBody wishListBody = new WishlistBody();
        WishlistBody.Wishlist wishlistData = new WishlistBody.Wishlist(SharedPrefs.getInstance().getString(ConstantHelper.KEY_CUSTOMER,context.getString(R.string.empty))
                , SharedPrefs.getInstance().getString(ConstantHelper.secure_key, context.getString(R.string.empty)),
                product.getIdProduct(), "");
        wishListBody.setWishlist(wishlistData);
        WishListViewModel wishListViewModel = new ViewModelProvider((ViewModelStoreOwner) context).get(WishListViewModel.class);
        wishListViewModel.setWishListValue(wishListBody);
        wishListViewModel.getWishList().observe((LifecycleOwner) context, wishListResponse -> {
            if (wishListResponse.getSuccess() != null) {
                Toasty.success(context, wishListResponse.getMessage(), Toasty.LENGTH_SHORT, true).show();
            }
        });
    }
}
