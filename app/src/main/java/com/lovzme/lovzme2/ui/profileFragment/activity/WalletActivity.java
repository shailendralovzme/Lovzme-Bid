package com.lovzme.lovzme2.ui.profileFragment.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.lovzme.lovzme2.R;
import com.lovzme.lovzme2.databinding.ActivityWalletBinding;

import java.util.Objects;

public class WalletActivity extends AppCompatActivity {
    ActivityWalletBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_wallet);

        setSupportActionBar(binding.toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Wallet");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        binding.toolbar.setTitleTextColor(getResources().getColor(android.R.color.white));

        binding.TVFirstAmount.setOnClickListener(v -> {
            binding.ETAmount.setText(binding.TVFirstAmount.getText().toString());
        });

        binding.TVSecoundAmount.setOnClickListener(v -> {
            binding.ETAmount.setText(binding.TVSecoundAmount.getText().toString());
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