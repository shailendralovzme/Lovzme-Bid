package com.lovzme.lovzme2.ui.homefragment.repo;


import androidx.lifecycle.MutableLiveData;

import com.lovzme.lovzme2.prefrence.ConstantHelper;
import com.lovzme.lovzme2.prefrence.SharedPrefs;
import com.lovzme.lovzme2.ui.mybagFragment.addToCart.AddToCart;
import com.lovzme.lovzme2.ui.mybagFragment.addToCart.body.AddToCartBody;
import com.lovzme.lovzme2.ui.mybagFragment.addToCart.body.UpdateCartBody;
import com.lovzme.lovzme2.ui.mybagFragment.model.order.OrderBody;
import com.lovzme.lovzme2.ui.mybagFragment.model.order.OrderList;
import com.lovzme.lovzme2.ui.mybagFragment.model.order.OrderPaymentSuccess;
import com.lovzme.lovzme2.ui.mybagFragment.model.order.PaymentOrder;
import com.lovzme.lovzme2.ui.mybagFragment.model.wallet.WalletBalance;
import com.lovzme.lovzme2.ui.mybagFragment.model.wallet.WalletBody.WalletBody;
import com.lovzme.lovzme2.utils.Constants;
import com.lovzme.lovzme2.utils.api.ApiCall;
import com.lovzme.lovzme2.utils.api.ApiIterface;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddtoCartRepository {
    ApiIterface apiIterface;
    public static AddtoCartRepository addToCartRepository;

    public static AddtoCartRepository getInstance(){
        if (addToCartRepository == null){
            addToCartRepository = new AddtoCartRepository();
        }
        return addToCartRepository;
    }
    public AddtoCartRepository() {
        apiIterface = ApiCall.getRetrofit().create(ApiIterface.class);
    }

    /*TODO Post Cart TODO */
    public MutableLiveData<AddToCart> addToCartMutableLiveData(AddToCartBody addToCartBody) {
        final MutableLiveData<AddToCart> result = new MutableLiveData<>();
        apiIterface.addtocart(Constants.WS_KEY, addToCartBody)
                .enqueue(new Callback<AddToCart>() {
                    @Override
                    public void onResponse(@NotNull Call<AddToCart> call, @NotNull Response<AddToCart> response) {
                        if (response.code() == 200) {
                            if (response.body() != null) {
                                result.postValue(response.body());
                            }
                        }
                    }

                    @Override
                    public void onFailure(@NotNull Call<AddToCart> call, @NotNull Throwable t) {
                        AddToCart addresslistData = new AddToCart();
                        result.setValue(addresslistData);
                    }
                });
        return result;
    }
    /*TODO get Cart TODO */
    public MutableLiveData<AddToCart> getCartToAddMutableLiveData() {
        final MutableLiveData<AddToCart> result = new MutableLiveData<>();
        apiIterface.getcartItem(Constants.WS_KEY, SharedPrefs.getInstance().getString(ConstantHelper.KEY_CUSTOMER,"EMPTY"))
                .enqueue(new Callback<AddToCart>() {
                    @Override
                    public void onResponse(@NotNull Call<AddToCart> call, @NotNull Response<AddToCart> response) {
                        if (response.code() == 200) {
                            if (response.body() != null) {
                                result.postValue(response.body());
                            }
                        }
                    }

                    @Override
                    public void onFailure(@NotNull Call<AddToCart> call, @NotNull Throwable t) {
                        AddToCart addresslistData = new AddToCart();
                        result.setValue(addresslistData);
                    }
                });
        return result;
    }
    /*TODO Delete Cart TODO */
    public MutableLiveData<AddToCart> deleteCartItemMutableLiveData(String id_cart,String id_product,String id_product_attribute) {
        final MutableLiveData<AddToCart> result = new MutableLiveData<>();
        apiIterface.deleteCart(Constants.WS_KEY,id_cart,id_product,id_product_attribute)
                .enqueue(new Callback<AddToCart>() {
                    @Override
                    public void onResponse(@NotNull Call<AddToCart> call, @NotNull Response<AddToCart> response) {
                        if (response.code() == 200) {
                            if (response.body() != null) {
                                result.postValue(response.body());
                            }
                        }
                    }

                    @Override
                    public void onFailure(@NotNull Call<AddToCart> call, @NotNull Throwable t) {
                        AddToCart addresslistData = new AddToCart();
                        result.setValue(addresslistData);
                    }
                });
        return result;
    }
    /*TODO update Cart TODO */
    public MutableLiveData<AddToCart> updateCarttMutableLiveData(UpdateCartBody updateCartBody) {
        final MutableLiveData<AddToCart> result = new MutableLiveData<>();
        apiIterface.updateCart(Constants.WS_KEY, updateCartBody)
                .enqueue(new Callback<AddToCart>() {
                    @Override
                    public void onResponse(@NotNull Call<AddToCart> call, @NotNull Response<AddToCart> response) {
                        if (response.code() == 200) {
                            if (response.body() != null) {
                                result.postValue(response.body());
                            }
                        }
                    }

                    @Override
                    public void onFailure(@NotNull Call<AddToCart> call, @NotNull Throwable t) {
                        AddToCart addToCart = new AddToCart();
                        result.setValue(addToCart);
                    }
                });
        return result;
    }

    /*TODO Order  TODO */
    public MutableLiveData<OrderList> orderListMutableLiveData(OrderBody orderBody) {
        final MutableLiveData<OrderList> result = new MutableLiveData<>();
        apiIterface.orderproductlist(Constants.WS_KEY, orderBody)
                .enqueue(new Callback<OrderList>() {
                    @Override
                    public void onResponse(@NotNull Call<OrderList> call, @NotNull Response<OrderList> response) {
                        if (response.code() == 200) {
                            if (response.body() != null) {
                                result.postValue(response.body());
                            }
                        }
                    }

                    @Override
                    public void onFailure(@NotNull Call<OrderList> call, @NotNull Throwable t) {
                        OrderList orderList = new OrderList();
                        result.setValue(orderList);
                    }
                });
        return result;
    }
    /*TODO Online Order  TODO */
    public MutableLiveData<OrderList> onlineorderMutableLiveData(PaymentOrder paymentOrder) {
        final MutableLiveData<OrderList> result = new MutableLiveData<>();
        apiIterface.onlineOrder(Constants.WS_KEY, paymentOrder)
                .enqueue(new Callback<OrderList>() {
                    @Override
                    public void onResponse(@NotNull Call<OrderList> call, @NotNull Response<OrderList> response) {
                        if (response.code() == 200) {
                            if (response.body() != null) {
                                result.postValue(response.body());
                            }
                        }
                    }

                    @Override
                    public void onFailure(@NotNull Call<OrderList> call, @NotNull Throwable t) {
                        OrderList orderList = new OrderList();
                        result.setValue(orderList);
                    }
                });
        return result;
    }
    /*TODO  OrderPaymentSuccessful  TODO */
    public MutableLiveData<OrderList> orderpaymentsuccessfulMutableLiveData(OrderPaymentSuccess orderPaymentSuccess) {
        final MutableLiveData<OrderList> result = new MutableLiveData<>();
        apiIterface.ordersuccessful(Constants.WS_KEY, orderPaymentSuccess)
                .enqueue(new Callback<OrderList>() {
                    @Override
                    public void onResponse(@NotNull Call<OrderList> call, @NotNull Response<OrderList> response) {
                        if (response.code() == 200) {
                            if (response.body() != null) {
                                result.postValue(response.body());
                            }
                        }
                    }

                    @Override
                    public void onFailure(@NotNull Call<OrderList> call, @NotNull Throwable t) {
                        OrderList orderList = new OrderList();
                        result.setValue(orderList);
                    }
                });
        return result;
    }



    /*TODO Wallet  TODO */
    public MutableLiveData<WalletBalance> walletBalanceMutableLiveData() {
        final MutableLiveData<WalletBalance> result = new MutableLiveData<>();
        apiIterface.walletBalance(Constants.WS_KEY, SharedPrefs.getInstance().getString(ConstantHelper.KEY_CUSTOMER,"EMPTY"))
                .enqueue(new Callback<WalletBalance>() {
                    @Override
                    public void onResponse(@NotNull Call<WalletBalance> call, @NotNull Response<WalletBalance> response) {
                        if (response.code() == 200) {
                            if (response.body() != null) {
                                result.postValue(response.body());
                            }
                        }
                    }

                    @Override
                    public void onFailure(@NotNull Call<WalletBalance> call, @NotNull Throwable t) {
                        WalletBalance walletBalance = new WalletBalance();
                        result.setValue(walletBalance);
                    }
                });
        return result;
    }

    /*TODO Redeem Wallet  TODO */
    public MutableLiveData<AddToCart> redeemwalletMutableLiveData(WalletBody walletBody) {
        final MutableLiveData<AddToCart> result = new MutableLiveData<>();
        apiIterface.redeemWallet(Constants.WS_KEY,walletBody)
                .enqueue(new Callback<AddToCart>() {
                    @Override
                    public void onResponse(@NotNull Call<AddToCart> call, @NotNull Response<AddToCart> response) {
                        if (response.code() == 200) {
                            if (response.body() != null) {
                                result.postValue(response.body());
                            }
                        }
                    }

                    @Override
                    public void onFailure(@NotNull Call<AddToCart> call, @NotNull Throwable t) {
                        AddToCart walletBalance = new AddToCart();
                        result.setValue(walletBalance);
                    }
                });
        return result;
    }

    /*TODO Delete  Wallet  TODO */
    public MutableLiveData<AddToCart> deletewalletMutableLiveData(String cart_id) {
        final MutableLiveData<AddToCart> result = new MutableLiveData<>();
        apiIterface.deleteWallet(Constants.WS_KEY,SharedPrefs.getInstance().getString(ConstantHelper.KEY_CUSTOMER,"Empty"),cart_id)
                .enqueue(new Callback<AddToCart>() {
                    @Override
                    public void onResponse(@NotNull Call<AddToCart> call, @NotNull Response<AddToCart> response) {
                        if (response.code() == 200) {
                            if (response.body() != null) {
                                result.postValue(response.body());
                            }
                        }
                    }

                    @Override
                    public void onFailure(@NotNull Call<AddToCart> call, @NotNull Throwable t) {
                        AddToCart walletBalance = new AddToCart();
                        result.setValue(walletBalance);
                    }
                });
        return result;
    }
}
