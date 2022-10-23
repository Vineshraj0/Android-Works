package com.example.loginregister;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText username,pwd,repwd;
    Button signup,signin;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username=(EditText) findViewById(R.id.user);
        pwd=(EditText) findViewById(R.id.pwd);
        repwd=(EditText) findViewById(R.id.repwd);
        signin=(Button)findViewById(R.id.signinBtn);
        signup=(Button)findViewById(R.id.signupBtn);
        DB=new DBHelper(this);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user=username.getText().toString();
                String pass=pwd.getText().toString();
                String repass=repwd.getText().toString();

                if(user.equals("")||pass.equals("")||repass.equals(""))
                Toast.makeText(MainActivity.this,"Please enter all the fields",Toast.LENGTH_LONG).show();
                else
                {
                    if(pass.equals(repass))
                    {
                        Boolean checkuser=DB.checkUserName(user);
                        if(checkuser==false)
                        {
                            Boolean insert=DB.insertData(user,pass);
                            if(insert==true)
                            {
                                Toast.makeText(MainActivity.this,"Registered successfully",Toast.LENGTH_LONG).show();
                                Intent intent=new Intent(getApplicationContext(),HomeActivity.class);
                                startActivity(intent);
                            }
                            else
                            {
                                Toast.makeText(MainActivity.this,"Registered failed",Toast.LENGTH_LONG).show();
                            }
                        }
                        else
                        {
                            Toast.makeText(MainActivity.this,"User already exits please sign-in",Toast.LENGTH_LONG).show();
                        }
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this,"Passwords not matching",Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}