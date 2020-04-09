package com.android.baselib.data;

public final class EventBusData {

    private Action action;
    private Object data;

    public Action getAction() {
        return this.action;
    }

    public Object getData() {
        return this.data;
    }

    public EventBusData(EventBusData.Action action, Object data) {
        this.action = action;
        this.data = data;
    }

    public enum Action {
        DELETE_ALL_MESSAGE_IN_SESSION;

        public EventBusData createEventBusData() {
            return this.createEventBusData(null);
        }

        public EventBusData createEventBusData(Object data) {
            return new EventBusData(this, data);
        }
    }
}

