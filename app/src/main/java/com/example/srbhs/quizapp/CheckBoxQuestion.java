package com.example.srbhs.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;

public class CheckBoxQuestion extends AppCompatActivity {

    public int score, countQuestion;
    private QuestionBank questionBank = new QuestionBank();
    TextView questionTextView, scoreTextView;
    Button nextButton;
    public String answer[], c1="-", c2="-",c3="-";
    ImageView planetImage;
    CheckBox optionOne, optionTwo, optionThree;
    public int selectedCheckBoxes = 0, checkBoxCount=0;

    @Override
    public void onBackPressed() {
        Intent backToMain = new Intent(CheckBoxQuestion.this, MainActivity.class);
        startActivity(backToMain);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box_question);

        Bundle getExtraFromRadioQuestion = getIntent().getExtras();
        score = getExtraFromRadioQuestion.getInt("score");
        countQuestion = getExtraFromRadioQuestion.getInt("countQuestion");

        questionTextView = findViewById(R.id.question);
        scoreTextView = findViewById(R.id.score);
        nextButton = findViewById(R.id.next);
        planetImage = findViewById(R.id.planet_image);
        optionOne = findViewById(R.id.option_one);
        optionTwo = findViewById(R.id.option_two);
        optionThree = findViewById(R.id.option_three);

        updateQuestion(checkBoxCount);

        addListenerCheckBox();

    }

    public void updateQuestion(int questionNumber){

        Log.i("CheckBoxQuestion", "Q-NO: " + String.valueOf(countQuestion));

        if (countQuestion == 7) {
            Intent startRadioQuestion = new Intent(this, RadioQuestion.class);
            startRadioQuestion.putExtra("score", score);
            startRadioQuestion.putExtra("countQuestion", countQuestion-1);
            startActivity(startRadioQuestion);
            finish();
        } else {

            questionTextView.setText(questionBank.getCheckBoxQuestion(questionNumber));
            scoreTextView.setText("" + score);
            nextButton.setText("Submit");

            optionOne.setText(questionBank.getCheckBoxOptionOne(questionNumber));
            optionTwo.setText(questionBank.getCheckBoxOptionTwo(questionNumber));
            optionThree.setText(questionBank.getCheckBoxOptionThree(questionNumber));

            planetImage.setImageResource(questionBank.getCheckBoxImage(questionNumber));

            answer = questionBank.getCheckBoxAnswer(questionNumber);
            Log.v("CheckBoxQuestion", answer[0]);
            Log.v("CheckBoxQuestion", answer[1]);
            Log.v("CheckBoxQuestion", answer[2]);

            c1 = "-";
            c2 = "-";
            c3 = "-";

            optionOne.setChecked(false);
            optionTwo.setChecked(false);
            optionThree.setChecked(false);

            countQuestion++;
        }
    }

    public void addListenerCheckBox(){

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (optionOne.isChecked()) {
                    selectedCheckBoxes++;
                    c1 = optionOne.getText().toString();
                }
                if(optionTwo.isChecked()){
                    selectedCheckBoxes++;
                    c2 = optionTwo.getText().toString();
                }
                if(optionThree.isChecked()){
                    selectedCheckBoxes++;
                    c3 = optionThree.getText().toString();
                }
                if(selectedCheckBoxes != 0){
                    checkAnswer();
                } else {
                    checkBoxCount++;
                    updateQuestion(checkBoxCount);
                }
            }
        });
    }

    public  void checkAnswer(){
        if (Arrays.asList(answer).contains(c1) && Arrays.asList(answer).contains(c2) && Arrays.asList(answer).contains(c3)) {
            score++;
            checkBoxCount++;
            updateQuestion(checkBoxCount);
        }
        else {
            checkBoxCount++;
            updateQuestion(checkBoxCount);
        }
    }

}
