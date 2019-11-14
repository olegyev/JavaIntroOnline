package by.yevstratyev.java_intro.module_02;

/*
 * Module 2. Algorithmization
 * Одномерные массивы
 * Задача 2
 * Условие:
 *  Дана последовательность действительных чисел a(1), a(2), ..., a(n).
 *  Заменить все ее члены, большие данного Z, этим числом.
 *  Подсчитать количество замен.
 */

public class Task02 {
    public static void main(String[] args) {
        final double Z = Math.random() * 200 - 100; // от -100 до 100 исключительно
        final int ARRAY_LENGTH = 2 + (int) (Math.random() * 9); // от 2 до 10 включительно
        double[] array = new double[ARRAY_LENGTH];
        int counter = 0;

        System.out.println("Z is " + Z);
        System.out.print("Array numbers: ");
        for (int i = 0; i < array.length; i++) {
            array[i] = Math.random() * 200 - 100; // от -100 до 100 исключительно
            System.out.print(array[i] + " | ");
        }

        System.out.print("\nWithout numbers > Z: ");
        for (int i = 0; i < array.length; i++) {
            if (array[i] > Z) {
                array[i] = Z;
                counter++;
            }
            System.out.print(array[i] + " | ");
        }
        System.out.print("\nNumber of replacements is " + counter);
    }
}