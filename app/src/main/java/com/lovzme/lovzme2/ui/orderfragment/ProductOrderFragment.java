package com.lovzme.lovzme2.ui.orderfragment;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.lovzme.lovzme2.R;
import com.lovzme.lovzme2.databinding.FragmentProductOrderBinding;
import com.lovzme.lovzme2.ui.orderfragment.adapter.OrderDetailsAdapter;
import com.lovzme.lovzme2.ui.orderfragment.model.TicketOrder;
import com.lovzme.lovzme2.ui.orderfragment.viewModel.TicketOrderViewModel;


import java.util.ArrayList;

public class ProductOrderFragment extends Fragment {
    FragmentProductOrderBinding binding;
    OrderDetailsAdapter orderDetailsAdapter;
    TicketOrderViewModel viewModel;
    ArrayList<TicketOrder> ticketOrders = new ArrayList<>();
    int startposition = 0;
    int endposition = 10;
    private boolean isLoading;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_product_order, container, false);
        View view = binding.getRoot();

        viewModel = new ViewModelProvider(requireActivity()).get(TicketOrderViewModel.class);


        binding.ordersView.setLayoutManager(new LinearLayoutManager(requireContext()));


        binding.ordersView.addOnScrollListener((new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();

                if (!isLoading) {
                    if (linearLayoutManager != null && linearLayoutManager.findLastCompletelyVisibleItemPosition() == ticketOrders.size() - 1) {
                        getOrdersProduct();
                        Log.e("TAG", "onScrolled: ");
                        isLoading = true;
                    }
                }
            }
        }));

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
//        LovzMe2App.showBidProgressDialog(requireContext());
        getOrdersProduct();
    }

    private void getOrdersProduct(){
        viewModel.setProductOrder(startposition,endposition);
        viewModel.getProductOrderlistDataMutableLiveData().observe(requireActivity(), productOrderlistData -> {
                if (productOrderlistData.getPayload().getOrder()!=null){
                    showCartView();
                    //LovzMe2App.hideBidProgressDialog();
                    ticketOrders.clear();
              ticketOrders.addAll(productOrderlistData.getPayload().getOrder());

                orderDetailsAdapter = new OrderDetailsAdapter(requireContext(), ticketOrders);
                binding.ordersView.setAdapter(orderDetailsAdapter);
                orderDetailsAdapter.notifyDataSetChanged();
                startposition = endposition + 1;
                endposition = startposition + 9;
            }else {
                    showEmptyCartView();
                }

        });
    }
    public void showEmptyCartView() {
        binding.emptyBagLayout.setVisibility(View.VISIBLE);
        binding.ordersView.setVisibility(View.GONE);

    }

    public void showCartView() {
        binding.ordersView.setVisibility(View.VISIBLE);
        binding.emptyBagLayout.setVisibility(View.GONE);
    }
}