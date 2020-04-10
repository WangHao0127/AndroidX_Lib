package com.android.baselib.ui;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.baselib.R;
import com.android.baselib.base.BaseAppCompatActivity;
import com.android.baselib.data.EventBusData;
import com.android.baselib.event.BaseActionEvent;
import com.android.baselib.viewmodel.IViewModelAction;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Observer;
import com.blankj.utilcode.util.ToastUtils;

/**
 * Author: WangHao
 * Created On: 2020/04/08  14:22
 * Description:
 */
public abstract class BaseActivity<T extends ViewDataBinding> extends BaseAppCompatActivity {

    protected Dialog loadingPop;

    protected T mBinding;

    @Override
    protected void createBinding() {
        mBinding = DataBindingUtil.setContentView(this,getLayoutId());
    }

    protected abstract AndroidViewModel initViewModel();

    protected List<AndroidViewModel> initViewModelList(){
        return null;
    }

    @Override
    protected void initViewModelEvent(){
        List<AndroidViewModel> viewModelList = initViewModelList();
        if (viewModelList !=null && viewModelList.size() >0){
            observeEvent(viewModelList);
        }else{
            AndroidViewModel model= initViewModel();
            if (model!=null){
                List<AndroidViewModel> modelList = new ArrayList<>();
                modelList.add(model);
                observeEvent(modelList);
            }
        }
    }

    private void observeEvent(List<AndroidViewModel> viewModelList){
        for (AndroidViewModel viewModel : viewModelList) {
            if (viewModel instanceof IViewModelAction) {
                IViewModelAction viewModelAction = (IViewModelAction) viewModel;
                viewModelAction.getActionLiveData().observe(this,
                    baseActionEvent -> {
                        if (baseActionEvent!=null){
                            switch (baseActionEvent.getAction()){
                                case BaseActionEvent.SHOW_LOADING_DIALOG:
                                    showLoading(baseActionEvent.getMessage());
                                    break;
                                case BaseActionEvent.DISMISS_LOADING_DIALOG:
                                    hideLoading();
                                    break;
                                case BaseActionEvent.SHOW_TOAST:
                                    ToastUtils.showShort(baseActionEvent.getMessage());
                                    break;
                                case BaseActionEvent.FINISH:
                                    finish();
                                    break;
                                case BaseActionEvent.FINISH_WITH_RESULT_OK:
                                    setResult(RESULT_OK);
                                    break;
                            }
                        }
                    });
            }
        }
    }

    @Override
    protected void onNavigateClick() {
        if (hasTitleBar()) {
            ImageButton backView = findViewById(R.id.actionbar_back);
            if (backView != null) {
                backView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });
            }
        }
    }

    @Override
    protected void setCustomTitle(CharSequence title) {
        if (hasTitleBar()) {
            TextView titleView = findViewById(R.id.title_tv_message);
            if (titleView != null) {
                titleView.setText(title);
                setTitle("");
            }
        }
    }

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        if (hasTitleBar()) {
            mImmersionBar.titleBar(R.id.title_bar).init();
        } else {
            if (!isStatusBarOverlap()) {
                mImmersionBar.fitsSystemWindows(true).statusBarColor(R.color.colorWhite).init();
            }
        }
    }

    public synchronized void hideLoading() {
        if (loadingPop != null && loadingPop.isShowing()) {
            loadingPop.dismiss();
        }
    }

    private synchronized void showLoading() {
        showLoading(null);
    }

    public synchronized void showLoading(String message) {
        if (loadingPop == null) {
            loadingPop = new Dialog(this, R.style.NoTitleDialogStyle);
            loadingPop.setContentView(R.layout.popup_loading);
            loadingPop.setCanceledOnTouchOutside(false);

            TextView title = loadingPop.findViewById(R.id.pl_content_txt);
            title.setText(message);
        }
        loadingPop.show();
    }

    @Override
    protected boolean hasTitleBar() {
        return findViewById(R.id.title_bar) != null;
    }

    @Override
    protected boolean isBindEventBusHere() {
        return false;
    }

    @Override
    protected boolean isOverridePendingTransition() {
        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        hideLoading();
    }

    @Override
    protected TransitionMode getTransitionMode() {
        return TransitionMode.FADE;
    }

    @Override
    protected void eventBusSend(EventBusData data) {
        EventBus.getDefault().post(data);
    }

}
