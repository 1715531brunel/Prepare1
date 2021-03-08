package com.example.prepare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class BreatheActivity extends AppCompatActivity {

    private static final long START_TIME_IN_MILLIS = 600000;
    private TextView timer_Text;
    private Button countdown_button;
    private Button exit_button;
    private CountDownTimer countdownTimer;
    private boolean timerRunning;
    private long timeLeftInMilliseconds = START_TIME_IN_MILLIS;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breathe);

        timer_Text = findViewById(R.id.timerText);
        countdown_button = findViewById(R.id.countdownButton);
        exit_button = findViewById(R.id.exitButton);


        countdown_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(timerRunning){
                   pauseTimer();
               }else
                    startTimer();
            }
        });

      exit_button.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              finish();
          }
      });

        updateTimer();
    }

    public void startTimer(){
      countdownTimer = new CountDownTimer(timeLeftInMilliseconds,1000) {
          @Override
          public void onTick(long millisUntilFinished) {
              timeLeftInMilliseconds = millisUntilFinished;
              updateTimer();
          }

          @Override
          public void onFinish() {
              timerRunning = false;
              countdown_button.setText("START");


          }
      }.start();

        timerRunning = true;
        countdown_button.setText("STOP");
        exit_button.setVisibility(View.INVISIBLE);


    }
    private void pauseTimer() {
        countdownTimer.cancel();
        timerRunning = false;
        countdown_button.setVisibility(View.INVISIBLE);
        exit_button.setVisibility(View.VISIBLE);
    }


    public void updateTimer(){
        int minutes = (int) (timeLeftInMilliseconds / 1000) / 60;
        int seconds = (int) (timeLeftInMilliseconds / 1000) % 60;

        String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);


        timer_Text.setText(timeLeftFormatted);
    }

}