package com.lovzme.lovzme2.ui.homefragment.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;

import com.bumptech.glide.Glide;
import com.lovzme.lovzme2.R;
import com.lovzme.lovzme2.databinding.BannerLayoutBinding;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.List;


public class ProductImageSlider extends SliderViewAdapter<ProductImageSlider.Sliderview> {
    Context context;
    List<String> data;

    public ProductImageSlider(Context context, List<String> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public ProductImageSlider.Sliderview onCreateViewHolder(ViewGroup parent) {
        BannerLayoutBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.banner_layout, parent, false);
        return new Sliderview(binding);
    }

    @Override
    public void onBindViewHolder(ProductImageSlider.Sliderview viewHolder, int position) {
//        final SliderData sliderItem = data.get(position);
        Glide.with(context).load(data.get(position)).into(viewHolder.binding.imageView);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    public class Sliderview extends SliderViewAdapter.ViewHolder {
        BannerLayoutBinding binding;
        public Sliderview(BannerLayoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
