package com.lovzme.lovzme2.ui.profileFragment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.lovzme.lovzme2.R;
import com.lovzme.lovzme2.databinding.LayoutBidHisotryBinding;

import java.util.ArrayList;


public class BidHistoryAdapter extends RecyclerView.Adapter<BidHistoryAdapter.ViewHolder> {
    Context context;
    ArrayList<String> list;

    public BidHistoryAdapter(Context context, ArrayList<String> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public BidHistoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutBidHisotryBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.layout_bid_hisotry,parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull BidHistoryAdapter.ViewHolder holder, int position) {
        holder.binding.textViewProductName.setText(list.get(position));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        LayoutBidHisotryBinding binding;
        public ViewHolder(LayoutBidHisotryBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
