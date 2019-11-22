package by.yevstratyev.java_intro.module_02;

import java.math.BigDecimal;

/*
 * Module 2. Algorithmization
 * Одномерные массивы. Сортировки
 * Задача 6
 * Условие:
 *  Сортировка Шелла.
 *  Дан массив n действительных чисел. Требуется упорядочить его по возрастанию.
 *  Делается это следующим образом: сравниваются два соседних элемента a(i) и a(i+1).
 *  Если a(i) <= a(i+1), то продвигаются на один элемент вперед. Если a(i) > a(i+1),
 *  то производится перестановка и сдвигаются на один элемент назад.
 *  Составить алгоритм этой сортировки.
 */

public class Task32 {
    public static void main(String[] args) {
        // Определение длины массива (от 2 до 10 включительно).
        final int ARRAY_LENGTH = (int) (2 + Math.random() * 9);
        double[] array = new double[ARRAY_LENGTH];

        // Заполнение массива числами (от -10 до 10 исключительно).
        System.out.println("Initial array:");
        for (int i = 0; i < ARRAY_LENGTH; i++) {
            array[i] = Math. random() * 20 - 10;
            System.out.print(array[i] + " | ");
        }

        // Создание копии несортированного массива для второго метода.
        double[] arrayCopy = new double[ARRAY_LENGTH];
        for (int i = 0; i < ARRAY_LENGTH; i++) {
            arrayCopy[i] = array[i];
        }

        Task32 solution = new Task32();
        solution.shellSort(array);
        solution.taskSort(arrayCopy);
    }

    // Сортировка Шелла с шагом d(1) = n/2, d(i) = d(i-1)/2, d(k) = 1.
   public void shellSort(double[] array) {
        BigDecimal a;
        BigDecimal b;

        for (int step = array.length / 2; step >= 1; step /= 2) {
            for (int inc = 0; inc < step; inc++) {
                for (int i = inc; i < array.length - step; i += step) {
                    for (int j = i + step; j - step >= 0; j -= step) {
                        a = new BigDecimal(array[j - step]);
                        b = new BigDecimal(array[j]);
                        if (a.compareTo(b) > 0) {
                            double tmp = array[j];
                            array[j] = array[j - step];
                            array[j - step] = tmp;
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        a = null;
        b = null;

        System.out.println("\nShell sort:");
        for (double element : array) {
            System.out.print(element + " | ");
        }
    }

    // Сортировка в соответствии с условием задачи.
    public void taskSort(double[] array) {
        BigDecimal a;
        BigDecimal b;

        for (int i = 0; i < array.length - 1;) {
            a = new BigDecimal(array[i + 1]);
            b = new BigDecimal(array[i]);
            if (a.compareTo(b) >= 0) {
                i++;
            } else {
                double tmp = array[i];
                array[i] = array[i  + 1];
                array[i + 1] = tmp;
                if (i > 0) {
                    i--;
                }
            }
        }
        a = null;
        b = null;

        System.out.println("\nTask sort:");
        for (double element : array) {
            System.out.print(element + " | ");
        }
    }
}