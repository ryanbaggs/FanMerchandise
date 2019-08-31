package com.fastburngames.fanmerchandise.auth;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.fastburngames.fanmerchandise.R;

/**
 * Fragment for registering a new user setting up an email account and
 * password.
 */
public class RegisterEmailPassFragment extends Fragment {

    // Constants.
    private static final String TAG = "RegisterEmailPassFragme";

    // Member Variables.
    private EditText mTextEmail;
    private EditText mTextPass;
    private String mStringEmail;
    private String mStringPass;

    public RegisterEmailPassFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView started.");

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_register_email_pass,
                container, false);

        // Setup references to email and password TextViews.
        mTextEmail = view.findViewById(R.id.edit_text_email);
        mTextPass = view.findViewById(R.id.edit_text_password);

        // Set up Button reference.
        Button mButtonCreateAccount = view.findViewById
                (R.id.button_create_account);

        // Setup onClickListener
        mButtonCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "OnClick.");
                // Get the email and password and set it to the Strings.
                mStringEmail = mTextEmail.getText().toString();
                mStringPass = mTextPass.getText().toString();
            }
        });

        return view;
    }

    // TODO: Set up comms between Fragments.
}
