package by.yevstratyev.java_intro.module_02;

/*
 * Module 2. Algorithmization
 * Массивы массивов
 * Задача 15
 * Условие:
 *  Найдите наибольший элемент матрицы и замените все нечетные элементы на него.
 */

public class Task25 {
    public static void main(String[] args) {
        final byte ROWS = (byte) (2 + (byte) (Math.random() * 9)); // от 2 до 10 включительно
        final byte COLUMNS = (byte) (2 + (byte) (Math.random() * 9)); // от 2 до 10 включительно
        byte[][] matrix = new byte[ROWS][COLUMNS];
        byte maxNumber = 0;

        System.out.println("Initial matrix:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = (byte) (Math.random() * 21); // от 0 до 20 включительно
                if (matrix[i][j] > maxNumber) {
                    maxNumber = matrix[i][j];
                }
                System.out.print(matrix[i][j] + " | ");
            }
            System.out.println();
        }

        System.out.println("\nMax number is " + maxNumber);

        System.out.println("\nModified matrix:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j <matrix[0].length; j++) {
                if (matrix[i][j] % 2 != 0) {
                    matrix[i][j] = maxNumber;
                }
                System.out.print(matrix[i][j] + " | ");
            }
            System.out.println();
        }
    }
}