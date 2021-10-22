package com.example.quiz;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class SessionManager {


    public static final String key_nama = "keynama";
    private static final String pref_name = "Quiz";
    private static final String is_login = "islogin";
    private static final String umur_nya = "umur";

    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context context;
    int mode = 0;

    @SuppressLint("CommitPrefEdits")
    public SessionManager(Context context) {
        this.context = context;
        pref = context.getSharedPreferences(pref_name, mode);
        editor = pref.edit();
    }

    private static SharedPreferences getSharedPreference(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static void setLogin(Context context, boolean idLogin) {
        SharedPreferences.Editor editor = getSharedPreference(context).edit();
        editor.putBoolean(is_login, idLogin);
        editor.apply();
    }

    public static boolean is_login(Context context) {
        return getSharedPreference(context).getBoolean(is_login, false);
    }


    public static void setKey_nama(Context context, String nama) {
        SharedPreferences.Editor editor = getSharedPreference(context).edit();
        editor.putString(key_nama, nama);
        editor.apply();
    }

    public static String getKey_nama(Context context) {
        return getSharedPreference(context).getString(key_nama, "");
    }

    public static int getUmur(Context context) {
        return getSharedPreference(context).getInt(umur_nya, 0);
    }

    public static void setUmur_nya(Context context, int value) {
        SharedPreferences.Editor editor = getSharedPreference(context).edit();
        editor.putInt(umur_nya, value);
        editor.apply();
    }

    //


}
