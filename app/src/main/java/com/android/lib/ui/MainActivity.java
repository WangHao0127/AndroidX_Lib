package com.android.lib.ui;

import android.view.View;

import com.android.baselib.BR;
import com.android.baselib.data.AppBarData;
import com.android.baselib.ui.BaseActivity;
import com.android.lib.R;
import com.android.lib.data.ObservableUser;
import com.android.lib.databinding.ActivityMainBinding;
public class MainActivity extends BaseActivity<ActivityMainBinding> {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViewsAndEvents() {
        ObservableUser observableUser =new ObservableUser("wanghao","是的吧衰减大");
        AppBarData barData =new AppBarData("首页","",R.drawable.icon_back);
        mBinding.setObservableUser(observableUser);
        mBinding.setVariable(BR.appBar,barData);

        mBinding.setClick1(v -> {
            observableUser.like.set("我喜欢打篮球");
            observableUser.name.set("王浩");
        });
        mBinding.setClick2(v->{
            observableUser.like.set("我喜欢打篮球2");
            observableUser.name.set("王浩2");
        });
    }
}
