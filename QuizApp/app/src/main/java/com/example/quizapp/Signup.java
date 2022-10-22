package com.example.quizapp;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Signup extends AppCompatActivity {
    EditText firstName, lastName, Email, Password, ConfirmPassword;
    Database DB;

    //    String[] items= new String[]{"Male","Female"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        DB = new Database(this);
//        Spinner dropdown = findViewById(R.id.spinner1);
        //create an adapter to describe how the items are displayed, adapters are used in several places in android.
//There are multiple variations of this, but this is the basic variant.
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
//set the spinners adapter to the previously created one.
//        dropdown.setAdapter(adapter);
    }

    public void Start(View view){
        firstName=findViewById(R.id.et_First);
        lastName=findViewById(R.id.et_Last);
        Email=findViewById(R.id.et_EmailText);
        Password=findViewById(R.id.et_Pass);
        ConfirmPassword=findViewById(R.id.et_ConfirmPassText);
                String Fname,Lname,email,Passw,CPassw;
                Fname=firstName.getText().toString();
                Lname=lastName.getText().toString();
                email=Email.getText().toString();
                Passw=Password.getText().toString();
                CPassw=ConfirmPassword.getText().toString();

                if(Fname.equals("")) {
                    Toast.makeText(Signup.this,"First Name Not Entered",Toast.LENGTH_SHORT).show();
                }

                else if(Lname.equals("")){
                    Toast.makeText(Signup.this, "Last Name Not Entered", Toast.LENGTH_SHORT).show();
                }
                else if(email.equals("")){
                    Toast.makeText(Signup.this,"Email Not Entered",Toast.LENGTH_SHORT).show();
                }
                else if(Passw.equals("")){
                    Toast.makeText(Signup.this,"Password Not Entered",Toast.LENGTH_SHORT).show();
                }

                else if(CPassw.equals("")){
                    Toast.makeText(Signup.this,"Password Wasn't Confirmed",Toast.LENGTH_SHORT).show();

                }

                else if (!Passw.equals(CPassw)){
                    Toast.makeText(Signup.this, "Password do not match", Toast.LENGTH_SHORT).show();
                }

                else{
                    DB.insertuserdata(Fname, Lname, email, Passw);
                    Intent intent= new Intent(Signup.this,Login.class);
                    startActivity(intent);
                }

            }


}
