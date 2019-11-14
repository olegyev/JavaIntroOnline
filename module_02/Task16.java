package by.yevstratyev.java_intro.module_02;

/*
 * Module 2. Algorithmization
 * Массивы массивов
 * Задача 6
 * Условие:
 *  Сформировать квадратную матрицу порядка n по заданному образцу (n - четное):
 *  1 1 1 ... 1 1 1
 *  0 1 1 ... 1 1 0
 *  0 0 1 ... 1 0 0
 *  . . . . .  . . .
 *  0 1 1 ... 1 1 0
 *  1 1 1 ... 1 1 1
 */

public class Task16 {
    public static void main(String[] args) {
        final byte N = (byte) ((3 + (byte) (Math.random() * 5)) * 2); // n = 6, 8, 10, 12, 14
        byte[][] matrix = new byte[N][N];

        System.out.println("n = " + N);
        System.out.println("Matrix: ");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = 1;
                if (i < (matrix.length / 2) && (j < i || j > ((matrix.length - 1) - i))) {
                    matrix[i][j] = 0;
                } else if (i >= (matrix.length / 2) && (j > i || j < ((matrix.length - 1) - i))) {
                    matrix[i][j] = 0;
                }
                System.out.print(matrix[i][j] + " | ");
            }
            System.out.println();
        }
    }
}