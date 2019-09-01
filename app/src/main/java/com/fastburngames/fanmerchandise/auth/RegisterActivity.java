package com.fastburngames.fanmerchandise.auth;

import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.fastburngames.fanmerchandise.R;
import com.fastburngames.fanmerchandise.adapters.RegisterPagerAdapter;

/**
 * Activity for setting up a new user account. Only holds UI code.
 */
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


}
