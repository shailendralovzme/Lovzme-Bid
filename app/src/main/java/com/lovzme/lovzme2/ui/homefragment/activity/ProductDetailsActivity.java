package com.lovzme.lovzme2.ui.homefragment.activity;


import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.Html;
import android.widget.ImageView;
import android.widget.Toast;

import com.lovzme.lovzme2.R;
import com.lovzme.lovzme2.databinding.ActivityProductDetailsBinding;
import com.lovzme.lovzme2.prefrence.ConstantHelper;
import com.lovzme.lovzme2.prefrence.SharedPrefs;
import com.lovzme.lovzme2.ui.homefragment.adapter.ProductFeaturesAdapter;
import com.lovzme.lovzme2.ui.homefragment.adapter.ProductImageSlider;
import com.lovzme.lovzme2.ui.homefragment.response.productdetaiils.Product;
import com.lovzme.lovzme2.ui.homefragment.response.productdetaiils.ProductFeatures;
import com.lovzme.lovzme2.ui.homefragment.response.productdetaiils.ProductSize;
import com.lovzme.lovzme2.ui.homefragment.response.sallingresponse.SellingProduct;
import com.lovzme.lovzme2.ui.homefragment.viewModel.AddToCartViewModel;
import com.lovzme.lovzme2.ui.homefragment.viewModel.PinCodeViewModel;
import com.lovzme.lovzme2.ui.homefragment.viewModel.ProductListViewModel;
import com.lovzme.lovzme2.ui.homefragment.viewModel.WishListViewModel;
import com.lovzme.lovzme2.ui.mybagFragment.MyBagFragment;
import com.lovzme.lovzme2.ui.mybagFragment.addToCart.body.AddToCartBody;
import com.lovzme.lovzme2.ui.wishlist.model.WishlistBody;
import com.varunest.sparkbutton.SparkEventListener;

import java.util.ArrayList;
import java.util.Objects;

import es.dmoral.toasty.Toasty;

public class ProductDetailsActivity extends AppCompatActivity {
    ActivityProductDetailsBinding binding;
    SellingProduct productTicketList;
    Product product = new Product();
    ArrayList<ProductFeatures> productFeatures = new ArrayList<>();
    ArrayList<ProductSize> product_sizes = new ArrayList<>();
    ProductListViewModel viewModel;
    ProductFeaturesAdapter adapter;
    ProductSize selectedProductSize;


    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_product_details);


        viewModel = new ViewModelProvider(this).get(ProductListViewModel.class);
        productTicketList = (SellingProduct) getIntent().getSerializableExtra("Product_details");

        if (productTicketList != null) {
            binding.toolbar.setTitle("Place a Bid");
            setSupportActionBar(binding.toolbar);
            Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
            getProductDetails(productTicketList.getIdProduct());
        }

        binding.btnCheck.setOnClickListener(v -> {
            if (binding.edtPincode.getText().toString().length() > 5) {

                setPinCode(binding.edtPincode.getText().toString());
            } else {
                Toasty.success(ProductDetailsActivity.this, R.string.invalid_pin, Toast.LENGTH_SHORT, true).show();
            }

        });
     /*   binding.ImgAddCart.setOnClickListener(v -> {

        });*/
        /*binding.sparkButton.setEventListener(new SparkEventListener() {
            @Override
            public void onEvent(ImageView button, boolean buttonState) {
                if (buttonState) {
                    binding.sparkButton.setClickable(false);
                    binding.sparkButton.setEnabled(false);
                    setWishList();
                } else {
                    binding.sparkButton.setClickable(true);
                    binding.sparkButton.setEnabled(true);

                }

            }

            @Override
            public void onEventAnimationEnd(ImageView button, boolean buttonState) {

            }

            @Override
            public void onEventAnimationStart(ImageView button, boolean buttonState) {

            }
        });*/
        binding.BTNBid.setOnClickListener(v -> {
            if (selectedProductSize != null) {
                AddToCart(product);
            } else {
                Toasty.error(this, "Please Select Bid Price", Toast.LENGTH_SHORT, true).show();
            }
        });

        binding.TVAmount.setOnClickListener(v -> {
            selectedProductSize = product.getProductSizes().get(0);
            binding.TVAmount.setBackground(getResources().getDrawable(R.drawable.buttonbackground, null));
            binding.TVAmount1.setBackground(getResources().getDrawable(R.drawable.background, null));
            binding.TVAmount2.setBackground(getResources().getDrawable(R.drawable.background, null));
        });
        binding.TVAmount1.setOnClickListener(v -> {
            selectedProductSize = product.getProductSizes().get(1);
            binding.TVAmount.setBackground(getResources().getDrawable(R.drawable.background, null));
            binding.TVAmount1.setBackground(getResources().getDrawable(R.drawable.buttonbackground, null));
            binding.TVAmount2.setBackground(getResources().getDrawable(R.drawable.background, null));
        });
        binding.TVAmount2.setOnClickListener(v -> {
            selectedProductSize = product.getProductSizes().get(2);
            binding.TVAmount.setBackground(getResources().getDrawable(R.drawable.background, null));
            binding.TVAmount1.setBackground(getResources().getDrawable(R.drawable.background, null));
            binding.TVAmount2.setBackground(getResources().getDrawable(R.drawable.buttonbackground, null));
        });


    }

    @SuppressLint("SetTextI18n")
    private void getProductDetails(String product_id) {
        viewModel.setCurrrentBidListMutableLiveData(product_id);
        viewModel.getProductDetails().observe(this, productDetails -> {
            if (productDetails != null) {
                product = productDetails.getPayload().getProduct();
                ProductImageSlider sliderAdapter = new ProductImageSlider(ProductDetailsActivity.this, product.getProductImageList());
                binding.sliderVpSubBanner.setSliderAdapter(sliderAdapter);
                binding.sliderVpSubBanner.setAutoCycle(true);
                binding.sliderVpSubBanner.startAutoCycle();
                binding.sliderVpSubBanner.setScrollTimeInMillis(5000);
                sliderAdapter.notifyDataSetChanged();

                binding.TVProductName.setText(product.getName());
                binding.textViewAmountValue.setText("₹ " + product.getPriceSelling());
             /*   binding.textViewDescountValue.setText("₹ " + product.getPriceTaxIncl());
                binding.textViewDescountValue.setPaintFlags(binding.textViewDescountValue.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);*/
                binding.tvProductDescription.setText(Html.fromHtml(product.getDescription()));

                ChooseSizes();
                setproductDetails();


            }
        });
    }

    private void setproductDetails() {
        productFeatures.addAll(product.getProductFeaturesList());
        binding.rvProductFeatures.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        binding.rvProductFeatures.setHasFixedSize(true);
        adapter = new ProductFeaturesAdapter(getApplicationContext(), productFeatures);
        binding.rvProductFeatures.setAdapter(adapter);
    }

    private void setPinCode(String pinCode) {
        PinCodeViewModel viewModel = new ViewModelProvider(this).get(PinCodeViewModel.class);
        viewModel.setPinCodeRepository(pinCode);
        viewModel.getPincode().observe(this, pinCodeResponse -> {
            if (pinCodeResponse.getSuccess() != null) {
                Toasty.success(ProductDetailsActivity.this, pinCodeResponse.getMessage(), Toast.LENGTH_SHORT, true).show();

            }
        });
    }

    private void ChooseSizes() {
        product_sizes.clear();
        product_sizes.addAll(product.getProductSizes());
        binding.TVAmount.setText(String.format("₹ %s", product.getProductSizes().get(0).getCombination().getBidValue()));
        binding.TVAmount1.setText(String.format("₹ %s", product.getProductSizes().get(1).getCombination().getBidValue()));
        binding.TVAmount2.setText(String.format("₹ %s", product.getProductSizes().get(2).getCombination().getBidValue()));

    }

    private void AddToCart(Product product) {
        AddToCartBody addToCartBody1 = new AddToCartBody();
        AddToCartBody.Cart cart = new AddToCartBody.Cart(SharedPrefs.getInstance().getString(ConstantHelper.KEY_CUSTOMER, getString(R.string.empty)),
                "1", "0", product.getIdProduct(),
                selectedProductSize.getIdProductAttribute(), "1", SharedPrefs.getInstance().getString(ConstantHelper.secure_key, getString(R.string.empty)));
        addToCartBody1.setCart(cart);
        AddToCartViewModel viewModel = new ViewModelProvider(this).get(AddToCartViewModel.class);
        viewModel.setListDataMutableLiveData(addToCartBody1);
        viewModel.postAddToCart().observe(this, addToCartResponse -> {
            if (addToCartResponse.getMessage() != null) {
                Toasty.success(this, addToCartResponse.getMessage(), Toasty.LENGTH_SHORT, true).show();
            }
        });
    }

    private void setWishList() {
        WishlistBody wishListBody = new WishlistBody();
        WishlistBody.Wishlist wishlistData = new WishlistBody.Wishlist(SharedPrefs.getInstance().getString(ConstantHelper.KEY_CUSTOMER, getString(R.string.empty))
                , SharedPrefs.getInstance().getString(ConstantHelper.secure_key, getString(R.string.empty)), product.getIdProduct(), "");
        wishListBody.setWishlist(wishlistData);
        WishListViewModel wishListViewModel = new ViewModelProvider(this).get(WishListViewModel.class);
        wishListViewModel.setWishListValue(wishListBody);
        wishListViewModel.getWishList().observe(this, wishListResponse -> {
            if (wishListResponse.getSuccess() != null) {
                Toasty.success(ProductDetailsActivity.this, wishListResponse.getMessage(), Toasty.LENGTH_SHORT, true).show();
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