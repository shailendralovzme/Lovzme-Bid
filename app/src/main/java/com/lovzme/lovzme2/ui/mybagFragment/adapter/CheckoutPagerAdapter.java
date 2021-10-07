package com.lovzme.lovzme2.ui.mybagFragment.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import com.lovzme.lovzme2.ui.mybagFragment.ChooseAddressFragment;
import com.lovzme.lovzme2.ui.mybagFragment.CommentOrderFragment;
import com.lovzme.lovzme2.ui.mybagFragment.MakePaymentFragment;

public class CheckoutPagerAdapter extends FragmentStatePagerAdapter {
    int tabCount;
    public CheckoutPagerAdapter(FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount = tabCount;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new ChooseAddressFragment();
            case 1:
                return new CommentOrderFragment();
            case 2:
                return new MakePaymentFragment();

            default:
                return null;
        }
    }


    @Override
    public int getCount() {
        return tabCount;
    }
}