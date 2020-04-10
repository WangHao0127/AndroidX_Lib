package com.android.baselib.ui;

import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.android.baselib.R;
import com.android.baselib.base.BaseAppCompatActivity;
import com.android.baselib.data.EventBusData;

import org.greenrobot.eventbus.EventBus;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

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
        if (loadingPop != null) {
            loadingPop.dismiss();
        }
    }

    public synchronized void showLoading() {
        if (loadingPop == null) {
            loadingPop = new Dialog(this, R.style.NoTitleDialogStyle);
            loadingPop.setContentView(R.layout.popup_loading);
            loadingPop.setCanceledOnTouchOutside(false);
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
        return false;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (loadingPop != null && loadingPop.isShowing()) {
            loadingPop.dismiss();
        }
    }

    @Override
    protected TransitionMode getTransitionMode() {
        return TransitionMode.NONE;
    }

    @Override
    protected void eventBusSend(EventBusData data) {
        EventBus.getDefault().post(data);
    }

}
