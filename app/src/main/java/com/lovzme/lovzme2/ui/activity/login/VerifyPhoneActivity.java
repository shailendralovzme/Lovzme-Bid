package com.lovzme.lovzme2.ui.activity.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.messaging.FirebaseMessaging;
import com.lovzme.lovzme2.R;
import com.lovzme.lovzme2.application.LovzMe2App;
import com.lovzme.lovzme2.databinding.ActivityVerifyPhoneBinding;
import com.lovzme.lovzme2.prefrence.ConstantHelper;
import com.lovzme.lovzme2.prefrence.SharedPrefs;
import com.lovzme.lovzme2.ui.activity.MainActivity;
import com.lovzme.lovzme2.ui.activity.login.viewModel.SigninViewModel;
import com.lovzme.lovzme2.ui.activity.signUp.SignUpActivity;
import com.lovzme.lovzme2.ui.activity.signUp.model.SignupBody;
import com.lovzme.lovzme2.ui.activity.signUp.viewModel.SignupViewModel;
import com.lovzme.lovzme2.utils.Constants;


import java.util.Objects;
import java.util.concurrent.TimeUnit;

import es.dmoral.toasty.Toasty;


public class VerifyPhoneActivity extends AppCompatActivity {
    ActivityVerifyPhoneBinding binding;
    String mobile, mVerificationId, Taskname;
    FirebaseAuth mAuth;
    PhoneAuthCredential credential;
    SignupViewModel viewModel;
    String FcmToken;

    public static final String EXTRA_MOBILE_NO = "com.lovzme.lovzme2.ui.activity.login.mobile.no";
    public static final String EXTRA_FROM = "com.lovzme.lovzme2.ui.activity.login.from.activity";
    public static final String EXTRA_NAME = "com.lovzme.lovzme2.ui.activity.login.name.activity";
    public static final String EXTRA_LASTNAME = "com.lovzme.lovzme2.ui.activity.login.lastname.activity";
    public static final String EXTRA_EMAIL = "com.lovzme.lovzme2.ui.activity.login.email.activity";
    public static final String EXTRA_PHONE = "com.lovzme.lovzme2.ui.activity.login.phone.activity";
    public static final String EXTRA_PASSWORD = "com.lovzme.lovzme2.ui.activity.login.password.activity";
    public static final String EXTRA_RB = "com.lovzme.lovzme2.ui.activity.login.rb.activity";
    public static final String EXTRA_CB_NEWS = "com.lovzme.lovzme2.ui.activity.login.news.activity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_verify_phone);

        viewModel = new ViewModelProvider(this).get(SignupViewModel.class);

        mobile = "+91 " + getIntent().getStringExtra(EXTRA_MOBILE_NO);
        binding.TvPhoneNumber.setText(mobile);
        startCounter();
        mAuth = FirebaseAuth.getInstance();
        if(getIntent().hasExtra(EXTRA_FROM)) {
            Taskname = getIntent().getStringExtra(EXTRA_FROM);
        }

        binding.BtnVerify.setOnClickListener(v -> {
            LovzMe2App.showBidProgressDialog(VerifyPhoneActivity.this);
            if (TextUtils.isEmpty(binding.pinView.getText()) || Objects.requireNonNull(binding.pinView.getText()).length() != 6) {
                Toasty.warning(this, "Enter a Valid Code", Toasty.LENGTH_SHORT, true).show();
            } else {
                String code = binding.pinView.getText().toString().trim();
                credential = PhoneAuthProvider.getCredential(mVerificationId, code);
                if(Taskname.equals(Constants.INTENT_EXTRA_LOGIN)) {
                    getVerifyPhoneLogin(getIntent().getStringExtra(EXTRA_MOBILE_NO));
                } else {
                    signInWithPhoneAuthCredential(credential);
                }
            }
        });

        binding.TvResendCode.setOnClickListener(v -> {
            PhoneAuthProvider.getInstance().verifyPhoneNumber(mobile, 60, TimeUnit.SECONDS, VerifyPhoneActivity.this, mCallbacks);
            startCounter();
        });
        PhoneAuthProvider.getInstance().verifyPhoneNumber(mobile, 60, TimeUnit.SECONDS, VerifyPhoneActivity.this, mCallbacks);

    }

    private final PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        @Override
        public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
            String code = phoneAuthCredential.getSmsCode();
            if (code != null) {
                binding.pinView.setText(code);
                credential = PhoneAuthProvider.getCredential(mVerificationId, code);
               signInWithPhoneAuthCredential(credential);
            }
        }

        @Override
        public void onVerificationFailed(FirebaseException e) {
            Log.e("VerificationFail", "" + e.getMessage());
            Log.e("dddddddd", "" + e.getMessage());
            Toast.makeText(VerifyPhoneActivity.this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);
            mVerificationId = s;
        }
    };

    private void startCounter() {
        new CountDownTimer(21000, 1000) {
            @SuppressLint("SetTextI18n")
            public void onTick(long millisUntilFinished) {
                binding.TvTimer.setVisibility(View.VISIBLE);
                binding.TvResendCode.setVisibility(View.GONE);
                binding.TvTimer.setText("Seconds Remaining : " + millisUntilFinished / 1000);
            }
            public void onFinish() {
                binding.TvTimer.setVisibility(View.GONE);
                binding.TvResendCode.setVisibility(View.VISIBLE);
            }

        }.start();

    }

    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        signUp();
                        startCounter();
                    } else {
                        getVerifyPhoneLogin(getIntent().getStringExtra("mobile_no"));
                    }
                });
    }

    private void getVerifyPhoneLogin(String phone) {
        SigninViewModel viewModel = new ViewModelProvider(this).get(SigninViewModel.class);
        viewModel.setPhoneloginMutabledata(phone);
        viewModel.getphoneLivedata().observe(this, phoneLogin -> {
            if (phoneLogin.getSuccess()) {

                LovzMe2App.hideBidProgressDialog();
                Toasty.success(VerifyPhoneActivity.this, phoneLogin.getMessage(), Toasty.LENGTH_LONG, true).show();
                SharedPrefs.getInstance().addString(ConstantHelper.KEY_CUSTOMER, phoneLogin.getPayload().getIdCustomer());
                SharedPrefs.getInstance().addString(ConstantHelper.secure_key, phoneLogin.getPayload().getSecureKey());
                SharedPrefs.getInstance().addString(ConstantHelper.USERNAME, phoneLogin.getPayload().getFirstname());
                SharedPrefs.getInstance().addString(ConstantHelper.LASTNAME,phoneLogin.getPayload().getLastname());
                SharedPrefs.getInstance().addString(ConstantHelper.EMAIL, phoneLogin.getPayload().getEmail());
                SharedPrefs.getInstance().addString(ConstantHelper.MOBILE_NO, Objects.requireNonNull(binding.pinView.getText()).toString());
                SharedPrefs.getInstance().addBoolean(ConstantHelper.IS_REMINDER, true);
                startActivity(new Intent(VerifyPhoneActivity.this, MainActivity.class));
            } else {
                if (getIntent().getStringExtra(EXTRA_FROM).equalsIgnoreCase("LOGIN")){
                    LovzMe2App.hideBidProgressDialog();
                    Toasty.error(VerifyPhoneActivity.this, phoneLogin.getMessage() + " please go to the signup page", Toasty.LENGTH_LONG, true).show();
                    startActivity(new Intent(VerifyPhoneActivity.this, SignUpActivity.class));
                }else {
                    signInWithPhoneAuthCredential(credential);
                }

            }
            finishAffinity();
        });

    }
    public void signUp(){
        SignupBody signupBody = new SignupBody();
        String token =   SharedPrefs.getInstance().getString(ConstantHelper.FCMTOKEN, "empty");
        Log.e("hgdhgdhdfghfd", "onCreateView: "+token );
        SignupBody.Customer customerdata = new SignupBody.Customer
                (getIntent().getStringExtra(EXTRA_NAME),
                      getIntent().getStringExtra(EXTRA_LASTNAME) ,
                       getIntent().getStringExtra(EXTRA_EMAIL) ,
                     getIntent().getStringExtra(EXTRA_PASSWORD),
                        getIntent().getStringExtra(EXTRA_PHONE) ,
                        getIntent().getStringExtra(EXTRA_RB)
                     ,"",
                        getIntent().getStringExtra(EXTRA_CB_NEWS),
                        token);

        signupBody.setCustomer(customerdata);
        viewModel.setSignupRepository(signupBody);

        viewModel.getLogin().observe(this, signupresponseData -> {
            if (signupresponseData.getSuccess()){
                LovzMe2App.hideBidProgressDialog();
                SharedPrefs.getInstance().addString(ConstantHelper.KEY_CUSTOMER, signupresponseData.getPayload().getIdCustomer());
                SharedPrefs.getInstance().addString(ConstantHelper.secure_key,signupresponseData.getPayload().getSecureKey());
                SharedPrefs.getInstance().addString(ConstantHelper.USERNAME,signupresponseData.getPayload().getFirstname());
                SharedPrefs.getInstance().addString(ConstantHelper.LASTNAME,signupresponseData.getPayload().getLastname());
                SharedPrefs.getInstance().addString(ConstantHelper.EMAIL,signupresponseData.getPayload().getEmail());
               SharedPrefs.getInstance().addBoolean(ConstantHelper.IS_REMINDER, true);
                Toasty.success(this,signupresponseData.getMessage(),Toasty.LENGTH_LONG,true).show();
                startActivity(new Intent(this,MainActivity.class));
            }else {
                LovzMe2App.hideBidProgressDialog();
                Toasty.error(this,signupresponseData.getMessage(),Toasty.LENGTH_LONG,true).show();
            }
        });
    }


}