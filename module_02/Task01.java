package by.yevstratyev.java_intro.module_02;

/*
 * Module 2. Algorithmization
 * Одномерные массивы
 * Задача 1
 * Условие:
 *  В массив A[N] занесены натуральные числа.
 *  Найти сумму тех элементов, которые кратны данному K.
 */

public class Task01 {
    public static void main(String[] args) {
        final int K = 1 + (int) (Math.random() * 10); // от 1 до 10 включительно
        final int ARRAY_LENGTH = 2 + (int) (Math.random() * 99); // от 2 до 100 включительно
        int[] array = new int[ARRAY_LENGTH];
        int result = 0;

        System.out.println("K is " + K);
        System.out.print("Array numbers: ");
        for (int i = 0; i < array.length; i++) {
            array[i] = 1 + (int) (Math.random() * 1000); // от 1 до 1000 включительно
            System.out.print(array[i] + " | ");
        }

        System.out.print("\nNumbers divisible by K: ");
        for (int number : array) {
            if (number % K == 0) {
                System.out.print(number + " | ");
                result += number;
            }
        }

        if (result != 0) {
            System.out.print("\nResult is " + result);
        } else {
            System.out.print("none");
        }
    }
}