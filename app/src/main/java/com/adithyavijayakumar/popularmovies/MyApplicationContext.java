package com.adithyavijayakumar.popularmovies;

import android.app.Application;
import android.content.Context;

/**
 * Created by Adithya Vijayakumar on 6/25/2018.
 */

public class MyApplicationContext extends Application {
    private static MyApplicationContext sInstance;
    @Override
    public void onCreate(){
        super.onCreate();
        sInstance = this;
    }
    public static MyApplicationContext getInstance(){
    return sInstance;
    }
    public static Context getAppContext (){
        return sInstance.getApplicationContext();
    }

}
