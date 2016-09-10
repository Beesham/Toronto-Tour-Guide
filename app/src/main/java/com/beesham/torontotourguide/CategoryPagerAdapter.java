package com.beesham.torontotourguide;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Beesham on 9/9/2016.
 */
public class CategoryPagerAdapter extends FragmentPagerAdapter {

    Context mContext;

    public CategoryPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new AttractionsFragment();

            case 1:
                return new ShoppingFragment();

            case 2:
                return new RestaurantsFragment();

            case 3:
                return new NightlifeFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return mContext.getString(R.string.attractions);

            case 1:
                return mContext.getString(R.string.shopping);

            case 2:
                return mContext.getString(R.string.restaurants);

            case 3:
                return mContext.getString(R.string.nightlife);
        }

        return super.getPageTitle(position);
    }
}
