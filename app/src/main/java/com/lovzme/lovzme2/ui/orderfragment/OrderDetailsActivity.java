package com.lovzme.lovzme2.ui.orderfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.graphics.Color;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.lovzme.lovzme2.R;
import com.lovzme.lovzme2.databinding.ActivityOrderDetailsBinding;
import com.lovzme.lovzme2.ui.orderfragment.model.TicketOrder;

import java.util.Objects;

public class OrderDetailsActivity extends AppCompatActivity {
    ActivityOrderDetailsBinding binding;
    TicketOrder order;

    public static final String PRODUCT_ORDER = "product_order";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_order_details);

        setSupportActionBar(binding.toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Ticket Order");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        binding.toolbar.setTitleTextColor(Color.BLACK);

        order = (TicketOrder) getIntent().getSerializableExtra(PRODUCT_ORDER);
        if (order != null) {
            binding.TvTicketId.setText(order.getIdOrder());
            binding.TvTicketReferenceId.setText(order.getReference());
            String[] replace = order.getDateAdd().split("\\s");
            binding.TvTicketDateValue.setText(String.valueOf(replace[0]));
            binding.TvTicketStatusValue.setText(order.getStatus());
            binding.TvTicketPaymentMethodValue.setText(order.getPayment());
            binding.TVName.setText(String.format("%s %s", order.getAddressDetails().getShippingAddress().getFirstname(),
                    order.getAddressDetails().getShippingAddress().getLastname()));
            binding.TVAddress.setText(String.format("%s%s", order.getAddressDetails().getShippingAddress().getAddress1(),
                    order.getAddressDetails().getShippingAddress().getAddress2()));
            binding.TVCity.setText(order.getAddressDetails().getShippingAddress().getCity());
            binding.TVState.setText(order.getAddressDetails().getShippingAddress().getStateName());
            binding.TVPincode.setText(order.getAddressDetails().getShippingAddress().getPostcode());
            binding.tvMobileNo.setText(order.getAddressDetails().getShippingAddress().getPhone());

            Glide.with(getApplicationContext()).load(order.getOrderProducts().get(0).getProductImage()).into(binding.ivProductImage);
            binding.tvProductTitle.setText(order.getOrderProducts().get(0).getName());
            binding.TvBiddingPrice.setText(String.format("₹ %s", order.getOrderProducts().get(0).getBidValue()));
            binding.TvTicketPrice.setText(String.format("₹ %s", order.getTotalpaid()));
            binding.TVTicketSubTotal.setText(String.format("₹ %s", order.getTotalProducts()));
            binding.TVDisscount.setText(String.format("₹ %s", order.getTotalDiscount()));
            binding.TVShiiping.setText(String.format("₹ %s", order.getShippingCostTotal()));
            binding.TVTax.setText(String.format("₹ %s", order.getTotalTax()));
            binding.TVFinalTotal.setText(String.format("₹ %s", order.getTotalpaid()));

        }

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