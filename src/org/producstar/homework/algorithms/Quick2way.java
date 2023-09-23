package org.producstar.homework.algorithms;

import java.util.Random;

/**
 * Алгоритм быстрой сортировки с трёхчастным разбиением.
 * Взят из книги Роберт Седжвик, Кевин Уэйн. Алгоритмы на Java.
 * @param <T> тип элемента массива
 */
public class Quick2way<T extends Comparable<T>> {

    /**
     * Выполняет сортировку указанного массива
     * @param a сортируемый массив
     */
    public void sort(T[] a) {
        sort(a, true);
    }

    /**
     * Выполняет сортировку указанного массива
     * @param a сортируемый массив
     * @param shuffle если истина, массив будет перемешан
     */
    public void sort(T[] a, boolean shuffle) {
        if (shuffle) shuffleArray(a);
        sort(a, 0, a.length - 1);
    }

    /**
     * Перемешивает указанный массив.
     * Устранение зависимости от входных данных.
     * @param arr массив
     */
    private void shuffleArray(T[] arr) {
        Random rnd = new Random();
        for (int i = arr.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            T temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;
        }
    }

    /**
     * Выполняет сортировку подмассива.
     * @param a подмассив
     * @param lo от
     * @param hi до
     */
    private void sort(T[] a, int lo, int hi) {
        if (hi <= lo) return;
        int lt = lo, i = lo + 1, gt = hi;
        T v = a[lo];
        while (i <= gt) {
            int cmp = a[i].compareTo(v);
            if (cmp < 0) exchange(a, lt++, i++);
            else if (cmp > 0) exchange(a, i, gt--);
            else i++;
        }
        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
    }

    /**
     * Выполняет перестановку.
     * @param a массив, в котором выполняется перестановка
     * @param i индекс элемента, который будет заменён j-м элементом
     * @param j индекс элемента, который будет заменён i-м элементом
     */
    private void exchange(T[] a, int i, int j) {
        T t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
