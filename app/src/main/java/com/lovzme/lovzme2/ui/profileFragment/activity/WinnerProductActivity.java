package com.lovzme.lovzme2.ui.profileFragment.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.lovzme.lovzme2.R;
import com.lovzme.lovzme2.application.LovzMe2App;
import com.lovzme.lovzme2.databinding.ActivityWinnerProductBinding;
import com.lovzme.lovzme2.prefrence.ConstantHelper;
import com.lovzme.lovzme2.prefrence.SharedPrefs;
import com.lovzme.lovzme2.ui.homefragment.response.sallingresponse.SellingProduct;
import com.lovzme.lovzme2.ui.homefragment.viewModel.AddToCartViewModel;
import com.lovzme.lovzme2.ui.mybagFragment.addToCart.body.AddToCartBody;
import com.lovzme.lovzme2.ui.orderfragment.viewModel.TicketOrderViewModel;
import com.lovzme.lovzme2.ui.profileFragment.adapter.WinnerProductAdapter;
import java.util.ArrayList;
import java.util.Objects;
import es.dmoral.toasty.Toasty;

public class WinnerProductActivity extends AppCompatActivity {
    ActivityWinnerProductBinding binding;
    ArrayList<SellingProduct> winnerProducts = new ArrayList<>();
    int startposition = 0;
    int endposition = 10;
    private boolean isLoading;
    WinnerProductAdapter winnerProductAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_winner_product);

        setSupportActionBar(binding.toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Winner Product");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        binding.toolbar.setTitleTextColor(getResources().getColor(android.R.color.white));

        binding.winnerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        winnerProductAdapter = new WinnerProductAdapter(this, winnerProducts, (product,  itemPosition) ->
                addToCart(product.getCacheDefaultAttribute(),product.getIdProduct()));

        binding.winnerView.setAdapter(winnerProductAdapter);

         LovzMe2App.showBidProgressDialog(this);
        getWinnerList();

        binding.winnerView.addOnScrollListener((new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();

                if (!isLoading) {
                    if (linearLayoutManager != null && linearLayoutManager.findLastCompletelyVisibleItemPosition() == winnerProducts.size() - 1) {
                        getWinnerList();
                        Log.e("TAG", "onScrolled: ");
                        isLoading = true;
                    }
                }
            }
        }));

    }
    public void showEmptyCartView() {
        binding.emptyBagLayout.setVisibility(View.VISIBLE);
        binding.winnerView.setVisibility(View.GONE);
    }

    public void showCartView() {
        binding.winnerView.setVisibility(View.VISIBLE);
        binding.emptyBagLayout.setVisibility(View.GONE);
    }

    private void getWinnerList() {
        TicketOrderViewModel viewModel = new ViewModelProvider(this).get(TicketOrderViewModel.class);
        viewModel.setWinnerProductlistMutableLiveData(startposition, endposition);
        viewModel.getWinnerProductlistMutableLiveData().observe(this, winnerProductlist -> {
            if (winnerProductlist.getSallingPayload().getSellingProducts()!=null) {
                showCartView();
                LovzMe2App.hideBidProgressDialog();
                winnerProducts.addAll(winnerProductlist.getSallingPayload().getSellingProducts());
                winnerProductAdapter.notifyDataSetChanged();
                startposition = endposition + 1;
                endposition = startposition + 9;
            }else {
                showEmptyCartView();
            }
        });
    }
    private void addToCart(String productAttribute,String product_id){
        AddToCartBody addToCartBody1 = new AddToCartBody();
        AddToCartBody.Cart cart = new AddToCartBody.Cart(SharedPrefs.getInstance().getString(ConstantHelper.KEY_CUSTOMER,""),
                "1", "0", product_id,
                productAttribute, "1", SharedPrefs.getInstance().getString(ConstantHelper.secure_key,""));
        addToCartBody1.setCart(cart);
        AddToCartViewModel viewModel = new ViewModelProvider(this).get(AddToCartViewModel.class);
        viewModel.setListDataMutableLiveData(addToCartBody1);
        viewModel.postAddToCart().observe(this, addToCartResponse -> {
            if (addToCartResponse.getMessage()!= null) {
                Toasty.success(this, addToCartResponse.getMessage(), Toasty.LENGTH_SHORT, true).show();
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}