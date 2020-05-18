package com.android.lib.ui;

import com.android.baselib.ui.BaseActivity;
import com.android.lib.R;
import com.android.lib.databinding.ActivityConstraintBinding;
import com.android.lib.viewmodel.MainViewModel;

import androidx.lifecycle.AndroidViewModel;

public class ConstraintActivity extends BaseActivity<ActivityConstraintBinding,MainViewModel> {

    @Override
    protected Class<? extends AndroidViewModel> getViewModel() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_constraint;
    }

    @Override
    protected void initViewsAndEvents() {

    }

}
