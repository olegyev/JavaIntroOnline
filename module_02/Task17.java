package by.yevstratyev.java_intro.module_02;

/*
 * Module 2. Algorithmization
 * Массивы массивов
 * Задача 7
 * Условие:
 *  Сформировать квадратную матрицу порядка N по правилу:
 *  A[I, J] = sin((I^2 - J^2) / N)
 *  и подсчитать количество положительных элементов в ней.
 */

public class Task17 {
    public static void main(String[] args) {
        final byte N = (byte) (2 + (byte) (Math.random() * 9)); // от 2 до 10 включительно
        double[][] matrix = new double[N][N];
        byte positiveNumbersCounter = 0;

        System.out.println("n = " + N);
        System.out.println("Matrix: ");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                // Значения в радианах.
                matrix[i][j] = Math.sin((Math.pow(i, 2) - Math.pow(j, 2)) / N);
                System.out.print(matrix[i][j] + " | ");
                if (matrix[i][j] > 0) {
                    positiveNumbersCounter++;
                }
            }
            System.out.println();
        }
        System.out.println("Number of positive numbers: " + positiveNumbersCounter);
    }
}