package com.app.exapandablelistviewexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.SimpleExpandableListAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

/**
 * Created by iSaleem on 11/23/17.
 */

public class MyExpandableListViewAdapter extends BaseExpandableListAdapter {


    private final List<Student> students;
    private final Context context;
    private LayoutInflater inflater;

    public MyExpandableListViewAdapter(Context context, List<Student> students){
        this.students = students;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }


    @Override
    public int getGroupCount() {
        return students.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return students.get(groupPosition).getCourses().size();
    }

    @Override
    public Student getGroup(int position) {
        return students.get(position);
    }

    @Override
    public String getChild(int groupPosition, int childPosition) {
        return students.get(groupPosition).getCourses().get(childPosition);
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View view, ViewGroup viewGroup) {
        View v = inflater.inflate(R.layout.group_layout,viewGroup,false);
        TextView tvGroupTitle = v.findViewById(R.id.tvGroupTitle);
        tvGroupTitle.setText(students.get(groupPosition).getName());
        return v;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isExpanded, View view, ViewGroup viewGroup) {
        View v = inflater.inflate(R.layout.child_layout,viewGroup,false);
        TextView tvChild = v.findViewById(R.id.tvChild);
        tvChild.setText(students.get(groupPosition).getCourses().get(childPosition));
        return v;
    }

    @Override
    public boolean isChildSelectable(int childPosition, int groupPosition) {
        return true;
    }

    @Override
    public long getGroupId(int id) {
        return 0;
    }

    @Override
    public long getChildId(int groupId, int childId) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }
}
