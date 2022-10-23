package com.example.p23sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText et1,et2;
    String e1,e2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=(EditText) findViewById(R.id.et1);
        et2=(EditText) findViewById(R.id.et2);
    }

    public void onNext(View v)
    {
        e1=et1.getText().toString();
        e2=et2.getText().toString();
        SharedPreferences sp=getSharedPreferences("SD",Context.MODE_PRIVATE);
        SharedPreferences.Editor ed=sp.edit();
        ed.putString("un",e1);
        ed.putString("up",e2);

        ed.commit();
        Intent i=new Intent(this,SecondActivity.class);
        startActivity(i);
    }
}