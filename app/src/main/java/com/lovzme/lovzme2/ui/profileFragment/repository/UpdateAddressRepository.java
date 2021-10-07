package com.lovzme.lovzme2.ui.profileFragment.repository;

import androidx.lifecycle.MutableLiveData;

import com.lovzme.lovzme2.ui.profileFragment.addressmodel.AddressData;
import com.lovzme.lovzme2.ui.profileFragment.addressmodel.UpdateAddressData;
import com.lovzme.lovzme2.ui.profileFragment.addressmodel.body.AddressBody;
import com.lovzme.lovzme2.ui.profileFragment.addressmodel.body.UpdateAddressBody;
import com.lovzme.lovzme2.utils.Constants;
import com.lovzme.lovzme2.utils.api.ApiCall;
import com.lovzme.lovzme2.utils.api.ApiIterface;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpdateAddressRepository {
    ApiIterface apiIterface;
    private static UpdateAddressRepository updateAddressRepository;

    public static UpdateAddressRepository getInstance() {
        if (updateAddressRepository == null) {
            updateAddressRepository = new UpdateAddressRepository();
        }
       return updateAddressRepository;
    }
    public UpdateAddressRepository() {
        apiIterface = ApiCall.getRetrofit().create(ApiIterface.class);
    }
    public MutableLiveData<UpdateAddressData> updateAddressDataMutableLiveData(UpdateAddressBody updateAddressBody){
        final MutableLiveData<UpdateAddressData> result = new MutableLiveData<>();
        apiIterface.updateAddress(Constants.WS_KEY,updateAddressBody).enqueue(new Callback<UpdateAddressData>() {
            @Override
            public void onResponse(@NotNull Call<UpdateAddressData> call, @NotNull Response<UpdateAddressData> response) {
                if (response.code()==200){
                    if (response.body()!=null){
                        result.postValue(response.body());
                    }
                }
            }
            @Override
            public void onFailure(@NotNull Call<UpdateAddressData> call, @NotNull Throwable t) {
                UpdateAddressData signupresponseData = new UpdateAddressData();
                result.setValue(signupresponseData);
            }
        });
        return result;
    }
}
