package com.android.lib.data;

import androidx.databinding.ObservableField;

/**
 * Author: WangHao
 * Created On: 2020/04/09  13:17
 * Description:
 */
public class ObservableUser {
    public ObservableField<String> name = new ObservableField<>();
    public ObservableField<String> like = new ObservableField<>();

    public ObservableUser(String name, String like) {
        this.name.set(name);
        this.like.set(like);
    }

}
