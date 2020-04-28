package com.android.lib.ui;

import android.os.Build;
import android.view.View;

import com.android.baselib.ui.BaseActivity;
import com.android.baselib.util.SbUtil;
import com.android.baselib.weight.snackbar.TBSnackbar;
import com.android.lib.R;
import com.android.lib.databinding.ActivityTestSnackbarUtilsBinding;

import androidx.lifecycle.AndroidViewModel;
/**
 * Author: WangHao
 * Created On: 2020/04/27  16:16
 * Description: Snackbar 的使用
 */
public class TestSnackbarUtilsActivity extends
    BaseActivity<ActivityTestSnackbarUtilsBinding> {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_test_snackbar_utils;
    }

    @Override
    protected void initViewsAndEvents() {
        mBinding.setClick1(c ->
            SbUtil.showCustomTop(mBinding.coordinator, "This is a top snack!")
        );
        mBinding.setClick2(c ->
            SbUtil.showCustomBOTTOM(mBinding.coordinator, "This is a bottom snack!")
        );
        mBinding.setClick3(c -> {
            SbUtil.showCustomWindow(this, "This is a fitsystemwindow snack!");
        });
        mBinding.setClick4(
            c -> SbUtil.showIconLeft(mBinding.coordinator, "This is a left icon snack!", R.mipmap.ic_launcher));

        mBinding.setClick5(c -> {
                final TBSnackbar snackbar = TBSnackbar
                    .make(mBinding.coordinator, "This is a action snack!",
                        TBSnackbar.LENGTH_INDEFINITE, TBSnackbar.STYLE_SHOW_TOP);
                snackbar.setAction("Action", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        snackbar.dismiss();
                    }
                });
                snackbar.show();
            }
        );
    }

    @Override
    protected AndroidViewModel initViewModel() {
        return null;
    }
}
