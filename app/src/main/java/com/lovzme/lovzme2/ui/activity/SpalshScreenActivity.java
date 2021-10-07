package com.lovzme.lovzme2.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;


import com.google.firebase.messaging.FirebaseMessaging;
import com.lovzme.lovzme2.R;
import com.lovzme.lovzme2.databinding.ActivitySpalshScreenBinding;
import com.lovzme.lovzme2.prefrence.ConstantHelper;
import com.lovzme.lovzme2.prefrence.SharedPrefs;
import com.lovzme.lovzme2.ui.activity.login.SignInActivity;

public class SpalshScreenActivity extends AppCompatActivity {
    ActivitySpalshScreenBinding binding;
    Animation uptodown, downtoup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_spalsh_screen);


        uptodown = AnimationUtils.loadAnimation(this, R.anim.uptodown);
        downtoup = AnimationUtils.loadAnimation(this, R.anim.downtoup);

        binding.imgGif.setAnimation(downtoup);

        Thread myThread = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(4000);
                    if (SharedPrefs.getInstance().getBoolean(ConstantHelper.IS_REMINDER, false)) {
                        String cust_id = SharedPrefs.getInstance().getString(ConstantHelper.KEY_CUSTOMER, "EMPTY");
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        intent.putExtra("Customer_id", cust_id);
                        startActivity(intent);
                    } else {
                        Intent intent = new Intent(getApplicationContext(), LogInActivity.class);
                        startActivity(intent);
                    }
                /*    if (SharedPrefs.getInstance().getBoolean(ConstantHelper.IS_REMINDER, true)) {

                    } else {
                        Intent intent = new Intent(getApplicationContext(), LogInActivity.class);
                        startActivity(intent);
                    }*/
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        myThread.start();

    }

}
