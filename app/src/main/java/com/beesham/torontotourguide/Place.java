package com.beesham.torontotourguide;

import android.content.Context;

/**
 * Created by Beesham on 9/12/2016.
 */
public class Place {
    private String mTitle;
    private int mImageResourceId;
    private String mGeoLocation;

    private Context mContext;

    public Place(Context context, String title, String location, int imageResourceId) {
        mContext = context;
        mTitle = title;
        mGeoLocation = location;
        mImageResourceId = imageResourceId;
    }

    public String getmTitle() {
        return mTitle;
    }

    public int getmImageResourceId() {
        return mImageResourceId;
    }

    public String getmGeoLocation() {
        return mGeoLocation;
    }

}
