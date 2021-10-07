package com.lovzme.lovzme2.ui.homefragment.viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.lovzme.lovzme2.ui.homefragment.repo.WishListRepository;
import com.lovzme.lovzme2.ui.wishlist.model.DeleteWishlistItem;
import com.lovzme.lovzme2.ui.wishlist.model.WishlistBody;
import com.lovzme.lovzme2.ui.wishlist.model.Wishlistdata;
import com.lovzme.lovzme2.ui.wishlist.model.wishlist.Wishlistresponse;

public class WishListViewModel extends ViewModel {
    MutableLiveData<Wishlistdata> wishlistResponseMutableLiveData = new MutableLiveData<>();
    MutableLiveData<Wishlistresponse> wishlistresponseMutableLiveData = new MutableLiveData<>();
    MutableLiveData<DeleteWishlistItem> deleteWishlistItemMutableLiveData = new MutableLiveData<>();

    public void setWishListValue(WishlistBody wishListBody){
        wishlistResponseMutableLiveData = WishListRepository.getInstance().wishlistResponseMutableLiveData(wishListBody);
    }


    public MutableLiveData<Wishlistdata> getWishList(){
        return wishlistResponseMutableLiveData;
    }

    /*TODO getWishList TODO*/
    public void setWishlistItemdata(int startposition,int endposition){
        wishlistresponseMutableLiveData = WishListRepository.getInstance().getWishlistMutableLIveData(startposition,endposition);
    }
    public MutableLiveData<Wishlistresponse> getWishlistresponseMutableLiveData(){
        return wishlistresponseMutableLiveData;
    }

    /*TODO DeleteWishlit TODO*/
    public void setDeleteWishlistItemMutableLiveData(String product_id){
        deleteWishlistItemMutableLiveData = WishListRepository.getInstance().deleteWishlistItemMutableLiveData(product_id);
    }
    public MutableLiveData<DeleteWishlistItem> deleteWishlistresponseMutableLiveData(){
        return deleteWishlistItemMutableLiveData;
    }
}
