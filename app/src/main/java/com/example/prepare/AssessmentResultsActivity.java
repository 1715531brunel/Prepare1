package com.example.prepare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class AssessmentResultsActivity extends AppCompatActivity {

    TextView resultScore;
    TextView  adviceMessage;
    Button backAssessPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assessment_results);

        resultScore = findViewById(R.id.result_text);
        adviceMessage = findViewById(R.id.score_results);
        backAssessPage = findViewById(R.id.back_to_assessment);

        Bundle bundle = getIntent().getExtras();
        double score = bundle.getDouble("finalScore");
        resultScore.setText("You score: " + score);


        if (score >= 4.0 && score <= 5.0) {
            adviceMessage.setText(getString(R.string.extremely_high_anxiety));
        } else if (score >= 3.5 && score <= 3.9) {
            adviceMessage.setText(getString(R.string.high_anxiety));
        } else if (score >= 3.0 && score <= 3.4) {
            adviceMessage.setText(getString(R.string.moderately_high_anxiety));
        }else if (score >= 2.5 && score <= 2.9) {
            adviceMessage.setText(getString(R.string.high_normal_anxiety));
        }
        else if (score >= 2.0 && score <= 2.5 ) {
            adviceMessage.setText(getString(R.string.average_anxiety));
        } else {
            adviceMessage.setText(getString(R.string.low_anxiety));
        }

        backAssessPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AssessmentResultsActivity.this, question_page.class));
                AssessmentResultsActivity.this.finish();
            }
        });

    }
}

