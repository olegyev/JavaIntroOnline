package by.yevstratyev.java_intro.module_02;

/*
 * Module 2. Algorithmization
 * Массивы массивов
 * Задача 10
 * Условие:
 *  Найти положительные элементы главной диагонали квадратной матрицы.
 */

public class Task20 {
    public static void main(String[] args) {
        final byte N = (byte) (2 + (byte) (Math.random() * 9)); // от 2 до 10 включительно
        byte[][] matrix = new byte[N][N];
        boolean flag = false;

        System.out.println("Matrix:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = (byte) ((byte) (Math.random() * 21) - 10); // от -10 до 10 включительно
                System.out.print(matrix[i][j] + " | ");
            }
            System.out.println();
        }

        System.out.println("\nPositive elements of main diagonal: ");
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][i] > 0) {
                System.out.print(matrix[i][i] + " | ");
                flag = true;
            }
        }
        if (!flag) {
            System.out.print("no such elements");
        }
    }
}