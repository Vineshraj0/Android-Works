package com.example.p4intent1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    TextView tv;
    String n1;
    int a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_act);
        tv=(TextView) findViewById(R.id.tv);
        Intent i=getIntent();
        n1=i.getStringExtra("n1");
        a=Integer.parseInt(n1);
        tv.setText(a+"");

    }


}