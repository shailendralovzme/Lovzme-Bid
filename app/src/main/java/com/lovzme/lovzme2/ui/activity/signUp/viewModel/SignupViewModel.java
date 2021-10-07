package com.lovzme.lovzme2.ui.activity.signUp.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.lovzme.lovzme2.ui.activity.signUp.model.SignupBody;
import com.lovzme.lovzme2.ui.activity.signUp.model.SignupresponseData;
import com.lovzme.lovzme2.ui.activity.signUp.model.UpdateUserDetails;
import com.lovzme.lovzme2.ui.activity.signUp.model.UpdateUserDetailsBody;
import com.lovzme.lovzme2.ui.activity.signUp.repository.SignupRepository;

public class SignupViewModel extends ViewModel {
    SignupRepository signupRepository;
    MutableLiveData<SignupresponseData> signupRepositoryMutableLiveData = new MutableLiveData<>();
    MutableLiveData<UpdateUserDetails> updateSignUpMutableLiveData = new MutableLiveData<>();

    public void setSignupRepository(SignupBody signupBody) {
        signupRepository = SignupRepository.getInstance();
        signupRepositoryMutableLiveData = signupRepository.Signup(signupBody);
    }

    public LiveData<SignupresponseData> getLogin() {
        return signupRepositoryMutableLiveData;
    }

    /*TODO UpdateUserData TODO*/
    public void setUpdateSignUpMutableLiveData(UpdateUserDetailsBody updateUserDetailsBody) {
        signupRepository = SignupRepository.getInstance();
        updateSignUpMutableLiveData = signupRepository.updateSignUpMutableLiveData(updateUserDetailsBody);
    }

    public LiveData<UpdateUserDetails> updateSignUpLiveData() {
        return updateSignUpMutableLiveData;
    }
}
