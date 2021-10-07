package com.lovzme.lovzme2.ui.homefragment.repo;

import androidx.lifecycle.MutableLiveData;

import com.lovzme.lovzme2.prefrence.ConstantHelper;
import com.lovzme.lovzme2.prefrence.SharedPrefs;
import com.lovzme.lovzme2.ui.wishlist.model.DeleteWishlistItem;
import com.lovzme.lovzme2.ui.wishlist.model.wishlist.Wishlistresponse;
import com.lovzme.lovzme2.utils.Constants;
import com.lovzme.lovzme2.utils.api.ApiCall;
import com.lovzme.lovzme2.utils.api.ApiIterface;
import com.lovzme.lovzme2.ui.wishlist.model.WishlistBody;
import com.lovzme.lovzme2.ui.wishlist.model.Wishlistdata;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WishListRepository {
    ApiIterface apiIterface;
    public static WishListRepository wishListRepository;

    public static WishListRepository getInstance(){
        if (wishListRepository == null){
            wishListRepository = new WishListRepository();
        }
        return wishListRepository;
    }

    public WishListRepository(){
        apiIterface = ApiCall.getRetrofit().create(ApiIterface.class);
    }
    public MutableLiveData<Wishlistdata> wishlistResponseMutableLiveData(WishlistBody wishlistBody){
        final MutableLiveData<Wishlistdata> result = new MutableLiveData<>();
        apiIterface.addWishlist(Constants.WS_KEY,wishlistBody).enqueue(new Callback<Wishlistdata>() {
            @Override
            public void onResponse(@NotNull Call<Wishlistdata> call, @NotNull Response<Wishlistdata> response) {
                if (response.code()==200){
                    if (response.body()!=null){
                        result.postValue(response.body());
                    }
                }

            }

            @Override
            public void onFailure(@NotNull Call<Wishlistdata> call, @NotNull Throwable t) {
                Wishlistdata wishListResponse = new Wishlistdata();
              result.setValue(wishListResponse);

            }
        });
       return result;
    }

    /*TODO getWishList TODO*/
    public MutableLiveData<Wishlistresponse> getWishlistMutableLIveData(int startposition, int endposition){
        final MutableLiveData<Wishlistresponse> result = new MutableLiveData<>();
        apiIterface.getWishlist(Constants.WS_KEY, SharedPrefs.getInstance().getString(ConstantHelper.KEY_CUSTOMER,"Empty"),
                startposition+","+endposition)
                .enqueue(new Callback<Wishlistresponse>() {
            @Override
            public void onResponse(@NotNull Call<Wishlistresponse> call, @NotNull Response<Wishlistresponse> response) {
                if (response.code()==200){
                    if (response.body()!=null){
                        result.postValue(response.body());
                    }
                }

            }

            @Override
            public void onFailure(@NotNull Call<Wishlistresponse> call, @NotNull Throwable t) {
                Wishlistresponse wishListResponse = new Wishlistresponse();
                result.setValue(wishListResponse);

            }
        });
        return result;
    }

    /*TODO DeleteWishList TODO*/
    public MutableLiveData<DeleteWishlistItem> deleteWishlistItemMutableLiveData(String productid){
        final MutableLiveData<DeleteWishlistItem> result = new MutableLiveData<>();
        apiIterface.deletewishlist(Constants.WS_KEY, SharedPrefs.getInstance().getString(ConstantHelper.KEY_CUSTOMER,"Empty"),
                productid,SharedPrefs.getInstance().getString(ConstantHelper.secure_key,"EMPTY") )
                .enqueue(new Callback<DeleteWishlistItem>() {
                    @Override
                    public void onResponse(@NotNull Call<DeleteWishlistItem> call, @NotNull Response<DeleteWishlistItem> response) {
                        if (response.code()==200){
                            if (response.body()!=null){
                                result.postValue(response.body());
                            }
                        }

                    }

                    @Override
                    public void onFailure(@NotNull Call<DeleteWishlistItem> call, @NotNull Throwable t) {
                        DeleteWishlistItem wishListResponse = new DeleteWishlistItem();
                        result.setValue(wishListResponse);

                    }
                });
        return result;
    }
}
