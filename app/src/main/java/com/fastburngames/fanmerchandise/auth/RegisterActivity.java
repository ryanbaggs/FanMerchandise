package com.fastburngames.fanmerchandise.auth;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.fastburngames.fanmerchandise.R;

public class RegisterActivity extends FragmentActivity {

    // Static variables.
    private static int NUM_PAGES;

    //Member variables.
    private ViewPager mPager;
    private PagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Email and pass, verification, and continue to app.
        NUM_PAGES = getResources().getInteger(R.integer.register_pages_count);

        // Initialize the ViewPager and PagerAdapter.
        mPager = findViewById(R.id.view_pager_register);
    }

    private class RegisterPagerAdapter extends FragmentStatePagerAdapter {

        public RegisterPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
            }
            return null;
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }
}
