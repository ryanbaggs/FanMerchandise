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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Email and pass, verification, and continue to app.
        NUM_PAGES = getResources().getInteger(R.integer.register_pages_count);

        // Initialize the ViewPager and PagerAdapter then set the adapter to
        // the ViewPager.
        mPager = findViewById(R.id.view_pager_register);
        PagerAdapter mPagerAdapter = new RegisterPagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);
    }

    @Override
    public void onBackPressed() {
        if (mPager.getCurrentItem() == 0){
            // Allow system to handle and return to previous Activity.
            super.onBackPressed();
        } else {
            // Go back a page.
            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
        }
    }

    /**
     * Class for the Pager Adapter that returns the fragment associated with
     * the users current step.
     */
    private class RegisterPagerAdapter extends FragmentStatePagerAdapter {

        RegisterPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new RegisterEmailPassFragment();
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }
}
