package com.fastburngames.fanmerchandise.view;

import android.content.Intent;
import android.os.Bundle;

import com.fastburngames.fanmerchandise.R;
import com.fastburngames.fanmerchandise.view.auth.FUIAuthActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import com.fastburngames.fanmerchandise.adapters.SectionsPagerAdapter;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    // TODO: Add member list of ApparelViewModel objects.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // PagerAdapter setup.
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter
                (this, getSupportFragmentManager());

        // Pager setup.
        ViewPager viewPager = findViewById(R.id.view_pager_main);
        viewPager.setAdapter(sectionsPagerAdapter);

        // Tab setup.
        TabLayout tabs = findViewById(R.id.tabs_main);
        tabs.setupWithViewPager(viewPager);

        // FloatingActionButton setup.
        FloatingActionButton fab = findViewById(R.id.fab_main);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action",
                        Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        // If there is no user logged in start up FUIAuthActivity.
        if (FirebaseAuth.getInstance().getCurrentUser() == null) {
            Intent loginIntent = new Intent(MainActivity.this,
                    FUIAuthActivity.class);
            startActivity(loginIntent);
        } else {
            // User signed in.
            // TODO: Create user signed-in code.
            FirebaseUser currentUser = FirebaseAuth.getInstance()
                    .getCurrentUser();
        }
    }

    //TODO: Create observer method for data.
}