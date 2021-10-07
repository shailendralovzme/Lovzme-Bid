package com.lovzme.lovzme2.ui.homefragment.repo;

import androidx.lifecycle.MutableLiveData;

import com.lovzme.lovzme2.ui.homefragment.response.pincode.PinCodeResponse;
import com.lovzme.lovzme2.utils.Constants;
import com.lovzme.lovzme2.utils.api.ApiCall;
import com.lovzme.lovzme2.utils.api.ApiIterface;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class PinCodeRepository {
    ApiIterface apiIterface;
   private static PinCodeRepository pinCodeRepository;

    public static PinCodeRepository getInstance(){
        if (pinCodeRepository == null){
            pinCodeRepository = new PinCodeRepository();
        }
        return pinCodeRepository;
    }

    public PinCodeRepository() {
        apiIterface = ApiCall.getRetrofit().create(ApiIterface.class);
    }

    public MutableLiveData<PinCodeResponse> pinCodeResponseMutableLiveData(String pincode){
        final MutableLiveData<PinCodeResponse> result = new MutableLiveData<>();
        apiIterface.pincoderesponse(Constants.WS_KEY,pincode).enqueue(new Callback<PinCodeResponse>() {
            @Override
            public void onResponse(@NotNull Call<PinCodeResponse> call, @NotNull Response<PinCodeResponse> response) {
                if (response.code()==200){
                    if (response.body()!=null){
                        result.postValue(response.body());
                    }
                }
            }
            @Override
            public void onFailure(@NotNull Call<PinCodeResponse> call, @NotNull Throwable t) {
                PinCodeResponse pinCodeResponseData = new PinCodeResponse();
                result.setValue(pinCodeResponseData);
            }
        });
        return result;
    }
}
