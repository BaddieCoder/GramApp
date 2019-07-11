package com.codepath.gram;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.codepath.gram.Fragments.ComposeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        bottomNavigationView =  findViewById(R.id.bottom_navigation);



        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_compose:
                        Intent intent = new Intent(HomeActivity.this, ComposeFragment.class);
                        startActivity(intent);
                        return true;
                    case R.id.action_profile:
                        // do something here
                        return true;
                    case R.id.action_home:
                        // do something here
                        return true;
                    default: return true;
                }
            }
        });



    }





}
