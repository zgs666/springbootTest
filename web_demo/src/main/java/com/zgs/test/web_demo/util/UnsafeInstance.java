package com.zgs.test.web_demo.util;

import jdk.internal.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author zgs
 * @date 2021年12月17日 16:40:00
 */
public class UnsafeInstance {
    public static Unsafe reflectGetUnsafe() {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            return (Unsafe) field.get(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
