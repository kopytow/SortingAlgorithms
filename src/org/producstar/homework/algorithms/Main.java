package org.producstar.homework.algorithms;

import java.util.Arrays;
import java.util.Random;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Selection<Integer> selection = new Selection<>();
        Quick2way<Integer> quick2way = new Quick2way<>();
        OrderCheck<Integer> orderCheck = new OrderCheck<>();
        Integer[] a = new Integer[100000];
        Integer[] b = new Integer[100000];
        Integer[] s = new Integer[100000];
        initArray(a);
        initArray(b);
        initArray(s);
        // Сортировка стандартным алгоритмом Arrays.sort()
        long startTime = System.nanoTime();
        Arrays.sort(s);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("Время сортировки стандартным алгоритмом Arrays.sort() = " + duration + " нс");
        // Сортировка выбором
        startTime = System.nanoTime();
        selection.sort(a);
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        assert orderCheck.isSorted(a);
        System.out.println("Время сортировки выбором = " + duration + " нс");
        // Быстрая сортировка с трёхчастным разбиением
        startTime = System.nanoTime();
        quick2way.sort(b, false);
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        assert orderCheck.isSorted(a);
        System.out.println("Время быстрой сортировки с трёхчастным разбиением = " + duration + " нс");
        startTime = System.nanoTime();
        quick2way.sort(a);
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        assert orderCheck.isSorted(a);
        System.out.println("Время быстрой сортировки с трёхчастным разбиением\n с предварительным перемешиванием массива = " + duration + " нс");
    }

    /**
     * Инициализирует массив случайными числами.
     * @param a массив
     */
    private static void initArray(Integer[] a) {
        Random rand = new Random();
        for (int i = 0; i < a.length; i++) a[i] = rand.nextInt();
    }
}