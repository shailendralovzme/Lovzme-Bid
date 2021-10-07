package com.lovzme.lovzme2.ui.profileFragment.repository;

import androidx.lifecycle.MutableLiveData;

import com.lovzme.lovzme2.prefrence.ConstantHelper;
import com.lovzme.lovzme2.prefrence.SharedPrefs;
import com.lovzme.lovzme2.ui.profileFragment.addressmodel.AddresslistData;
import com.lovzme.lovzme2.utils.Constants;
import com.lovzme.lovzme2.utils.api.ApiCall;
import com.lovzme.lovzme2.utils.api.ApiIterface;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddAddressRepository {
    ApiIterface apiIterface;
    private static AddAddressRepository addressRepository;

    public static AddAddressRepository getInstance() {
        if (addressRepository == null) {
            addressRepository = new AddAddressRepository();
        }
        return addressRepository;
    }

    public AddAddressRepository() {
        apiIterface = ApiCall.getRetrofit().create(ApiIterface.class);
    }

    public MutableLiveData<AddresslistData> addressDataMutableLiveData() {
        final MutableLiveData<AddresslistData> result = new MutableLiveData<>();
        apiIterface.getAddress(Constants.WS_KEY, SharedPrefs.getInstance().getString(ConstantHelper.KEY_CUSTOMER, "EMPTY"), "0")
                .enqueue(new Callback<AddresslistData>() {
            @Override
            public void onResponse(@NotNull Call<AddresslistData> call, @NotNull Response<AddresslistData> response) {
                if (response.code() == 200) {
                    if (response.body() != null) {
                        result.postValue(response.body());
                    }
                }
            }

            @Override
            public void onFailure(@NotNull Call<AddresslistData> call, @NotNull Throwable t) {
                AddresslistData addresslistData = new AddresslistData();
                result.setValue(addresslistData);
            }
        });
     return result;
    }
}