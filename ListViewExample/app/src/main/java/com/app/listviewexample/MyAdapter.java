package com.app.listviewexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by iSaleem on 11/21/17.
 */

public class MyAdapter extends BaseAdapter {

    private final List<Employee> employees;
    private final Context context;
    private LayoutInflater inflater;
    MyAdapter(Context context, List<Employee> employees){
        this.employees = employees;
        this.context = context;
        //this.inflater = LayoutInflater.from(context);
        this.inflater = (LayoutInflater)
                context
                        .getSystemService
                                (Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return employees.size();
    }

    @Override
    public Employee getItem(int position) {
        return employees.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        //Toast.makeText(context, position+"", Toast.LENGTH_SHORT).show();
        if(view == null){
            view = inflater.inflate(R.layout.list_item,viewGroup,
                    false);
            MyHolder holder = new MyHolder();
            holder.imageView = view.findViewById(R.id.img);
            holder.tvTitle = view.findViewById(R.id.tvTitle);
            holder.tvSubTitle = view.findViewById(R.id.tvSubTitle);
            view.setTag(holder);
        }
        MyHolder holder = (MyHolder)view.getTag();
        holder.tvTitle.setText(employees.get(position).getTitle());
        holder.tvSubTitle.setText(employees.get(position).getSubTitle());
        holder.imageView.setImageResource(employees.get(position).getImageResource());
        return view;
    }
    static class MyHolder {
        ImageView imageView;
        TextView tvTitle;
        TextView tvSubTitle;
    }
}
