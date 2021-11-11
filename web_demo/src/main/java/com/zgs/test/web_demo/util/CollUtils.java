package com.zgs.test.web_demo.util;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author zgs
 * @date 2021年11月11日 16:57:00
 */
public class CollUtils {
    private static final Predicate<Collection<?>> IS_EMPTY = (coll) -> {
        return coll == null || coll.isEmpty();
    };

    public CollUtils() {
    }

    public static <T, K> List<K> toList(Collection<T> coll, Function<T, K> func) {
        return isEmpty(coll) ? Collections.emptyList() : (List)coll.stream().map(func).collect(Collectors.toList());
    }

    public static <T, K> Set<K> toSet(Collection<T> coll, Function<T, K> func) {
        return isEmpty(coll) ? Collections.emptySet() : (Set)coll.stream().map(func).collect(Collectors.toSet());
    }

    public static <T, K> List<K> convertList(Collection<T> coll, Function<T, K> func) {
        return isEmpty(coll) ? Collections.emptyList() : (List)coll.stream().map(func).collect(Collectors.toList());
    }

    public static <T, K> List<K> filterConvertToList(Collection<T> coll, Predicate<T> predicate, Function<T, K> func) {
        return isEmpty(coll) ? Collections.emptyList() : (List)coll.stream().filter(predicate).map(func).collect(Collectors.toList());
    }

    public static boolean isEmpty(Collection<?> coll) {
        return IS_EMPTY.test(coll);
    }

    public static boolean isEmpty(Map<?, ?> map) {
        return map == null || map.isEmpty();
    }

    public static <T, K> Map<K, T> convertMap(List<T> coll, Function<T, K> func) {
        return isEmpty((Collection)coll) ? Collections.emptyMap() : (Map)coll.stream().collect(Collectors.toMap(func, Function.identity(), (k1, k2) -> {
            return k1;
        }));
    }

    public static <T, K> Map<K, List<T>> convertMultiMap(List<T> coll, Function<T, K> func) {
        return isEmpty((Collection)coll) ? Collections.emptyMap() : (Map)coll.stream().collect(Collectors.groupingBy(func, Collectors.toList()));
    }

    public static <T, K extends CharSequence> String joining(List<T> coll, Function<T, K> func, String split) {
        return isEmpty((Collection)coll) ? null : (String)coll.stream().map(func).collect(Collectors.joining(split));
    }
}
