package com.example.p1calc1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    EditText et1,et2,et3;
    //LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //linearLayout=findViewById(R.id.linearLayout);
       // LinearLayout currentLayout =
       //         (LinearLayout) findViewById(R.id.Linearlayout);


      //  currentLayout.setBackgroundColor(Color.RED);

    }

    public void onAdd(View v){
        int res,e1,e2;
        et1=(EditText) findViewById(R.id.et1);

        et2=(EditText) findViewById(R.id.et2);
        et3=(EditText) findViewById(R.id.et3);


        e1=Integer.parseInt(et1.getText().toString());
        e2=Integer.parseInt(et2.getText().toString());
        res=e1+e2;
        et3.setText(""+res);

    }
}