package by.yevstratyev.java_intro.module_02;

/*
 * Module 2. Algorithmization
 * Массивы массивов
 * Задача 4
 * Условие:
 *  Сформировать квадратную матрицу порядка n по заданному образцу (n - четное):
 *  1  2   3  ... n
 *  n n-1 n-2 ... 1
 *  1  2   3  ... n
 *  n n-1 n-2 ... 1
 */

public class Task14 {
    public static void main(String[] args) {
        final byte N = (byte) ((1 + (byte) (Math.random() * 5)) * 2); // n = 2, 4, 6, 8, 10
        byte[][] matrix = new byte[N][N];

        System.out.println("n = " + N);
        System.out.println("Matrix: ");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (i % 2 == 0) {
                    matrix[i][j] = (byte) (j + 1);
                } else {
                    matrix[i][j] = (byte) (matrix.length - j);
                }
                System.out.print(matrix[i][j] + " | ");
            }
            System.out.println();
        }
    }
}