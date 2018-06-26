package com.adithyavijayakumar.popularmovies.Network;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.LruCache;

import com.adithyavijayakumar.popularmovies.MyApplicationContext;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

/**
 * Created by Adithya Vijayakumar on 6/25/2018.
 */

public class VolleySingleton {
    private static VolleySingleton sInstance = null ;
    private RequestQueue mRequestQueue;
    private ImageLoader mImageLoader;
    private VolleySingleton(){
        mRequestQueue = Volley.newRequestQueue(MyApplicationContext.getAppContext());
        mImageLoader = new ImageLoader(mRequestQueue, new ImageLoader.ImageCache(){
            private LruCache<String, Bitmap> cache = new LruCache<>((int)(Runtime.getRuntime().maxMemory()/1024)/8);

            @Override
            public Bitmap getBitmap(String url) {
                return cache.get(url);
            }

            @Override
            public void putBitmap(String url, Bitmap bitmap) {
            cache.put(url, bitmap);
            }
        });

    }
    public static VolleySingleton getsInstance(){
        if(sInstance == null)
        {
            sInstance = new VolleySingleton();
        }
        return sInstance;
    }
    public RequestQueue getRequestQueue(){
        return mRequestQueue;
    }
    public ImageLoader getImageLoader (){
        return mImageLoader;
    }
}
