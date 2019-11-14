package by.yevstratyev.java_intro.module_02;

/*
 * Module 2. Algorithmization
 * Одномерные массивы
 * Задача 7
 * Условие:
 *  Даны действительные числа a(1), a(2), ..., a(2n).
 *  Найти max(a(1) + a(2n), a(2) + a(2n-1), ..., a(n) + a(n+1)).
 *  Например, при n = 5, в массиве из 10 элементов найти
 *  максимум (а(1) + а(10), а(2) + а(9), а(3) + а(8), а(4) + а(7), a(5) + a(6)).
 */

public class Task07 {
    public static void main(String[] args) {
        byte n = (byte) (2 + (byte) (Math.random() * 9)); // от 2 до 10 включительно
        final byte ARRAY_LENGTH = (byte) (n * 2);
        double[] array = new double[ARRAY_LENGTH];
        final byte MAX_LENGTH = (byte) 2;
        byte[] maxPair = new byte[MAX_LENGTH];
        double max = Double.MIN_VALUE;
        double controlNumber;

        System.out.println("n = " + n);
        System.out.print("Array numbers: ");
        for (int i = 0; i < array.length; i++) {
            array[i] = Math.random() * 200 - 100; // от -100 до 100 исключительно
            System.out.print(array[i] + " | ");
        }

        for (int i = 0; i < array.length; i++) {
            controlNumber = array[i] + array[array.length - (i + 1)];
            if (controlNumber > max) {
                max = controlNumber;
                maxPair[0] = (byte) i;
                maxPair[1] = (byte) (array.length - (i + 1));
            }
        }
        System.out.println("\nThe maximum pair (from 0): " + maxPair[0] + " + " + maxPair[1]);
        System.out.print("The maximum sum: " + max);
    }
}