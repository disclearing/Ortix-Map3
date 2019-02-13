/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Function
 *  com.google.common.collect.Iterables
 *  com.google.common.collect.Ordering
 */
package com.customhcf.util;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import com.google.common.collect.Ordering;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MapSorting
{
    private static final Function EXTRACT_KEY;
    private static final Function EXTRACT_VALUE;

    public static <T, V extends Comparable<V>> List<Map.Entry<T, V>> sortedValues(final Map<T, V> map) {
        return sortedValues(map, Ordering.natural());
    }

    public static <T, V> List<Map.Entry<T, V>> sortedValues(final Map<T, V> map, final Comparator<V> valueComparator) {
        return Ordering.from((Comparator)valueComparator).onResultOf((Function)extractValue()).sortedCopy((Iterable)map.entrySet());
    }

    public static <T, V> Iterable<T> keys(final List<Map.Entry<T, V>> entryList) {
        return Iterables.transform((Iterable)entryList, (Function)extractKey());
    }

    public static <T, V> Iterable<V> values(final List<Map.Entry<T, V>> entryList) {
        return Iterables.transform((Iterable)entryList, (Function)extractValue());
    }

    private static <T, V> Function<Map.Entry<T, V>, T> extractKey() {
        return MapSorting.EXTRACT_KEY;
    }

    private static <T, V> Function<Map.Entry<T, V>, V> extractValue() {
        return MapSorting.EXTRACT_VALUE;
    }

    static {
        EXTRACT_KEY = new Function<Map.Entry<Object, Object>, Object>() {
            public Object apply(final Map.Entry<Object, Object> input) {
                return (input == null) ? null : input.getKey();
            }
        };
        EXTRACT_VALUE = new Function<Map.Entry<Object, Object>, Object>() {
            public Object apply(final Map.Entry<Object, Object> input) {
                return (input == null) ? null : input.getValue();
            }
        };
    }
}