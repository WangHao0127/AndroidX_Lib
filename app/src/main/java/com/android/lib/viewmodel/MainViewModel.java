package com.android.lib.viewmodel;

import android.app.Application;

import com.android.lib.data.ObservableUser;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

/**
 * Author: WangHao
 * Created On: 2020/04/10  13:51
 * Description:
 */
public class MainViewModel extends AndroidViewModel {

    private MutableLiveData<ObservableUser> users = new MutableLiveData<>();

    public MainViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<ObservableUser> getUsers() {
        return users;
    }

    public void getUserData(){
        //网络请求
        ObservableUser observableUser =new ObservableUser("wanghao","是的吧衰减大");
        users.setValue(observableUser);
    }

}
