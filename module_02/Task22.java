package by.yevstratyev.java_intro.module_02;

/*
 * Module 2. Algorithmization
 * Массивы массивов
 * Задача 12
 * Условие:
 *  Отсортировать строки матрицы по возрастанию и убыванию значений элементов.
 */

public class Task22 {
    public static void main(String[] args) {
        final byte ROWS = (byte) (2 + (byte) (Math.random() * 9)); // от 2 до 10 включительно
        final byte COLUMNS = (byte) (2 + (byte) (Math.random() * 9)); // от 2 до 10 включительно
        byte[][] matrix = new byte[ROWS][COLUMNS];

        System.out.println("Initial matrix:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = (byte) (Math.random() * 21); // от 0 до 20 включительно
                System.out.print(matrix[i][j] + " | ");
            }
            System.out.println();
        }

        System.out.println("\nRows sorted in ascending order:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                for (int k = matrix[0].length - 1; k > j; k--) {
                    if (matrix[i][j] > matrix[i][k]) {
                        byte tmp = matrix[i][j];
                        matrix[i][j] = matrix[i][k];
                        matrix[i][k] = tmp;
                    }
                }
                System.out.print(matrix[i][j] + " | ");
            }
            System.out.println();
        }

        System.out.println("\nRows sorted in descending order:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                for (int k = matrix[0].length - 1; k > j; k--) {
                    if (matrix[i][j] < matrix[i][k]) {
                        byte tmp = matrix[i][j];
                        matrix[i][j] = matrix[i][k];
                        matrix[i][k] = tmp;
                    }
                }
                System.out.print(matrix[i][j] + " | ");
            }
            System.out.println();
        }
    }
}