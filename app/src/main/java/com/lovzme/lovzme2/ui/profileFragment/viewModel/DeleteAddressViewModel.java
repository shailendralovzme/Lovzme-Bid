package com.lovzme.lovzme2.ui.profileFragment.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.lovzme.lovzme2.ui.profileFragment.addressmodel.DeleteAddressData;
import com.lovzme.lovzme2.ui.profileFragment.repository.DeleteAddressRespository;

public class DeleteAddressViewModel extends ViewModel {
    DeleteAddressRespository deleteAddressrepo;
    MutableLiveData<DeleteAddressData> listDataMutableLiveData = new MutableLiveData<>();

    public void setState(String address_id){
        deleteAddressrepo = DeleteAddressRespository.getInstance();
        listDataMutableLiveData = deleteAddressrepo.addresslistDataMutableLiveData(address_id);
    }
    public LiveData<DeleteAddressData> getStateList(){
        return listDataMutableLiveData;
    }
}
