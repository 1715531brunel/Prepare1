package com.example.prepare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Code navigates through the pages from navigation bar
        BottomNavigationView bottomNav = findViewById(R.id.bottomBar);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_out, new HomeFragment()).commit();



    }



    private final BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;
            // switch statements for selected icons on bottom navigation
            switch (item.getItemId()){
                case R.id.nav_home:
                    selectedFragment = new HomeFragment();
                    break;
                case R.id.nav_nav_breathe:
                    selectedFragment = new BreatheFragment();
                    break;
                case R.id.nav_learn:
                    selectedFragment = new LearnFragment();
                    break;
                case R.id.nav_skill:
                    selectedFragment = new SkillFragment();
                    break;
                case R.id.nav_plan:
                    selectedFragment = new PlanFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_out,selectedFragment).commit();

            return true;
        }
    };

}
