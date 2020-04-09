package com.android.lib.data;

/**
 * Author: WangHao
 * Created On: 2020/04/09  13:17
 * Description:
 */
public class User {
    private String name;
    private String like;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(String name, String like) {
        this.name = name;
        this.like = like;
    }

    public void setLike(String like) {
        this.like = like;
    }

    public String getLike() {
        return like;
    }
}
