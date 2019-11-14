package by.yevstratyev.java_intro.module_02;

/*
 * Module 2. Algorithmization
 * Массивы массивов
 * Задача 13
 * Условие:
 *  Отсортировать столбцы матрицы по возрастанию и убыванию значений элементов.
 */

public class Task23 {
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

        // Алгоритм сравнивает все элементы строки 0 с соответствующими элементами строк n, n-1, n-2 ... до 0,
        // затем - все элементы строки 1 с элементами строк n, n-1, n-2 ... до 1, и т.д. до последней строки,
        // выводя поочередно на консоль строки, отсортированные по столбцам.
        System.out.println("\nColumns sorted in ascending order:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = matrix.length - 1; j >= i; j--) {
                for (int k = 0; k < matrix[0].length; k++) {
                    if (matrix[i][k] > matrix[j][k]) {
                        byte tmp = matrix[i][k];
                        matrix[i][k] = matrix[j][k];
                        matrix[j][k] = tmp;
                    }
                    if (j == i) {
                        System.out.print(matrix[i][k] + " | ");
                    }
                }
            }
            System.out.println();
        }

        System.out.println("\nColumns sorted in descending order:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = matrix.length - 1; j >= i; j--) {
                for (int k = 0; k < matrix[0].length; k++) {
                    if (matrix[i][k] < matrix[j][k]) {
                        byte tmp = matrix[i][k];
                        matrix[i][k] = matrix[j][k];
                        matrix[j][k] = tmp;
                    }
                    if (j == i) {
                        System.out.print(matrix[i][k] + " | ");
                    }
                }
            }
            System.out.println();
        }
    }
}