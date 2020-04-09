package com.android.baselib.base;

import android.content.Context;

import androidx.multidex.MultiDex;
import androidx.multidex.MultiDexApplication;
import com.blankj.utilcode.util.Utils;

/**
 * Author: WangHao
 * Created On: 2020/04/08  16:22
 * Description:
 */
public class BaseLibApplication extends MultiDexApplication {

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);

        //万能工具类初始化
        Utils.init(this);
    }
}
