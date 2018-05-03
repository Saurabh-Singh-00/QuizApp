package com.example.srbhs.quizapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ViewScore extends AppCompatActivity {

    @Override
    public void onBackPressed() {
        Intent backToMain = new Intent(ViewScore.this, MainActivity.class);
        startActivity(backToMain);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_score);

        Bundle getScore = getIntent().getExtras();
        int score = getScore.getInt("score");

        Typeface greetingFont = Typeface.createFromAsset(getAssets(), "fonts/century.ttf");

        TextView greetingTextView = findViewById(R.id.greeting_text_view);
        greetingTextView.setTypeface(greetingFont);
        TextView scoreTextView = findViewById(R.id.score_text_view);
        scoreTextView.setTypeface(greetingFont);

        scoreTextView.setText(score + "/10");


    }
}
