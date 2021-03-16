package com.example.prepare;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;


public class LearnFragment extends Fragment {

    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_learn, container, false);


        CardView learnCard = v.findViewById(R.id.learn_card);

        learnCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),ExamAnxietyActivity.class));
            }

        });
        return v;
    }
}
