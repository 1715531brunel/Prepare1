package com.example.prepare;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class question_page extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_page);

        Button btnStartAssess = findViewById(R.id.start_assessment);
        btnStartAssess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAsses();
            }
        });

    }
    private void startAsses() {
        Intent intent = new Intent(question_page.this, AssessActivity.class);
        startActivity(intent);
    }
}


