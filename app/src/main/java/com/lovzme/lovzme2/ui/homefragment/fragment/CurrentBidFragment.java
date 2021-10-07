package com.lovzme.lovzme2.ui.homefragment.fragment;

import android.annotation.SuppressLint;
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
import com.lovzme.lovzme2.application.LovzMe2App;
import com.lovzme.lovzme2.databinding.FragmentCurrentBidBinding;
import com.lovzme.lovzme2.ui.homefragment.adapter.ProductHomeAdapter;
import com.lovzme.lovzme2.ui.homefragment.response.sallingresponse.SellingProduct;
import com.lovzme.lovzme2.ui.homefragment.viewModel.ProductListViewModel;

import java.util.ArrayList;


public class CurrentBidFragment extends Fragment {
    FragmentCurrentBidBinding binding;
    ProductHomeAdapter productHomeAdapter;
    ProductListViewModel viewModel;
    ArrayList<SellingProduct> sellingProducts = new ArrayList<>();
    int startposition = 0;
    int endposition = 10;
    private boolean isLoading;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_current_bid, container, false);
        View view = binding.getRoot();

        viewModel = new ViewModelProvider(this).get(ProductListViewModel.class);

        binding.recylerView.setLayoutManager(new LinearLayoutManager(getContext()));
        productHomeAdapter = new ProductHomeAdapter(getContext(), sellingProducts);
        binding.recylerView.setAdapter(productHomeAdapter);
        getProductTicket();

        binding.recylerView.addOnScrollListener((new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();

                if (!isLoading) {
                    if (linearLayoutManager != null && linearLayoutManager.findLastCompletelyVisibleItemPosition() == sellingProducts.size() - 1) {
                    //   getProductTicket();
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
       // getProductTicket();

    }

    @SuppressLint("NotifyDataSetChanged")
    private void getProductTicket() {
        if (LovzMe2App.getInstance().getLivesaleLists() != null && LovzMe2App.getInstance().getLivesaleLists().isEmpty()) {
            viewModel.setProductTicket(startposition, endposition);
            viewModel.getProductTicket().observe(requireActivity(), productTicketList -> {
                if (productTicketList.getSallingPayload() != null) {
                   sellingProducts.clear();
                    sellingProducts.addAll(productTicketList.getSallingPayload().getSellingProducts());
                    productHomeAdapter.notifyDataSetChanged();
                    startposition = endposition + 1;
                    endposition = startposition + 9;
                    LovzMe2App.getInstance().setLivesaleLists(sellingProducts);
                }
            });
        } else {
            sellingProducts.clear();
            sellingProducts.addAll(LovzMe2App.getInstance().getLivesaleLists());
            productHomeAdapter.notifyDataSetChanged();
            startposition = endposition + 1;
            endposition = startposition + 9;
        }
    }
}