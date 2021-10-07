package com.lovzme.lovzme2.ui.profileFragment.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.lovzme.lovzme2.R;
import com.lovzme.lovzme2.databinding.ActivityManageAddressBinding;
import com.lovzme.lovzme2.prefrence.ConstantHelper;
import com.lovzme.lovzme2.prefrence.SharedPrefs;
import com.lovzme.lovzme2.ui.profileFragment.addressmodel.AddresslistData;
import com.lovzme.lovzme2.ui.profileFragment.addressmodel.StateListData;
import com.lovzme.lovzme2.ui.profileFragment.addressmodel.body.AddressBody;
import com.lovzme.lovzme2.ui.profileFragment.viewModel.AddressViewModel;
import com.lovzme.lovzme2.ui.profileFragment.viewModel.StateListViewModel;
import com.lovzme.lovzme2.ui.profileFragment.viewModel.UpdateAddressViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import es.dmoral.toasty.Toasty;

public class ManageAddressActivity extends AppCompatActivity {
    ActivityManageAddressBinding binding;
    AddressViewModel Viewmodel;
    String state;
    String country = "";
    boolean isEdit;
    String stateId = "";
    AddresslistData.Payload address;
    ArrayList<StateListData.Payload> statelist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_manage_address);

        setSupportActionBar(binding.toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Manage Address");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        binding.btnSave.setOnClickListener(v -> {
            String firstname = Objects.requireNonNull(binding.ETFirstName.getText()).toString();
            String last_name = Objects.requireNonNull(binding.ETLastName.getText()).toString();
            String phone = Objects.requireNonNull(binding.ETPhoneNo.getText()).toString();
            String password = Objects.requireNonNull(binding.edtCity.getText()).toString();
            String address1 = Objects.requireNonNull(binding.etAddress1.getText()).toString();
            String address2 = Objects.requireNonNull(binding.edtAddress2.getText()).toString();
            String pincode = Objects.requireNonNull(binding.edtPincode.getText()).toString();
            String state = Objects.requireNonNull(binding.SpState.getSelectedItem().toString());

            if (TextUtils.isEmpty(firstname) && TextUtils.isEmpty(last_name) && TextUtils.isEmpty(phone) && TextUtils.isEmpty(password) && TextUtils.isEmpty(address1)
                    && TextUtils.isEmpty(address2) && TextUtils.isEmpty(pincode) && TextUtils.isEmpty(state)) {
                Toasty.error(this, "All fields are mandatory", Toast.LENGTH_SHORT).show();
            } else if (binding.ETFirstName.getText().toString().isEmpty()) {
                binding.ETFirstName.setError("Please enter first name");
            } else if (binding.ETLastName.getText().toString().isEmpty()) {
                binding.ETLastName.setError("Please enter last name");
            } else if (binding.ETPhoneNo.length() != 10) {
                binding.ETPhoneNo.setError("Please enter connect number");
            } else if (binding.edtCity.getText().toString().isEmpty()) {
                binding.edtCity.setError("Please enter city name");
            } else if (binding.etAddress1.getText().toString().isEmpty()) {
                binding.etAddress1.setError("Please enter Address");
            } else if (binding.edtAddress2.getText().toString().isEmpty()) {
                binding.edtAddress2.setError("Please enter Address");
            } else if (binding.edtPincode.length() != 6) {
                binding.edtAddress2.setError("Please enter valid number");
            } else if (binding.SpState.getSelectedItem().toString().isEmpty()) {
                Toasty.error(getApplicationContext(), "Please select state", Toasty.LENGTH_SHORT, true).show();
            } else {
                if (isEdit) {
                    address.setFirstname(binding.ETFirstName.getText().toString());
                    address.setLastname(binding.ETLastName.getText().toString());
                    address.setPhoneMobile(binding.ETPhoneNo.getText().toString());
                    address.setCity(binding.edtCity.getText().toString());
                    address.setAddress1(binding.etAddress1.getText().toString());
                    address.setAddress2(binding.edtAddress2.getText().toString());
                    address.setPostcode(binding.edtPincode.getText().toString());

                    address.setIdState(stateId);
                    UpdateAddress(address);
                } else {
                    AddressManageList();
                }
            }

        });
        StateList();
        binding.SpState.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                country = binding.SpState.getItemAtPosition(binding.SpState.getSelectedItemPosition()).toString();

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    private void setAddress(AddresslistData.Payload address) {
        binding.ETFirstName.setText(address.getFirstname());
        binding.ETLastName.setText(address.getLastname());
        binding.ETPhoneNo.setText(address.getPhoneMobile());
        binding.etAddress1.setText(address.getAddress1());
        binding.edtAddress2.setText(address.getAddress2());
        binding.edtCity.setText(address.getCity());
        binding.edtPincode.setText(address.getPostcode());
        int position = 0;
        for (StateListData.Payload state : statelist) {
            if (state.getIdState().equals(address.getIdState())) {
                position = statelist.indexOf(state);
                stateId = state.getIdState();
            }
        }
        binding.SpState.setSelection(position);
    }

    private void AddressManageList() {
        Viewmodel = new ViewModelProvider(this).get(AddressViewModel.class);
        AddressBody addressBody = new AddressBody();
        AddressBody.Address address = new AddressBody.Address(SharedPrefs.getInstance().getString(ConstantHelper.KEY_CUSTOMER, "EMPTY"),
                state, binding.rbOffice.isChecked() ? "Home" : "Office", "",
                Objects.requireNonNull(binding.ETFirstName.getText()).toString(), Objects.requireNonNull(binding.ETLastName.getText()).toString(),
                Objects.requireNonNull(binding.etAddress1.getText()).toString(), Objects.requireNonNull(binding.edtAddress2.getText()).toString(),
                Objects.requireNonNull(binding.edtPincode.getText()).toString(), Objects.requireNonNull(binding.edtCity.getText()).toString(), "",
                "", Objects.requireNonNull(binding.ETPhoneNo.getText()).toString());
        addressBody.setAddress(address);
        Viewmodel.setAddressDataMutableLiveData(addressBody);

        Viewmodel.getAddressdata().observe(this, addressData -> {
            if (addressData.getSuccess()) {
                finish();
                Toasty.success(this, "Address add Successfull", Toast.LENGTH_SHORT).show();
            } else {
                Toasty.error(this, "something missing", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void StateList() {
        StateListViewModel viewModel = new ViewModelProvider(this).get(StateListViewModel.class);
        viewModel.setState();
        viewModel.getStateList().observe(this, (StateListData stateListData) -> {
            if (stateListData.getSuccess() != null) {
                statelist.addAll(stateListData.getPayload());
                ArrayList<String> stateName = new ArrayList<>();
                for (int i = 0; i < statelist.size(); i++) {
                    stateName.add(statelist.get(i).getName());
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, stateName);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                binding.SpState.setAdapter(adapter);
                if (getIntent().hasExtra("Address_list")) {
                    address = (AddresslistData.Payload) getIntent().getSerializableExtra("Address_list");
                    setAddress(address);
                    isEdit = true;
                }

                binding.SpState.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        state = getStateId(statelist, binding.SpState.getSelectedItem().toString());
                        stateId = statelist.get(position).getIdState();
                        Log.e("dadadada", "" + state);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                    }
                });
            }
        });
    }

    private String getStateId(List<StateListData.Payload> list, String stateName) {
        String id = "";
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equals(stateName)) {
                id = list.get(i).idState;
                stateId = list.get(i).getIdState();
            }
        }
        return id;
    }

    private void UpdateAddress(AddresslistData.Payload payload) {
        UpdateAddressViewModel viewModel = new ViewModelProvider(this).get(UpdateAddressViewModel.class);
        viewModel.setUpdateAddress(payload.getUpdateAddress());
        viewModel.getupdateAddress().observe(this, updateAddressData -> {
            if (updateAddressData != null) {
                finish();
                Toasty.success(this, "Address update Successfull", Toast.LENGTH_SHORT).show();
            } else {
                Toasty.error(this, "something missing", Toast.LENGTH_SHORT).show();
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

    @Override
    protected void onResume() {
        super.onResume();
    }
}