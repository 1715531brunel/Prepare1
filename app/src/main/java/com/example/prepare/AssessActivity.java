package com.example.prepare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class AssessActivity extends AppCompatActivity {

    private TextView textViewQuest;
    private TextView textViewScore;
    private TextView textViewQuestCount;
    private RadioGroup radGrop;
    private RadioButton radbt1;
    private RadioButton radbt2;
    private RadioButton radbt3;
    private RadioButton radbt4;
    private RadioButton radbt5;
    private Button btNext;

    private List<Quest> questList;
    private int questCounter;
    private int questTotalCount;
    private Quest currentQuest;
    private int scores;
    private boolean answrd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assess);

        textViewQuest = findViewById(R.id.questView);
        textViewScore = findViewById(R.id.text_view_scores);
        textViewQuestCount = findViewById(R.id.ques_numbers);
        radGrop = findViewById(R.id.rad_group);
        radbt1 = findViewById(R.id.radio_butt1);
        radbt2 = findViewById(R.id.radio_butt2);
        radbt3 = findViewById(R.id.radio_butt3);
        radbt4 = findViewById(R.id.radio_butt4);
        radbt5 = findViewById(R.id.radio_butt5);
        btNext = findViewById(R.id.nxt_button);

        AssessDbHelper dbHelper = new AssessDbHelper(this);
        questList = dbHelper.getAllQuests();
        questTotalCount = questList.size();


        showNxtQuest();
        btNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!answrd) {
                    if (radbt1.isChecked()) {
                        scores += 5;
                        checkAns();

                    } else if (radbt2.isChecked()) {
                        scores += 4;
                        checkAns();

                    } else if (radbt3.isChecked()) {
                        scores += 3;

                        checkAns();

                    }else if(radbt4.isChecked()){
                        scores += 2;

                        checkAns();

                    }else if(radbt5.isChecked()){
                        scores += 1;
                        checkAns();

                    }else{
                        Toast.makeText(AssessActivity.this,"Please choose an answer",Toast.LENGTH_SHORT).show();
                    }
                }else{
                    showNxtQuest();
                }

            }
        });

    }

    private void showNxtQuest() {

        radGrop.clearCheck();

        if (questCounter < questTotalCount) {
            currentQuest = questList.get(questCounter);

            textViewQuest.setText(currentQuest.getQuest());
            radbt1.setText(currentQuest.getOpt1());
            radbt2.setText(currentQuest.getOpt2());
            radbt3.setText(currentQuest.getOpt3());
            radbt4.setText(currentQuest.getOpt4());
            radbt5.setText(currentQuest.getOpt5());

            questCounter++;
            textViewQuestCount.setText("Question: " + questCounter + "/" + questTotalCount);
            answrd = false;
            btNext.setText("Confirm");

        } else {
            finishAssess();
        }
    }
    private void checkAns(){
        answrd = true;
        textViewScore.setText("Score: " + scores);
        showSol();
    }

    private void showSol() {
        if (questCounter < questTotalCount) {
            btNext.setText("Next");
        } else {
            btNext.setText("Finish");
        }

    }

    private void finishAssess() {
        finish();
    }

}