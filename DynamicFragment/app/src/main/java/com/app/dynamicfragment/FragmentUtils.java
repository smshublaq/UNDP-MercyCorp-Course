package com.app.dynamicfragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by iSaleem on 12/3/17.
 */

public class FragmentUtils {

    public static void addFragment(FragmentActivity activity,
                                   int container,
                                   Fragment fragment) {
        FragmentManager fragmentManager =
                activity.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction =
                fragmentManager.beginTransaction();
        fragmentTransaction.add(container, fragment);
        fragmentTransaction.commit();
    }

    public static void addFragment(FragmentActivity activity,
                                   int container,
                                   Fragment fragment,
                                   boolean isAddedToBackStack) {
        FragmentManager fragmentManager =
                activity.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction =
                fragmentManager.beginTransaction();
        fragmentTransaction.add(container, fragment);
        if (isAddedToBackStack) {
            fragmentTransaction.addToBackStack(null);
        }
        fragmentTransaction.commit();
    }

    public static void replaceFragment(FragmentActivity activity, int container, Fragment fragment) {
        FragmentManager fragmentManager =
                activity.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction =
                fragmentManager.beginTransaction();
        fragmentTransaction.replace(container, fragment);
        fragmentTransaction.commit();
    }

    public static void replaceFragment(FragmentActivity activity, int container, Fragment fragment, boolean isAddedToBackStack) {
        FragmentManager fragmentManager =
                activity.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction =
                fragmentManager.beginTransaction();
        fragmentTransaction.replace(container, fragment);
        if (isAddedToBackStack) {
            fragmentTransaction.addToBackStack(null);
        }
        fragmentTransaction.commit();
    }

}
