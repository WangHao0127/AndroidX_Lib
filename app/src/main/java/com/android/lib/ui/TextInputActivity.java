package com.android.lib.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.AndroidViewModel;
import com.blankj.utilcode.util.RegexUtils;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import com.android.baselib.ui.BaseActivity;
import com.android.lib.R;
import com.android.lib.databinding.ActivityTextInputBinding;

/**
 * Author: WangHao
 * Created On: 2020/04/27  16:16
 * Description: TextInputLayout 的使用
 */
public class TextInputActivity extends BaseActivity<ActivityTextInputBinding> {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_text_input;
    }

    @Override
    protected void initViewsAndEvents() {
        mBinding.etEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!RegexUtils.isEmail(s)){
                    mBinding.textinputlayoutEmail.setError("邮箱格式错误");
                    mBinding.textinputlayoutEmail.setErrorEnabled(true);
                }else {
                    mBinding.textinputlayoutEmail.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Override
    protected AndroidViewModel initViewModel() {
        return null;
    }
}
