package com.example.taeconsultant.weekly_assignment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class accountActivity extends AppCompatActivity {
  Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
    }
    public void onClick(View view){
        intent=new Intent(this,DataActivity.class);
        startActivity(intent);
        finish();
    }
    public void backClick(View view){
        intent=new Intent(this,AssignmentActivity.class);
        startActivity(intent);
        finish();
    }
}
