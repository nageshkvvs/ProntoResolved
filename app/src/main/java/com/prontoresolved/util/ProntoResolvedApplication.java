package com.prontoresolved.util;

import android.app.Application;
import android.content.Context;

/**
 * Created by nageshk on 11/9/2017.
 */
public class ProntoResolvedApplication extends Application {

    private static Context mContext;

    @Override
    public void onCreate() {
        mContext = getApplicationContext();
        super.onCreate();
    }

    public static Context getContext() {
        return mContext;
    }


}
