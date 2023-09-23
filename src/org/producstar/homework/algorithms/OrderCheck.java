package org.producstar.homework.algorithms;

import java.util.stream.IntStream;

/**
 * Проверка упорядоченности массива.
 * @param <T> параметр элемента массива
 */
public class OrderCheck <T extends Comparable<T>>{

    /**
     * Проверка упорядоченности массива.
     * @param a проверяемый массив
     * @return истину, если массив упорядочен
     */
    public boolean isSorted(T[] a) {
        return IntStream.range(1, a.length).noneMatch(i -> a[i].compareTo(a[i - 1]) < 0);
    }

}
