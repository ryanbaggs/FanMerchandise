package com.fastburngames.fanmerchandise.dataModel;

public class UserData {

    private CharSequence email;
    private CharSequence password;
    private CharSequence street1;
    private CharSequence street2;
    private CharSequence city;
    private CharSequence state;
    private CharSequence zipCode;
    private Boolean selling;

    public void setEmail(CharSequence email) {
        this.email = email;
    }

    public void setPassword(CharSequence password) {
        this.password = password;
    }

    public void setStreet1(CharSequence street1) {
        this.street1 = street1;
    }

    public void setStreet2(CharSequence street2) {
        this.street2 = street2;
    }

    public void setCity(CharSequence city) {
        this.city = city;
    }

    public void setState(CharSequence state) {
        this.state = state;
    }

    public void setZipCode(CharSequence zipCode) {
        this.zipCode = zipCode;
    }

    public void setSelling(Boolean selling) {
        this.selling = selling;
    }

    public CharSequence getEmail() {
        return email;
    }

    public CharSequence getPassword() {
        return password;
    }

    public CharSequence getStreet1() {
        return street1;
    }

    public CharSequence getStreet2() {
        return street2;
    }

    public CharSequence getCity() {
        return city;
    }

    public CharSequence getState() {
        return state;
    }

    public CharSequence getZipCode() {
        return zipCode;
    }

    public Boolean getSelling() {
        return selling;
    }
}
