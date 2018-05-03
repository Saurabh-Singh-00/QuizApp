package com.example.srbhs.quizapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    public int score = 0;
    public int countQuestion = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView appTitle = findViewById(R.id.app_title);
        TextView splashSubTitle = findViewById(R.id.splash_sub_title);

        Typeface appTitleFont = Typeface.createFromAsset(getAssets(), "fonts/elianto.ttf");
        appTitle.setTypeface(appTitleFont);
        splashSubTitle.setTypeface(appTitleFont);
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    public void startQuiz(View view){
        Intent startRadioQuestion = new Intent(this, RadioQuestion.class);
        startRadioQuestion.putExtra("score", score);
        startRadioQuestion.putExtra("countQuestion", countQuestion);
        startActivity(startRadioQuestion);
    }

}
