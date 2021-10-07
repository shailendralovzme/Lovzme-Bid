package com.lovzme.lovzme2.ui.homefragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.tabs.TabLayout;
import com.lovzme.lovzme2.R;
import com.lovzme.lovzme2.ui.homefragment.adapter.TabPagerAdapter;
import com.lovzme.lovzme2.databinding.FragmentHomeBinding;
import com.lovzme.lovzme2.ui.profileFragment.activity.WalletActivity;
import com.lovzme.lovzme2.ui.wishlist.WishlistActivity;


public class HomeFragment extends Fragment {
    FragmentHomeBinding binding;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        View view = binding.getRoot();

        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Current Bid"));
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("UpComing Bid"));
        binding.tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        binding.toolbar.ivWishList.setOnClickListener(v -> startActivity(new Intent(requireContext(), WishlistActivity.class)));

        final TabPagerAdapter adapter = new TabPagerAdapter(getChildFragmentManager(),getContext(), binding.tabLayout.getTabCount());
        binding.viewpager.setAdapter(adapter);


        binding.viewpager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(binding.tabLayout));

        binding.tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                binding.viewpager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        return view;
    }
}

