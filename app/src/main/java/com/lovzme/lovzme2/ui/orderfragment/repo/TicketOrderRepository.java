package com.lovzme.lovzme2.ui.orderfragment.repo;

import androidx.lifecycle.MutableLiveData;

import com.lovzme.lovzme2.prefrence.ConstantHelper;
import com.lovzme.lovzme2.prefrence.SharedPrefs;
import com.lovzme.lovzme2.ui.homefragment.response.sallingresponse.ProductSellingDataList;
import com.lovzme.lovzme2.ui.orderfragment.model.ProductOrderlistData;
import com.lovzme.lovzme2.utils.Constants;
import com.lovzme.lovzme2.utils.api.ApiCall;
import com.lovzme.lovzme2.utils.api.ApiIterface;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TicketOrderRepository {
    ApiIterface apiIterface;
    public static TicketOrderRepository ticketOrderRepository;


    public static TicketOrderRepository getInstance() {
        if (ticketOrderRepository == null) {
            ticketOrderRepository = new TicketOrderRepository();
        }
        return ticketOrderRepository;
    }

    public TicketOrderRepository() {
        apiIterface = ApiCall.getRetrofit().create(ApiIterface.class);
    }

    /*TODO OrderTicket TODO*/
    public MutableLiveData<ProductOrderlistData> productOrderTicketlistDataMutableLiveData(int startposition, int endposition) {
        final MutableLiveData<ProductOrderlistData> result = new MutableLiveData<>();
        apiIterface.ticketOrder(Constants.WS_KEY, SharedPrefs.getInstance().getString(ConstantHelper.KEY_CUSTOMER, "empty"),
                startposition + "," + endposition)
                .enqueue(new Callback<ProductOrderlistData>() {
                    @Override
                    public void onResponse(@NotNull Call<ProductOrderlistData> call, @NotNull Response<ProductOrderlistData> response) {
                        if (response.code() == 200) {
                            if (response.body() != null) {
                                result.postValue(response.body());
                            }
                        }
                    }

                    @Override
                    public void onFailure(@NotNull Call<ProductOrderlistData> call, @NotNull Throwable t) {
                        ProductOrderlistData productOrderlistData = new ProductOrderlistData();
                        result.setValue(productOrderlistData);
                    }
                });
        return result;
    }
    /*TODO ProductOrder TODO*/
    public MutableLiveData<ProductOrderlistData> productOrderlistDataMutableLiveData(int startposition, int endposition) {
        final MutableLiveData<ProductOrderlistData> result = new MutableLiveData<>();
        apiIterface.productDetailsOrder(Constants.WS_KEY, SharedPrefs.getInstance().getString(ConstantHelper.KEY_CUSTOMER, "empty"),
                startposition + "," + endposition)
                .enqueue(new Callback<ProductOrderlistData>() {
                    @Override
                    public void onResponse(@NotNull Call<ProductOrderlistData> call, @NotNull Response<ProductOrderlistData> response) {
                        if (response.code() == 200) {
                            if (response.body() != null) {
                                result.postValue(response.body());
                            }
                        }
                    }

                    @Override
                    public void onFailure(@NotNull Call<ProductOrderlistData> call, @NotNull Throwable t) {
                        ProductOrderlistData productOrderlistData = new ProductOrderlistData();
                        result.setValue(productOrderlistData);
                    }
                });
        return result;
    }

    /*TODO WinnerProduct TODO*/
    public MutableLiveData<ProductSellingDataList> winnerProductlistMutableLiveData(int startposition, int endposition) {
        final MutableLiveData<ProductSellingDataList> result = new MutableLiveData<>();
        apiIterface.winnerProdcut(Constants.WS_KEY, SharedPrefs.getInstance().getString(ConstantHelper.KEY_CUSTOMER, "empty"),
                startposition + "," + endposition)
                .enqueue(new Callback<ProductSellingDataList>() {
                    @Override
                    public void onResponse(@NotNull Call<ProductSellingDataList> call, @NotNull Response<ProductSellingDataList> response) {
                        if (response.code() == 200) {
                            if (response.body() != null) {
                                result.postValue(response.body());
                            }
                        }
                    }

                    @Override
                    public void onFailure(@NotNull Call<ProductSellingDataList> call, @NotNull Throwable t) {
                        ProductSellingDataList winnerPoduct = new ProductSellingDataList();
                        result.setValue(winnerPoduct);
                    }
                });
        return result;
    }
}
