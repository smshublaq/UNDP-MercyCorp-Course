package com.app.viewpagerexample;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by iSaleem on 12/3/17.
 */

public class MyPagerAdapter extends FragmentStatePagerAdapter {
    final int YELLOW_FRAGMENT = 0;
    final int PURPLE_FRAGMENT = 1;
    final int BLUE_FRAGMENT = 2;
    final int COUNT = 3;
    private final Context context;

    public MyPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position){
            case YELLOW_FRAGMENT:
                fragment = new YellowFragment();
                break;
            case PURPLE_FRAGMENT:
                fragment = new PurpleFragment();
                break;
            case BLUE_FRAGMENT:
                fragment = new BlueFragment();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return COUNT;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String fragment = null;
        switch (position){
            case YELLOW_FRAGMENT:
                fragment = context.getString(R.string.yellow);
                break;
            case PURPLE_FRAGMENT:
                fragment = context.getString(R.string.purple);
                break;
            case BLUE_FRAGMENT:
                fragment = context.getString(R.string.blue);
                break;
        }
        return fragment;
    }
}
