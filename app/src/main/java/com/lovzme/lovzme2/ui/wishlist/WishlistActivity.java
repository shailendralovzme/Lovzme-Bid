package com.lovzme.lovzme2.ui.wishlist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.lovzme.lovzme2.R;
import com.lovzme.lovzme2.databinding.ActivityWishlistBinding;
import com.lovzme.lovzme2.interFace.MyOnItemClickListner;
import com.lovzme.lovzme2.ui.homefragment.viewModel.WishListViewModel;
import com.lovzme.lovzme2.ui.wishlist.model.wishlist.Wish;

import java.util.ArrayList;
import java.util.Objects;

import es.dmoral.toasty.Toasty;

public class WishlistActivity extends AppCompatActivity {
    ActivityWishlistBinding binding;
    WishListViewModel viewModel;
    ArrayList<Wish> wishArrayList = new ArrayList<>();
    int startposition = 0;
    int endposition = 10;
    private boolean isLoading;
    WishlistAdapter wishlistAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_wishlist);


        setSupportActionBar(binding.toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Wish List");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        binding.toolbar.setTitleTextColor(getResources().getColor(android.R.color.white));

        viewModel = new ViewModelProvider(this).get(WishListViewModel.class);
        binding.wishlistView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        wishlistAdapter = new WishlistAdapter(WishlistActivity.this, wishArrayList);
        binding.wishlistView.setAdapter(wishlistAdapter);

        getWishlistItem();

        binding.wishlistView.addOnScrollListener((new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();

                if (!isLoading) {
                    if (linearLayoutManager != null && linearLayoutManager.findLastCompletelyVisibleItemPosition() == wishArrayList.size() - 1) {
                        getWishlistItem();
                        Log.e("TAG", "onScrolled: ");
                        isLoading = true;
                    }
                }
            }
        }));
    }

    private void getWishlistItem() {
        viewModel.setWishlistItemdata(startposition, endposition);
        viewModel.getWishlistresponseMutableLiveData().observe(this, wishlistresponse -> {
            if (wishlistresponse.getSuccess() != null) {
                wishArrayList.addAll(wishlistresponse.getPayload().getWishlist());
                wishlistAdapter.notifyDataSetChanged();
                startposition = endposition + 1;
                endposition = startposition + 9;
                wishlistAdapter.setListener(new MyOnItemClickListner() {
                    @Override
                    public void onRemoveClick(int position) {
                        deleteWishlistItem(wishArrayList.get(position), position);
                    }

                    @Override
                    public void onEditClick(int position) {

                    }
                });
            }
        });
    }

    private void deleteWishlistItem(Wish wish, int adapterPosition) {
        viewModel.setDeleteWishlistItemMutableLiveData(wish.getIdProduct());
        viewModel.getWishlistresponseMutableLiveData().observe(this, wishlistresponse -> {
            if (wishlistresponse.getSuccess() != null) {
                Toasty.success(getApplicationContext(), "Cart Delete Successfull", Toast.LENGTH_SHORT).show();
                wishlistAdapter.removeCartItem(adapterPosition);
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