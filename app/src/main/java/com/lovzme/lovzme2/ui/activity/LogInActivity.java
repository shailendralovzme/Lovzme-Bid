package com.lovzme.lovzme2.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.widget.Toast;
import com.lovzme.lovzme2.R;
import com.lovzme.lovzme2.application.LovzMe2App;
import com.lovzme.lovzme2.databinding.ActivityLoginBinding;
import com.lovzme.lovzme2.ui.activity.login.SignInActivity;
import com.lovzme.lovzme2.ui.activity.signUp.SignUpActivity;
import com.lovzme.lovzme2.ui.activity.login.VerifyPhoneActivity;
import com.lovzme.lovzme2.utils.Constants;

import es.dmoral.toasty.Toasty;

public class LogInActivity extends AppCompatActivity {
    ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       binding = DataBindingUtil.setContentView(this,R.layout.activity_login);

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);


        String text = "Don't have account ? Sign Up";
        SpannableString spannableString = new SpannableString(text);
        int color = getResources().getColor(R.color.Backgraound_color);
        ForegroundColorSpan red = new ForegroundColorSpan(color);
        spannableString.setSpan(red,
                20, 28, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        binding.textViewSignUp.setText(spannableString);

        binding.textViewSignUp.setOnClickListener(v -> startActivity(new Intent(this, SignUpActivity.class)));

        binding.cardViewEmail.setOnClickListener(v -> startActivity(new Intent(this, SignInActivity.class)));

        binding.BTNSignWithOTP.setOnClickListener(v -> {
            if (!binding.ETPhoneNo.getText().toString().trim().isEmpty()){
                LovzMe2App.showBidProgressDialog(LogInActivity.this);
                if ((binding.ETPhoneNo.getText().toString().trim()).length()==10) {
                    Intent intent = new Intent(this,VerifyPhoneActivity.class);
                    intent.putExtra(VerifyPhoneActivity.EXTRA_MOBILE_NO,binding.ETPhoneNo.getText().toString());
                    intent.putExtra(VerifyPhoneActivity.EXTRA_FROM, Constants.INTENT_EXTRA_LOGIN);

                    startActivity(intent);
                }else {
                    Toasty.error(this, "Please enter correct number", Toast.LENGTH_SHORT, true).show();
                }
                }else {
                Toasty.warning(this, "Enter mobile number", Toast.LENGTH_SHORT, true).show();
            }
        });
    }

}