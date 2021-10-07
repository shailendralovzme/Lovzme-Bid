package com.lovzme.lovzme2.ui.homefragment.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.lovzme.lovzme2.ui.homefragment.response.productdetaiils.ProductDetails;
import com.lovzme.lovzme2.ui.homefragment.repo.ProductTicketlistRepository;
import com.lovzme.lovzme2.ui.homefragment.response.sallingresponse.ProductSellingDataList;

public class ProductListViewModel extends ViewModel {
    ProductTicketlistRepository productTicketlistRepository;
    MutableLiveData<ProductSellingDataList> productTicketListMutableLiveData = new MutableLiveData<>();
    MutableLiveData<ProductDetails> productDetailsMutableLiveData = new MutableLiveData<ProductDetails>();
    MutableLiveData<ProductSellingDataList> UpcomingproductListMutableLiveData = new MutableLiveData<>();

    /**/
    public void  setCurrrentBidListMutableLiveData(String product_id){
        productTicketlistRepository = ProductTicketlistRepository.getInstance();
        productDetailsMutableLiveData = productTicketlistRepository.productDetailsMutableLiveData(product_id);
    }
    public LiveData<ProductDetails> getProductDetails(){
        return productDetailsMutableLiveData;
    }

    /*TODO liveSale TODO*/
    public void  setProductTicket(int startposition,int endposition){
        productTicketlistRepository = ProductTicketlistRepository.getInstance();
        productTicketListMutableLiveData = productTicketlistRepository.productTicketListMutableLiveData(startposition,endposition);
    }
    public LiveData<ProductSellingDataList> getProductTicket(){
        return productTicketListMutableLiveData;
    }

    /*TODO Upcoming sale TODO*/
    public void  setUpcomingProduct(int startposition,int endposition){
        productTicketlistRepository = ProductTicketlistRepository.getInstance();
        UpcomingproductListMutableLiveData = productTicketlistRepository.productUpcomingsaleLiveData(startposition,endposition);
    }
    public LiveData<ProductSellingDataList> getUpcomingsaleProduct(){
        return UpcomingproductListMutableLiveData;
    }
}
