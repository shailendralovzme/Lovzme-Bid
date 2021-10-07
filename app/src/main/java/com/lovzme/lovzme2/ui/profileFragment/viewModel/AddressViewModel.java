package com.lovzme.lovzme2.ui.profileFragment.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.lovzme.lovzme2.ui.profileFragment.addressmodel.body.AddressBody;
import com.lovzme.lovzme2.ui.profileFragment.addressmodel.AddressData;
import com.lovzme.lovzme2.ui.profileFragment.repository.AddressRepository;


public class AddressViewModel extends ViewModel {
    AddressRepository addressRepository;
    MutableLiveData<AddressData> listDataMutableLiveData = new MutableLiveData<>();

    public void setAddressDataMutableLiveData(AddressBody addressBody){
        addressRepository = AddressRepository.getInstance();
        listDataMutableLiveData = addressRepository.addressDataMutableLiveData(addressBody);
    }
    public LiveData<AddressData> getAddressdata(){
        return listDataMutableLiveData;
    }
}
