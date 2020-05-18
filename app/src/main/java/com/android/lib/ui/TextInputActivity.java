package com.android.lib.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.AndroidViewModel;
import com.blankj.utilcode.util.RegexUtils;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.widget.TableLayout;

import com.android.baselib.ui.BaseActivity;
import com.android.lib.R;
import com.android.lib.databinding.ActivityTextInputBinding;
import com.android.lib.viewmodel.MainViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: WangHao
 * Created On: 2020/04/27  16:16
 * Description: TextInputLayout 的使用
 */
public class TextInputActivity extends BaseActivity<ActivityTextInputBinding, MainViewModel> {

    @Override
    protected Class<? extends AndroidViewModel> getViewModel() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_text_input;
    }

    @Override
    protected boolean isStatusBarOverlap() {
        return true;
    }

    @Override
    protected void initViewsAndEvents() {
        mBinding.etEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!RegexUtils.isEmail(s)) {
                    mBinding.textinputlayoutEmail.setError("邮箱格式错误");
                    mBinding.textinputlayoutEmail.setErrorEnabled(true);
                } else {
                    mBinding.textinputlayoutEmail.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        // 添加 tab item
        mBinding.tab.addTab(mBinding.tab.newTab().setText("TAB1"));
        mBinding.tab.addTab(mBinding.tab.newTab().setText("TAB2"));
        mBinding.tab.addTab(mBinding.tab.newTab().setText("TAB3"));
        mBinding.tab.addTab(mBinding.tab.newTab().setText("TAB4"));

        mBinding.setClick1(c -> {
            mBinding.drawer.openDrawer(Gravity.LEFT);
        });

    }

}
