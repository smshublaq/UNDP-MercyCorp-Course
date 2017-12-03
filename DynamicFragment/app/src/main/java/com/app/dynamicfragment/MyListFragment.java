package com.app.dynamicfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by iSaleem on 12/3/17.
 */

public class MyListFragment extends ListFragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity()
                ,android.R.layout.simple_list_item_1);
        adapter.add("A");
        adapter.add("B");
        adapter.add("C");
        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        String item = (String)getListAdapter().getItem(position);
        Fragment fragment = new MyDetailsListFragment();
        Bundle bundle = new Bundle();
        bundle.putString(AppConstants.DETAILS_KEY,item);
        fragment.setArguments(bundle);
        FragmentUtils.replaceFragment(getActivity(),R.id.container,fragment,true);
        Toast.makeText(getActivity(), item, Toast.LENGTH_SHORT).show();
    }
}
