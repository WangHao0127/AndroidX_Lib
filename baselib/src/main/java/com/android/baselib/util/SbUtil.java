package com.android.baselib.util;

import android.app.Activity;
import android.os.Build;
import android.view.View;

import com.android.baselib.weight.snackbar.TBSnackbar;

import androidx.annotation.DrawableRes;
import androidx.annotation.RequiresApi;

/**
 * Author: WangHao
 * Created On: 2020/04/27  16:16
 * Description: Snackbar 的工具类
 */
public class SbUtil {

    /*显示顶部的普通Snackbar*/
    public static void showCustomTop(View view, String msg) {
        TBSnackbar.make(view, msg, TBSnackbar.LENGTH_SHORT, TBSnackbar.STYLE_SHOW_TOP).show();
    }

    /*显示底部的普通Snackbar*/
    public static void showCustomBOTTOM(View view, String msg) {
        TBSnackbar.make(view, msg, TBSnackbar.LENGTH_SHORT, TBSnackbar.STYLE_SHOW_BOTTOM).show();
    }

    /*显示沉浸式状态栏的Snackbar*/
    public static void showCustomWindow(Activity activity, String msg) {
        TBSnackbar.make(activity.getWindow().getDecorView(), msg, TBSnackbar.LENGTH_SHORT,
            TBSnackbar.STYLE_SHOW_TOP_FITSYSTEMWINDOW).show();
    }

    /*显示带左边图标的Snackbar*/

    public static void showIconLeft(View view, String msg, @DrawableRes int res) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            TBSnackbar.make(view, msg, TBSnackbar.LENGTH_SHORT, TBSnackbar.STYLE_SHOW_TOP)
                .setIconLeft(res, 24).show();
        }
    }

    /*显示带Action的Snackbar*/
    public static void showActionCustom(View view, String msg,
        final View.OnClickListener listener, String actionMsg) {
        TBSnackbar.make(view, msg, TBSnackbar.LENGTH_INDEFINITE, TBSnackbar.STYLE_SHOW_TOP)
            .setAction(actionMsg, listener).show();
    }
}
