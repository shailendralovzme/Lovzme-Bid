package com.lovzme.lovzme2.ui.orderfragment.viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.lovzme.lovzme2.ui.homefragment.response.sallingresponse.ProductSellingDataList;
import com.lovzme.lovzme2.ui.orderfragment.model.ProductOrderlistData;
import com.lovzme.lovzme2.ui.orderfragment.repo.TicketOrderRepository;


public class TicketOrderViewModel extends ViewModel {
    /*TODO TICKETORDER TODO*/
    MutableLiveData<ProductOrderlistData> productOrderlistDataMutableLiveData = new MutableLiveData<>();

    public void setTicketOrder(int startposition,int endposition){
        productOrderlistDataMutableLiveData = TicketOrderRepository.getInstance().productOrderTicketlistDataMutableLiveData(startposition,endposition);
    }
    public MutableLiveData<ProductOrderlistData> getProductOrderTicketlistDataMutableLiveData(){
        return productOrderlistDataMutableLiveData;
    }

    /*TODO ProductOrders TODO*/
    public void setProductOrder(int startposition,int endposition){
        productOrderlistDataMutableLiveData = TicketOrderRepository.getInstance().productOrderlistDataMutableLiveData(startposition,endposition);
    }
    public MutableLiveData<ProductOrderlistData> getProductOrderlistDataMutableLiveData(){
        return productOrderlistDataMutableLiveData;
    }


    /*TODO WinnerProduct TODO*/
    MutableLiveData<ProductSellingDataList> winnerProductlistMutableLiveData = new MutableLiveData<>();

    public void setWinnerProductlistMutableLiveData(int startposition,int endposition){
        winnerProductlistMutableLiveData = TicketOrderRepository.getInstance().winnerProductlistMutableLiveData(startposition,endposition);
    }
    public MutableLiveData<ProductSellingDataList> getWinnerProductlistMutableLiveData(){
        return winnerProductlistMutableLiveData;
    }
}
