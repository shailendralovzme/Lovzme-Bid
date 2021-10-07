package com.lovzme.lovzme2.ui.mybagFragment.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.lovzme.lovzme2.R;
import com.lovzme.lovzme2.databinding.PaymentModeListLayoutBinding;
import com.lovzme.lovzme2.ui.mybagFragment.activity.PaymentModeData;

public class PaymentModeAdapter extends RecyclerView.Adapter<PaymentModeAdapter.ViewHolder> {
    Context context;
     int mSelectedItem = -1;
     int payment_mode_no = 0;
     String payment_mode;

    public PaymentModeAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public PaymentModeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        PaymentModeListLayoutBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.payment_mode_list_layout, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PaymentModeAdapter.ViewHolder holder, int position) {
        holder.binding.tvPaymentMode.setText(PaymentModeData.getData().get(position).getPayment_mode());
        holder.binding.rbPaymentMode.setChecked(position == mSelectedItem);
        Glide.with(context).load(PaymentModeData.getData().get(position).getPayment_mode_img()).into(holder.binding.ivPaymentMode);
    }

    @Override
    public int getItemCount() {
        return PaymentModeData.getData().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        PaymentModeListLayoutBinding binding;
        @SuppressLint("NotifyDataSetChanged")
        public ViewHolder(PaymentModeListLayoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

            binding.getRoot().setOnClickListener(v -> {
                if (getAdapterPosition() != -1) {
                    mSelectedItem = getAdapterPosition();
                    payment_mode_no = PaymentModeData.getData().get(getAdapterPosition()).getPayment_mode_no();
                    payment_mode = PaymentModeData.getData().get(getAdapterPosition()).getPayment_mode();
                    notifyDataSetChanged();


                }

            });
        }
    }
    public int getPayment_mode_no() {
        return payment_mode_no;
    }

    public String getPaymentMode() {
        return payment_mode;
    }
}
