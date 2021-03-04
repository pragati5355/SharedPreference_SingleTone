package com.example.sharedpreference_singletone;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.Preference;
import android.preference.PreferenceManager;

public class SharedPreference {

    private static final String SHARED_NAME = "Pragati";
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor ;
    private static Preference mInstancePreference;


    private static final String FirstName = "First Name";
    private static final String EmailName = "Email Id";
    private static final String Password = "password";
    private static final String isLogin = "isLogin";


    public SharedPreference(Context context){

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        editor = sharedPreferences.edit();
        editor.putInt(SHARED_NAME,0);
        editor.apply();

    }
    public static Preference getmInstancePreference(Context context){

        if(mInstancePreference==null){
            mInstancePreference = new Preference(context);
        }
        return mInstancePreference;
    }

    public void setFirstName(String fName){
        editor.putString(FirstName,fName).commit();
    }

    public String getFirstName(){
        return sharedPreferences.getString(FirstName,"");
    }


    public void setEmailName(String EName){
        editor.putString(EmailName,EName).commit();
    }
    public String getEmailName(){
        return sharedPreferences.getString(EmailName,"");
    }

    public void setPassword(String PName){
        editor.putString(Password,PName).commit();
    }

    public String getPassword(){
        return sharedPreferences.getString(Password,"");
    }


    public void setIsLogin(boolean login){
        editor.putBoolean(isLogin,login).commit();
    }
    public boolean getIsLogin(){
        return sharedPreferences.getBoolean(isLogin,false);
    }


}
