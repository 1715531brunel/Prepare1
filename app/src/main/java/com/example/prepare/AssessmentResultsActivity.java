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
            adviceMessage.setText("4.0-5.0 -Extremely high anxiety , \nYour score suggests that you are experiencing high levels of test anxiety at the moment" +
                    " We recommend booking an appointment with your GP or University Counselling services right away" +
                    "as there are many tools that could help you through this" +
                    "\n\n If you need to speak to someone urgently, you can speak to A&E deparment or" +
                    "talk to the Samaritans available 24/7(find them on the support page of the app");
        } else if (score >= 3.5 && score <= 3.9) {
            adviceMessage.setText("3.5 - 3.9 - High test anxiety \nYour score suggest you have a high test anxiety, " +
                    "You may want to speak with your GP/Doctor or use a counselling service" +
                    "\n\nIf your symptoms are causing distress." +
                    "\n\nThe tools in the app  provide some helpful tools to manage symptoms alongside treatment if you require it ");
        } else if (score >= 3.0 && score <= 3.4) {
            adviceMessage.setText("3.0 - 3.4 - Moderately high (some items rated 4=high) \nYour score suggest a moderately high test anxiety" +
                    " The symptoms may be interfering with your life and maybe causing some distress but may feel manageable" +
                    "\nThe tools in this app can help with some of the symptoms you are experiencing ");
        }else if (score >= 2.5 && score <= 2.9) {
            adviceMessage.setText(" 2.5 - 2.9 - High normal test anxiety \nYour score suggests a mild test anxiety" +
                    " \n\nYour might find the tools in this app helpful in maintaining your well being");
        }
        else if (score >= 2.0 && score <= 2.5 ) {
            adviceMessage.setText("2.0 - 2.5 - Normal or average test anxiety \nYour score suggest a normal test anxiety level. " +
                    "\nThis is only an indicator of how you are feeling at the moment" +
                    " \n\nCome back and re take this assessment if things change");
        } else {
            adviceMessage.setText("1.0 - 1.9 - Comfortably low test anxiety \nYour score suggests that you are not experiencing test anxiety at the moment ");
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

