package com.android.baselib.base;

import android.content.Context;

import androidx.multidex.MultiDex;
import androidx.multidex.MultiDexApplication;
import com.blankj.utilcode.util.Utils;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/**
 * Author: WangHao
 * Created On: 2020/04/08  16:22
 * Description:
 * @author WangHao
 */
public class BaseLibApplication extends MultiDexApplication {

    private RefWatcher refWatcher;
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);

        //万能工具类初始化
        Utils.init(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)){
            return;
        }
        LeakCanary.install(this);
        refWatcher= setupLeakCanary();
    }

    private RefWatcher setupLeakCanary() {
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return RefWatcher.DISABLED;
        }
        return LeakCanary.install(this);
    }

    public static RefWatcher getRefWatcher(Context context) {
        BaseLibApplication leakApplication = (BaseLibApplication) context.getApplicationContext();
        return leakApplication.refWatcher;
    }
}
