package com.example.dbdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText e1, e2, e3;
    CDB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1 = (EditText) findViewById(R.id.e1);
        e2 = (EditText) findViewById(R.id.e2);
        e3 = (EditText) findViewById(R.id.e3);
        db = new CDB(this);

    }
    public void onsave(View v) {
        String dn, d1;

        dn = e2.getText().toString();
        d1 = e3.getText().toString();

        db.addDept(dn, d1);
        Toast.makeText(this, dn + d1, Toast.LENGTH_SHORT).show();
        e2.setText("");
        e3.setText("");
    }

    public void ondelete(View v) {
        String dno = e1.getText().toString();
        db.deleteDept(Integer.parseInt(dno));
        e2.setText("");
        e3.setText("");
    }

    public void onupdate(View v) {
        String dno = e1.getText().toString();
        String dn, d1;
        dn = e2.getText().toString();
        d1 = e3.getText().toString();
        db.update(Integer.parseInt(dno), dn, d1);
        e2.setText("");
        e3.setText("");
    }

    public void onlist(View v) {
        List<CDept> rec = db.getAllvalues();
        String str = "";

        for (CDept cr : rec) {
            String log = "DId: " + cr.id + " ,DNAME: " + cr.dname + ",DLOC: " + cr.dloc;
            log = log + "\n";
            str = str + log;
        }
        TextView t = (TextView) findViewById(R.id.tv);
        t.setText(str);
    }

    public void onselect(View v) {
        String a[];
        try {
            String dno = e1.getText().toString();
            a = db.getOneDepartment(Integer.parseInt(dno));
            if (a[0] != "") {
                e2.setText(a[0]);
                e3.setText(a[1]);
            } else {
                Toast.makeText(this, "NOT FOUND..", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            System.out.println(e);
            Log.d("select123", e.toString());
        }
    }
}

