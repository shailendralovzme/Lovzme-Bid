package com.lovzme.lovzme2.prefrence;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;
import java.util.Map;

public class SharedPrefs {

 /*   public static final String CUSTOMER_ID_KEY = "com.lovzme.lovzme2.prefrence.user.customer.id";
    public static final String REM

    public static synchronized SharedPreferences getInstance(Context context) {
        return context.getSharedPreferences("com.lovzme.lovzme2", Context.MODE_PRIVATE);
    }

    public static String getStringPref(Context context, String key) {
        return getInstance(context).getString(key, "EMPTY");
    }

    public static void setStringPref(Context context, String key, String value) {
        SharedPreferences.Editor editor = getInstance(context).edit();
        editor.putString(key, value);
        editor.apply();
    }

    public static boolean getBooleanPref(Context context, String key) {
        return getInstance(context).getBoolean(key,false);
    }

    public static void setBooleanPref(Context context,String key,boolean value){
        SharedPreferences.Editor editor = getInstance(context).edit();
        editor.putBoolean(key, value);
        editor.apply();
    }*/

    public boolean getBoolean(String key, boolean defaultValue) {
        if (sharedPrefMap.containsKey(key)) {
            return (boolean) sharedPrefMap.get(key);
        }
        return sharedPreferences.getBoolean(key, defaultValue);
    }

    public void addBoolean(String key, boolean value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.apply();
        sharedPrefMap.put(key, value);
    }
    private static final String SHARED_PREFS_NAME = "Lovzme2App";

    private static SharedPrefs sharedPrefs;
    private SharedPreferences sharedPreferences;
    private Map<String, Object> sharedPrefMap;

    private SharedPrefs(Context context) {
        sharedPrefMap = new HashMap<>();
        sharedPreferences = context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE);
    }

    public static void initialize(Context context) {
        if (sharedPrefs == null) {
            sharedPrefs = new SharedPrefs(context);
        }
    }

    public static SharedPrefs getInstance() {
        if (sharedPrefs == null) {
            throw new RuntimeException("Initialize SharedPrefs by calling initialize() method");
        }
        return sharedPrefs;
    }

    public boolean containsKey(String key) {
        return sharedPrefMap.containsKey(key);
    }

    public void addString(String key, String value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
        sharedPrefMap.put(key, value);
    }



    public void addInt(String key, int value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, value);
        editor.apply();
        sharedPrefMap.put(key, value);
    }

    public void addLong(String key, long value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putLong(key, value);
        editor.apply();
        sharedPrefMap.put(key, value);
    }

    public void remove(String key) {
        sharedPrefMap.remove(key);
        if (sharedPreferences.contains(key)) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.remove(key).apply();
        }
    }

    public void removeAll() {
        sharedPrefMap.clear();
        Map<String, ?> allKeys = sharedPreferences.getAll();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        for (String key : allKeys.keySet()) {
            editor.remove(key);
        }
        editor.apply();
    }

    public String getString(String key, String defaultValue) {
        if (sharedPrefMap.containsKey(key)) {
            return (String) sharedPrefMap.get(key);
        }
        return sharedPreferences.getString(key, defaultValue);
    }



    public int getInt(String key, int defaultValue) {
        if (sharedPrefMap.containsKey(key)) {
            return (int) sharedPrefMap.get(key);
        }
        return sharedPreferences.getInt(key, defaultValue);
    }

    public long getLong(String key, long defaultValue) {
        if (sharedPrefMap.containsKey(key)) {
            return (long) sharedPrefMap.get(key);
        }
        return sharedPreferences.getLong(key, defaultValue);
    }
}