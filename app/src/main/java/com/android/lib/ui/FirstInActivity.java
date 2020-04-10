package com.android.lib.ui;

import android.os.Bundle;

import com.android.baselib.ui.BaseActivity;
import com.android.lib.R;
import com.android.lib.databinding.ActivityFristInBinding;

import androidx.lifecycle.AndroidViewModel;

public class FirstInActivity extends BaseActivity<ActivityFristInBinding> {

    @Override
    protected AndroidViewModel initViewModel() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_frist_in;
    }

    @Override
    protected void initViewsAndEvents() {
        mBinding.setOnClick1(c -> go(MainActivity.class));
    }
}
