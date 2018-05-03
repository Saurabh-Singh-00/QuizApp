package com.example.srbhs.quizapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class RadioQuestion extends AppCompatActivity {

    private QuestionBank questionBank = new QuestionBank();

    private int numberOfQuestion = questionBank.question.length + 1;
    private String answer = "";
    public int score = 0;
    public int countQuestion = 0;
    public String selectedOption = "";

    RadioButton optionOne, optionTwo, optionThree;
    RadioGroup optionRadioGroup;
    Button nextButton;
    TextView scoreTextView, questionTextView;
    ImageView planetImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_question);

        Bundle getExtraFromStart = getIntent().getExtras();
        score = getExtraFromStart.getInt("score");
        countQuestion = getExtraFromStart.getInt("countQuestion");

        Typeface questionFont = Typeface.createFromAsset(getAssets(), "fonts/century.ttf");

        questionTextView = findViewById(R.id.question);
        scoreTextView = findViewById(R.id.score);

        optionOne = findViewById(R.id.option_one);
        optionTwo = findViewById(R.id.option_two);
        optionThree = findViewById(R.id.option_three);
        nextButton = findViewById(R.id.next);

        planetImage = findViewById(R.id.planet_image);


        // Set Century font for each element of Question Layout
        questionTextView.setTypeface(questionFont);
        scoreTextView.setTypeface(questionFont);
        optionOne.setTypeface(questionFont);
        optionTwo.setTypeface(questionFont);
        optionThree.setTypeface(questionFont);

        updateQuestion(countQuestion);

        addListenerRadioButton();

    }

    private void addListenerRadioButton(){
        optionRadioGroup = findViewById(R.id.option_radio_group);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int selectedButton = optionRadioGroup.getCheckedRadioButtonId();

                if(selectedButton == -1){
                    updateQuestion(countQuestion);
                    optionRadioGroup.clearCheck();
                }
                else {
                    RadioButton selectedRadioButton = findViewById(selectedButton);
                    selectedOption = selectedRadioButton.getText().toString();
                    if (countQuestion < numberOfQuestion) {
                        checkAnswer();
                        scoreTextView.setText("" + score);
                        updateQuestion(countQuestion);
                        optionRadioGroup.clearCheck();
                    }
                }
            }

        });
    }

    public void updateQuestion(int questionNumber){

        Log.v("RadioQuestion", String.valueOf(questionNumber));

        if (questionNumber == 5) {
            Intent startCheckBoxQuestion = new Intent(this, CheckBoxQuestion.class);
            startCheckBoxQuestion.putExtra("countQuestion", countQuestion);
            startCheckBoxQuestion.putExtra("score", score);
            startActivity(startCheckBoxQuestion);
        } else if(questionNumber == numberOfQuestion - 1){
            Intent startViewScore = new Intent(this, ViewScore.class);
            startViewScore.putExtra("score", score);
            startActivity(startViewScore);
            finish();
        } else {
            questionTextView.setText(questionBank.getQuestion(questionNumber));
            scoreTextView.setText("" + score);
            nextButton.setText("Submit");

            optionOne.setText(questionBank.getOptionOne(questionNumber));
            optionTwo.setText(questionBank.getOptionTwo(questionNumber));
            optionThree.setText(questionBank.getOptionThree(questionNumber));

            planetImage.setImageResource(questionBank.getImage(questionNumber));

            answer = questionBank.getAnswer(questionNumber);

            selectedOption = "";

            countQuestion++;
        }

    }

    @Override
    public void onBackPressed() {
        Intent backToMain = new Intent(RadioQuestion.this, MainActivity.class);
        startActivity(backToMain);
        finish();
    }

    public void checkAnswer(){
        Toast opt;
        if (selectedOption.equals(answer)) {
            score++;
        }
        opt = Toast.makeText(this, "Option Selected: " + selectedOption, Toast.LENGTH_SHORT);
        opt.show();
    }
}
