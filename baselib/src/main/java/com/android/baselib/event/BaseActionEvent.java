package com.android.baselib.event;

/**
 * Author: WangHao
 * Created On: 2020/04/10  15:15
 * Description: 用于向View层传递Action的Model
 */
public class BaseActionEvent extends BaseEvent {

    public static final int SHOW_LOADING_DIALOG = 1;

    public static final int DISMISS_LOADING_DIALOG = 2;

    public static final int SHOW_TOAST = 3;

    public static final int FINISH = 4;

    public static final int FINISH_WITH_RESULT_OK = 5;

    private String mMessage;

    public BaseActionEvent(int action) {
        super(action);
    }

    public String getMessage() {
        return mMessage;
    }

    public void setMessage(String message) {
        mMessage = message;
    }
}
