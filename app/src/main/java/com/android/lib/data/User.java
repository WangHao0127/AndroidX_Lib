package com.android.lib.data;

/**
 * Author: WangHao
 * Created On: 2020/05/08  10:00
 * Description:Build模式
 */
public class User {
    private final String mFirstName;
    private final String mLastName;
    private final String mGender;
    private final int age;
    private final String mPhoneNo;

    private User(Builder builder) {
        mFirstName = builder.mFirstName;
        mLastName = builder.mLastName;
        mGender = builder.mGender;
        age = builder.age;
        mPhoneNo = builder.mPhoneNo;
    }

    public static final class Builder {
        private String mFirstName;
        private String mLastName;
        private String mGender;
        private int age;
        private String mPhoneNo;

        public Builder() {}

        public Builder mFirstName(String val) {
            mFirstName = val;
            return this;
        }

        public Builder mLastName(String val) {
            mLastName = val;
            return this;
        }

        public Builder mGender(String val) {
            mGender = val;
            return this;
        }

        public Builder age(int val) {
            age = val;
            return this;
        }

        public Builder mPhoneNo(String val) {
            mPhoneNo = val;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
