package com.app.dynamicfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by iSaleem on 11/30/17.
 */

public class MyFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_my,container,false);
        Button btn = v.findViewById(R.id.goTo);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
               FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
               Fragment secondFragment = new SecondFragment();
               fragmentTransaction.replace(R.id.container,secondFragment);
               fragmentTransaction.commit();
            }
        });
        return v;
    }
}
