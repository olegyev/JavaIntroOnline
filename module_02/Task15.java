package by.yevstratyev.java_intro.module_02;

/*
 * Module 2. Algorithmization
 * Массивы массивов
 * Задача 5
 * Условие:
 *  Сформировать квадратную матрицу порядка n по заданному образцу (n - четное):
 *   1   1  1 ... 1 1 1
 *   2   2  2 ... 2 2 0
 *   3   3  3 ... 3 0 0
 *  n-1 n-1 0 ... 0 0 0
 *   n   0  0 ... 0 0 0
 */

public class Task15 {
    public static void main(String[] args) {
        final byte N = (byte) ((1 + (byte) (Math.random() * 5)) * 2); // n = 2, 4, 6, 8, 10
        byte[][] matrix = new byte[N][N];

        System.out.println("n = " + N);
        System.out.println("Matrix: ");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = (byte) (i + 1);
                if (j >= matrix.length - i) {
                    matrix[i][j] = 0;
                }
                System.out.print(matrix[i][j] + " | ");
            }
            System.out.println();
        }
    }
}