package com.android.baselib.viewmodel;

import com.android.baselib.event.BaseActionEvent;

import androidx.lifecycle.MutableLiveData;

/**
 * Author: WangHao
 * Created On: 2020/04/10  15:22
 * Description:
 */
public interface IViewModelAction {

    void startLoading();

    void startLoading(String message);

    void dismissLoading();

    void showToast(String message);

    void finish();

    void finishWithResultOk();

    MutableLiveData<BaseActionEvent> getActionLiveData();

}
