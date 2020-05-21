package com.android.lib.ui;

import com.android.baselib.ui.BaseActivity;
import com.android.lib.R;
import com.android.lib.databinding.ActivityFragmentTestBinding;
import com.android.lib.viewmodel.MainViewModel;

import androidx.lifecycle.AndroidViewModel;

public class FragmentTestActivity extends BaseActivity<ActivityFragmentTestBinding, MainViewModel> {

    @Override
    protected Class<? extends AndroidViewModel> getViewModel() {
        return MainViewModel.class;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_fragment_test;
    }

    @Override
    protected void initViewsAndEvents() {

    }
}
