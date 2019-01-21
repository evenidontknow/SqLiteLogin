package com.sqlitelogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText mTextUsername,mTextPassword;
    DatabaseHelper db;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DatabaseHelper(this);
        mTextUsername = (EditText)findViewById(R.id.idmusername);
        mTextPassword= (EditText)findViewById(R.id.idmpassword);

    }

    public void Login(View view) {
        String user = mTextUsername.getText().toString().trim();
        String pwd = mTextPassword.getText().toString().trim();
        Boolean res = db.checkUser(user,pwd);
        if(res== true)
        {
            Toast.makeText(MainActivity.this,"login sucess",Toast.LENGTH_LONG).show();
        }
        else
            Toast.makeText(MainActivity.this,"error",Toast.LENGTH_LONG).show();

    }

    public void register(View view) {
        Intent intent = new Intent(MainActivity.this,Register.class);
        startActivity(intent);

    }
}
