package com.lovzme.lovzme2.ui.activity.login.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.lovzme.lovzme2.ui.activity.login.repository.LogInRepository;
import com.lovzme.lovzme2.ui.activity.login.response.ChangePassword;
import com.lovzme.lovzme2.ui.activity.login.response.logIn.LogInData;
import com.lovzme.lovzme2.ui.activity.login.response.logIn.PhoneLogin;

public class SigninViewModel extends ViewModel {
    LogInRepository loginrepo;
    MutableLiveData<LogInData> addToCartResponseMutableLiveData = new MutableLiveData<>();
    MutableLiveData<ChangePassword> changePasswordMutableLiveData = new MutableLiveData<>();
    MutableLiveData<PhoneLogin> phoneLoginMutableLiveData = new MutableLiveData<>();

    public void  setLogin(String username,String password,String FcmToken){
        loginrepo = LogInRepository.getInstance();
        addToCartResponseMutableLiveData = loginrepo.Login(username,password ,FcmToken);
    }
    public LiveData<LogInData> getLogin(){
        return addToCartResponseMutableLiveData;
    }

    /*TODO PhoneLogIn TODO*/
    public void  setPhoneloginMutabledata(String phone){
        loginrepo = LogInRepository.getInstance();
        phoneLoginMutableLiveData = loginrepo.phoneLoginMutableLiveData(phone);
    }
    public LiveData<PhoneLogin> getphoneLivedata(){
        return phoneLoginMutableLiveData;
    }

    /*TODO PhoneLogIn TODO*/
    public void  setChangePasswordMutableLiveData(String email){
        loginrepo = LogInRepository.getInstance();
        changePasswordMutableLiveData = loginrepo.changePasswordMutableLiveData(email);
    }
    public LiveData<ChangePassword> getchangePasswordliveData(){
        return changePasswordMutableLiveData;
    }
}
