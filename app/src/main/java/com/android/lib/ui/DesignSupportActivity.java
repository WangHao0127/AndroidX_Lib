package com.android.lib.ui;

import android.view.View;

import com.android.baselib.ui.BaseActivity;
import com.android.lib.R;
import com.android.lib.databinding.ActivityDesignSupportBinding;

import androidx.lifecycle.AndroidViewModel;
/**
 * Author: WangHao
 * Created On: 2020/04/27  16:16
 * Description: Design Support 的导航页
 */
public class DesignSupportActivity extends BaseActivity<ActivityDesignSupportBinding> {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_design_support;
    }

    @Override
    protected void initViewsAndEvents() {
        mBinding.toolbar.setNavigationOnClickListener(v -> finish());

            mBinding.setClick1(c-> go(TestSnackbarUtilsActivity.class));
            mBinding.setClick2(c->go(TextInputActivity.class));
            mBinding.setClick3(c->go(AppbarLayoutActivity.class));
    }

    @Override
    protected AndroidViewModel initViewModel() {
        return null;
    }

}
