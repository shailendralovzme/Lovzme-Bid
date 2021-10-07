package com.lovzme.lovzme2.ui.orderfragment.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.lovzme.lovzme2.ui.orderfragment.ProductOrderFragment;
import com.lovzme.lovzme2.ui.orderfragment.TicketOrderFragment;

public class OrderHistoryPagerAdapter extends FragmentStatePagerAdapter {
     int tabCount;
    public OrderHistoryPagerAdapter(@NonNull FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount = tabCount;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new TicketOrderFragment();
            case 1:
                return new ProductOrderFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
