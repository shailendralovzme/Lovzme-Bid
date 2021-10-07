package com.lovzme.lovzme2.ui.activity;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.annotation.SuppressLint;
import android.os.Bundle;
import com.lovzme.lovzme2.R;
import com.lovzme.lovzme2.ui.homefragment.HomeFragment;
import com.lovzme.lovzme2.databinding.ActivityMainBinding;
import com.lovzme.lovzme2.ui.mybagFragment.MyBagFragment;
import com.lovzme.lovzme2.ui.orderfragment.OrderFragment;
import com.lovzme.lovzme2.ui.profileFragment.ProfileFragment;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    String customer_id = "";
     Fragment fragment = null;

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, new HomeFragment());
        fragmentTransaction.commit();


         customer_id = getIntent().getStringExtra("Customer_id");

        binding.bottomNav.setItemSelected(R.id.Home_fragment, true);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new HomeFragment()).commit();

        binding.bottomNav.setOnItemSelectedListener(i -> {
            switch (i) {
                case R.id.Home_fragment:
                    fragment = new HomeFragment();
                    break;
                case R.id.my_bag:
                    fragment = new MyBagFragment();
                    break;
                case R.id.Order_fragment:
                    fragment = new OrderFragment();
                    break;
                case R.id.Profile_fragment:
                    fragment = new ProfileFragment();
                    break;

            }

            if (fragment != null) {
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, fragment).commit();
            }
        });



    }

}