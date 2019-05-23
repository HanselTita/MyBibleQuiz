package com.softhans.mybiblequiz;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class Level01 extends AppCompatActivity {


    //TODO: Declare numbers variable here.
    Button trueBtn;
    Button falseBtn;
    TextView mQuestionTextView;
    int mIndex; // This is to track the question the user is on.
    int mscore; // This is to tracj the score of the user.
    int mQuestion;
    TextView mScoreTextView;
    ProgressBar progressBar;

    //TODO: Uncomment to create question bank.
    private TrueFalse[] mQuestionBank = new TrueFalse[]{

            new TrueFalse(R.string.question_1, true),
            new TrueFalse(R.string.question_2, false),
            new TrueFalse(R.string.question_3, true),
            new TrueFalse(R.string.question_4, false),
            new TrueFalse(R.string.question_5, true),
            new TrueFalse(R.string.question_6, false),
            new TrueFalse(R.string.question_7, true),
            new TrueFalse(R.string.question_8, false),
            new TrueFalse(R.string.question_9, true),
            new TrueFalse(R.string.question_10, true),
            new TrueFalse(R.string.question_11, false),
            new TrueFalse(R.string.question_12, false),
            new TrueFalse(R.string.question_13, true),
            new TrueFalse(R.string.question_14, false),
            new TrueFalse(R.string.question_15, true)

    };


    //TODO: Declare constants here
    final int PROGRESS_BAR_INCREMENT = (int) Math.ceil(100.0 / mQuestionBank.length);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level01);

        trueBtn = (Button) findViewById(R.id.trueBtn);
        falseBtn = (Button) findViewById(R.id.falseBtn);
        mQuestionTextView = (TextView) findViewById(R.id.questionTextView);
        mScoreTextView = (TextView) findViewById(R.id.score);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        TrueFalse firstQUestion = mQuestionBank[mIndex];
        mQuestion = mQuestionBank[mIndex].getmQuestionID();

        mQuestionTextView.setText(mQuestion);

        trueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);
                updateQuestion();

            }
        });


        falseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
                updateQuestion();

            }
        });


    }

    private void updateQuestion() {

        mIndex = (mIndex + 1) % mQuestionBank.length; // this code takes the user back to questions 1 after the user has reached the 15th question.

        if (mIndex == 0) {
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("Total Score");
            alert.setCancelable(false);
            alert.setMessage("You scored " + mscore + " Point(s)!");


            alert.setPositiveButton("Close", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    //TODO: transfer the finish code to a main screen, and put here the select level screen.
                    finish();
                }
            });
            alert.show();

        }
        mQuestion = mQuestionBank[mIndex].getmQuestionID();
        mQuestionTextView.setText(mQuestion);
        progressBar.incrementProgressBy(PROGRESS_BAR_INCREMENT);
        mScoreTextView.setText("score: " + mscore + "/" + mQuestionBank.length);

        //mQuestionBank.length displays the total number of questions given.


    }

    private void checkAnswer(boolean userSelection) {

        boolean correctAnswer = mQuestionBank[mIndex].isAnswer();

        if (userSelection == correctAnswer) {

            Toast.makeText(getApplicationContext(), R.string.correct_toast, Toast.LENGTH_SHORT).show();
            mscore = mscore + 1;
        } else {
            Toast.makeText(getApplicationContext(), R.string.incorrect_toast, Toast.LENGTH_SHORT).show();

        }


    }


}