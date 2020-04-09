package com.android.baselib.data;

/**
 * Author: WangHao
 * Created On: 2020/04/09  15:47
 * Description: 通用标题的数据类
 */
public class AppBarData {

    private String title;
    private String title_right;
    private int title_iv_right;

    public AppBarData(String title, String title_right, int title_iv_right) {
        this.title = title;
        this.title_right = title_right;
        this.title_iv_right = title_iv_right;
    }

    public AppBarData(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle_right() {
        return title_right;
    }

    public void setTitle_right(String title_right) {
        this.title_right = title_right;
    }

    public int getTitle_iv_right() {
        return title_iv_right;
    }

    public void setTitle_iv_right(int title_iv_right) {
        this.title_iv_right = title_iv_right;
    }
}
