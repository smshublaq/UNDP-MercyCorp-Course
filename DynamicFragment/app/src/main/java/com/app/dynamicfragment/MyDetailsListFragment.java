package com.app.dynamicfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by iSaleem on 12/3/17.
 */

public class MyDetailsListFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

       Bundle bundle = getArguments();

       View v=  inflater.inflate(R.layout.fragment_details,container,false);
       TextView tvDetails = v.findViewById(R.id.tvDetails);

       if(bundle !=null){
           if(bundle.containsKey(AppConstants.DETAILS_KEY)){
               tvDetails.setText(bundle.getString(AppConstants.DETAILS_KEY));
           }
       }
        return v;
    }
}
