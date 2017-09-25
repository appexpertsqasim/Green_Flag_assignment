package com.example.taeconsultant.weekly_assignment;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AssignmentActivity extends AppCompatActivity {
Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignment);
        Typeface face= Typeface.createFromAsset(getAssets(),"fonts/museoSans_300.ttf");
        TextView tv=(TextView)findViewById(R.id.message);
        TextView tv2=(TextView)findViewById(R.id.message2);
        TextView tv3=(TextView)findViewById(R.id.message3);
        TextView tv4=(TextView)findViewById(R.id.message4);
        TextView tv5=(TextView)findViewById(R.id.message5);
        tv.setTypeface(face);
        tv2.setTypeface(face);
        tv3.setTypeface(face);
        tv4.setTypeface(face);
        tv5.setTypeface(face);
    }

    public void onClick(View view){
        intent=new Intent(this,accountActivity.class);
        startActivity(intent);
        finish();
    }
}
