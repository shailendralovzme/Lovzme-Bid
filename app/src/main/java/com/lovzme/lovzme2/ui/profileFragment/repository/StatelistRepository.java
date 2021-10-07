package com.lovzme.lovzme2.ui.profileFragment.repository;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import com.lovzme.lovzme2.ui.profileFragment.addressmodel.StateListData;
import com.lovzme.lovzme2.utils.Constants;
import com.lovzme.lovzme2.utils.api.ApiCall;
import com.lovzme.lovzme2.utils.api.ApiIterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StatelistRepository {
    ApiIterface apiIterface;
    private static StatelistRepository statelistRepository;

    public static StatelistRepository getInstance() {
        if (statelistRepository == null) {
            statelistRepository = new StatelistRepository();
        }
        return statelistRepository;
    }
    public StatelistRepository() {
        apiIterface = ApiCall.getRetrofit().create(ApiIterface.class);
    }
    public MutableLiveData<StateListData> stateListDataMutableLiveData() {
        final MutableLiveData<StateListData> result = new MutableLiveData<>();
        apiIterface.statelist(Constants.WS_KEY).enqueue(new Callback<StateListData>() {
            @Override
            public void onResponse(@NonNull Call<StateListData> call, @NonNull Response<StateListData> response) {
                if (response.code() == 200) {
                    if (response.body() != null) {
                        result.postValue(response.body());

                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<StateListData> call, @NonNull Throwable t) {
                StateListData stateListData = new StateListData();
                result.setValue(stateListData);
            }
        });
        return result;
    }

}
