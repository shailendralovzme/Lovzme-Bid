package com.lovzme.lovzme2.application;

import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;
import com.lovzme.lovzme2.R;
import com.lovzme.lovzme2.prefrence.SharedPrefs;
import com.lovzme.lovzme2.ui.homefragment.response.sallingresponse.SellingProduct;
import com.lovzme.lovzme2.ui.mybagFragment.addToCart.Cart;

import java.util.ArrayList;

public class LovzMe2App extends Application {
    private static LovzMe2App applicationInstance;
    public static Dialog dialog;
    private ArrayList<SellingProduct> livesaleLists = new ArrayList<>();
    private  ArrayList<SellingProduct> upcomingsales = new ArrayList<>();
     public static Cart cart;

    public static LovzMe2App getInstance() {
        return applicationInstance;
    }
    @Override
    public void onCreate() {
        super.onCreate();
       SharedPrefs.initialize(this);
        applicationInstance = this;
    }

    public ArrayList<SellingProduct> getLivesaleLists() {
        return livesaleLists;
    }

    public void setLivesaleLists(ArrayList<SellingProduct> livesaleLists) {
        this.livesaleLists = livesaleLists;
    }

    public ArrayList<SellingProduct> getUpcomingsales() {
        return upcomingsales;
    }

    public void setUpcomingsales(ArrayList<SellingProduct> upcomingsales) {
        this.upcomingsales = upcomingsales;
    }

    public static void showBidProgressDialog(Context context) {
        dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.layout_progress_dialog);
        dialog.setCanceledOnTouchOutside(false);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.show();
    }

    public static void hideBidProgressDialog() {
        if (dialog != null) {
            dialog.dismiss();
        }
    }
}
