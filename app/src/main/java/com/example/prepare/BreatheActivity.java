package com.example.prepare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;


import java.util.Locale;

public class BreatheActivity extends AppCompatActivity {

    private static final long START_TIME_IN_MILLIS = 120000;
    private TextView timer_Text;
    private Button countdown_button;
    private Button exit_button;
    private CountDownTimer countdownTimer;
    private boolean timerRunning;
    private long timeLeftInMilliseconds = START_TIME_IN_MILLIS;
    private Handler handler = new Handler();
    private TextView statusText;
    private View  innerCircleView;
    private Animation animationInhaleText, animationExhaleText, animationInhaleInnerCircle, animationExhaleInnerCircle;
    private int holdDuration = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breathe);


        statusText = findViewById(R.id.circle_text);
        statusText.setText(Constants.INHALE);
        innerCircleView = findViewById(R.id.view_circle_inner);
        timer_Text = findViewById(R.id.timerText);
        countdown_button = findViewById(R.id.countdownButton);
        exit_button = findViewById(R.id.exitButton);

// On click listener for starting breathing activity
        countdown_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prepareAnimations();
                statusText.startAnimation(animationInhaleText);
                innerCircleView.startAnimation(animationInhaleInnerCircle);
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

    private void setInhaleDuration(int duration) {
        animationInhaleText.setDuration(duration);
        animationInhaleInnerCircle.setDuration(duration);
    }

    private void setExhaleDuration(int duration) {
        animationExhaleText.setDuration(duration);
        animationExhaleInnerCircle.setDuration(duration);
    }


    private void prepareAnimations() {
        int inhaleDuration = 5000;
        int exhaleDuration = 5000;
        holdDuration = 4000;

        // Inhale - make large
        animationInhaleText = AnimationUtils.loadAnimation(this, R.anim.anim_text_inhale);
        animationInhaleText.setFillAfter(true);
        animationInhaleText.setAnimationListener(inhaleAnimationListener);

        animationInhaleInnerCircle = AnimationUtils.loadAnimation(this, R.anim.anim_inner_circle_inhale);
        animationInhaleInnerCircle.setFillAfter(true);
        animationInhaleInnerCircle.setAnimationListener(inhaleAnimationListener);
        setInhaleDuration(inhaleDuration);



        // Exhale - make small
        animationExhaleText = AnimationUtils.loadAnimation(this, R.anim.anim_text_exhale);
        animationExhaleText.setFillAfter(true);
        animationExhaleText.setAnimationListener(exhaleAnimationListener);

        animationExhaleInnerCircle = AnimationUtils.loadAnimation(this, R.anim.anim_inner_circle_exhale);
        animationExhaleInnerCircle.setFillAfter(true);
        animationExhaleInnerCircle.setAnimationListener(exhaleAnimationListener);
        setExhaleDuration(exhaleDuration);



    }

    private Animation.AnimationListener inhaleAnimationListener = new Animation.AnimationListener() {
        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationEnd(Animation animation) {
            statusText.setText(Constants.HOLD);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    statusText.setText(Constants.EXHALE);
                    statusText.startAnimation(animationExhaleText);
                    innerCircleView.startAnimation(animationExhaleInnerCircle);
                }
            }, holdDuration);
        }

        @Override
        public void onAnimationRepeat(Animation animation) {
        }
    };

    private Animation.AnimationListener exhaleAnimationListener = new Animation.AnimationListener() {
        @Override
        public void onAnimationStart(Animation animation) {
        }

        @Override
        public void onAnimationEnd(Animation animation) {
            statusText.setText(Constants.HOLD);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    statusText.setText(Constants.INHALE);
                    statusText.startAnimation(animationInhaleText);
                    innerCircleView.startAnimation(animationInhaleInnerCircle);
                }
            }, holdDuration);
        }

        @Override
        public void onAnimationRepeat(Animation animation) {
        }
    };

}
