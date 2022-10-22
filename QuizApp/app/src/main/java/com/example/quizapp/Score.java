package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
//import static com.example.quizapp.quiz.*;


public class Score extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    public static final String myPreference="myScore";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        TextView Score=(TextView)findViewById(R.id.Scoring);
        Intent intent = getIntent();
        int SCORES = intent.getIntExtra("score",0);
        Score.setText(String.format("YOUR SCORE IS: %s", SCORES));
    }
}
