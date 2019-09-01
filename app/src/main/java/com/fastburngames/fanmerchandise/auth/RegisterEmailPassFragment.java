package com.fastburngames.fanmerchandise.auth;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.fastburngames.fanmerchandise.R;
import com.fastburngames.fanmerchandise.model.RegisterActivityViewModel;

import java.util.Objects;

/**
 * Fragment for registering a new user setting up an email account and
 * password.
 */
public class RegisterEmailPassFragment extends Fragment {

    // Constants.
    private static final String TAG = "RegisterEmailPassFragme";

    // Member Variables.
    private RegisterActivityViewModel mViewModel;
    private EditText mTextEmail;
    private EditText mTextPass;

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
                // Pass email and password to the mViewModel object.
                mViewModel.setEmail(mTextEmail.getText());
                mViewModel.setPassword(mTextPass.getText());
            }
        });

        return view;
    }

    /**
     * Adding the ModelView here allows it to be destroyed and rebuilt every
     * time that the app is destroyed. This prevents memory leaks.
     *
     * @param savedInstanceState any simple data saved, not necessary here.
     */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // Initialize mViewModel.
        mViewModel = ViewModelProviders.of
                (Objects.requireNonNull(getActivity()))
                .get(RegisterActivityViewModel.class);

        // Set up the observers for email and password TextViews.
        mViewModel.getEmail().observe(getViewLifecycleOwner(),
                new Observer<CharSequence>() {
            @Override
            public void onChanged(CharSequence charSequence) {
                mTextEmail.setText(charSequence);
            }
        });
        mViewModel.getPassword().observe(getViewLifecycleOwner(),
                new Observer<CharSequence>() {
                    @Override
                    public void onChanged(CharSequence charSequence) {
                        mTextPass.setText(charSequence);
                    }
                });
    }
}
