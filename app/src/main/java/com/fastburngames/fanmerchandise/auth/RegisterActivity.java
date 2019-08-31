package com.fastburngames.fanmerchandise.auth;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.fastburngames.fanmerchandise.R;

import java.util.ArrayList;
import java.util.List;

public class RegisterActivity extends FragmentActivity {

    //Member variables.
    private ViewPager mPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Initialize and set up the ViewPager.
        mPager = findViewById(R.id.view_pager_register);
        setupViewPager(mPager);
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

    private void setupViewPager(ViewPager viewPager){
        // Initialize the adapter.
        RegisterPagerAdapter adapter = new RegisterPagerAdapter
                (getSupportFragmentManager());
        // Add the fragments.
        adapter.addFragment(new RegisterEmailPassFragment());
        viewPager.setAdapter(adapter);
    }

    // TODO: Create ViewModel object for user account info.

    /**
     * Class for the Pager Adapter that returns the fragment associated with
     * the users current step.
     */
    private class RegisterPagerAdapter extends FragmentStatePagerAdapter {

        private final List<Fragment> mFragmentList = new ArrayList<>();

        RegisterPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        private void addFragment(Fragment fragment){
            mFragmentList.add(fragment);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }
    }
}
