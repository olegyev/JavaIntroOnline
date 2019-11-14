package by.yevstratyev.java_intro.module_02;

/*
 * Module 2. Algorithmization
 * Одномерные массивы
 * Задача 4
 * Условие:
 *  Даны действительные числа a(1), a(2), ..., a(n).
 *  Поменять местами наибольший и наименьший элементы.
 */

public class Task04 {
    public static void main(String[] args) {
        final int ARRAY_LENGTH = 2 + (int) (Math.random() * 9); // от 2 до 10 включительно
        double[] array = new double[ARRAY_LENGTH];
        int maxIndex = 1;
        int minIndex = 1;

        System.out.print("Array numbers: ");
        for (int i = 0; i < array.length; i++) {
            array[i] = Math.random() * 200 - 100; // от -100 до 100 исключительно
            System.out.print(array[i] + " | ");
            if (array[i] > array[maxIndex]) {
                maxIndex = i;
            } else if (array[i] < array[minIndex]) {
                minIndex = i;
            }
        }

        System.out.println("\nMaximum's index: " + maxIndex);
        System.out.println("Minumum's index: " + minIndex);

        double tmp = array[maxIndex];
        array[maxIndex] =  array[minIndex];
        array[minIndex] = tmp;

        System.out.print("Modified array: ");
        for (double number : array) {
            System.out.print(number + " | ");
        }
    }
}