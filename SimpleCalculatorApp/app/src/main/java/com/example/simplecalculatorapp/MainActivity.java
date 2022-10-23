package com.example.simplecalculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText et1,et2,et3;
    Button b1,b2,b3,b4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=(EditText) findViewById(R.id.et1);
        et2=(EditText) findViewById(R.id.et2);
        et3=(EditText) findViewById(R.id.et3);




    }

    public void onAdd(View v)
    {
        int res;
        int a, b;
        a=Integer.parseInt(et1.getText().toString());
        b=Integer.parseInt(et2.getText().toString());

        res=a+b;

        et3.setText(""+res);

    }

    public void onSub(View v)
    {
        int res;
        int a, b;
        a=Integer.parseInt(et1.getText().toString());
        b=Integer.parseInt(et2.getText().toString());

        res=a-b;

        et3.setText(""+res);

    }

    public void onMul(View v)
    {
        int res;
        int a, b;
        a=Integer.parseInt(et1.getText().toString());
        b=Integer.parseInt(et2.getText().toString());

        res=a*b;

        et3.setText(""+res);

    }

    public void onDiv(View v)
    {
        int res;
        int a, b;
        a=Integer.parseInt(et1.getText().toString());
        b=Integer.parseInt(et2.getText().toString());

        res=a/b;

        et3.setText(""+res);

    }
}