package com.android.baselib.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.android.baselib.R;
import com.android.baselib.data.EventBusData;

import org.greenrobot.eventbus.EventBus;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.AndroidViewModel;
import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.KeyboardUtils;
import com.blankj.utilcode.util.ScreenUtils;
import com.gyf.immersionbar.ImmersionBar;

/**
 * Author: WangHao
 * Created On: 2020/04/08  15:27
 * Description:
 */
public abstract class BaseAppCompatActivity extends AppCompatActivity {

    public static final int NON_CODE = -1;

    protected String TAG = null;

    /**
     * Screen information
     */
    protected int mScreenWidth = 0;
    protected int mScreenHeight = 0;
    protected float mScreenDensity = 0.0f;

    //沉浸式状态栏
    protected ImmersionBar mImmersionBar;

    public Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        TAG = this.getClass().getSimpleName();
        mContext = BaseAppCompatActivity.this;

        /*判断是否设置转场动画*/
        if (isOverridePendingTransition()) {
            _overridePendingTransition();
        }

        super.onCreate(savedInstanceState);

        getDataBinding();

        /*getBundleExtras*/
        Bundle extras = getIntent().getExtras();
        if (null != extras) {
            getBundleExtras(extras);
        }

        /*EventBus.register*/
        if (isBindEventBusHere()) {
            EventBus.getDefault().register(this);
        }

        /* 获取屏幕信息 */
        getDisplayInfo();

        /* 判断是否使用沉浸式状态栏 */
        if (isImmersionBarEnabled()) {
            initImmersionBar();
        }

        if (hasTitleBar()) {
            setCustomTitle(getTitle());
            onNavigateClick();
        }
        initViewModel();
        initViewModelEvent();
        initViewsAndEvents();
    }

    protected void initImmersionBar() {
        mImmersionBar = ImmersionBar.with(this);
        mImmersionBar.init();
        if (ImmersionBar.isSupportStatusBarDarkFont()) {
            mImmersionBar.statusBarDarkFont(true, 0.2f).keyboardEnable(true).init();
        }
    }

    private void getDisplayInfo() {
        mScreenDensity = ScreenUtils.getScreenDensity();
        mScreenHeight = ScreenUtils.getScreenHeight();
        mScreenWidth = ScreenUtils.getScreenWidth();
    }

    @Override
    public void finish() {
        super.finish();
        KeyboardUtils.hideSoftInput(this);
        if (isOverridePendingTransition()) {
            _overridePendingTransition();
        }
    }

    @Override
    protected void onDestroy() {
        if (isBindEventBusHere()) {
            EventBus.getDefault().unregister(this);
        }
        super.onDestroy();
    }

    /**
     * Activity 跳转
     *
     * @param clazz  目标activity
     * @param bundle 传递参数
     * @param finish 是否结束当前activity
     */
    private void _goActivity(Class<? extends Activity> clazz, Bundle bundle, int requestCode,
        boolean finish) {
        if (null == clazz) {
            throw new IllegalArgumentException("you must pass a target activity where to go.");
        }
        Intent intent = new Intent(this, clazz);
        if (null != bundle) {
            intent.putExtras(bundle);
        }
        if (requestCode > NON_CODE) {
            startActivityForResult(intent, requestCode);
        } else {
            startActivity(intent);
        }
        if (finish) {
            finish();
        }
    }

    /**
     * startActivity
     *
     * @param clazz target Activity
     */
    protected void go(Class<? extends AppCompatActivity> clazz) {
        _goActivity(clazz, null, NON_CODE, false);
    }

    /**
     * startActivity with bundle
     *
     * @param clazz target Activity
     */
    protected void go(Class<? extends AppCompatActivity> clazz, Bundle bundle) {
        _goActivity(clazz, bundle, NON_CODE, false);
    }

    /**
     * startActivity then finish this
     *
     * @param clazz target Activity
     */
    protected void goAndFinish(Class<? extends AppCompatActivity> clazz) {
        _goActivity(clazz, null, NON_CODE, true);
    }

    /**
     * startActivity with bundle and then finish this
     *
     * @param clazz  target Activity
     * @param bundle bundle extra
     */
    protected void goAndFinish(Class<? extends AppCompatActivity> clazz, Bundle bundle) {
        _goActivity(clazz, bundle, NON_CODE, true);
    }

    /**
     * startActivityForResult
     */
    protected void goForResult(Class<? extends AppCompatActivity> clazz, int requestCode) {
        _goActivity(clazz, null, requestCode, false);
    }

    /**
     * startActivityForResult with bundle
     */
    protected void goForResult(Class<? extends AppCompatActivity> clazz, Bundle bundle,
        int requestCode) {
        _goActivity(clazz, bundle, requestCode, false);
    }

    /**
     * startActivityForResult then finish this
     */
    protected void goForResultAndFinish(Class<? extends AppCompatActivity> clazz, int requestCode) {
        _goActivity(clazz, null, requestCode, true);
    }

    /**
     * startActivityForResult with bundle and then finish this
     */
    protected void goForResultAndFinish(Class<? extends AppCompatActivity> clazz, Bundle bundle,
        int requestCode) {
        _goActivity(clazz, bundle, requestCode, true);
    }

    /**
     * 设置转场动画
     */
    private void _overridePendingTransition() {
        switch (getTransitionMode()) {
            case LEFT:
                overridePendingTransition(R.anim.left_in, R.anim.left_out);
                break;
            case RIGHT:
                overridePendingTransition(R.anim.right_in, R.anim.right_out);
                break;
            case TOP:
                overridePendingTransition(R.anim.top_in, R.anim.top_out);
                break;
            case BOTTOM:
                overridePendingTransition(R.anim.bottom_in, R.anim.bottom_out);
                break;
            case SCALE:
                overridePendingTransition(R.anim.scale_in, R.anim.scale_out);
                break;
            case FADE:
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                break;
            case NONE:
            default:
                break;
        }
    }

    protected abstract void initViewModel();

    protected abstract void initViewModelEvent();

    protected abstract void getDataBinding();

    protected abstract Class<? extends AndroidViewModel> getViewModel();

    protected abstract void eventBusSend(EventBusData data);

    protected abstract void onNavigateClick();

    protected abstract void setCustomTitle(CharSequence title);

    protected abstract boolean hasTitleBar();

    /*bind layout resource file*/
    protected abstract int getLayoutId();

    /*页面逻辑处理*/
    protected abstract void initViewsAndEvents();

    /*是否可以使用沉浸式*/
    protected boolean isImmersionBarEnabled() {
        return true;
    }

    /*是否和状态栏重叠：默认不重叠*/
    protected boolean isStatusBarOverlap() {
        return false;
    }

    /*是否注册EventBus*/
    protected boolean isBindEventBusHere() {
        return false;
    }

    /*extras:传递过来的参数*/
    protected void getBundleExtras(Bundle extras) {}

    /*页面进入的动画效果*/
    protected abstract boolean isOverridePendingTransition();

    /*转场动画*/
    protected abstract TransitionMode getTransitionMode();

    /*overridePendingTransition mode: 转场动画*/
    public enum TransitionMode {
        NONE, LEFT, RIGHT, TOP, BOTTOM, SCALE, FADE
    }
}
