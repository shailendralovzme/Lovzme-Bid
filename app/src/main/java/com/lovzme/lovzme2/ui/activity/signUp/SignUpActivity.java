package com.lovzme.lovzme2.ui.activity.signUp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.widget.Toast;
import com.lovzme.lovzme2.R;
import com.lovzme.lovzme2.application.LovzMe2App;
import com.lovzme.lovzme2.databinding.ActivitySignUpBinding;
import com.lovzme.lovzme2.ui.activity.login.VerifyPhoneActivity;
import com.lovzme.lovzme2.ui.activity.signUp.viewModel.SignupViewModel;
import com.lovzme.lovzme2.utils.Constants;

import java.util.Objects;

import es.dmoral.toasty.Toasty;

public class SignUpActivity extends AppCompatActivity {
    ActivitySignUpBinding binding;
    SignupViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_sign_up);

        viewModel = new ViewModelProvider(this).get(SignupViewModel.class);

        binding.btnSignUp.setOnClickListener(v -> {
            String firstname = Objects.requireNonNull(binding.ETFirstName.getText()).toString();
            String last_name = binding.ETFirstName.getText().toString();
            String email = Objects.requireNonNull(binding.ETEmail.getText()).toString();
            String password = Objects.requireNonNull(binding.ETPassword.getText()).toString();
            String mobile = Objects.requireNonNull(binding.ETMobileNo.getText()).toString();
            LovzMe2App.showBidProgressDialog(SignUpActivity.this);
            if (TextUtils.isEmpty(firstname) && TextUtils.isEmpty(last_name) && TextUtils.isEmpty(email)
                    && TextUtils.isEmpty(password)  && TextUtils.isEmpty(mobile)){
                LovzMe2App.hideBidProgressDialog();
                Toasty.error(this, "All fields are mandatory", Toast.LENGTH_SHORT).show();
            }else if (binding.ETPassword.getText().toString().trim().length()!=6){
                Toast.makeText(this, "Password too short, minimum 6 characters", Toast.LENGTH_SHORT).show();
            }else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                Toast.makeText(this, "Enter Valid Email ID", Toast.LENGTH_SHORT).show();
            }else if (password.length()<6){
                Toast.makeText(this, "Enter Valid Password", Toast.LENGTH_SHORT).show();
            }else if (binding.ETMobileNo.getText().toString().trim().length()!=10){
                Toasty.error(this, "Please enter correct number", Toast.LENGTH_SHORT, true).show();
            } else if (!binding.cbNewsletter.isChecked()){
                Toasty.error(SignUpActivity.this, "Something is missing", Toast.LENGTH_SHORT).show();
            }else {
                Intent intent = new Intent(getApplicationContext(),VerifyPhoneActivity.class);
                intent.putExtra(VerifyPhoneActivity.EXTRA_MOBILE_NO,binding.ETMobileNo.getText().toString());
                intent.putExtra(VerifyPhoneActivity.EXTRA_FROM, Constants.INTENT_EXTRA_SIGN_UP);
                intent.putExtra(VerifyPhoneActivity.EXTRA_NAME,binding.ETFirstName.getText().toString());
                intent.putExtra(VerifyPhoneActivity.EXTRA_LASTNAME, Objects.requireNonNull(binding.ETLastName.getText()).toString());
                intent.putExtra(VerifyPhoneActivity.EXTRA_EMAIL,binding.ETEmail.getText().toString());
                intent.putExtra(VerifyPhoneActivity.EXTRA_PASSWORD,binding.ETPassword.getText().toString());
                intent.putExtra(VerifyPhoneActivity.EXTRA_PHONE,binding.ETMobileNo.getText().toString());
                intent.putExtra(VerifyPhoneActivity.EXTRA_RB,binding.rbMale.isChecked() ?"1":"2");
                intent.putExtra(VerifyPhoneActivity.EXTRA_CB_NEWS,binding.cbNewsletter.isChecked() ?"1" :"2");
                startActivity(intent);
                finish();
            }
        });
    }

}