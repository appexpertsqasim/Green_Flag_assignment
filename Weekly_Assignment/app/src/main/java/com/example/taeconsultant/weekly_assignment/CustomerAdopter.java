package com.example.taeconsultant.weekly_assignment;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import LocalDB.CustomerModel;

/**
 * Created by TAE Consultant on 23/09/2017.
 */

class CustomerAdopter extends RecyclerView.Adapter<CustomerAdopter.MyViewHolder> {
    /**
     *
     */
    ArrayList<CustomerModel> customerModels;
    int row;
    Context applicationContext;
    public CustomerAdopter(ArrayList<CustomerModel> customerModels, int row, Context applicationContext) {
        this.customerModels=customerModels;
        this.row=row;
        this.applicationContext=applicationContext;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=  LayoutInflater.from(parent.getContext()).inflate(row,null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tvName.setText(customerModels.get(position).getName());
        holder.age.setText(customerModels.get(position).getAge());

    }

    @Override
    public int getItemCount() {
        return customerModels.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView age;
        public MyViewHolder(View itemView) {
            super(itemView);
            tvName=(TextView)itemView.findViewById(R.id.textView);
            age=(TextView)itemView.findViewById(R.id.textView2);
        }
    }
}
