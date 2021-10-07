package com.lovzme.lovzme2.ui.homefragment.viewModel;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.lovzme.lovzme2.ui.homefragment.repo.PinCodeRepository;
import com.lovzme.lovzme2.ui.homefragment.response.pincode.PinCodeResponse;


public class PinCodeViewModel extends ViewModel {
    MutableLiveData<PinCodeResponse> pinCodeResponseMutableLiveData = new MutableLiveData<>();

    public void setPinCodeRepository(String pincode){
        pinCodeResponseMutableLiveData = PinCodeRepository.getInstance().pinCodeResponseMutableLiveData(pincode);
    }

    public LiveData<PinCodeResponse> getPincode(){
        return pinCodeResponseMutableLiveData;
    }
}
