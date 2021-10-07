package com.lovzme.lovzme2.ui.activity.login.repository;


import androidx.lifecycle.MutableLiveData;

import com.lovzme.lovzme2.ui.activity.login.response.ChangePassword;
import com.lovzme.lovzme2.ui.activity.login.response.logIn.LogInData;
import com.lovzme.lovzme2.ui.activity.login.response.logIn.PhoneLogin;
import com.lovzme.lovzme2.utils.Constants;
import com.lovzme.lovzme2.utils.api.ApiCall;
import com.lovzme.lovzme2.utils.api.ApiIterface;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LogInRepository {
    ApiIterface apiIterface;
    private static LogInRepository HomeRepository;

    public  static LogInRepository getInstance() {
        if (HomeRepository == null) {
            HomeRepository = new LogInRepository();
        }
        return HomeRepository;
    }
    public LogInRepository() {
        apiIterface = ApiCall.getRetrofit().create(ApiIterface.class);
    }
    public MutableLiveData<LogInData> Login(String username ,String password,String FcmToken){
        final MutableLiveData<LogInData> result = new MutableLiveData<>();
        apiIterface.loginData(Constants.WS_KEY,username,password,FcmToken).enqueue(new Callback<LogInData>() {
            @Override
            public void onResponse(@NotNull Call<LogInData> call, @NotNull Response<LogInData> response) {
                if (response.code()==200){
                    if (response.body()!=null){
                        result.postValue(response.body());

                    }
                }
            }
            @Override
            public void onFailure(@NotNull Call<LogInData> call, @NotNull Throwable t) {
                LogInData logInData = new LogInData();
                result.setValue(logInData);
            }
        });
        return result;
    }
    public MutableLiveData<ChangePassword> changePasswordMutableLiveData(String email){
        final MutableLiveData<ChangePassword> result = new MutableLiveData<>();
        apiIterface.changePassword(Constants.WS_KEY,email).enqueue(new Callback<ChangePassword>() {
            @Override
            public void onResponse(@NotNull Call<ChangePassword> call, @NotNull Response<ChangePassword> response) {
                if (response.code()==200){
                    if (response.body()!=null){
                        result.postValue(response.body());

                    }
                }
            }
            @Override
            public void onFailure(@NotNull Call<ChangePassword> call, @NotNull Throwable t) {
                ChangePassword logInData = new ChangePassword();
                result.setValue(logInData);
            }
        });
        return result;
    }

    public MutableLiveData<PhoneLogin> phoneLoginMutableLiveData(String phonelogin){
        final MutableLiveData<PhoneLogin> result = new MutableLiveData<>();
        apiIterface.phonelogin(Constants.WS_KEY,phonelogin).enqueue(new Callback<PhoneLogin>() {
            @Override
            public void onResponse(@NotNull Call<PhoneLogin> call, @NotNull Response<PhoneLogin> response) {
                if (response.code()==200){
                    if (response.body()!=null){
                        result.postValue(response.body());

                    }
                }
            }
            @Override
            public void onFailure(@NotNull Call<PhoneLogin> call, @NotNull Throwable t) {
                PhoneLogin logInData = new PhoneLogin();
                result.setValue(logInData);
            }
        });
        return result;
    }
}
