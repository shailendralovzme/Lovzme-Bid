package com.lovzme.lovzme2.ui.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.lovzme.lovzme2.R;
import com.lovzme.lovzme2.databinding.AddressLayoutBinding;
import com.lovzme.lovzme2.interFace.MyOnItemClickListner;
import com.lovzme.lovzme2.ui.profileFragment.addressmodel.AddresslistData;
import com.lovzme.lovzme2.ui.profileFragment.activity.AddressActivity;

import java.util.ArrayList;

public class AddressAdapter extends RecyclerView.Adapter<AddressAdapter.ViewHolder> {
    Context context;
    ArrayList<AddresslistData.Payload> addresslistData;
    MyOnItemClickListner listner;
     boolean isSelectableAddress;
     int mSelectedItem = -1;
     AddressActivity addressActivity;
     AddresslistData.Payload selectedAddress;

    public AddressAdapter(Context context,AddressActivity addressActivity, ArrayList<AddresslistData.Payload> addresslistData,boolean selectableAddress) {
        this.context = context;
        this.addresslistData = addresslistData;
        this.isSelectableAddress = selectableAddress;
        this.addressActivity = addressActivity;
    }

    public void setListener(MyOnItemClickListner listener){
        this.listner= listener;
    }

    @NonNull
    @Override
    public AddressAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        AddressLayoutBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.
                getContext()), R.layout.address_layout, parent, false);
        return new ViewHolder(binding);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull AddressAdapter.ViewHolder holder, int position) {
        if (addresslistData.get(position).getDeleted().equalsIgnoreCase("0")) {
            holder.binding.tvUsername.setText(addresslistData.get(position).getFirstname() + " " +
                    addresslistData.get(position).getLastname());
            holder.binding.tvAddress.setText(addresslistData.get(position).getAddress1()
                    + " " + addresslistData.get(position).getAddress2()
                    + " " + addresslistData.get(position).getCity()
                    + " " + addresslistData.get(position).getPostcode() + ".");
            holder.binding.tvMobileNo.setText(addresslistData.get(position).getPhoneMobile());
            holder.binding.tvAddressType.setText(addresslistData.get(position).getAlias());

            holder.binding.rbAddress.setChecked(position == mSelectedItem);

            if (isSelectableAddress) {
                holder.binding.editRemoveContainer.setVisibility(View.GONE);
                holder.binding.rbAddress.setVisibility(View.VISIBLE);
            } else {
                holder.binding.editRemoveContainer.setVisibility(View.VISIBLE);
                holder.binding.rbAddress.setVisibility(View.GONE);
            }

            holder.binding.tvRemoveBtn.setOnClickListener(v -> {
                if (listner!=null){
                    listner.onRemoveClick(position);
                }else {
                    Log.e("listener", "onBindViewHolder: listner is null");
                }
            });

            holder.binding.tvEditBtn.setOnClickListener(v -> {
                if (listner!=null){
                    listner.onEditClick(position);

                }else {
                    Log.e("listener", "onBindViewHolder: listner is null");
                }
            });

        }
    }

    @Override
    public int getItemCount() {
        return addresslistData.size();
    }
    public void removeItem(int adapterPosition) {
        addresslistData.remove(adapterPosition);
        notifyItemRemoved(adapterPosition);
        notifyItemRangeChanged(adapterPosition, addresslistData.size());
    }

    public class ViewHolder extends RecyclerView.ViewHolder  {
        AddressLayoutBinding binding;
        public ViewHolder(AddressLayoutBinding binding) {
            super(binding.getRoot());
            this.binding= binding;

            binding.getRoot().setOnClickListener(v -> {
                if (getAdapterPosition() != -1) {
                    mSelectedItem = getAdapterPosition();
                    selectedAddress = addresslistData.get(getAdapterPosition());
                    notifyDataSetChanged();
                }
            });
        }
    }
    public AddresslistData.Payload getSelectedAddress() {
        return selectedAddress;
    }

}
