package com.zgs.test.web_demo.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zgs
 * @date 2021年11月12日 17:38:00
 */
public class SpringTest01 {
    public static void main(String[] args) {
        List list1 =new ArrayList();

        list1.add("A");

        list1.add("B");

        List list2 =new ArrayList();

        list2.add("c");

        list2.add("B");

/** 并集 **/

//list1.addAll(list2);

//System.out.println(list1);//运行结果：[A, B, B, C]

/** 无重复并集 **/

//list2.removeAll(list1);

//list1.addAll(list2);

//System.out.println(list1);//运行结果：[A, B, C]

/** 交集 **/

//list1.retainAll(list2);

//System.out.println(list1);//运行结果：[B]

/** 差集 **/

        list1.removeAll(list2);

        System.out.println(list1);//运行结果：[A]

    }
}
