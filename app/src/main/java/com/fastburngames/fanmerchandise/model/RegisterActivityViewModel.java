package com.fastburngames.fanmerchandise.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * ViewModel for the User input data to be passed between Fragments.
 */
public class RegisterActivityViewModel extends ViewModel {

    private MutableLiveData<CharSequence> email = new MutableLiveData<>();
    private MutableLiveData<CharSequence> password = new MutableLiveData<>();
    private MutableLiveData<CharSequence> street1 = new MutableLiveData<>();
    private MutableLiveData<CharSequence> street2 = new MutableLiveData<>();
    private MutableLiveData<CharSequence> city = new MutableLiveData<>();
    private MutableLiveData<CharSequence> state = new MutableLiveData<>();
    private MutableLiveData<CharSequence> zipCode = new MutableLiveData<>();
    private MutableLiveData<Boolean> selling = new MutableLiveData<>();


    public void setEmail(CharSequence email) {
        this.email.setValue(email);
    }

    public void setPassword(CharSequence password) {
        this.password.setValue(password);
    }

    public void setStreet1(CharSequence street1) {
        this.street1.setValue(street1);
    }

    public void setStreet2(CharSequence street2) {
        this.street2.setValue(street2);
    }

    public void setCity(CharSequence city) {
        this.city.setValue(city);
    }

    public void setState(CharSequence state) {
        this.state.setValue(state);
    }

    public void setZipCode(CharSequence zipCode) {
        this.zipCode.setValue(zipCode);
    }

    public void setSelling(Boolean selling) {
        this.selling.setValue(selling);
    }

    public LiveData<CharSequence> getEmail() {
        return email;
    }

    public LiveData<CharSequence> getPassword() {
        return password;
    }

    public LiveData<CharSequence> getStreet1() {
        return street1;
    }


    public LiveData<CharSequence> getStreet2() {
        return street2;
    }

    public LiveData<CharSequence> getCity() {
        return city;
    }

    public LiveData<CharSequence> getState() {
        return state;
    }

    public LiveData<CharSequence> getZipCode() {
        return zipCode;
    }

    public LiveData<Boolean> getSelling() {
        return selling;
    }
}
