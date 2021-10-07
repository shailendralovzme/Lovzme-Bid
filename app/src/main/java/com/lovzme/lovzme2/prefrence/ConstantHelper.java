package com.lovzme.lovzme2.prefrence;

import android.annotation.SuppressLint;

public class ConstantHelper {

    @SuppressLint("StaticFieldLeak")
/*    public static Prefs mSharedPref;
    public static final String LOGIN = "login";
    public static final String LOGOUT = "logout";*/
    public static ConstantHelper helper;
    public static final String ADDRESSID = "AddressId";
    public static final String MOBILE_NO = "mobile";
    public static final String EMAIL = "email";
    public static final String USERNAME = "username";
    public static final String LASTNAME = "last_name";
    public final static String KEY_CUSTOMER = "customer";
    public final static String secure_key = "secure_key";
    public final static String IS_REMINDER = "isReminder";
    public final static String FCMTOKEN = "fcmToken";

    /*private PreferenceHelper()
    {

    }

    public static PreferenceHelper init(Context context)
    {
        if(mSharedPref == null){
            mSharedPref = new Prefs(context);
            helper = new PreferenceHelper();
        }
        return helper;
    }

    public  void setName(String value){
        mSharedPref.setString(NAME,value);
    }
    public  String getName(){
       return mSharedPref.getString(NAME);
    }
    public  void setMobile(String value){
        mSharedPref.setString(MOBILE_NO,value);
    }
    public  String getMobile(){
        return mSharedPref.getString(MOBILE_NO);
    }
    public  void setLogin(boolean value){
        mSharedPref.setBoolean(LOGIN,value);
    }
    public boolean login(){
        return mSharedPref.getBoolean(LOGIN);
    }

    public void setSignin(boolean value){
        mSharedPref.setBoolean(SIGNIN,value);
    }
    public boolean signin(){
        return mSharedPref.getBoolean(SIGNIN);

    }

    public static String getKeyCustomer() {
        return mSharedPref.getString(KEY_CUSTOMER);
    }

    public  void setEmail(String value){
        mSharedPref.setString(EMAIL,value);
    }
    public String getEmail(){
        return mSharedPref.getString(EMAIL);
    }
    public  void Logout(){
       setName("");
       setLogin(false);
       setMobile("");
       setEmail("");
       setSignin(false);
    }*/


}
