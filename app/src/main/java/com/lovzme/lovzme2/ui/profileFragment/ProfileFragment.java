package com.lovzme.lovzme2.ui.profileFragment;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.lovzme.lovzme2.R;
import com.lovzme.lovzme2.databinding.FragmentProfileBinding;
import com.lovzme.lovzme2.databinding.LayoutUpdateUserBinding;
import com.lovzme.lovzme2.prefrence.ConstantHelper;
import com.lovzme.lovzme2.prefrence.SharedPrefs;
import com.lovzme.lovzme2.ui.activity.signUp.model.UpdateUserDetailsBody;
import com.lovzme.lovzme2.ui.activity.signUp.viewModel.SignupViewModel;
import com.lovzme.lovzme2.ui.profileFragment.activity.AddressActivity;
import com.lovzme.lovzme2.ui.activity.LogInActivity;
import com.lovzme.lovzme2.ui.profileFragment.activity.WalletActivity;
import com.lovzme.lovzme2.ui.profileFragment.activity.WinnerProductActivity;
import java.util.Objects;

import es.dmoral.toasty.Toasty;

public class ProfileFragment extends Fragment {
    FragmentProfileBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_profile, container, false);
        View view = binding.getRoot();




        binding.TVUserName.setText(SharedPrefs.getInstance().getString(ConstantHelper.USERNAME, "EMPTY"));
        binding.TvLastName.setText(SharedPrefs.getInstance().getString(ConstantHelper.LASTNAME, "EMPTY"));
        binding.TVUserEmailId.setText(SharedPrefs.getInstance().getString(ConstantHelper.EMAIL, "EMPTY"));

        binding.constraintProfileAccount.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
            ViewGroup viewGroup = requireActivity().findViewById(android.R.id.content);
            LayoutUpdateUserBinding layoutUpdateUserBinding = DataBindingUtil.inflate(LayoutInflater.from(v.
                    getContext()), R.layout.layout_update_user, viewGroup, false);
            builder.setView(layoutUpdateUserBinding.getRoot());
            AlertDialog alertDialog = builder.create();

            ((AppCompatActivity) requireActivity()).setSupportActionBar(layoutUpdateUserBinding.updateToolbar);
            layoutUpdateUserBinding.updateToolbar.setTitleTextColor(Color.WHITE);

            layoutUpdateUserBinding.ImgClose.setOnClickListener(v1 -> alertDialog.dismiss());

            layoutUpdateUserBinding.btnUpdateUser.setOnClickListener(v1 -> {
                updateUser(Objects.requireNonNull(layoutUpdateUserBinding.ETUsername.getText()).toString(),
                        Objects.requireNonNull(layoutUpdateUserBinding.ETLastName.getText()).toString()
                        , layoutUpdateUserBinding.rbMale.isChecked() ? "1" : "2");
                alertDialog.dismiss();
            });
            alertDialog.show();
        });


        binding.constraintProfileChat.setOnClickListener(v -> {
            String number = "+91 8208145918";
            String url = "https://api.whatsapp.com/send?phone=" + number;
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        });


        binding.BtnLogout.setOnClickListener(v -> {
            SharedPrefs.getInstance().removeAll();
            startActivity(new Intent(getContext(), LogInActivity.class));
            requireActivity().finish();
        });
        binding.constraintProfileWallet.setOnClickListener(v -> startActivity(new Intent(getContext(), WalletActivity.class)));
        //  binding.TVBidHistory.setOnClickListener(v -> startActivity(new Intent(getContext(), BidHistoryActivity.class)));

        binding.constraintProfileAddress.setOnClickListener(v -> startActivity(new Intent(getContext(), AddressActivity.class)));

       /* binding.TvPrivacyPolicy.setOnClickListener(v -> {
            Uri uriPrivacyPolicy = Uri.parse("http://betdigital.club/privacy-policy.html");
            Intent intentPrivacyPolicy = new Intent(Intent.ACTION_VIEW, uriPrivacyPolicy);
            startActivity(intentPrivacyPolicy);
        });*/

        binding.constraintProfileWinners.setOnClickListener(v -> startActivity(new Intent(requireContext(), WinnerProductActivity.class)));

        return view;
    }

    private void updateUser(String username, String lastname, String gender) {
        SignupViewModel viewModel = new ViewModelProvider(this).get(SignupViewModel.class);
        UpdateUserDetailsBody userDetailsBody = new UpdateUserDetailsBody();
        UpdateUserDetailsBody.Customer customer = new UpdateUserDetailsBody.Customer(SharedPrefs.getInstance().getString(ConstantHelper.KEY_CUSTOMER, "")
                , SharedPrefs.getInstance().getString(ConstantHelper.secure_key, ""), "",
                username, lastname, "", gender, "", "1");

        userDetailsBody.setCustomer(customer);
        viewModel.setUpdateSignUpMutableLiveData(userDetailsBody);
        viewModel.updateSignUpLiveData().observe(requireActivity(), updateUserDetails -> {
            if (updateUserDetails != null) {
                SharedPrefs.getInstance().addString(ConstantHelper.USERNAME, updateUserDetails.getPayload().getFirstname());
                SharedPrefs.getInstance().addString(ConstantHelper.LASTNAME, updateUserDetails.getPayload().getLastname());
                Toasty.success(requireContext(), "Update Successful", Toast.LENGTH_SHORT, true).show();
                binding.TVUserName.setText(SharedPrefs.getInstance().getString(ConstantHelper.USERNAME, "EMPTY"));
                binding.TvLastName.setText(SharedPrefs.getInstance().getString(ConstantHelper.LASTNAME, "EMPTY"));
                binding.TVUserEmailId.setText(SharedPrefs.getInstance().getString(ConstantHelper.EMAIL, "EMPTY"));
            }

        });

    }
}
