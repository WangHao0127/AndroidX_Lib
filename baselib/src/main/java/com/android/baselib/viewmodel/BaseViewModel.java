package com.android.baselib.viewmodel;

import android.app.Application;

import com.android.baselib.event.BaseActionEvent;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;

/**
 * Author: WangHao
 * Created On: 2020/04/10  15:23
 * Description:作为消息发送方的BaseViewModel的具体实现
 */
public class BaseViewModel extends AndroidViewModel implements IViewModelAction {

    private MutableLiveData<BaseActionEvent> mActionLiveData;

    protected LifecycleOwner mLifecycleOwner;

    public BaseViewModel(@NonNull Application application) {
        super(application);
        mActionLiveData = new MutableLiveData<>();
    }

    @Override
    public void startLoading() {
        startLoading(null);
    }

    @Override
    public void startLoading(String message) {
        BaseActionEvent baseActionEvent = new BaseActionEvent(BaseActionEvent.SHOW_LOADING_DIALOG);
        baseActionEvent.setMessage(message);
        mActionLiveData.setValue(baseActionEvent);
    }

    @Override
    public void dismissLoading() {
        mActionLiveData.setValue(new BaseActionEvent(BaseActionEvent.DISMISS_LOADING_DIALOG));
    }

    @Override
    public void showToast(String message) {
        BaseActionEvent baseActionEvent = new BaseActionEvent(BaseActionEvent.SHOW_TOAST);
        baseActionEvent.setMessage(message);
        mActionLiveData.setValue(baseActionEvent);
    }

    @Override
    public void finish() {
        mActionLiveData.setValue(new BaseActionEvent(BaseActionEvent.FINISH));
    }

    @Override
    public void finishWithResultOk() {
        mActionLiveData.setValue(new BaseActionEvent(BaseActionEvent.FINISH_WITH_RESULT_OK));
    }


    @Override
    public MutableLiveData<BaseActionEvent> getActionLiveData() {
        return mActionLiveData;
    }

    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        mLifecycleOwner = lifecycleOwner;
    }
}
