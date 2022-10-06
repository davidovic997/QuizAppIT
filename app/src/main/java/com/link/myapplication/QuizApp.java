package com.link.myapplication;

import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class QuizApp extends AppCompatActivity implements View.OnClickListener{

    TextView questionTextView;
    Button odgA, odgB, odgC;
    Button submitBtn;

    int score=0;
    int totalQuestion = QuestionList.question.length;
    int currentQuestionIndex = 0;
    String selectedAnswer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_quiz);

        questionTextView = findViewById(R.id.question);
        odgA = findViewById(R.id.odg_A);
        odgB = findViewById(R.id.odg_B);
        odgC = findViewById(R.id.odg_C);
        submitBtn = findViewById(R.id.submit_btn);

        odgA.setOnClickListener(this);
        odgB.setOnClickListener(this);
        odgC.setOnClickListener(this);
        submitBtn.setOnClickListener(this);

        loadNewQuestion();
    }

    @Override
    public void onClick(View view) {

        odgA.setBackgroundColor(Color.WHITE);
        odgB.setBackgroundColor(Color.WHITE);
        odgC.setBackgroundColor(Color.WHITE);

        Button clickedButton = (Button) view;
        if(clickedButton.getId()==R.id.submit_btn){
            if(selectedAnswer.equals(QuestionList.correctAnswers[currentQuestionIndex])){
                score++;
            }
            currentQuestionIndex++;
            loadNewQuestion();
        }else{
            selectedAnswer  = clickedButton.getText().toString();
            clickedButton.setBackgroundColor(Color.GRAY);
        }
    }

    void loadNewQuestion(){

        if(currentQuestionIndex == totalQuestion ){
            finishQuiz();
            return;
        }

        questionTextView.setText(QuestionList.question[currentQuestionIndex]);
        odgA.setText(QuestionList.answers[currentQuestionIndex][0]);
        odgB.setText(QuestionList.answers[currentQuestionIndex][1]);
        odgC.setText(QuestionList.answers[currentQuestionIndex][2]);

    }

    void finishQuiz(){
        String passStatus = "";
        if(score > totalQuestion*0.20){
            passStatus = "Čestitamo! Položili ste.";
        }else{
            passStatus = "Niste položili.";
        }
        new AlertDialog.Builder(this)
                .setTitle(passStatus)
                .setMessage("Vaša ocjena je: "+ score+" / "+ totalQuestion)
                .setPositiveButton("PLAY AGAIN",(dialogInterface, i) -> restartQuiz() )
                .setCancelable(false)
                .show();
    }
    void restartQuiz(){
        score = 0;
        currentQuestionIndex =0;
        loadNewQuestion();
    }
}



