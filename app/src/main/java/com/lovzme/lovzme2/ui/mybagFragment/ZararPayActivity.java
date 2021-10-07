package com.lovzme.lovzme2.ui.mybagFragment;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import android.widget.Toast;

import com.lovzme.lovzme2.R;
import com.lovzme.lovzme2.prefrence.ConstantHelper;
import com.lovzme.lovzme2.prefrence.SharedPrefs;
import com.razorpay.Checkout;
import com.razorpay.PaymentData;
import com.razorpay.PaymentResultListener;
import com.razorpay.PaymentResultWithDataListener;

import org.json.JSONObject;

public class ZararPayActivity extends AppCompatActivity implements PaymentResultWithDataListener {
    private static final String TAG = ZararPayActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zarar_pay);


        Checkout.preload(getApplicationContext());

        // Payment button created by you in XML layout
        Button button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startPayment();
            }
        });




    }

    public void startPayment() {
        /*
          You need to pass current activity in order to let Razorpay create CheckoutActivity
         */
        final Activity activity = this;

        final Checkout co = new Checkout();
        co.setKeyID("rzp_test_xI1Jl1zceFffBb");
        try {
            JSONObject options = new JSONObject();
            options.put("name", "Juvenca Online pvt ltd");
            options.put("description", "");
            options.put("image", "https://s3.amazonaws.com/rzp-mobile/images/rzp.png");
            //options.put("order_id","order_123456");
            options.put("theme.color", "#3399cc");
            options.put("currency", "INR");
            options.put("amount",1000);
            options.put("prefill.email", "abc@gmail.com");
            options.put("prefill.contact","9167136256");
            JSONObject retryObj = new JSONObject();
            retryObj.put("enabled", true);
            retryObj.put("max_count", 4);
            options.put("retry", retryObj);

            JSONObject preFill = new JSONObject();
            preFill.put("email", "test@razorpay.com");
            preFill.put("contact", "9876543210");

            options.put("prefill", preFill);

            co.open(activity, options);
        } catch (Exception e) {
            Toast.makeText(activity, "Error in payment: " + e.getMessage(), Toast.LENGTH_SHORT)
                    .show();
            Log.e(TAG, "startPayment: "+e.getMessage() );
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unused")
   /* @Override
    public void onPaymentSuccess(String razorpayPaymentID) {
        try {
            Toast.makeText(this, "Payment Successful: " + razorpayPaymentID, Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            Log.e(TAG, "Exception in onPaymentSuccess", e);
        }
    }


    @SuppressWarnings("unused")
    @Override
    public void onPaymentError(int code, String response) {
        try {
            Toast.makeText(this, "Payment failed: " + code + " " + response, Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Log.e(TAG, "Exception in onPaymentError", e);
        }
    }*/

    @Override
    public void onPaymentSuccess(String s, PaymentData paymentData) {
        Log.e("fdfjjdfhjdfsjhs", "onPaymentSuccess: "+paymentData.getOrderId() );
    }

    @Override
    public void onPaymentError(int i, String s, PaymentData paymentData) {

    }
}