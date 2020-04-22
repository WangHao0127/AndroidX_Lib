package com.android.lib;

import android.content.Context;

import org.junit.Test;
import org.mockito.Mock;

import java.util.List;

import static org.mockito.Mockito.*;

/**
 * Author: WangHao
 * Created On: 2020/04/22  13:58
 * Description:
 */
public class MyMockitoTest {

    @Test
    public void test(){
        List list = mock(List.class);

        //打桩Stud,在mock对象正在执行某个操作之前插入桩函数
        when(list.get(0)).thenReturn("成功了");
        System.out.println(list.get(0));

        when(list.get(1)).thenReturn(new RuntimeException());
        System.out.println(list.get(1));

        System.out.println(list.get(99));


        list.add("one");
//        list.clear();
        verify(list).add("one");//验证对应的操作是否被执行过
        verify(list).clear();

    }

}
