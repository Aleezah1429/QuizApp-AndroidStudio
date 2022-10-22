package com.example.quizapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;


public class quiz extends AppCompatActivity {
    public static int var=0;
    public static int score=0;


    String[] Questions={
            "We live on the planet Earth. According to the scientists, the Earth was formed about ___ years ago",
            "Iran was first to recognize",
            "Pakistan opened its first embassy in",
            "Which country is building “Mars Science City” to develop technology to colonize Mars?",
            "First captain of Pakistan’s cricket team ",
            "Pakistan cricket team first visited",
            "Which city is also called The City of 1,000 Minarets?",
            "The Pico Island is located in",
            "Sultan Ahmed Mosque is popularly knows as"};
    String[][] Options={
            {"4.6 million","5.6 million","4.6 billion","5.6 billion"},
            {"India","Pakistan","Africa","Algeria"},
            {"Iran","Pakistan","India","Africa"},
            {"UAE","Qatar","United State","Pakistan","Iran"},
            {"Imran Khan","Shahid Afridi","Waseem Akram","Abdul Hafeez Kardar"},
            {"South Africa","India","Iran","Algeria"},
            {"Karachi","Historic Cairo","Makkah","Egypt"},
            {"Switzerland","Portugal","Turkey","Egypt"},
            {"Blue Mosque","Red Mosque","Purple Mosque","White"}};
    String[] answer={
            "28",
            "4.6 million",
            "Pakistan",
            "Iran",
            "UAE",
            "Abdul Hafeez Kardar",
            "India",
            "Historic Cairo",
            "Portugal",
            "Blue Mosque"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        TextView Scoring=(TextView) findViewById(R.id.score);
        TextView Que=(TextView) findViewById(R.id.ques);
        RadioButton op1=(RadioButton) findViewById(R.id.option1);
        RadioButton op2=(RadioButton) findViewById(R.id.option2);
        RadioButton op3=(RadioButton) findViewById(R.id.option3);
        RadioButton op4=(RadioButton) findViewById(R.id.option4);
        Button Next=(Button)findViewById(R.id.next);
        Next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(var==9){
                    Intent intent=new Intent(quiz.this,Score.class);
                    intent.putExtra("score",score);
                    startActivity(intent);
                };
                if (op1.isChecked()) {
                    if(answer[var].equals(op1.getText().toString())){
                        score++;
                    }
                } else if (op2.isChecked()) {
                    if(answer[var].equals(op2.getText().toString())){
                        score++;

                    }
                } else if (op3.isChecked()) {
                    if(answer[var].equals(op3.getText().toString())){
                        score++;

                    }
                } else if (op4.isChecked()) {
                    if(answer[var].equals(op4.getText().toString())){
                        score++;
                    }
                }
                Scoring.setText(String.valueOf(score));
                Que.setText(Questions[var]);
                op1.setText(Options[var][0]);
                op2.setText(Options[var][1]);
                op3.setText(Options[var][2]);
                op4.setText(Options[var][3]);
                System.out.println(var);

                var++;
            }
        });
    }


    }


