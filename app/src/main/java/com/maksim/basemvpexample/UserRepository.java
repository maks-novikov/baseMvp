package com.maksim.basemvpexample;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Maksim Novikov on 08-Feb-18.
 */

public class UserRepository {

    public static final String USER_TABLE ="user";
    public static final String NAME_KEY = "name";
    public static final String AGE_KEY = "age";

    private SharedPreferences mPrefs;

    private UserRepository(Context context){
        mPrefs = context.getSharedPreferences(USER_TABLE,Context.MODE_PRIVATE);
    }

    private static UserRepository instance;
    public static UserRepository getInstance(Context context){
        if(instance == null){
            instance = new UserRepository(context);
        }
        return instance;
    }

    public void setName(String name){
        mPrefs.edit().putString(NAME_KEY,name).apply();
    }

    public void setAge(String age){
        mPrefs.edit().putString(AGE_KEY,age).apply();
    }

    public String getName(){
        return  mPrefs.getString(NAME_KEY,null);
    }

    public String getAge(){
        return  mPrefs.getString(AGE_KEY,null);
    }




}
