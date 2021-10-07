package com.lovzme.lovzme2.utils.api;

import com.lovzme.lovzme2.ui.activity.login.response.ChangePassword;
import com.lovzme.lovzme2.ui.activity.login.response.logIn.PhoneLogin;
import com.lovzme.lovzme2.ui.activity.signUp.model.UpdateUserDetails;
import com.lovzme.lovzme2.ui.activity.signUp.model.UpdateUserDetailsBody;
import com.lovzme.lovzme2.ui.homefragment.response.pincode.PinCodeResponse;
import com.lovzme.lovzme2.ui.homefragment.response.productdetaiils.ProductDetails;
import com.lovzme.lovzme2.ui.homefragment.response.sallingresponse.ProductSellingDataList;
import com.lovzme.lovzme2.ui.mybagFragment.addToCart.AddToCart;
import com.lovzme.lovzme2.ui.mybagFragment.addToCart.body.AddToCartBody;
import com.lovzme.lovzme2.ui.mybagFragment.addToCart.body.UpdateCartBody;
import com.lovzme.lovzme2.ui.mybagFragment.model.order.OrderBody;
import com.lovzme.lovzme2.ui.mybagFragment.model.order.OrderList;
import com.lovzme.lovzme2.ui.mybagFragment.model.order.OrderPaymentSuccess;
import com.lovzme.lovzme2.ui.mybagFragment.model.order.PaymentOrder;
import com.lovzme.lovzme2.ui.mybagFragment.model.wallet.WalletBalance;
import com.lovzme.lovzme2.ui.mybagFragment.model.wallet.WalletBody.WalletBody;
import com.lovzme.lovzme2.ui.orderfragment.model.ProductOrderlistData;
import com.lovzme.lovzme2.ui.profileFragment.addressmodel.AddresslistData;
import com.lovzme.lovzme2.ui.profileFragment.addressmodel.DeleteAddressData;
import com.lovzme.lovzme2.ui.profileFragment.addressmodel.StateListData;
import com.lovzme.lovzme2.ui.activity.login.response.logIn.LogInData;
import com.lovzme.lovzme2.ui.activity.signUp.model.SignupBody;
import com.lovzme.lovzme2.ui.activity.signUp.model.SignupresponseData;
import com.lovzme.lovzme2.ui.profileFragment.addressmodel.UpdateAddressData;
import com.lovzme.lovzme2.ui.profileFragment.addressmodel.body.AddressBody;
import com.lovzme.lovzme2.ui.profileFragment.addressmodel.AddressData;
import com.lovzme.lovzme2.ui.profileFragment.addressmodel.body.UpdateAddressBody;
import com.lovzme.lovzme2.ui.wishlist.model.DeleteWishlistItem;
import com.lovzme.lovzme2.ui.wishlist.model.WishlistBody;
import com.lovzme.lovzme2.ui.wishlist.model.Wishlistdata;
import com.lovzme.lovzme2.ui.wishlist.model.wishlist.Wishlistresponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface ApiIterface {
    /*TODO https://api.100percentback.in/app/v1/api/login TODO*/
    @FormUrlEncoded
    @POST("api/login")
    Call<LogInData> loginData(@Header("ws-key") String ws_key, @Field("username") String username, @Field("password") String password
    ,@Field("devicetoken") String devicetoken);

    /*------------TODO https://api.100percentback.in/app/v1/api/passwordrecovery TODO------------*/
    @FormUrlEncoded
    @POST("api/passwordrecovery")
    Call<ChangePassword> changePassword(@Header("ws-key") String ws_key, @Field("email") String email);

    /*------------TODO https://api.100percentback.in/app/v1/api/customersphonelogin TODO------------*/
    @FormUrlEncoded
    @POST("api/customersphonelogin")
    Call<PhoneLogin> phonelogin(@Header("ws-key") String ws_key, @Field("phone") String phone);

    /*------------TODO   https://api.100percentback.in/app/v1/api/customers TODO------------*/
    @Headers({"Accept: application/json"})
    @POST("api/customers")
    Call<SignupresponseData> signupdata(@Header("ws-key") String ws_key, @Body SignupBody signupBody);

    /*------------TODO   https://api.100percentback.in/app/v1/api/customers TODO------------*/
    @Headers({"Accept: application/json"})
    @PUT("api/customers")
    Call<UpdateUserDetails> updateUserDetails(@Header("ws-key") String ws_key, @Body UpdateUserDetailsBody updateUserDetailsBody);

    /*------------TODO  https://api.100percentback.in/app/v1/api/address TODO------------*/
    @POST("api/address")
    Call<AddressData> addressdata(@Header("ws-key") String ws_key, @Body AddressBody addressBody);

    /*------------TODO https://api.100percentback.in/app/v1/api/address?id_customer=3&deleted=0 TODO------------*/
    @GET("api/address/state")
    Call<AddresslistData> getAddress(@Header("ws-key") String ws_key, @Query("id_customer") String id_customer, @Query("deleted") String deleted);

    /*------------TODO   https://api.100percentback.in/app/v1/api/address/state  TODO------------*/
    @GET("api/address/state")
    Call<StateListData> statelist(@Header("ws-key") String ws_key);

    /*------------TODO   https://api.100percentback.in/app/v1/api/address  TODO------------*/
    @PUT("api/address")
    Call<UpdateAddressData> updateAddress(@Header("ws-key") String ws_key, @Body UpdateAddressBody updateAddressBody);

    /*------------TODO   https://api.100percentback.in/app/v1//api/address?id_customer=128&id_address=106 TODO------------*/
    @DELETE("api/address")
    Call<DeleteAddressData> deleteAddress(@Header("ws-key") String ws_key, @Query("id_customer")
            String id_customer, @Query("id_address") String id_address);

    /*------------TODO  https://api.100percentback.in/app/v1/api/productsticket/livesale?id_customer=3&limit=0,10  TODO------------*/
    @GET("api/productsticket/livesale")
    Call<ProductSellingDataList> productticketlist(@Header("ws-key") String ws_key, @Query("id_customer")
            String id_customer, @Query("limit") String limit);

    /*------------TODO  https://api.100percentback.in/app/v1/api/productsticket/upcomingsale?id_customer=3&limit=0,10  TODO------------*/
    @GET("api/productsticket/upcomingsale")
    Call<ProductSellingDataList> productupcomingsale(@Header("ws-key") String ws_key, @Query("id_customer")
            String id_customer, @Query("limit") String limit);

    /*------------TODO   https://api.100percentback.in/app/v1/api/products?id_product=202&id_customer=3 TODO------------*/
    @GET("api/products")
    Call<ProductDetails> productDetails(@Header("ws-key") String ws_key, @Query("id_product")
            String id_product, @Query("id_customer") String id_customer);

    /*------------TODO   https://api.100percentback.in/app/v1/api/pincheck?pincode=400093  TODO------------*/
    @GET("api/pincheck")
    Call<PinCodeResponse> pincoderesponse(@Header("ws-key") String ws_key, @Query("pincode") String pincode);

    /*------------TODO   https://api.100percentback.in/app/v1/api/cart  TODO------------*/
    @POST("api/cart")
    Call<AddToCart> addtocart(@Header("ws-key") String ws_key, @Body AddToCartBody addToCartBody);

    /*------------TODO   https://api.100percentback.in/app/v1/api/cart?id_customer=3  TODO------------*/
    @GET("api/cart")
    Call<AddToCart> getcartItem(@Header("ws-key") String ws_key, @Query("id_customer") String id_customer);

    /*------------TODO   https://api.100percentback.in/app/v1//api/cart?id_cart=502&id_product=202&id_product_attribute=2104   TODO------------*/
    @DELETE("api/cart")
    Call<AddToCart> deleteCart(@Header("ws-key") String ws_key, @Query("id_cart")
            String id_cart, @Query("id_product") String id_product, @Query("id_product_attribute") String id_product_attribute);

    /*------------TODO   https://api.100percentback.in/app/v1/api/cart  TODO------------*/
    @PUT("api/cart")
    Call<AddToCart> updateCart(@Header("ws-key") String ws_key, @Body UpdateCartBody updateCartBody);

    /*------------TODO   https://api.100percentback.in/app/v1/api/wishlist   TODO------------*/
    @POST("api/wishlist")
    Call<Wishlistdata> addWishlist(@Header("ws-key") String ws_key, @Body WishlistBody wishlistBody);

    /*------------TODO   https://api.100percentback.in/app/v1/api/wishlist?id_customer=143&limit=0,10   TODO------------*/
    @GET("api/wishlist")
    Call<Wishlistresponse> getWishlist(@Header("ws-key") String ws_key,@Query("id_customer") String id_customer,@Query("limit") String limit);

    /*-----TODO   https://api.100percentback.in/app/v1//api/wishlist?id_customer=9701&id_product=349&secure_key=41011df57ad798ee58aebbb92707860e  TODO------------*/
    @DELETE("api/wishlist")
    Call<DeleteWishlistItem> deletewishlist (@Header("ws-key") String ws_key, @Query("id_customer")
            String id_customer, @Query("id_product") String id_product, @Query("secure_key") String secure_key);

    /*------------TODO   https://api.100percentback.in/app/v1/api/order   TODO------------*/
    @POST("api/order")
    Call<OrderList> orderproductlist(@Header("ws-key") String ws_key, @Body OrderBody orderBody);

    /*------------TODO   https://api.100percentback.in/app/v1/api/order   TODO------------*/
    @POST("api/order")
    Call<OrderList> onlineOrder(@Header("ws-key") String ws_key, @Body PaymentOrder paymentOrder);

    /*------------TODO   https://api.100percentback.in/app/v1/api/order   TODO------------*/
    @POST("api/order")
    Call<OrderList> ordersuccessful(@Header("ws-key") String ws_key, @Body OrderPaymentSuccess orderPaymentSuccess);


    /*------------TODO https://api.100percentback.in/app/v1/api/wallet/balance TODO------------*/
    @FormUrlEncoded
    @POST("api/wallet/balance")
    Call<WalletBalance> walletBalance(@Header("ws-key") String ws_key, @Field("id_customer") String id_customer);

    /*------------TODO   https://api.100percentback.in/app/v1/api/wallet/redeem   TODO------------*/
    @POST("api/wallet/redeem")
    Call<AddToCart> redeemWallet(@Header("ws-key") String ws_key, @Body WalletBody walletBody);

    /*------------TODO   https://api.100percentback.in/app/v1/api/wallet/clear?id_customer=109&id_cart=536    TODO------------*/
    @DELETE("api/wallet/clear")
    Call<AddToCart> deleteWallet (@Header("ws-key") String ws_key, @Query("id_customer")
            String id_customer, @Query("id_cart") String id_cart );

    /*------------TODO   https://api.100percentback.in/app/v1/api/order/details/tickets?id_customer=159&limit=0,10   TODO------------*/
    @GET("api/order/details/tickets")
    Call<ProductOrderlistData> ticketOrder(@Header("ws-key") String ws_key, @Query("id_customer") String id_customer,
                                           @Query("limit") String limit);

    /*------------TODO   https://api.100percentback.in/app/v1/api/order/details/products?id_customer=159&limit=0,10   TODO------------*/
    @GET("api/order/details/products")
    Call<ProductOrderlistData> productDetailsOrder(@Header("ws-key") String ws_key, @Query("id_customer") String id_customer,
                                                   @Query("limit") String limit);

    /*------------TODO   https://api.100percentback.in/app/v1/api/productsticket/winner?id_customer=109&limit=0,10  TODO------------*/
    @GET("api/productsticket/winner")
    Call<ProductSellingDataList> winnerProdcut(@Header("ws-key") String ws_key, @Query("id_customer") String id_customer,
                                    @Query("limit") String limit);

}
