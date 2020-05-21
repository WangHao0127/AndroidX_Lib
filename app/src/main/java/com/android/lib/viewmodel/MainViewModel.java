package com.android.lib.viewmodel;

import android.app.Application;

import com.android.baselib.viewmodel.BaseViewModel;
import com.android.lib.data.ObservableUser;
import com.android.lib.data.Weather;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;

/**
 * Author: WangHao
 * Created On: 2020/04/10  13:51
 * Description:
 */
public class MainViewModel extends BaseViewModel {

    private MutableLiveData<ObservableUser> users;
    private MutableLiveData<Weather> mWeatherMutableLiveData;

    public MainViewModel(@NonNull Application application) {
        super(application);
        users = new MutableLiveData<>();
        mWeatherMutableLiveData = new MutableLiveData<>();
    }

    public MutableLiveData<ObservableUser> getUsers() {
        return users;
    }

    public void getUserData() {
        //网络请求
        ObservableUser observableUser = new ObservableUser("wanghao", "是的吧衰减大");
        users.setValue(observableUser);
    }

    public void queryWeather(String cityName) {
        //网络请求
    }

    public MutableLiveData<Weather> getWeatherMutableLiveData() {
        return mWeatherMutableLiveData;
    }
}
