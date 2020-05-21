package com.android.lib.ui;

import com.android.baselib.ui.BaseActivity;
import com.android.lib.R;
import com.android.lib.data.User;
import com.android.lib.databinding.ActivityFristInBinding;
import com.android.lib.viewmodel.MainViewModel;

import androidx.lifecycle.AndroidViewModel;

public class FirstInActivity extends BaseActivity<ActivityFristInBinding, MainViewModel> {

    @Override
    protected Class<? extends AndroidViewModel> getViewModel() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_frist_in;
    }

    @Override
    protected void initViewsAndEvents() {
        mBinding.setOnClick1(c ->
            go(MainActivity.class)
        );
        mBinding.setOnClick2(c ->
            go(DesignSupportActivity.class));
        mBinding.setOnClick3(c -> go(ConstraintActivity.class));
        mBinding.setOnClick4(c -> go(PageListActivity.class));
        mBinding.setOnClick5(c -> go(FragmentTestActivity.class));
        mBinding.setOnClick6(c->go(RoomActivity.class));
        new User.Builder()
            .mFirstName("")
            .mLastName("")
            .age(13)
            .mGender("男")
            .mPhoneNo("15756856985")
            .build();
    }

}
