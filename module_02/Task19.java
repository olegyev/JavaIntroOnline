package by.yevstratyev.java_intro.module_02;

/*
 * Module 2. Algorithmization
 * Массивы массивов
 * Задача 9
 * Условие:
 *  Задана матрица неотрицательных чисел.
 *  Посчитать сумму элементов в каждом столбце.
 *  Определить, какой столбец содержит максимальную сумму.
 */

public class Task19 {
    public static void main(String[] args) {
        final byte ROWS = (byte) (2 + (byte) (Math.random() * 9)); // от 2 до 10 включительно
        final byte COLUMNS = (byte) (2 + (byte) (Math.random() * 9)); // от 2 до 10 включительно
        double[][] matrix = new double[ROWS][COLUMNS];
        double ctrl = 0;
        double sum = 0;
        byte maxColumn = 0;

        System.out.println("Matrix:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = Math.random() * 10; // вещественные числа от 0 включительно до 10 исключительно
                System.out.print(matrix[i][j] + " | ");
            }
            System.out.println();
        }

        System.out.println();
        for (int j = 0; j < matrix[0].length; j++) {
            for (int i = 0; i < matrix.length; i++) {
                ctrl += matrix[i][j];
            }
            System.out.println("The sum of column " + j + " is " + ctrl);
            if (ctrl > sum) {
                sum = ctrl;
                maxColumn = (byte) j;
            }
            ctrl = 0;
        }
        System.out.println("\nThe max column has index " + maxColumn + ", the sum of its elements is " + sum);
    }
}