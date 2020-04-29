package com.android.lib.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.AndroidViewModel;

import android.os.Bundle;

import com.android.baselib.ui.BaseActivity;
import com.android.lib.R;
import com.android.lib.databinding.ActivityAppbarLayoutBinding;

/**
 * Author: WangHao
 * Created On: 2020/04/29  13:34
 * Description: AppbarLayout 的使用
 */
public class AppbarLayoutActivity extends BaseActivity<ActivityAppbarLayoutBinding> {

    @Override
    protected boolean isStatusBarOverlap() {
        return true;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_appbar_layout;
    }

    @Override
    protected void initViewsAndEvents() {

    }

    @Override
    protected AndroidViewModel initViewModel() {
        return null;
    }
}
