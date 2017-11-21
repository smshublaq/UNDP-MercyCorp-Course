package com.app.recyclerviewexample;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by iSaleem on 11/21/17.
 */

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyHolder>{

    interface IClickListener{
        void onItemClick(int position,Employee employee);
    }

    IClickListener iClickListener;
    private final List<Employee> employeeList;
    private final Context context;
    LayoutInflater inflater;

    MyRecyclerAdapter(Context context, List<Employee> employeeList){
        this.context = context;
        this.employeeList = employeeList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.recycler_item,parent,false);
        MyHolder holder = new MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, final int position) {
        holder.tvName.setText(employeeList.get(position).getName());
        holder.tvId.setText(employeeList.get(position).getId());
        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(iClickListener !=null){
                    iClickListener.onItemClick(position,employeeList.get(position));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return employeeList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder{
        TextView tvName;
        TextView tvId;
        ViewGroup container;
        public MyHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvId = itemView.findViewById(R.id.tvId);
            container = itemView.findViewById(R.id.container);

        }

    }

    public void setiClickListener(IClickListener iClickListener) {
        this.iClickListener = iClickListener;
    }

    public void addEmployee(Employee employee){
        employeeList.add(employee);
        notifyDataSetChanged();
    }

    public void addEmployee(List<Employee> employee){
        employeeList.addAll(employee);
        notifyDataSetChanged();
    }
}
