package com.android.baselib.bindingutil;

import android.widget.TextView;

import androidx.databinding.BindingAdapter;

/**
 * Author: WangHao
 * Created On: 2020/04/10  10:05
 * Description: 防止dataBinding数据双向绑定，产生ANR
 */
public class CustomBindingAdapter {

    @BindingAdapter("android:text")
    public static void setText(TextView view, CharSequence text) {
        CharSequence oldText = view.getText();

        if (!haveContentsChanged(text, oldText)) {
            return; // 数据没有变化不进行刷新视图
        }
        view.setText(text);
    }

    // 本工具类截取自官方源码
    private static boolean haveContentsChanged(CharSequence str1, CharSequence str2) {
        if ((str1 == null) != (str2 == null)) {
            return true;
        } else if (str1 == null) {
            return false;
        }
        final int length = str1.length();
        if (length != str2.length()) {
            return true;
        }
        for (int i = 0; i < length; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return true;
            }
        }
        return false;
    }
}
