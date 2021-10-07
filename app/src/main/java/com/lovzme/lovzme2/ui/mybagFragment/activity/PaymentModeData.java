package com.lovzme.lovzme2.ui.mybagFragment.activity;

import com.lovzme.lovzme2.R;

import java.util.ArrayList;

public class PaymentModeData {
    public static ArrayList<PaymentModeModel> getData() {
        ArrayList<PaymentModeModel> data = new ArrayList<>();

        int[] paymentModeNo = {1, 2};

        int[] paymentModeImg = {
                R.drawable.ic_cash_payment,
                R.drawable.ic_online_payment

        };


        String[] paymentMode = {
                "Cash On Delivery",
                "Online Payment"
        };

        for (int i = 0; i < paymentModeNo.length; i++) {
            PaymentModeModel current = new PaymentModeModel();
            current.setPayment_mode_no(paymentModeNo[i]);
            current.setPayment_mode_img(paymentModeImg[i]);
            current.setPayment_mode(paymentMode[i]);
            data.add(current);
        }
        return data;
    }


    public static class PaymentModeModel {

        public int payment_mode_no;
        public String payment_mode;
        public int payment_mode_img;

        public int getPayment_mode_no() {
            return payment_mode_no;
        }

        void setPayment_mode_no(int payment_mode_no) {
            this.payment_mode_no = payment_mode_no;
        }

        public String getPayment_mode() {
            return payment_mode;
        }

        void setPayment_mode(String payment_mode) {
            this.payment_mode = payment_mode;
        }

        public int getPayment_mode_img() {
            return payment_mode_img;
        }

        void setPayment_mode_img(int payment_mode_img) {
            this.payment_mode_img = payment_mode_img;
        }

    }
}
