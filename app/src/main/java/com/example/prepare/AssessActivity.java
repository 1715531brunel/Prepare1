package com.example.prepare;

import androidx.appcompat.app.AppCompatActivity;

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
        radGrop = findViewById(R.id.ques_group);
        radbt1 = findViewById(R.id.radio_butt1);
        radbt2 = findViewById(R.id.radio_butt2);
        radbt3 = findViewById(R.id.radio_butt3);
        radbt4 = findViewById(R.id.radio_butt4);
        radbt5 = findViewById(R.id.radio_butt5);
        btNext = findViewById(R.id.nxt_button);
        AssessDbHelper dbHelper = new AssessDbHelper(this);
        questList = dbHelper.getAllQuests();
    }

}