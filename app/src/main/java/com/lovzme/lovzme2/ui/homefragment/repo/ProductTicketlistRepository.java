package com.lovzme.lovzme2.ui.homefragment.repo;

import androidx.lifecycle.MutableLiveData;
import com.lovzme.lovzme2.prefrence.ConstantHelper;
import com.lovzme.lovzme2.prefrence.SharedPrefs;
import com.lovzme.lovzme2.ui.homefragment.response.productdetaiils.ProductDetails;
import com.lovzme.lovzme2.ui.homefragment.response.sallingresponse.ProductSellingDataList;
import com.lovzme.lovzme2.utils.Constants;
import com.lovzme.lovzme2.utils.api.ApiCall;
import com.lovzme.lovzme2.utils.api.ApiIterface;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductTicketlistRepository {
    ApiIterface apiIterface;
    public static ProductTicketlistRepository currentBidRepository;

    public static ProductTicketlistRepository getInstance(){
        if (currentBidRepository==null){
            currentBidRepository = new ProductTicketlistRepository();
        }
        return currentBidRepository;
    }
    public ProductTicketlistRepository(){
        apiIterface = ApiCall.getRetrofit().create(ApiIterface.class);
    }
    public MutableLiveData<ProductDetails>productDetailsMutableLiveData(String product_id){
        final MutableLiveData<ProductDetails> result = new MutableLiveData<>();
        apiIterface.productDetails(Constants.WS_KEY,product_id, SharedPrefs.getInstance().getString(ConstantHelper.KEY_CUSTOMER,"EMPTY"))
                .enqueue(new Callback<ProductDetails>() {
            @Override
            public void onResponse(@NotNull Call<ProductDetails> call, @NotNull Response<ProductDetails> response) {
                if (response.code()==200){
                    if (response.body()!=null){
                        result.postValue(response.body());
                    }
                }
            }
            @Override
            public void onFailure(@NotNull Call<ProductDetails> call, @NotNull Throwable t) {
                ProductDetails signupresponseData = new ProductDetails();
                result.setValue(signupresponseData);
            }
        });
        return result;
    }

    public MutableLiveData<ProductSellingDataList> productTicketListMutableLiveData(int startposition, int endposition){
        final MutableLiveData<ProductSellingDataList> result = new MutableLiveData<>();
        apiIterface.productticketlist(Constants.WS_KEY,SharedPrefs.getInstance().getString(ConstantHelper.KEY_CUSTOMER,"EMPTY"),
                startposition+","+endposition)
                .enqueue(new Callback<ProductSellingDataList>() {
            @Override
            public void onResponse(@NotNull Call<ProductSellingDataList> call, @NotNull Response<ProductSellingDataList> response) {
                if (response.code()==200){
                    if (response.body()!=null){
                        result.postValue(response.body());
                    }
                }
            }
            @Override
            public void onFailure(@NotNull Call<ProductSellingDataList> call, @NotNull Throwable t) {
                ProductSellingDataList livesale = new ProductSellingDataList();
                result.setValue(livesale);
            }
        });
        return result;
    }

    public MutableLiveData<ProductSellingDataList> productUpcomingsaleLiveData(int startposition, int endposition){
        final MutableLiveData<ProductSellingDataList> result = new MutableLiveData<>();
        apiIterface.productupcomingsale(Constants.WS_KEY,SharedPrefs.getInstance().getString(ConstantHelper.KEY_CUSTOMER,"EMPTY"),
                startposition+","+endposition)
                .enqueue(new Callback<ProductSellingDataList>() {
                    @Override
                    public void onResponse(@NotNull Call<ProductSellingDataList> call, @NotNull Response<ProductSellingDataList> response) {
                        if (response.code()==200){
                            if (response.body()!=null){
                                result.postValue(response.body());
                            }
                        }
                    }
                    @Override
                    public void onFailure(@NotNull Call<ProductSellingDataList> call, @NotNull Throwable t) {
                        ProductSellingDataList upcomingsale = new ProductSellingDataList();
                        result.setValue(upcomingsale);
                    }
                });
        return result;
    }
}
