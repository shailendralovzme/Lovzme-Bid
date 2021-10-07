package com.lovzme.lovzme2.ui.homefragment.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.lovzme.lovzme2.R;
import com.lovzme.lovzme2.databinding.LayoutProductBinding;

import java.util.ArrayList;

public class MorebidAdapter extends RecyclerView.Adapter<MorebidAdapter.ViewHolder> {
    Context context;
    ArrayList<String> list;

    public MorebidAdapter(Context context, ArrayList<String> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MorebidAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutProductBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.layout_product,parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MorebidAdapter.ViewHolder holder, int position) {
        holder.binding.textViewProductName.setText(list.get(position));
     //   holder.binding.textViewOfferAmount.setPaintFlags(holder.binding.textViewOfferAmount.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        LayoutProductBinding binding;
        public ViewHolder(LayoutProductBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
