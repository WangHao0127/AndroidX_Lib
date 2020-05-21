package com.android.baselib.util;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.savedstate.SavedStateRegistryOwner;

/**
 * Author: WangHao
 * Created On: 2020/04/10  13:51
 * Description: ViewModel的实例化工具
 */
public class VMUtils {

    public static ViewModel obtainViewModel(FragmentActivity activity, Class clazz) {
        if (clazz==null){
            return null;
        }
        return new ViewModelProvider(activity).get(clazz);
    }

    public static ViewModel obtainViewModel(Fragment fragment, Class clazz) {
        if (clazz==null){
            return null;
        }
        return new ViewModelProvider(fragment).get(clazz);
    }

    public static ViewModel obtainViewModelHandler(FragmentActivity activity, Class clazz,
        SavedStateRegistryOwner owner) {
        if (clazz==null){
            return null;
        }
        return new ViewModelProvider(activity,new SavedStateViewModelFactory(activity.getApplication(),owner)).get(clazz);
    }
}
