package org.producstar.homework.algorithms;

/**
 * Алгоритм сортировки выбором.
 * Взят из книги Роберт Седжвик, Кевин Уэйн. Алгоритмы на Java.
 * @param <T> тип элементов массива
 */
public class Selection<T extends Comparable<T>> {

    /**
     * Сортирует указанный массив по возрастанию.
     * @param a сортируемый массив
     */
    public void sort(T[] a) {
        int N = a.length; //длина массива
        for (int i = 0; i < N; i++) {
            // Перестановка a[i] с наименьшим элементом из a[i+1 ... N]
            int min = i; //индекс минимального элемента
            for (int j = i + 1; j < N; j++) {
                if (less(a[j], a[min])) min = j;
            }
            exchange(a, i, min);
        }
    }

    /**
     * Сравнивает два значения.
     * @param v сравниваемое значение
     * @param w эталон
     * @return истину, если v меньше w
     */
    private boolean less(T v, T w) {
        return v.compareTo(w) < 0;
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
