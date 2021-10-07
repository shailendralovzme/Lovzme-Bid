package com.lovzme.lovzme2.ui.mybagFragment.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Paint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.lovzme.lovzme2.R;
import com.lovzme.lovzme2.databinding.LayoutCartItemBinding;
import com.lovzme.lovzme2.interFace.MyOnItemClickListner;
import com.lovzme.lovzme2.ui.homefragment.activity.ProductDetailsActivity;
import com.lovzme.lovzme2.ui.mybagFragment.addToCart.CartProduct;

import java.util.ArrayList;


public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {
    Context context;
    ArrayList<CartProduct> cartProducts;
    private int quantity;
    MyOnItemClickListner listner;
    onItemClickListener itemClickListener;

  public CartAdapter(Context context, ArrayList<CartProduct> cartProducts, onItemClickListener itemClickListener) {
        this.context = context;
        this.cartProducts = cartProducts;
        this.itemClickListener = itemClickListener;
    }

    public void setListener(MyOnItemClickListner listener){
        this.listner= listener;
    }

    @NonNull
    @Override
    public CartAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutCartItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.layout_cart_item, parent, false);
        return new ViewHolder(binding);
    }


    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull CartAdapter.ViewHolder holder, int position) {
        holder.binding.setCartProduct(cartProducts.get(position));

        holder.binding.TvTicketPrice.setText(" ₹ "+cartProducts.get(position).getPriceReduction());
       holder.binding.TvBiddingPrice.setText(" ₹ "+cartProducts.get(position).getBidValue());
        cartProducts.get(position).CartImage(holder.binding.ivProductImage, cartProducts.get(position).getProductImage());

    }

    @Override
    public int getItemCount() {
        return cartProducts.size();
    }

    public void removeCartItem(int adapterPosition) {
        cartProducts.remove(adapterPosition);
        notifyItemRemoved(adapterPosition);
        notifyItemRangeChanged(adapterPosition, cartProducts.size());
    }

    private boolean isDiscountAvailable(int position) {
        return (cartProducts.get(position).getReductionRate() != null && Float.parseFloat((String) cartProducts.get(position).getReductionRate()) > 0);
    }

    public void updateQty_Price(CartProduct product, int position) {
        cartProducts.set(position, product);
        notifyItemChanged(position);
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        LayoutCartItemBinding binding;

        public ViewHolder(LayoutCartItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

           // binding.tvOldPrice.setPaintFlags(binding.tvOldPrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

            /*TODO Delete Button TODO*/
           binding.TVDelete.setOnClickListener(v -> {
                if (listner!=null){
                    listner.onRemoveClick(getAdapterPosition());
                }else {
                    Log.e("listener", "onBindViewHolder: listner is null");
                }
            });

      /*     *//* TODO Increase Quantity TODO*//*
            binding.ivIncreaseBtn.setOnClickListener(v -> {
                quantity = Integer.parseInt(cartProducts.get(getAdapterPosition()).getQuantity());
                if (quantity > 9) {
                   binding.ivIncreaseBtn.setClickable(false);
                   binding.ivIncreaseBtn.setEnabled(false);
                    Toast.makeText(context, "Maximum 10 products can be added", Toast.LENGTH_SHORT).show();
                } else {
                    itemClickListener.onClick(cartProducts.get(getAdapterPosition()), ++quantity, getAdapterPosition());
                }

            });

            *//*TODO  Decrease Quantity TODO*//*
           binding.ivDecreaseBtn.setOnClickListener(v -> {
                quantity = Integer.parseInt(cartProducts.get(getAdapterPosition()).getQuantity());
                if (quantity > 1) {
                    itemClickListener.onClick(cartProducts.get(getAdapterPosition()), --quantity, getAdapterPosition());
                }
            });*/
        }
    }
    public interface onItemClickListener{
        void onClick(CartProduct cartPosition, int quantity, int itemPosition);
    }
}
