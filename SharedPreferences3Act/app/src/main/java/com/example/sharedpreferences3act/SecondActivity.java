package com.example.sharedpreferences3act;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    String n1;
    EditText et1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activty);
        et1=(EditText) findViewById(R.id.et1);
        SharedPreferences sp=getSharedPreferences("SD", Context.MODE_PRIVATE);
        n1=sp.getString("val","").toString();
        et1.setText(n1);
        SharedPreferences.Editor ed=sp.edit();
        ed.putString("v1",n1);
        ed.commit();
    }
    public void onNext(View view)
    {

        Intent i=new Intent(this,ThirdActivity.class);
        startActivity(i);
    }
}