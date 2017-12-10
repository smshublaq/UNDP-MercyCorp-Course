package com.app.imagelibraries;

import android.app.Application;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

/**
 * Created by iSaleem on 12/7/17.
 */

public class MyApplication extends Application {

    private RequestQueue requestQueue;
    private static MyApplication anInstance;
    @Override
    public void onCreate() {
        super.onCreate();
        anInstance = this;
        requestQueue = Volley.newRequestQueue(this);

    }

    public void addToRequestQueue(Request request){
            getRequestQueue().add(request);

    }

    private RequestQueue getRequestQueue(){
        return  requestQueue;
    }

    public void cancelRequest(String tag){
        getRequestQueue().cancelAll(tag);
    }

    public static synchronized MyApplication getInstance(){
        return anInstance;
    }


    public ImageLoader getImageLoader(){
        return new ImageLoader(getRequestQueue(),new MyImageLoader());
    }
}
