package com.android.lib.ui;

import com.android.baselib.BR;
import com.android.baselib.data.AppBarData;
import com.android.baselib.ui.BaseActivity;
import com.android.lib.R;
import com.android.lib.data.User;
import com.android.lib.databinding.ActivityMainBinding;
public class MainActivity extends BaseActivity<ActivityMainBinding> {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViewsAndEvents() {
        User user=new User("wanghao","是的吧衰减大");
        AppBarData barData =new AppBarData("首页","",R.drawable.icon_back);
        mBinding.setUser(user);
        mBinding.setVariable(BR.appBar,barData);
    }
}
