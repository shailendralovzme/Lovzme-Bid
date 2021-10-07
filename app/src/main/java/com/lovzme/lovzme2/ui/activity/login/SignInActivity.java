package com.lovzme.lovzme2.ui.activity.login;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.google.firebase.messaging.FirebaseMessaging;
import com.lovzme.lovzme2.R;
import com.lovzme.lovzme2.application.LovzMe2App;
import com.lovzme.lovzme2.databinding.ActivitySignInBinding;
import com.lovzme.lovzme2.databinding.DialogForgetPasswordBinding;
import com.lovzme.lovzme2.prefrence.ConstantHelper;
import com.lovzme.lovzme2.prefrence.SharedPrefs;
import com.lovzme.lovzme2.ui.activity.MainActivity;
import com.lovzme.lovzme2.ui.activity.login.viewModel.SigninViewModel;

import es.dmoral.toasty.Toasty;

public class SignInActivity extends AppCompatActivity {
    ActivitySignInBinding binding;
    SigninViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_sign_in);

        viewModel = new ViewModelProvider(this).get(SigninViewModel.class);
        binding.progressBar.setVisibility(View.VISIBLE);

        generateFcmToken();

        binding.TVCangePassword.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(SignInActivity.this);
            ViewGroup viewGroup = findViewById(android.R.id.content);
            DialogForgetPasswordBinding forgetPasswordBinding = DataBindingUtil.inflate(LayoutInflater.from(v.
                    getContext()), R.layout.dialog_forget_password, viewGroup, false);
            builder.setView(forgetPasswordBinding.getRoot());

            AlertDialog alertDialog = builder.create();
            forgetPasswordBinding.BtnSubmit.setOnClickListener(v1 -> {
                changePassword(forgetPasswordBinding.ETEmail.getText().toString());
                alertDialog.dismiss();
            });
            alertDialog.show();
        });
        binding.BtnSignIn.setOnClickListener(v -> {
            LovzMe2App.showBidProgressDialog(SignInActivity.this);
                String editEmail = binding.editTextTextEmailAddress.getText().toString();
                String editPassword = binding.editTextTextPassword.getText().toString();
                if (TextUtils.isEmpty(editEmail) && TextUtils.isEmpty(editPassword)){
                    Toasty.error(SignInActivity.this, "All fields are mandatory", Toast.LENGTH_SHORT).show();
                } else if (binding.editTextTextPassword.getText().toString().trim().length() < 6) {
                    binding.editTextTextPassword.setError("Password too short, minimum 6 characters");
                }else if (!Patterns.EMAIL_ADDRESS.matcher(editEmail).matches()){
                    binding.editTextTextEmailAddress.setError("Invalid Email Address");
                }else if (editPassword.length() < 6){
                    binding.editTextTextPassword.setError("Password too short, minimum 6 characters");
                }else if (!binding.checkBox.isChecked()){
                    Toasty.error(SignInActivity.this, "Please Accept the company's Term and Policy", Toast.LENGTH_SHORT).show();
                } else {
                    signIn(binding.editTextTextEmailAddress.getText().toString(),binding.editTextTextPassword.getText().toString(),
                            SharedPrefs.getInstance().getString(ConstantHelper.FCMTOKEN,"EMPTY"));
                }
        });
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();

    }



    private void signIn(String username, String password,String FcmToken) {
            viewModel.setLogin(username,password,FcmToken);
            viewModel.getLogin().observe(this, logInData -> {
                if (logInData.getSuccess().equals(true)){
                    LovzMe2App.hideBidProgressDialog();
                    startActivity(new Intent(SignInActivity.this, MainActivity.class));
                    SharedPrefs.getInstance().addString(ConstantHelper.KEY_CUSTOMER, logInData.getPayload().getIdCustomer());
                    SharedPrefs.getInstance().addString(ConstantHelper.secure_key,logInData.getPayload().getSecureKey());
                    SharedPrefs.getInstance().addString(ConstantHelper.USERNAME,logInData.getPayload().getFirstname());
                    SharedPrefs.getInstance().addString(ConstantHelper.LASTNAME,logInData.getPayload().getLastname());
                    SharedPrefs.getInstance().addString(ConstantHelper.EMAIL,logInData.getPayload().getEmail());
                    SharedPrefs.getInstance().addBoolean(ConstantHelper.IS_REMINDER, binding.checkBox.isChecked());
                    Toasty.success(SignInActivity.this,logInData.getMessage(),Toasty.LENGTH_LONG,true).show();
                    binding.progressBar.setVisibility(View.GONE);

                } else {
                    Toasty.error(SignInActivity.this, logInData.getMessage(), Toast.LENGTH_SHORT,true).show();
                    LovzMe2App.hideBidProgressDialog();
                }
            });


    }



    private void changePassword(String email){
        viewModel.setChangePasswordMutableLiveData(email);
        viewModel.getchangePasswordliveData().observe(this, changePassword -> {
            if (changePassword.getSuccess()!=null){
                Toasty.success(SignInActivity.this, changePassword.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void generateFcmToken() {
        FirebaseMessaging.getInstance().getToken().addOnCompleteListener(task -> {
            if (!task.isSuccessful()){
                Toast.makeText(this, "getInstanceId failed"+task.getException(), Toast.LENGTH_SHORT).show();
            }
            SharedPrefs.getInstance().addString(ConstantHelper.FCMTOKEN,task.getResult());

            Log.d("dfsdsfdfsdf", "FcmToken: " + task.getResult());
        });
    }

}