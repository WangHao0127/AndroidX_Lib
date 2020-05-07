package com.android.lib.ui;

import com.android.baselib.ui.BaseActivity;
import com.android.lib.R;
import com.android.lib.databinding.ActivityConstraintBinding;

import androidx.lifecycle.AndroidViewModel;

public class ConstraintActivity extends BaseActivity<ActivityConstraintBinding> {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_constraint;
    }

    @Override
    protected void initViewsAndEvents() {

    }

    @Override
    protected AndroidViewModel initViewModel() {
        return null;
    }
}
