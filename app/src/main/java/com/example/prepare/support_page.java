package com.example.prepare;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class support_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support_page);
        Hyperlink();
    }

    //method for hyperlink text in support page
    private void Hyperlink() {
        TextView linkTextView = findViewById(R.id.hyperlinkText);
        linkTextView.setMovementMethod(LinkMovementMethod.getInstance());
        linkTextView.setLinkTextColor(Color.BLUE);

        TextView studentMindTextView = findViewById(R.id.hyperlinkText1);
        studentMindTextView.setMovementMethod(LinkMovementMethod.getInstance());
        studentMindTextView.setLinkTextColor(Color.BLUE);

        TextView nightLineTextView = findViewById(R.id.hyperlinkText2);
        nightLineTextView.setMovementMethod(LinkMovementMethod.getInstance());
        nightLineTextView.setLinkTextColor(Color.BLUE);

    }
}