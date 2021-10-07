package com.lovzme.lovzme2.ui.profileFragment.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.lovzme.lovzme2.ui.profileFragment.addressmodel.DeleteAddressData;
import com.lovzme.lovzme2.ui.profileFragment.repository.AddAddressRepository;
import com.lovzme.lovzme2.ui.profileFragment.addressmodel.AddresslistData;
import com.lovzme.lovzme2.ui.profileFragment.repository.DeleteAddressRespository;


public class AddAddressViewModel extends ViewModel {
    AddAddressRepository addressRepository;
    MutableLiveData<AddresslistData> listDataMutableLiveData = new MutableLiveData<>();

    public void setAddressDataMutableLiveData() {
        addressRepository = AddAddressRepository.getInstance();
        listDataMutableLiveData = addressRepository.addressDataMutableLiveData();
    }

    public LiveData<AddresslistData> getAddressdata() {
        return listDataMutableLiveData;
    }


}
