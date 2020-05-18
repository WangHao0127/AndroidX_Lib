package com.android.lib.ui;

import com.android.baselib.BR;
import com.android.baselib.data.AppBarData;
import com.android.baselib.ui.BaseActivity;
import com.android.baselib.util.VMUtils;
import com.android.lib.R;
import com.android.lib.databinding.ActivityMainBinding;
import com.android.lib.observer.MyLifeCycleObserver;
import com.android.lib.observer.UploadWorker;
import com.android.lib.viewmodel.MainViewModel;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Observer;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;

public class MainActivity extends BaseActivity<ActivityMainBinding,MainViewModel> {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViewsAndEvents() {
        databindingDemo();
        viewModelDemo();
        workManagerDemo();
    }

    /**
     * workManagerDemo实例
     */
    private void workManagerDemo() {
        //constraints设置任务触发条件
        Constraints constraints = new Constraints.Builder()
            .setRequiresCharging(true)
            .setRequiresStorageNotLow(true)
            .setRequiresBatteryNotLow(true)
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build();

        Data data = new Data.Builder().putString("input_data", "王浩你哈").build();
        OneTimeWorkRequest request = new OneTimeWorkRequest.Builder(UploadWorker.class)
            .setConstraints(constraints)
            .setInputData(data)
            .build();

        WorkManager.getInstance(this).enqueue(request);

        WorkManager.getInstance(this).getWorkInfoByIdLiveData(request.getId()).observe(
            MainActivity.this, workInfo -> {
                if (workInfo != null && workInfo.getState() == WorkInfo.State.SUCCEEDED) {
                    ToastUtils.showShort(workInfo.getOutputData().getString("output_data"));
                    LogUtils.e("onChanged-->", workInfo.getOutputData().getString("output_data"));
                }
            });
    }

    private void viewModelDemo() {

        //将ViewModel与DataBinding绑定
        mBinding.setMainData(mViewModel);
        //让xml内绑定的LiveData和Observer建立连接，数据改变，UI自动会更新
        mBinding.setLifecycleOwner(this);

        //LifeCycle
        getLifecycle().addObserver(new MyLifeCycleObserver());
    }

    private void databindingDemo() {
        AppBarData barData = new AppBarData("首页", "", R.drawable.icon_back);
        mBinding.setVariable(BR.appBar, barData);

        mBinding.setClick1(v -> mViewModel.getUserData());

        mBinding.setClick2(v -> {
            //            ObservableUser observableUser =new ObservableUser("","");
            //            observableUser.like.set("我喜欢打篮球2");
            //            observableUser.name.set("王浩2");
            mViewModel.queryWeather(mBinding.edit.getText().toString());
        });

    }

    @Override
    protected Class<? extends AndroidViewModel> getViewModel() {
        return MainViewModel.class;
    }
}
