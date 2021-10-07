package com.lovzme.lovzme2.ui.homefragment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.lovzme.lovzme2.R;
import com.lovzme.lovzme2.databinding.ProductFeaturesLayoutBinding;
import com.lovzme.lovzme2.ui.homefragment.response.productdetaiils.ProductFeatures;

import java.util.List;


public class ProductFeaturesAdapter extends RecyclerView.Adapter<ProductFeaturesAdapter.ViewHolder> {
    Context context;
    List<ProductFeatures> productFeaturesList;

    public ProductFeaturesAdapter(Context context, List<ProductFeatures> productFeaturesList) {
        this.context = context;
        this.productFeaturesList = productFeaturesList;
    }
    @NonNull
    @Override
    public ProductFeaturesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ProductFeaturesLayoutBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.product_features_layout
                , parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductFeaturesAdapter.ViewHolder holder, int position) {
        holder.binding.tvProductFeature.setText(productFeaturesList.get(position).getProductFeatures());
        holder.binding.tvProductFeatureValue.setText(productFeaturesList.get(position).getProductFeaturesValues());

    }

    @Override
    public int getItemCount() {
        return productFeaturesList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ProductFeaturesLayoutBinding binding;
        public ViewHolder( ProductFeaturesLayoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

}
