package com.android.lib.ui;

import android.widget.Button;
import android.widget.TextView;

import com.android.lib.R;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;


/**
 * Author: WangHao
 * Created On: 2020/04/22  14:45
 * Description:
 */
@RunWith(RobolectricTestRunner.class)
public class MainActivityTest {

    @Test
    public void showClick() {
        MainActivity activity = Robolectric.setupActivity(MainActivity.class);
        Button btn = activity.findViewById(R.id.btn);
        TextView tv1 = activity.findViewById(R.id.tv1);
        btn.performClick();

        Assert.assertEquals("wanghao", tv1.getText().toString());

    }

}