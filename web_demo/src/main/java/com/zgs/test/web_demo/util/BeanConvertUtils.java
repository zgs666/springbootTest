package com.zgs.test.web_demo.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.cglib.core.Converter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Supplier;

/**
 * @author zgs
 * @date 2021年11月11日 17:00:00
 */
public class BeanConvertUtils {


    /**
     * 复制对象的属性
     *
     * @param source 源对象
     * @param target 目标对象
     */
    public static void copyProperties(Object source, Object target) {
        BeanCopier beanCopier = BeanCopierManager.get(source.getClass(), target.getClass());
        beanCopier.copy(source, target, null);
    }

    public static <S, T> T convertTo(S source, Supplier<T> targetSupplier) {
        return convertTo(source, targetSupplier, null);
    }

    /**
     * 转换对象
     *
     * @param source         源对象
     * @param targetSupplier 目标对象供应方
     * @param callBack       回调方法
     * @param <S>            源对象类型
     * @param <T>            目标对象类型
     * @return 目标对象
     */
    public static <S, T> T convertTo(S source, Supplier<T> targetSupplier, ConvertCallBack<S, T> callBack) {
        if (null == source || null == targetSupplier) {
            return null;
        }
        T target = targetSupplier.get();
        BeanCopier beanCopier = BeanCopierManager.get(source.getClass(), target.getClass());
        beanCopier.copy(source, target, null);
        if (callBack != null) {
            callBack.callBack(source, target);
        }
        return target;
    }

    public static <S, T> List<T> convertListTo(List<S> sources, Supplier<T> targetSupplier) {
        return convertListTo(sources, targetSupplier, null);
    }

    /**
     * 转换对象
     *
     * @param sources        源对象list
     * @param targetSupplier 目标对象供应方
     * @param callBack       回调方法
     * @param <S>            源对象类型
     * @param <T>            目标对象类型
     * @return 目标对象list
     */
    public static <S, T> List<T> convertListTo(List<S> sources, Supplier<T> targetSupplier, ConvertCallBack<S, T> callBack) {
        if (null == sources || null == targetSupplier) {
            return null;
        }

        List<T> list = new ArrayList<>(sources.size());
        for (S source : sources) {
            list.add(convertTo(source, targetSupplier, callBack));
        }
        return list;
    }

    /**
     * 回调接口
     *
     * @param <S> 源对象类型
     * @param <T> 目标对象类型
     */
    @FunctionalInterface
    public interface ConvertCallBack<S, T> {
        /**
         * 回调方法
         *
         * @param t target对象
         * @param s source对象
         */
        void callBack(S t, T s);
    }
}
