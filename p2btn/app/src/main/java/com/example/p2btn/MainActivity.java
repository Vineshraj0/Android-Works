package com.example.p2btn;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText et1;
    Button b1,b2,b3,b4,b5,b6;
    String e1;
    int n1,n2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=(EditText) findViewById(R.id.et1);

    }

    public void oneBtn(View v)
    {

        e1=et1.getText().toString();
        et1.setText(e1+"1");

    }

    public void twoBtn(View v)
    {
        e1=et1.getText().toString();
        et1.setText(e1+"2");
    }
    public void threeBtn(View v)
    {
        e1=et1.getText().toString();
        et1.setText(e1+"3");
    }
    public void fourBtn(View v)
    {
        e1=et1.getText().toString();
        et1.setText(e1+"4");
    }
    public void fiveBtn(View v)
    {
        e1=et1.getText().toString();
        et1.setText(e1+"5");
    }
    public void sixBtn(View v)
    {
        e1=et1.getText().toString();
        et1.setText(e1+"6");
    }

    public void onAdd(View v)
    {
        n1=Integer.parseInt(et1.getText().toString());
        et1.setText("");
    }

    public void onEquels(View v)
    {
        n2=Integer.parseInt(et1.getText().toString());
        int res;
        res=n1+n2;
        et1.setText(res+"");
    }

}