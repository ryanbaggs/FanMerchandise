package com.fastburngames.fanmerchandise;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import com.fastburngames.fanmerchandise.ui.main.SectionsPagerAdapter;

public class FanPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fan_page);

        // PagerAdapter setup.
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter
                (this, getSupportFragmentManager());

        // Pager setup.
        ViewPager viewPager = findViewById(R.id.view_pager_fan_page);
        viewPager.setAdapter(sectionsPagerAdapter);

        // Tab setup.
        TabLayout tabs = findViewById(R.id.tabs_fan_page);
        tabs.setupWithViewPager(viewPager);

        // FloatingActionButton setup.
        FloatingActionButton fab = findViewById(R.id.fab_fan_page);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action",
                        Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}
