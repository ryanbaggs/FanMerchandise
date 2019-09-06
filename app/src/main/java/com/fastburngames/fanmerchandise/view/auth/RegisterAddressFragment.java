package com.fastburngames.fanmerchandise.view.auth;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.fastburngames.fanmerchandise.R;
import com.fastburngames.fanmerchandise.dataModel.UserData;
import com.fastburngames.fanmerchandise.viewModel.RegisterActivityViewModel;

/**
 * Fragment for adding the address information of the user to the users
 * profile.
 */
public class RegisterAddressFragment extends Fragment {

    // Constants.
    private static final String TAG = "RegisterAddressFragment";

    // Member Variables.
    private RegisterActivityViewModel mViewModel;
    private UserData userData;
    // Views
    private EditText mEditStreet1;
    private EditText mEditStreet2;
    private EditText mEditCity;
    private EditText mEditZip;
    private Spinner mSpinnerState;
    private Button buttonNext;
    private Button buttonBack;


    // TODO: add the ViewModel.

    // TODO: add the observer.

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_register_address,
                container, false);

        setupViews();

        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // Initialize userdata from the ViewModel.
        userData = mViewModel.getUserLiveData().getValue();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    private void setupViews(){
        // EditText views.
        mEditStreet1.findViewById(R.id.edit_text_street_one);
        mEditStreet2.findViewById(R.id.edit_text_street_two);
        mEditCity.findViewById(R.id.edit_text_city);
        mEditZip.findViewById(R.id.edit_text_zip_code);

        // Spinner
        mSpinnerState.findViewById(R.id.spinner_state);

        // Buttons.
        buttonBack.findViewById(R.id.button_address_back);
        buttonNext.findViewById(R.id.button_address_next);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                previousFragment();
            }
        });
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (informationIsFilled()){
                    updateUserViewModel();
                    nextFragment();
                }
            }
        });
    }

    private void updateUserViewModel(){
        // set the data from forms to
        userData.setStreet1(mEditStreet1.getText());
        userData.setStreet2(mEditStreet2.getText());
        userData.setCity(mEditCity.getText());
        //userData.setState(); // TODO: Setup Spinner.
        userData.setZipCode(mEditZip.getText());

        mViewModel.setUserLiveData(userData);
    }

    private boolean informationIsFilled(){
        boolean informationIsFilled = true;

        // TODO: research way to verify forms filled properly.

        return informationIsFilled;
    }

    // Brings previous fragment back into focus.
    private void previousFragment(){

    }

    // Start the next fragment and end this fragment.
    private void nextFragment(){

    }
}
