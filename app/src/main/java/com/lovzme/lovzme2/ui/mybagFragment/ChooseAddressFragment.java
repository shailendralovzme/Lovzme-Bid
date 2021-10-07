package com.lovzme.lovzme2.ui.mybagFragment;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.lovzme.lovzme2.R;
import com.lovzme.lovzme2.application.LovzMe2App;
import com.lovzme.lovzme2.databinding.FragmentChooseAddressBinding;
import com.lovzme.lovzme2.prefrence.ConstantHelper;
import com.lovzme.lovzme2.prefrence.SharedPrefs;
import com.lovzme.lovzme2.ui.adapter.AddressAdapter;
import com.lovzme.lovzme2.ui.mybagFragment.activity.CheckoutActivity;
import com.lovzme.lovzme2.ui.profileFragment.activity.AddressActivity;
import com.lovzme.lovzme2.ui.profileFragment.addressmodel.AddresslistData;
import com.lovzme.lovzme2.ui.profileFragment.viewModel.AddAddressViewModel;
import org.greenrobot.eventbus.EventBus;
import java.util.ArrayList;
import es.dmoral.toasty.Toasty;

public class ChooseAddressFragment extends Fragment {
    FragmentChooseAddressBinding binding;
    AddressAdapter addressAdapter;
    AddAddressViewModel viewModel;
    ArrayList<AddresslistData.Payload> payloadArrayList = new ArrayList<>();
    CheckoutActivity checkoutActivity;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_choose_address, container, false);
        View view = binding.getRoot();
         viewModel = new ViewModelProvider(requireActivity()).get(AddAddressViewModel.class);
        loadData();
        InitView();


        binding.btnContinue.setOnClickListener(v -> {
            if (addressAdapter != null) {
                if (addressAdapter.getSelectedAddress() != null) {
                    EventBus.getDefault().post(addressAdapter.getSelectedAddress());
                    checkoutActivity.switchCheckoutStage(1);
                } else {
                    Toasty.warning(checkoutActivity, "Please select delivery address to continue !", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toasty.warning(checkoutActivity, "Please add & select delivery address to continue !", Toast.LENGTH_SHORT).show();
            }
        });
        binding.btnAddNewAddress.setOnClickListener(v -> {
            LovzMe2App.showBidProgressDialog(requireContext());
            startActivity(new Intent(requireContext(), AddressActivity.class));
            requireActivity().finish();

        });

        return view;
    }

    public void loadData() {
        viewModel.setAddressDataMutableLiveData();
        viewModel.getAddressdata().observe(requireActivity(), addresslistData -> {
            if (addresslistData.getSuccess() && addresslistData.payload.size() != 0) {
                hideNoAddressAddedLayout();
                payloadArrayList.clear();
                SharedPrefs.getInstance().addString(ConstantHelper.ADDRESSID,addresslistData.getPayload().get(0).getIdAddress());
                SharedPrefs.getInstance().addString(ConstantHelper.MOBILE_NO,addresslistData.getPayload().get(0).getPhoneMobile());
                payloadArrayList.addAll(addresslistData.getPayload());
                binding.recyclerView.setHasFixedSize(true);
                binding.recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
                addressAdapter = new AddressAdapter(getContext(),null, payloadArrayList, true);
                binding.recyclerView.setAdapter(addressAdapter);
            } else {
                showNoAddressAddedLayout();

            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        loadData();
    }

    public void showNoAddressAddedLayout() {
        binding.rlNoAddressLayout.setVisibility(View.VISIBLE);
        binding.recyclerView.setVisibility(View.GONE);
    }

    public void hideNoAddressAddedLayout() {
        binding.rlNoAddressLayout.setVisibility(View.GONE);
        binding.recyclerView.setVisibility(View.VISIBLE);
    }

    private void InitView() {
        checkoutActivity = (CheckoutActivity) getActivity();
    }
}