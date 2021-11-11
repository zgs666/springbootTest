package com.zgs.test.web_demo.util;

import org.springframework.cglib.beans.BeanCopier;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zgs
 * @date 2021年11月11日 17:00:00
 */
public class BeanCopierManager {
    private static final ConcurrentHashMap<String, BeanCopier> CACHE = new ConcurrentHashMap();

    public BeanCopierManager() {
    }

    public static BeanCopier get(Class<?> source, Class<?> target) {
        String key = genKey(source, target);
        BeanCopier beanCopier;
        if (CACHE.containsKey(key)) {
            beanCopier = (BeanCopier)CACHE.get(key);
        } else {
            beanCopier = BeanCopier.create(source, target, false);
            CACHE.put(key, beanCopier);
        }

        return beanCopier;
    }

    private static String genKey(Class<?> source, Class<?> target) {
        String var10000 = source.getName();
        return var10000 + target.getName();
    }
}
