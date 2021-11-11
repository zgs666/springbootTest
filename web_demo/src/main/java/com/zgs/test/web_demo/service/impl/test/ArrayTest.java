package com.zgs.test.web_demo.service.impl.test;

/**
 * @author zgs
 * @date 2021年11月10日 16:08:00
 */
public class ArrayTest {
    public static void main(String[] args) {
        StringBuffer s = new StringBuffer();
        int[] arr = new int[]{1,2,3,4};
        for (int i : arr) {
            s.append(i+",");
        }
        String ids = s.substring(0,s.length()-1);
        System.out.println(ids);
    }
}
