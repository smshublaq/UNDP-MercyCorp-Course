package com.app.viewpagerexample;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by iSaleem on 11/20/17.
 */

public class MyPagerAdapter extends FragmentStatePagerAdapter {

    private  final int YELLOW_FRAGMENT = 0;
    private  final int RED_FRAGMENT = 1;
    private  final int BLUE_FRAGMENT = 2;
    private  final int PAGES_COUNT = 3;
    private final Context context;

    public MyPagerAdapter(FragmentManager fm,Context context) {
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
            case BLUE_FRAGMENT:
                fragment = new BlueFragment();
                break;
            case RED_FRAGMENT :
                fragment = new RedFragment();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return PAGES_COUNT;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String fragment = "";
        switch (position){
            case YELLOW_FRAGMENT:
                fragment = context.getString(R.string.fragment_yellow);
                break;
            case BLUE_FRAGMENT:
                fragment = context.getString(R.string.fragment_blue);
                break;
            case RED_FRAGMENT :
                fragment = context.getString(R.string.fragment_red);
                break;
        }
        return fragment;
    }
}
