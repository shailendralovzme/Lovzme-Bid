package com.lovzme.lovzme2.ui.profileFragment.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.lovzme.lovzme2.R;
import com.lovzme.lovzme2.databinding.ActivityAddressBinding;
import com.lovzme.lovzme2.interFace.MyOnItemClickListner;
import com.lovzme.lovzme2.ui.profileFragment.addressmodel.AddresslistData;
import com.lovzme.lovzme2.ui.adapter.AddressAdapter;
import com.lovzme.lovzme2.ui.profileFragment.viewModel.AddAddressViewModel;
import com.lovzme.lovzme2.ui.profileFragment.viewModel.DeleteAddressViewModel;

import java.util.ArrayList;
import java.util.Objects;

import es.dmoral.toasty.Toasty;

public class AddressActivity extends AppCompatActivity {
    ActivityAddressBinding binding;
    AddressAdapter addressAdapter;
    ArrayList<AddresslistData.Payload> payloadArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_address);

        setSupportActionBar(binding.toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Shopping Address");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        binding.TVAddNewAddress.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), ManageAddressActivity.class)));
    }

    @Override
    protected void onResume() {
        super.onResume();
        getAddress();
    }

    @SuppressLint("NotifyDataSetChanged")
    private void getAddress() {
        AddAddressViewModel viewModel = new ViewModelProvider(this).get(AddAddressViewModel.class);
        viewModel.setAddressDataMutableLiveData();
        viewModel.getAddressdata().observe(this, addresslistData -> {
            if (addresslistData.getSuccess() != null) {
                payloadArrayList.clear();
                payloadArrayList.addAll(addresslistData.getPayload());
                binding.recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                addressAdapter = new AddressAdapter(getApplicationContext(), this, payloadArrayList,false);
                binding.recyclerView.setAdapter(addressAdapter);
                addressAdapter.notifyDataSetChanged();
                addressAdapter.setListener(new MyOnItemClickListner() {
                    @Override
                    public void onRemoveClick(int position) {
                        deleteAddressDialog(position);
                    }

                    @Override
                    public void onEditClick(int position) {
                        Intent intent = new Intent(AddressActivity.this, ManageAddressActivity.class);
                        intent.putExtra("Address_list", payloadArrayList.get(position));
                        startActivity(intent);
                    }
                });
            }
        });
    }


    public void deleteAddressDialog(int adapterPosition) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(AddressActivity.this);
        alertDialog.setTitle("Delete");
        alertDialog.setMessage("Are you sure you want to Delete?");
        alertDialog.setIcon(R.drawable.ic_delete_primary);
        alertDialog.setPositiveButton("delete", (dialog, which) ->
                DeleteAddress(payloadArrayList.get(adapterPosition).getIdAddress(), adapterPosition));
        alertDialog.setNegativeButton("no", (dialog, which) -> dialog.cancel());
        alertDialog.show();
    }

    private void DeleteAddress(String address_id, int adapterPosition) {
        DeleteAddressViewModel deleteAddressViewModel = new ViewModelProvider(this).get(DeleteAddressViewModel.class);
        deleteAddressViewModel.setState(address_id);
        deleteAddressViewModel.getStateList().observe(this, deleteAddressData -> {
            if (deleteAddressData.getPayload() != null) {
                Toasty.success(AddressActivity.this, "Addressdelete Successfull", Toast.LENGTH_SHORT).show();
                addressAdapter.removeItem(adapterPosition);
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}