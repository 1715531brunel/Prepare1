package com.example.prepare;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;


public class PlanFragment extends Fragment {

    CardView PlanCard;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_plan, container, false);


         PlanCard = view.findViewById(R.id.intro_plan);

        planCardClick();

        return view;
    }

    public void planCardClick(){
        PlanCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), PlanActivity.class));
            }

        });

    }

}
