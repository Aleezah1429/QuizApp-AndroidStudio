package com.example.quizapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.database.Cursor;
import android.widget.Toast;


public class Login extends AppCompatActivity {
    private Button login;
EditText first, last, Pass;
Database DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        DB = new Database(this);
        first=findViewById(R.id.et_First);
        last=findViewById(R.id.et_Last);
        Pass=findViewById(R.id.et_Pass);
        login = (Button) findViewById(R.id.loginSubmit);
        login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String Fn=first.getText().toString();
                String Ln=last.getText().toString();
                String Ps=Pass.getText().toString();
                Cursor res = DB.getdata();
                res.moveToFirst();
                if(!(Fn.equals("") || Ln.equals("") || Ps.equals(""))) {
                    while (res.moveToNext()) {
                        if (
                                Fn.equals(res.getString(0))) {

                            if (Ln.equals(res.getString(1))) {

                                if (Ps.equals(res.getString(3))) {

                                    Toast.makeText(Login.this, "Successfully Login", Toast.LENGTH_LONG).show();
                                    Intent intent = new Intent(Login.this,quiz.class);
                                    startActivity(intent);
                                }
                            }
                            break;
                        } else {
                            Toast.makeText(Login.this, "First Signup", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(Login.this,Signup.class);
                            startActivity(intent);

                        }
                    }
                }
                else {
                    Toast.makeText(Login.this, "Fill all the fields", Toast.LENGTH_LONG).show();

                }

            }
        });
    }


    }
