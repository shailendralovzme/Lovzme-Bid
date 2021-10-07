package com.lovzme.lovzme2.ui.profileFragment.repository;

import androidx.lifecycle.MutableLiveData;
import com.lovzme.lovzme2.ui.profileFragment.addressmodel.body.AddressBody;
import com.lovzme.lovzme2.ui.profileFragment.addressmodel.AddressData;
import com.lovzme.lovzme2.utils.Constants;
import com.lovzme.lovzme2.utils.api.ApiCall;
import com.lovzme.lovzme2.utils.api.ApiIterface;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddressRepository {
    ApiIterface apiIterface;
    private static AddressRepository addressRepository;

    public static AddressRepository getInstance() {
        if (addressRepository == null) {
            addressRepository = new AddressRepository();
        }
        return addressRepository;
    }
    public AddressRepository() {
        apiIterface = ApiCall.getRetrofit().create(ApiIterface.class);
    }
    public MutableLiveData<AddressData> addressDataMutableLiveData(AddressBody addressBody){
        final MutableLiveData<AddressData> result = new MutableLiveData<>();
        apiIterface.addressdata(Constants.WS_KEY,addressBody).enqueue(new Callback<AddressData>() {
            @Override
            public void onResponse(@NotNull Call<AddressData> call, @NotNull Response<AddressData> response) {
                if (response.code()==200){
                    if (response.body()!=null){
                        result.postValue(response.body());
                    }
                }
            }
            @Override
            public void onFailure(@NotNull Call<AddressData> call, @NotNull Throwable t) {
                AddressData signupresponseData = new AddressData();
                result.setValue(signupresponseData);
            }
        });
        return result;
    }
}
