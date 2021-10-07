package com.lovzme.lovzme2.ui.homefragment.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.lovzme.lovzme2.R;
import com.lovzme.lovzme2.application.LovzMe2App;
import com.lovzme.lovzme2.ui.homefragment.adapter.UpcomingAdapter;
import com.lovzme.lovzme2.databinding.FragmentUpCommingBinding;
import com.lovzme.lovzme2.ui.homefragment.response.sallingresponse.SellingProduct;
import com.lovzme.lovzme2.ui.homefragment.viewModel.ProductListViewModel;
import java.util.ArrayList;



public class UpCommingFragment extends Fragment {
    FragmentUpCommingBinding binding;
    UpcomingAdapter upcomingAdapter;
    ProductListViewModel viewModel;
    ArrayList<SellingProduct> upcomingsales = new ArrayList<>();
    int startposition = 0;
    int endposition = 10;
    private boolean isLoading;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_up_comming, container, false);
        View view = binding.getRoot();

        viewModel = new ViewModelProvider(this).get(ProductListViewModel.class);
        binding.upcoingView.setLayoutManager(new LinearLayoutManager(getContext()));
        upcomingAdapter = new UpcomingAdapter(getContext(), upcomingsales);
        binding.upcoingView.setAdapter(upcomingAdapter);
        upComingsale();

        binding.upcoingView.addOnScrollListener((new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();

                if (!isLoading) {
                    if (linearLayoutManager != null && linearLayoutManager.findLastCompletelyVisibleItemPosition() == upcomingsales.size() - 1) {
                     //upComingsale();
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
      //  upComingsale();
    }

    @SuppressLint("NotifyDataSetChanged")
    private void upComingsale(){
        if(LovzMe2App.getInstance().getUpcomingsales() != null && LovzMe2App.getInstance().getUpcomingsales().isEmpty()){
            viewModel.setUpcomingProduct(startposition,endposition);
            viewModel.getUpcomingsaleProduct().observe(requireActivity(), upcomingsale -> {
                if (upcomingsale.getSallingPayload() != null) {
                    upcomingsales.clear();
                    upcomingsales.addAll(upcomingsale.getSallingPayload().getSellingProducts());
                    upcomingAdapter.notifyDataSetChanged();
                    startposition = endposition + 1;
                    endposition = startposition + 9;
                    LovzMe2App.getInstance().setUpcomingsales(upcomingsales);
                }
            });
        }else{
            upcomingsales.clear();
            upcomingsales.addAll(LovzMe2App.getInstance().getUpcomingsales());
            upcomingAdapter.notifyDataSetChanged();
            startposition = endposition+1;
            endposition=startposition+9;
        }
    }
}