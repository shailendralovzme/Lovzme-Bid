package com.lovzme.lovzme2.prefrence;

import android.content.Context;
import android.content.SharedPreferences;

public class Prefs {

    private static final String PREF_NAME = "lovzme2";
    Context context;

    Prefs(Context context) {
        this.context = context;
    }

   public  void setString(String key,String value) {
       SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
       SharedPreferences.Editor editor = sharedPreferences.edit();
       editor.putString(key,value);
       editor.apply();
   }

   public String getString(String key){
       SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
       return sharedPreferences.getString(key, "");
   }

    public  void setInt(String key,int value){
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key,value);
        editor.apply();
    }

    public int getInt(String key){
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getInt(key, 0);
    }
    public  void setFloat(String key,float value){
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putFloat(key,value);
        editor.apply();
    }

    public float getFloat(String key){
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getFloat(key, 0);
    }
    public  void setBoolean(String key,boolean value){
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key,value);
        editor.apply();
    }

    public boolean getBoolean(String key){
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean(key, false);
    }
}
