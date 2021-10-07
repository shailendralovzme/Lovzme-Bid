package com.lovzme.lovzme2.ui.orderfragment;



import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.tabs.TabLayout;
import com.lovzme.lovzme2.R;
import com.lovzme.lovzme2.databinding.FragmentOderBinding;
import com.lovzme.lovzme2.ui.orderfragment.adapter.OrderHistoryPagerAdapter;

public class OrderFragment extends Fragment {
    FragmentOderBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_oder, container, false);
        View view = binding.getRoot();

        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Tickets"));
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Orders"));
        binding.tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);


        final OrderHistoryPagerAdapter adapter = new OrderHistoryPagerAdapter(getChildFragmentManager(), binding.tabLayout.getTabCount());
        binding.viewPager.setAdapter(adapter);


        binding.viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(binding.tabLayout));

        binding.tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                binding.viewPager.setCurrentItem(tab.getPosition());
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