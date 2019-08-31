package com.fastburngames.fanmerchandise.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * ViewModel for the User input data to be passed between Fragments.
 */
public class RegisterViewModel extends ViewModel {

    private MutableLiveData<CharSequence> email = new MutableLiveData<>();
    private MutableLiveData<CharSequence> password = new MutableLiveData<>();

    public void setEmail(CharSequence email) {
        this.email.setValue(email);
    }

    public void setPassword(CharSequence password) {
        this.password.setValue(password);
    }

    public LiveData<CharSequence> getEmail(){
        return email;
    }

    public LiveData<CharSequence> getPassword(){
        return password;
    }
}
