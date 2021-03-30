package com.example.prepare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class ExamAnxietyActivity extends AppCompatActivity {

    private ArrayList<ExamContent> examContentsList;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_anxiety);

        examContentsList = new ArrayList<>();
        recyclerView = findViewById(R.id.exam_anxiety_recycler_view);


        setExamContentInfo();
        setAdapter();
        decorateRecycleView();
    }

    private void setAdapter() {
        ExamContentAdapter adapter = new ExamContentAdapter(examContentsList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    public void setExamContentInfo(){

        examContentsList.add(new ExamContent("Overview","Test anxiety is a combination of physical symptoms and emotional reactions that interfere with your ability to perform well on tests. " +
                "Many students experience varying levels of test anxiety for a number of different reasons"));
        examContentsList.add(new ExamContent("Causes","Fear of failure, Lack of preparation, Poor test history, High pressure"));
        examContentsList.add(new ExamContent("Effects",getString(R.string.effects_anxiety)));
        examContentsList.add(new ExamContent("Problem Solve","Refer to skills section on how to study and prepare for exams"));


    }

    public void decorateRecycleView(){
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
    }
}