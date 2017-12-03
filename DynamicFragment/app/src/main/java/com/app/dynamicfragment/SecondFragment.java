package com.app.dynamicfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Created by iSaleem on 11/30/17.
 */

public class SecondFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        if(bundle !=null){
            if(bundle.containsKey("name")){
                Toast.makeText(getActivity(),bundle.getString("name"), Toast.LENGTH_SHORT).show();
            }
        }
        return inflater.inflate(R.layout.fragment_second,container,false);
    }
}
