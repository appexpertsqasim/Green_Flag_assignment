package com.example.taeconsultant.weekly_assignment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

import LocalDB.CustomerModel;
import LocalDB.RealmController.RealmController;
import io.realm.Realm;

public class customerList extends AppCompatActivity   {
   Realm realm;
    RealmController realmController;
    ArrayList<CustomerModel> customerModels;
    RecyclerView recyclerView;
    RealmController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_list);
        realm=Realm.getDefaultInstance();
        realmController=new RealmController(realm);

        customerModels = realmController.getCustomerList();

        for(int i=0; i<customerModels.size();i++)
        {
            Log.i("CustomerList",customerModels.get(i).getName());
        }
        initialzerecyclerView();

    }
    public void initialzerecyclerView(){
        recyclerView=(RecyclerView)findViewById(R.id.recyclerCustomer);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(new CustomerAdopter(customerModels,R.layout.row,getApplicationContext()));
    }


    private void getAllFromDB(){
        Realm.init(this);
        realm=Realm.getDefaultInstance();
        controller=new RealmController(realm);

        ArrayList<CustomerModel> customerList = controller.getCustomerList();

        for(CustomerModel cm: customerList) {
            String custName = cm.getName();
            String custAge = cm.getAge();
            Log.i("DataActivity", "+++++++++ " + custName+ " +++++++++++");
            Log.i("DataActivity", "+++++++++ " + custAge+ " +++++++++++");
        }

    }
}
