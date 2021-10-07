package com.lovzme.lovzme2.ui.mybagFragment.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.lovzme.lovzme2.R;
import com.lovzme.lovzme2.databinding.ActivityCheckoutBinding;
import com.lovzme.lovzme2.prefrence.ConstantHelper;
import com.lovzme.lovzme2.prefrence.SharedPrefs;
import com.lovzme.lovzme2.ui.homefragment.viewModel.AddToCartViewModel;
import com.lovzme.lovzme2.ui.mybagFragment.adapter.CheckoutPagerAdapter;
import com.lovzme.lovzme2.ui.mybagFragment.addToCart.CartDetails;
import com.lovzme.lovzme2.ui.mybagFragment.model.order.OrderPaymentSuccess;
import com.lovzme.lovzme2.ui.mybagFragment.model.order.SuccessPaymentGateway;
import com.lovzme.lovzme2.ui.mybagFragment.model.order.SuccessRazorpay;
import com.razorpay.PaymentData;
import com.razorpay.PaymentResultWithDataListener;

import java.util.Objects;

import es.dmoral.toasty.Toasty;

public class CheckoutActivity extends AppCompatActivity implements PaymentResultWithDataListener {
    ActivityCheckoutBinding binding;
    CheckoutPagerAdapter checkoutPagerAdapter;
    CartDetails cart_details = new CartDetails();
    public static final String EXTRAS_CART_DETAILS = "cart_details";
    AddToCartViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_checkout);

        viewModel = new ViewModelProvider(this).get(AddToCartViewModel.class);


        setSupportActionBar(binding.toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Check out");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setupViewPager();

        cart_details = (CartDetails) getIntent().getSerializableExtra(EXTRAS_CART_DETAILS);
        if (cart_details != null) {
            SetCartDetails(cart_details);
        }

    }

    public void setupViewPager() {
        checkoutPagerAdapter = new CheckoutPagerAdapter(getSupportFragmentManager(), 3);
        binding.viewPager.setAdapter(checkoutPagerAdapter);
        binding.viewPager.beginFakeDrag();
        binding.viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                checkStepViewByPageNo(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    public void checkStepViewByPageNo(int pageNo) {
        binding.stepView.go(pageNo, true);
    }

    public void switchCheckoutStage(int stage) {
        switch (stage) {
            case 0:
            case 1:
            case 2:
                binding.viewPager.setCurrentItem(stage, true);
                break;
        }
    }

    public CartDetails getCart_details() {
        return cart_details;
    }

    public void SetCartDetails(CartDetails cartdetails) {
        this.cart_details = cartdetails;
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

    @Override
    public void onPaymentSuccess(String s, PaymentData paymentData) {
        orderPaymentSuccessful(s, paymentData.getPaymentId(), paymentData.getOrderId(), paymentData.getSignature());

    }

    @Override
    public void onPaymentError(int i, String s, PaymentData paymentData) {
        Log.e("error", "onPaymentError: " + paymentData);
    }

    private void orderPaymentSuccessful(String id_transaction, String paymentId, String orderId, String signature) {
        OrderPaymentSuccess orderPaymentSuccess = new OrderPaymentSuccess();
        SuccessPaymentGateway successPaymentGateway = new SuccessPaymentGateway(new SuccessRazorpay(paymentId, orderId, signature));
        orderPaymentSuccess.setOrder(new OrderPaymentSuccess.Order(
                SharedPrefs.getInstance().getString(ConstantHelper.KEY_CUSTOMER, getString(R.string.empty)),
                cart_details.getIdCart(),
                SharedPrefs.getInstance().getString(ConstantHelper.secure_key, getString(R.string.empty)),
                "razorpay"
                , id_transaction, successPaymentGateway));
        viewModel.OrderpaymentsuccessfullMutableLiveData(orderPaymentSuccess);

        viewModel.OrderpaymentsuccessfullLiveData().observe(this, orderList -> {
            if (orderList.getPayload() != null) {
                Toasty.success(this, orderList.getMessage(), Toast.LENGTH_SHORT, true).show();
            }
        });
    }
}