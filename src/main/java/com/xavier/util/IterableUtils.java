package com.xavier.util;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Iterable工具类</p>
 *
 * @author NewGr8Player
 * @date 2017/10/21
 */
public class IterableUtils {

    /**
     * <p>将JPA返回的Iterable对象转为List集合</p>
     *
     * @param iterable JPA返回的Iterable对象
     * @param <T> Entity
     * @return List&lt;T&gt;
     */
    public static <T> List<T> toList(Iterable<T> iterable) {
        if (iterable instanceof List) {
            return (List<T>) iterable;
        }
        ArrayList<T> list = new ArrayList<>();
        if (iterable != null) {
            for (T e : iterable) {
                list.add(e);
            }
        }
        return list;
    }

}
