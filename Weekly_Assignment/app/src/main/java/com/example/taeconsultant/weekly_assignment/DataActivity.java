package com.example.taeconsultant.weekly_assignment;


import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.codetroopers.betterpickers.datepicker.DatePickerBuilder;
import com.codetroopers.betterpickers.datepicker.DatePickerDialogFragment;

import java.util.ArrayList;
import java.util.Calendar;

import LocalDB.CustomerModel;
import LocalDB.RealmController.RealmController;
import io.realm.Realm;

public class DataActivity extends AppCompatActivity implements DatePickerDialogFragment.DatePickerDialogHandler {
    EditText usernameText;
    EditText nameText;
    EditText ageText;

    Realm realm;
    RealmController controller;
    CustomerModel customerModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_data);
//        DatePickerBuilder dpb = new DatePickerBuilder()
//                .setFragmentManager(getSupportFragmentManager())
//                .setStyleResId(R.style.BetterPickersDialogFragment)
//                .setYearOptional(true);
//        dpb.show();
        Spinner sp = (Spinner) findViewById(R.id.spinner);
        String[] locations = {"Not Specified","Austraila", "India", "Maldives"};
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, locations);
        sp.setAdapter(adapter2);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> av, View v,
                                       int position, long itemId) {
                // TODO Auto-generated method stub
                String item = av.getItemAtPosition(position).toString();
            }

            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }


        });
        Button sendButton = (Button) findViewById(R.id.submit);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("DataActivity", "Save to DB" );
                saveToDB();
                Intent intent = new Intent(DataActivity.this,customerList.class);
                startActivity(intent);

            }
        });


        Button datePickerButton= (Button) findViewById(R.id.date_btn);
        datePickerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerBuilder dpb = new DatePickerBuilder()
                        .setFragmentManager(getSupportFragmentManager())
                        .setStyleResId(R.style.BetterPickersDialogFragment);
                dpb.show();
            }
        });



    }



    @Override
    public void onDialogDateSet(int reference, int year, int month, int day) {
        Calendar dob = Calendar.getInstance();
        Calendar today = Calendar.getInstance();

        dob.set(year, month, day);

        int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);

        if (today.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR)) {
            age--;
        }}

    private void saveToDB(){
        Realm.init(this);
        realm=Realm.getDefaultInstance();
        controller=new RealmController(realm);

        usernameText =(EditText)findViewById(R.id.username);
        nameText =(EditText)findViewById(R.id.name_txt);
        ageText =(EditText)findViewById(R.id.age);


        //TODO: logic to check for nulls here

        customerModel =new CustomerModel();
        customerModel.setName(String.valueOf(nameText.getText().toString()));
        customerModel.setAge(String.valueOf(ageText.getText().toString()));

        controller.saveCustomer(customerModel);

        ArrayList<CustomerModel> customerList = controller.getCustomerList();
        CustomerModel cm = customerList.get(0);

        for(CustomerModel cusomterLocalModel: customerList) {
            String custName = cusomterLocalModel.getName();
            String custAge = cusomterLocalModel.getAge();
            Log.i("DataActivity", "+++++++++ " + custName+ " +++++++++++");
            Log.i("DataActivity", "+++++++++ " + custAge+ " +++++++++++");
        }
    }


    public void backClick(View view){

        finish();
    }

    }







