package com.android.baselib.ui;

import com.android.baselib.base.BaseLibApplication;

import androidx.fragment.app.Fragment;
import com.squareup.leakcanary.RefWatcher;

/**
 * @author: WangHao
 * Created On: 2020/04/24  11:30
 * Description:
 */
public class BaseFragment extends Fragment {

    @Override
    public void onDestroy() {
        super.onDestroy();
        RefWatcher refWatcher = BaseLibApplication.getRefWatcher(getActivity());
        refWatcher.watch(this);
    }
}
