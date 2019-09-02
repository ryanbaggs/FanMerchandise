package com.fastburngames.fanmerchandise.auth;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fastburngames.fanmerchandise.R;

/**
 * Fragment for adding the address information of the user to the users
 * profile.
 */
public class RegisterAddressFragment extends Fragment {

    // TODO: add the ViewModel.

    // TODO: add the observer.


    private static final String TAG = "RegisterAddressFragment";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register_address, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
