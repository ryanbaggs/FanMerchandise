package com.fastburngames.fanmerchandise.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.fastburngames.fanmerchandise.dataModel.UserData;

/**
 * ViewModel for the UserData, this will be observed by the Fragments in
 * RegisterActivity.
 */
public class RegisterActivityViewModel extends ViewModel {

    private MutableLiveData<UserData> userLiveData = new MutableLiveData<>();

    public void setUserLiveData(UserData userData) {
        this.userLiveData.setValue(userData);
    }

    public LiveData<UserData> getUserLiveData() {
        return userLiveData;
    }
}
