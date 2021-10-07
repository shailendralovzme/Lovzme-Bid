package com.lovzme.lovzme2.ui.homefragment.adapter;


import android.content.Context;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import com.lovzme.lovzme2.ui.homefragment.fragment.CurrentBidFragment;
import com.lovzme.lovzme2.ui.homefragment.fragment.UpCommingFragment;

public class TabPagerAdapter extends FragmentPagerAdapter {
    Context context;
    int totalTabs;

    public TabPagerAdapter(@NonNull FragmentManager fm, Context context, int totalTabs) {
        super(fm);
        this.context = context;
        this.totalTabs = totalTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new CurrentBidFragment();
            case 1:
                return new UpCommingFragment();
            default:
                return null;
        }
    }
    // this counts total number of tabs
    @Override
    public int getCount() {
        return totalTabs;
    }
}