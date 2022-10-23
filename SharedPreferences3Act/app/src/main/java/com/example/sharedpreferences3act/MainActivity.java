package com.example.sharedpreferences3act;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText et1;
    String e1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=(EditText) findViewById(R.id.et1);
    }

    public void onPass(View view)
    {
        e1=et1.getText().toString();
        SharedPreferences sp=getSharedPreferences("SD", Context.MODE_PRIVATE);
        SharedPreferences.Editor ed=sp.edit();
        ed.putString("val",e1);
        ed.commit();
        Intent i=new Intent(this,SecondActivity.class);
        startActivity(i);
    }
}