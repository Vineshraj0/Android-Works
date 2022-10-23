package com.example.p23sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    EditText et1,et2;
    String e1,e2,e11,e22;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        SharedPreferences sp=getSharedPreferences("SD",Context.MODE_PRIVATE);
        et1=(EditText) findViewById(R.id.et1);
        et2=(EditText) findViewById(R.id.et2);
        e1=sp.getString("un","").toString();
        e2=sp.getString("up","").toString();
        et1.setText(e1);
        et2.setText(e2);

    }
    public void onClose(View v){
        finish();
    }

}