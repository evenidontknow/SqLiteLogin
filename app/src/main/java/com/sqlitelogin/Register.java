package com.sqlitelogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    EditText mTextUsername,mTextPassword,mCnfPassword;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        db = new DatabaseHelper(this);
        mTextUsername  = (EditText)findViewById(R.id.idusername);
        mTextPassword = (EditText)findViewById(R.id.idpassword);
        mCnfPassword  = (EditText)findViewById(R.id.idcnfpassword);

    }
    public void Register(View view)
    {
        String user = mTextUsername.getText().toString().trim();
        String pwd = mTextPassword.getText().toString().trim();
        String cnfpwd = mCnfPassword.getText().toString().trim();
        if(pwd.equals(cnfpwd))
        {
           long val =  db.addUser(user,pwd);
           if(val > 0)
           {
               Toast.makeText(Register.this,"match",Toast.LENGTH_LONG).show();
               Intent movelogin = new Intent(Register.this,MainActivity.class);
               startActivity(movelogin);

           }
           else
           {
               Toast.makeText(Register.this,"Registration error",Toast.LENGTH_LONG).show();


           }


        }
        else
            Toast.makeText(Register.this,"not match",Toast.LENGTH_LONG).show();

    }
    public void loginback(View view)
    {
        Intent intent  = new Intent(Register.this,MainActivity.class);
        startActivity(intent);

    }
}

