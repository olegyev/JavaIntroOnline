package by.yevstratyev.java_intro.module_02;

/*
 * Module 2. Algorithmization
 * Массивы массивов
 * Задача 3
 * Условие:
 *  Дана матрица. Вывести k-ю строку и p-й столбец матрицы.
 */

public class Task13 {
    public static void main(String[] args) {
        // Определение размера двумерного массива - от 2 до 10 элементов включительно в каждом измерении.
        final byte ROWS = (byte) (2 + (byte) (Math.random() * 9));
        final byte COLUMNS = (byte) (2 + (byte) (Math.random() * 9));
        byte[][] matrix = new byte[ROWS][COLUMNS];

        // Определение индексов выводимых строки и столбца.
        final byte K = (byte) (Math.random() * ROWS);
        System.out.println("Row k (index) = " + K);
        final byte P = (byte) (Math.random() * COLUMNS);
        System.out.println("Column p (index) = " + P);

        // Заполнение двумерного массива числами от -10 до 10 включительно.
        System.out.println("\nInitial matrix:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = (byte) ((byte) (Math.random() * 21) - 10);
                System.out.print(matrix[i][j] + " | ");
            }
            System.out.println();
        }

        System.out.println("\nRequired row:");
        for (int j = 0; j < matrix[K].length; j++) {
            System.out.print(matrix[K][j] + " | ");
        }

        System.out.println("\n\nRequired column:");
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(matrix[i][P] + " | ");
        }
    }
}