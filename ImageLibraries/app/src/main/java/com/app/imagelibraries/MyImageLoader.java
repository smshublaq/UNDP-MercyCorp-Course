package com.app.imagelibraries;

import android.graphics.Bitmap;
import android.util.LruCache;

import com.android.volley.toolbox.ImageLoader;

/**
 * Created by iSaleem on 12/10/17.
 */

public class MyImageLoader implements ImageLoader.ImageCache {
    LruCache<String,Bitmap> lruCache = new LruCache<>(10);

    @Override
    public Bitmap getBitmap(String url) {
        return lruCache.get(url);
    }

    @Override
    public void putBitmap(String url, Bitmap bitmap) {
        lruCache.put(url,bitmap);
    }
}
