package com.android.baselib.event;

/**
 * Author: WangHao
 * Created On: 2020/04/10  15:15
 * Description: 消息驱动，需要一个用于抽象消息类型的Event类
 */
public class BaseEvent {

    private int mAction;

    public BaseEvent(int action) {
        mAction = action;
    }

    public int getAction() {
        return mAction;
    }

}
