package com.lovzme.lovzme2.ui.homefragment.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.lovzme.lovzme2.ui.homefragment.repo.AddtoCartRepository;
import com.lovzme.lovzme2.ui.mybagFragment.addToCart.AddToCart;
import com.lovzme.lovzme2.ui.mybagFragment.addToCart.body.AddToCartBody;
import com.lovzme.lovzme2.ui.mybagFragment.addToCart.body.UpdateCartBody;
import com.lovzme.lovzme2.ui.mybagFragment.model.order.OrderBody;
import com.lovzme.lovzme2.ui.mybagFragment.model.order.OrderList;
import com.lovzme.lovzme2.ui.mybagFragment.model.order.OrderPaymentSuccess;
import com.lovzme.lovzme2.ui.mybagFragment.model.order.PaymentOrder;
import com.lovzme.lovzme2.ui.mybagFragment.model.wallet.WalletBalance;
import com.lovzme.lovzme2.ui.mybagFragment.model.wallet.WalletBody.WalletBody;


public class AddToCartViewModel  extends ViewModel {
    AddtoCartRepository addToCartRepository;
    MutableLiveData<AddToCart> addToCartMutableLiveData = new MutableLiveData<>();
    MutableLiveData<OrderList> orderListMutableLiveData = new MutableLiveData<>();
    MutableLiveData<OrderList> onlineorderMutableLiveData = new MutableLiveData<>();
    MutableLiveData<OrderList> orderPaymentSuccessMutableLiveData = new MutableLiveData<>();
    MutableLiveData<WalletBalance> walletBalanceMutableLiveData = new MutableLiveData<>();


    public void setListDataMutableLiveData(AddToCartBody addToCartBody) {
        addToCartRepository = AddtoCartRepository.getInstance();
        addToCartMutableLiveData = addToCartRepository.addToCartMutableLiveData(addToCartBody);
    }

    public LiveData<AddToCart> postAddToCart() {
        return addToCartMutableLiveData;
    }


    /*TODO get ADDTOCART TODO*/
    MutableLiveData<AddToCart> getCartToAddMutableLiveData = new MutableLiveData<>();

    public void setGetCartToAddMutableLiveData() {
        addToCartRepository = AddtoCartRepository.getInstance();
        getCartToAddMutableLiveData = addToCartRepository.getCartToAddMutableLiveData();
    }

    public LiveData<AddToCart> getCartToAddLiveData() {
        return getCartToAddMutableLiveData;
    }

    /*TODO get DeleteTOCART TODO*/
    MutableLiveData<AddToCart> deleteCartItemMutableLiveData = new MutableLiveData<>();

    public void setDeleteMutableLiveData(String id_cart,String id_product,String id_product_attribute) {
        addToCartRepository = AddtoCartRepository.getInstance();
        deleteCartItemMutableLiveData = addToCartRepository.deleteCartItemMutableLiveData(id_cart,id_product,id_product_attribute);
    }

    public LiveData<AddToCart> deleteCartItemLiveData() {
        return deleteCartItemMutableLiveData;
    }

    /*TODO get UpdateCART TODO*/

    public void setupdateCartMutableLiveData(UpdateCartBody updateCartBody) {
        addToCartRepository = AddtoCartRepository.getInstance();
        addToCartMutableLiveData = addToCartRepository.updateCarttMutableLiveData(updateCartBody);
    }

    public LiveData<AddToCart> updateCartItemLiveData() {
        return addToCartMutableLiveData;
    }

    /*TODO Order TODO*/

    public void setOrderListMutableLiveData(OrderBody orderBody) {
        addToCartRepository = AddtoCartRepository.getInstance();
        orderListMutableLiveData = addToCartRepository.orderListMutableLiveData(orderBody);
    }

    public LiveData<OrderList> orderListLiveData() {
        return orderListMutableLiveData;
    }

    /*TODO PaymetOrder TODO*/
    public void setOnlineOrderMutableLiveData(PaymentOrder paymentOrder) {
        addToCartRepository = AddtoCartRepository.getInstance();
        onlineorderMutableLiveData = addToCartRepository.onlineorderMutableLiveData(paymentOrder);
    }

    public LiveData<OrderList> onlineorderListLiveData() {
        return onlineorderMutableLiveData;
    }

    /*TODO PaymetOrder TODO*/
    public void OrderpaymentsuccessfullMutableLiveData(OrderPaymentSuccess orderPaymentSuccess) {
        addToCartRepository = AddtoCartRepository.getInstance();
        orderPaymentSuccessMutableLiveData = addToCartRepository.orderpaymentsuccessfulMutableLiveData(orderPaymentSuccess);
    }

    public LiveData<OrderList> OrderpaymentsuccessfullLiveData() {
        return orderPaymentSuccessMutableLiveData;
    }

    /*TODO Add WalleteBalance TODO*/

    public void setWalletBalanceMutableLiveData() {
        addToCartRepository = AddtoCartRepository.getInstance();
        walletBalanceMutableLiveData = addToCartRepository.walletBalanceMutableLiveData();
    }

    public LiveData<WalletBalance> walletBalanceLiveData() {
        return walletBalanceMutableLiveData;
    }

    /*TODO get Redeem Wallet Balance TODO*/
    MutableLiveData<AddToCart> getRedeemWalletMutableLiveData = new MutableLiveData<>();

    public void setRedeemWalletMutableLiveData(WalletBody walletBody) {
        addToCartRepository = AddtoCartRepository.getInstance();
        getRedeemWalletMutableLiveData = addToCartRepository.redeemwalletMutableLiveData(walletBody);
    }

    public LiveData<AddToCart> getRedeemWalletLiveData() {
        return getRedeemWalletMutableLiveData;
    }

    /*TODO get Delete Redeem Wallet Balance TODO*/
    MutableLiveData<AddToCart> getdeleteWalletMutableLiveData = new MutableLiveData<>();

    public void setDeleteWalletMutableLiveData(String cart_id) {
        addToCartRepository = AddtoCartRepository.getInstance();
        getdeleteWalletMutableLiveData = addToCartRepository.deletewalletMutableLiveData(cart_id);
    }

    public LiveData<AddToCart> getDeleteWalletLiveData() {
        return getdeleteWalletMutableLiveData;
    }
}
