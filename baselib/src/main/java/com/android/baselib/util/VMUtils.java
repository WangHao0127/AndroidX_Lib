package com.android.baselib.util;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;

/**
 * Author: WangHao
 * Created On: 2020/04/10  13:51
 * Description: ViewModel的实例化工具
 */
public class VMUtils {

    public static ViewModel obtainViewModel(FragmentActivity activity, Class clazz) {
        return ViewModelProviders.of(activity).get(clazz);
    }

    public static ViewModel obtainViewModel(Fragment fragment, Class clazz) {
        return ViewModelProviders.of(fragment).get(clazz);
    }
}
