package com.lovzme.lovzme2.ui.mybagFragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lovzme.lovzme2.R;
import com.lovzme.lovzme2.databinding.FragmentCommentOrderBinding;
import com.lovzme.lovzme2.ui.mybagFragment.activity.CheckoutActivity;
import com.lovzme.lovzme2.ui.profileFragment.addressmodel.AddresslistData;

import org.greenrobot.eventbus.EventBus;


public class CommentOrderFragment extends Fragment {
    FragmentCommentOrderBinding binding;
    CheckoutActivity checkoutActivity;
    AddresslistData.Payload selectedAddress = new AddresslistData.Payload();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_comment_order, container, false);
        View view = binding.getRoot();
        initView();


        binding.btnContinue.setOnClickListener(v -> {
            selectedAddress.setComment_order((binding.messageBody.getText().toString().length() > 0)
                    ? binding.messageBody.getText().toString() : "");
            EventBus.getDefault().post(selectedAddress);
            checkoutActivity.switchCheckoutStage(2);


        });
        return view;
    }

    public void initView() {
        checkoutActivity = (CheckoutActivity) getActivity();
    }


}