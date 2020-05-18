package com.android.lib.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.AndroidViewModel;
import com.blankj.utilcode.util.ToastUtils;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

import android.os.Bundle;
import android.view.View;

import com.android.baselib.ui.BaseActivity;
import com.android.lib.R;
import com.android.lib.databinding.ActivityAppbarLayoutBinding;
import com.android.lib.viewmodel.MainViewModel;

/**
 * Author: WangHao
 * Created On: 2020/04/29  13:34
 * Description: AppbarLayout 的使用
 */
public class AppbarLayoutActivity extends BaseActivity<ActivityAppbarLayoutBinding,MainViewModel> {

    @Override
    protected boolean isStatusBarOverlap() {
        return true;
    }

    @Override
    protected Class<? extends AndroidViewModel> getViewModel() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_appbar_layout;
    }

    @Override
    protected void initViewsAndEvents() {
        setSupportActionBar(mBinding.toolbar);

        BottomSheetBehavior behavior = BottomSheetBehavior.from(mBinding.designBottomSheet1);
        behavior.setState(BottomSheetBehavior.STATE_HIDDEN);
        mBinding.setClick(c -> {
            if (behavior.getState() == BottomSheetBehavior.STATE_HIDDEN) {
                behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            } else if (behavior.getState() == BottomSheetBehavior.STATE_COLLAPSED) {
                behavior.setState(BottomSheetBehavior.STATE_HIDDEN);
            }
        });
        behavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View view, int i) {
                ToastUtils.showShort("onStateChanged");
            }

            @Override
            public void onSlide(@NonNull View view, float v) {
                ToastUtils.showShort("onSlide");
            }
        });
    }
}
