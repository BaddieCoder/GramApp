package com.codepath.gram;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.codepath.gram.Fragments.ComposeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        bottomNavigationView =  findViewById(R.id.bottom_navigation);

        final FragmentManager fragmentManager = getSupportFragmentManager();


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
               Fragment fragment = new ComposeFragment();
                switch (item.getItemId()) {
                    case R.id.action_compose:
                      fragment  = new ComposeFragment();
                        Toast. makeText(HomeActivity.this, "Compose",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_profile:
                        fragment   = new ComposeFragment();
                        Toast. makeText(HomeActivity.this, "profile",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_home:
                        fragment   = new ComposeFragment();
                        Toast. makeText(HomeActivity.this, "home",Toast.LENGTH_SHORT).show();
                        break;
                    default: break;
                }

            fragmentManager.beginTransaction().replace(R.id.flContainer, fragment).commit();
            return true;

            }

        });

        bottomNavigationView.setSelectedItemId(R.id.action_home);

    }





}
