package com.fastburngames.fanmerchandise.auth;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.fastburngames.fanmerchandise.BuildConfig;
import com.fastburngames.fanmerchandise.R;
import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;
import java.util.List;

public class FUIAuthActivity extends AppCompatActivity {

    // Constants.
    public static final int RC_SIGN_IN = 454;

    // Member Variables.
    FirebaseAuth mAuth;

    // TODO: Create authentication code.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();
    }

    public void signIn() {
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
                FirebaseUser user = mAuth.getCurrentUser();
            } else {
                // Sign in failed. If response is null the user canceled the
                // sign-in flow using the back button. Otherwise check
                // response.getError().getErrorCode() and handle the error.
                // TODO: code sign in failure notifications/directions.
            }
        }
    }
}
