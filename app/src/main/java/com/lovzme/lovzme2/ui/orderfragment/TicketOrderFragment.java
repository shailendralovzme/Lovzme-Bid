package com.lovzme.lovzme2.ui.orderfragment;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.lovzme.lovzme2.R;
import com.lovzme.lovzme2.application.LovzMe2App;
import com.lovzme.lovzme2.databinding.FragmentTicketOrderBinding;
import com.lovzme.lovzme2.ui.orderfragment.adapter.OrderAdapter;
import com.lovzme.lovzme2.ui.orderfragment.model.TicketOrder;
import com.lovzme.lovzme2.ui.orderfragment.viewModel.TicketOrderViewModel;

import java.util.ArrayList;

public class TicketOrderFragment extends Fragment {
    FragmentTicketOrderBinding binding;
    OrderAdapter orderAdapter;
    ArrayList<TicketOrder> orders = new ArrayList<>();
    int startposition = 0;
    int endposition = 10;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_ticket_order, container, false);
        View view = binding.getRoot();
        getTicket();
        return view;
    }

    private void getTicket(){
        TicketOrderViewModel viewModel = new ViewModelProvider(requireActivity()).get(TicketOrderViewModel.class);
        viewModel.setTicketOrder(startposition,endposition);
        viewModel.getProductOrderTicketlistDataMutableLiveData().observe(requireActivity(), productOrderlistData -> {
            if (productOrderlistData.getPayload().getOrder()!=null){
                showCartView();
                LovzMe2App.hideBidProgressDialog();
                orders.addAll(productOrderlistData.getPayload().getOrder());
                binding.ticketView.setLayoutManager(new LinearLayoutManager(getContext()));
                binding.ticketView.hasFixedSize();
                orderAdapter = new OrderAdapter(getContext(),orders);
                startposition = endposition + 1;
                endposition = startposition + 9;
                binding.ticketView.setAdapter(orderAdapter);

            }else {
                showEmptyCartView();
            }
        });
    }

    public void showEmptyCartView() {
        binding.emptyBagLayout.setVisibility(View.VISIBLE);
        binding.ticketView.setVisibility(View.GONE);
    }

    public void showCartView() {
        binding.ticketView.setVisibility(View.VISIBLE);
        binding.emptyBagLayout.setVisibility(View.GONE);
    }
}