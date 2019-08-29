package com.fastburngames.fanmerchandise;

import android.content.Intent;
import android.os.Bundle;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import com.fastburngames.fanmerchandise.ui.main.SectionsPagerAdapter;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // Constants.
    public static final int RC_SIGN_IN = 454;

    // TODO: Add member list of Article objects.

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

        // TODO: Create authentication code.
        signIn();
    }

    //TODO: Create observer method for data.

    private void signIn(){
        // Initialize Firebase.
        FirebaseApp.initializeApp(this);

        ActionCodeSettings actionCodeSettings = ActionCodeSettings.newBuilder()
                .setAndroidPackageName(BuildConfig.APPLICATION_ID, true, null)
                .setHandleCodeInApp(true)
                .setUrl("https://google.com")
                .build();

        // Create the Authentication providers list.
        List<AuthUI.IdpConfig> providers = Arrays.asList
                (new AuthUI.IdpConfig.EmailBuilder().enableEmailLinkSignIn()
                                .setActionCodeSettings(actionCodeSettings)
                                .build(),
                new AuthUI.IdpConfig.GoogleBuilder().build(),
                new AuthUI.IdpConfig.AnonymousBuilder().build());

        // Create and launch sign-in intent.
        startActivityForResult
                (AuthUI.getInstance()
                .createSignInIntentBuilder()
                .setAvailableProviders(providers)
                .build(), RC_SIGN_IN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN){
            IdpResponse response = IdpResponse.fromResultIntent(data);

            if (resultCode == RESULT_OK) {
                // Successfully signed in.
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            } else {
                // Sign in failed. If response is null the user canceled the
                // sign-in flow using the back button. Otherwise check
                // response.getError().getErrorCode() and handle the error.
                // TODO: code sign in failure notifications/directions.
            }
        }
    }
}