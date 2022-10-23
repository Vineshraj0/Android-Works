package com.example.sharedpreferences3act;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity {
    EditText et1;
    String s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_activty);
        et1=(EditText) findViewById(R.id.et1);
        SharedPreferences sp=getSharedPreferences("SD", Context.MODE_PRIVATE);
        s=sp.getString("v1","").toString();
        et1.setText(s);
    }

    public void onHome(View view){
        Intent i=new Intent(this,MainActivity.class);
        startActivity(i);
    }

}