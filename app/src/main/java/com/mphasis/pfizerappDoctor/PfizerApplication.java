package com.mphasis.pfizerappDoctor;

import android.app.Application;
import android.text.TextUtils;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.mphasis.pfizerappDoctor.storage.AppPreferences;

/**
 * Created by Sourav.Bhattacharya on 1/18/2017.
 */

public class PfizerApplication extends Application {

    private static final String TAG = PfizerApplication.class.getSimpleName();
    public static AppPreferences appPreferences;
    private static PfizerApplication appInstance;
    private RequestQueue mRequestQueue;

    @Override
    public void onCreate() {
        super.onCreate();

        appInstance = this;
        appPreferences = new AppPreferences(this);
    }
public static AppPreferences getPreferance(){
    appPreferences = new AppPreferences(appInstance);
    return appPreferences;
}

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(getApplicationContext());
        }

        return mRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req, String tag) {
        req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
        getRequestQueue().add(req);
    }

    public <T> void addToRequestQueue(Request<T> req) {
        req.setTag(TAG);
        getRequestQueue().add(req);
    }

    public void cancelPendingRequests(Object tag) {
        if (mRequestQueue != null) {
            mRequestQueue.cancelAll(tag);
        }

    }



    public static synchronized PfizerApplication getInstance() {
        return appInstance;
    }
}
