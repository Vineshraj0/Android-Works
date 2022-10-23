package com.example.p4intent1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    String n1="5";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void onNext(View v)
    {
        Intent i=new Intent(this,SecondActivity.class);
        i.putExtra("n1",n1);
        startActivity(i);
    }
}