package com.lovzme.lovzme2.ui.activity.signUp.repository;

import androidx.lifecycle.MutableLiveData;

import com.lovzme.lovzme2.ui.activity.signUp.model.SignupBody;
import com.lovzme.lovzme2.ui.activity.signUp.model.SignupresponseData;
import com.lovzme.lovzme2.ui.activity.signUp.model.UpdateUserDetails;
import com.lovzme.lovzme2.ui.activity.signUp.model.UpdateUserDetailsBody;
import com.lovzme.lovzme2.utils.Constants;
import com.lovzme.lovzme2.utils.api.ApiCall;
import com.lovzme.lovzme2.utils.api.ApiIterface;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignupRepository {
    ApiIterface apiIterface;
    private static SignupRepository signupRepository;

    public static SignupRepository getInstance() {
        if (signupRepository == null) {
            signupRepository = new SignupRepository();
        }
        return signupRepository;
    }
    public SignupRepository() {
        apiIterface = ApiCall.getRetrofit().create(ApiIterface.class);
    }

    public MutableLiveData<SignupresponseData> Signup(SignupBody signupBody){
        final MutableLiveData<SignupresponseData> result = new MutableLiveData<>();
        apiIterface.signupdata(Constants.WS_KEY,signupBody).enqueue(new Callback<SignupresponseData>() {
            @Override
            public void onResponse(@NotNull Call<SignupresponseData> call, @NotNull Response<SignupresponseData> response) {
                if (response.code()==200){
                    if (response.body()!=null){
                        result.postValue(response.body());
                    }
                }
            }
            @Override
            public void onFailure(@NotNull Call<SignupresponseData> call, @NotNull Throwable t) {
                SignupresponseData signupresponseData = new SignupresponseData();
                result.setValue(signupresponseData);
            }
        });
        return result;
    }


    /*TODO UpdateUserData TODO*/
    public MutableLiveData<UpdateUserDetails> updateSignUpMutableLiveData(UpdateUserDetailsBody updateUserDetailsBody){
        final MutableLiveData<UpdateUserDetails> result = new MutableLiveData<>();
        apiIterface.updateUserDetails(Constants.WS_KEY, updateUserDetailsBody).enqueue(new Callback<UpdateUserDetails>() {
            @Override
            public void onResponse(@NotNull Call<UpdateUserDetails> call, @NotNull Response<UpdateUserDetails> response) {
                if (response.code()==200){
                    if (response.body()!=null){
                        result.postValue(response.body());
                    }
                }
            }
            @Override
            public void onFailure(@NotNull Call<UpdateUserDetails> call, @NotNull Throwable t) {
                UpdateUserDetails updateUserDetails = new UpdateUserDetails();
                result.setValue(updateUserDetails);
            }
        });
        return result;
    }
}
