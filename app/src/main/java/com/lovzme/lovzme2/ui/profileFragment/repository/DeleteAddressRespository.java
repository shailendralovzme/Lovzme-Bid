package com.lovzme.lovzme2.ui.profileFragment.repository;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import com.lovzme.lovzme2.prefrence.ConstantHelper;
import com.lovzme.lovzme2.prefrence.SharedPrefs;
import com.lovzme.lovzme2.ui.profileFragment.addressmodel.DeleteAddressData;
import com.lovzme.lovzme2.utils.Constants;
import com.lovzme.lovzme2.utils.api.ApiCall;
import com.lovzme.lovzme2.utils.api.ApiIterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DeleteAddressRespository {
    ApiIterface apiIterface;
    private static DeleteAddressRespository deleteAddressRespository;

    public static DeleteAddressRespository getInstance(){
        if (deleteAddressRespository == null){
            deleteAddressRespository = new DeleteAddressRespository();

        }
        return deleteAddressRespository;
    }
    public DeleteAddressRespository() {
        apiIterface = ApiCall.getRetrofit().create(ApiIterface.class);
    }

    public MutableLiveData<DeleteAddressData> addresslistDataMutableLiveData(String address_id){
        final MutableLiveData<DeleteAddressData> result = new MutableLiveData<>();
        apiIterface.deleteAddress(Constants.WS_KEY, SharedPrefs.getInstance().getString(ConstantHelper.KEY_CUSTOMER,"EMPTY"),address_id).enqueue(new Callback<DeleteAddressData>() {
            @Override
            public void onResponse(@NonNull Call<DeleteAddressData> call, @NonNull Response<DeleteAddressData> response) {
                if (response.code() == 200) {
                    if (response.body() != null) {
                        result.postValue(response.body());

                    }
                }
            }
            @Override
            public void onFailure(@NonNull Call<DeleteAddressData> call, @NonNull Throwable t) {
                DeleteAddressData deleteAddressData = new DeleteAddressData();
                result.setValue(deleteAddressData);
            }
        });
        return result;
    }
}
