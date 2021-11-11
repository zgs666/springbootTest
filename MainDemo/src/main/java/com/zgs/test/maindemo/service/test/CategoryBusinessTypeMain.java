package com.zgs.test.maindemo.service.test;

/**
 * @author zgs
 * @date 2021年10月12日 11:01:00
 */
public class CategoryBusinessTypeMain {
    public static void main(String[] args) {
        String text = CategoryBusinessType.from("1001").getText();
        System.out.println(text);
    }
}
