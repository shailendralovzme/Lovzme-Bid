package com.lovzme.lovzme2.ui.profileFragment.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.lovzme.lovzme2.ui.profileFragment.addressmodel.UpdateAddressData;
import com.lovzme.lovzme2.ui.profileFragment.addressmodel.body.UpdateAddressBody;
import com.lovzme.lovzme2.ui.profileFragment.repository.UpdateAddressRepository;

public class UpdateAddressViewModel extends ViewModel {
    UpdateAddressRepository updateAddressRepository;
    MutableLiveData<UpdateAddressData> listDataMutableLiveData = new MutableLiveData<>();

    public void setUpdateAddress(UpdateAddressBody updateAddressBody){
        updateAddressRepository = UpdateAddressRepository.getInstance();
        listDataMutableLiveData = updateAddressRepository.updateAddressDataMutableLiveData(updateAddressBody);
    }
    public LiveData<UpdateAddressData> getupdateAddress(){
        return listDataMutableLiveData;
    }
}
