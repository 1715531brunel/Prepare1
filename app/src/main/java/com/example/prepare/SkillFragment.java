package com.example.prepare;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;


public class SkillFragment extends Fragment {

    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_skill, container, false);


        CardView SkillCard = v.findViewById(R.id.Skill_card);
        CardView SkillCard1 = v.findViewById(R.id.Skill1_card);
        CardView SkillCard2 = v.findViewById(R.id.Skill2_card);
        CardView SkillCard3 = v.findViewById(R.id.Skill3_card);

        SkillCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),StudySkill1Activity.class));
            }
        });
        SkillCard1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),StudySkill2Activity.class));
            }
        });
        SkillCard2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),StudySkill3Activity.class));
            }
        });
        SkillCard3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),StudySkill4Activity.class));
            }
        });
        return v;
    }
}
