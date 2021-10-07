package com.lovzme.lovzme2.ui.profileFragment.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.lovzme.lovzme2.ui.profileFragment.addressmodel.StateListData;
import com.lovzme.lovzme2.ui.profileFragment.repository.StatelistRepository;


public class StateListViewModel extends ViewModel {
    StatelistRepository statelistRepository;
    MutableLiveData<StateListData> listDataMutableLiveData = new MutableLiveData<>();

    public void setState(){
        statelistRepository = StatelistRepository.getInstance();
        listDataMutableLiveData = statelistRepository.stateListDataMutableLiveData();
    }
    public LiveData<StateListData> getStateList(){
        return listDataMutableLiveData;
    }
}
