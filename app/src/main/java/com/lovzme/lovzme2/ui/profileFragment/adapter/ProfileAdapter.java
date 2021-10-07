package com.lovzme.lovzme2.ui.profileFragment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.lovzme.lovzme2.R;
import com.lovzme.lovzme2.databinding.LayoutProfileBinding;
import com.lovzme.lovzme2.ui.homefragment.response.sallingresponse.SellingProduct;

import java.util.ArrayList;


public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.ViewHolder> {
    Context context;
    ArrayList<String> titles;
    int [] images;

    public ProfileAdapter(Context context, ArrayList<String> titles,  int [] images) {
        this.context = context;
        this.titles = titles;
        this.images = images;
    }

    @NonNull
    @Override
    public ProfileAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutProfileBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.layout_profile,parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ProfileAdapter.ViewHolder holder, int position) {
        holder.binding.TVIconName.setText(titles.get(position));
        holder.binding.constraintProfileView.setTag(titles.get(position));
        holder.binding.ImageIcon.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return titles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        LayoutProfileBinding binding;
        public ViewHolder( LayoutProfileBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            binding.constraintProfileView.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            String title = v.getTag().toString();
           if (title.equalsIgnoreCase("")) {

           }
        }
    }
}
