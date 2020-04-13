package com.android.lib.ui;

import com.android.baselib.BR;
import com.android.baselib.data.AppBarData;
import com.android.baselib.ui.BaseActivity;
import com.android.baselib.util.VMUtils;
import com.android.lib.R;
import com.android.lib.databinding.ActivityMainBinding;
import com.android.lib.viewmodel.MainViewModel;

import androidx.lifecycle.AndroidViewModel;

public class MainActivity extends BaseActivity<ActivityMainBinding> {

    MainViewModel mModel;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViewsAndEvents() {
        databindingDemo();
        viewModelDemo();
    }

    private void viewModelDemo() {


        //将ViewModel与DataBinding绑定
        mBinding.setMainData(mModel);
        //让xml内绑定的LiveData和Observer建立连接，数据改变，UI自动会更新
        mBinding.setLifecycleOwner(this);
    }

    private void databindingDemo() {
        AppBarData barData =new AppBarData("首页","",R.drawable.icon_back);
        mBinding.setVariable(BR.appBar,barData);

        mBinding.setClick1(v -> mModel.getUserData());

        mBinding.setClick2(v->{
//            ObservableUser observableUser =new ObservableUser("","");
//            observableUser.like.set("我喜欢打篮球2");
//            observableUser.name.set("王浩2");
            mModel.queryWeather(mBinding.edit.getText().toString());
        });
    }

    @Override
    protected AndroidViewModel initViewModel() {
        mModel= (MainViewModel) VMUtils.obtainViewModel(this,MainViewModel.class);
        return null;
    }
}
