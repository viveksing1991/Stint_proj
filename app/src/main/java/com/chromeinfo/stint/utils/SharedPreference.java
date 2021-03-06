package com.chromeinfo.stint.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.Preference;

import com.google.gson.Gson;

/**
 * Created by root on 8/5/17.
 */
/*Class used for sharef preferences*/
public class SharedPreference {


    public static final String PREFS_NAME = "Loginpref";
    public static final String PREFS_KEY = "LoginPrefKey";

    public SharedPreference() {
        super();
    }

    public void save(Context context, String text, String prefName, String prefKeys) {
        SharedPreferences settings;
        SharedPreferences.Editor editor;
        settings = context.getSharedPreferences(prefName, Context.MODE_PRIVATE); //1
        editor = settings.edit(); //2

        editor.putString(prefKeys, text); //3

        editor.commit(); //4
    }

    public String getValue(Context context, String prefName, String prefKeys) {
        SharedPreferences settings;
        String text;
        settings = context.getSharedPreferences(prefName, Context.MODE_PRIVATE);
        text = settings.getString(prefKeys, null);
        return text;
    }

    public void clearSharedPreference(Context context, String prefName) {
        SharedPreferences settings;
        SharedPreferences.Editor editor;

        settings = context.getSharedPreferences(prefName, Context.MODE_PRIVATE);
        editor = settings.edit();

        editor.clear();
        editor.commit();
    }

    public void removeValue(Context context, String prefName, String prefKeys) {
        SharedPreferences settings;
        SharedPreferences.Editor editor;

        settings = context.getSharedPreferences(prefName, Context.MODE_PRIVATE);
        editor = settings.edit();

        editor.remove(prefKeys);
        editor.commit();
    }

    public void saveObject(Context context, Object obj, String prefName, String prefKeys) {
        SharedPreferences settings;

        settings = context.getSharedPreferences(prefName, Context.MODE_PRIVATE);

        SharedPreferences.Editor prefsEditor = settings.edit();
        Gson gson = new Gson();
        String json = gson.toJson(obj);
        prefsEditor.putString("MyObject", json);
        prefsEditor.commit();
    }

    public SharedPreferences retrieveObj(Context context, String prefName, String prefKeys) {
        SharedPreferences settings;
        settings = context.getSharedPreferences(prefName, Context.MODE_PRIVATE);

        return settings;
    }
}


