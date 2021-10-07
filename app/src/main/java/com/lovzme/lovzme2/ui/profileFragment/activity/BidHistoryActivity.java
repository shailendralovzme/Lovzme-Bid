package com.lovzme.lovzme2.ui.profileFragment.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.os.Bundle;

import com.lovzme.lovzme2.R;
import com.lovzme.lovzme2.databinding.ActivityBidHistoryBinding;
import com.lovzme.lovzme2.ui.profileFragment.adapter.BidHistoryAdapter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class BidHistoryActivity extends AppCompatActivity {
    ActivityBidHistoryBinding binding;
    String [] list = {"Blackberrys Ruston Tan Wallet","Blackberrys Ruston Tan Wallet","Blackberrys Ruston Tan Wallet","Blackberrys Ruston Tan Wallet","Blackberrys Ruston Tan Wallet","Blackberrys Ruston Tan Wallet"};
    ArrayList<String> data = new ArrayList<>(Arrays.asList(list));
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_bid_history);

        setSupportActionBar(binding.toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Bid History");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        binding.toolbar.setTitleTextColor(getResources().getColor(android.R.color.white));


        binding.recylerBidHistoryView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        BidHistoryAdapter bidHistoryAdapter = new BidHistoryAdapter(getApplicationContext(),data);
        binding.recylerBidHistoryView.setAdapter(bidHistoryAdapter);
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