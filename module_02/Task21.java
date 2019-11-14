package by.yevstratyev.java_intro.module_02;

/*
 * Module 2. Algorithmization
 * Массивы массивов
 * Задача 11
 * Условие:
 *  Матрицу 10x20 заполнить случайными числами от 0 до 15.
 *  Вывести на экран саму матрицу и номера строк, в которых
 *  число 5 встречается три и более раз.
 */

public class Task21 {
    public static void main(String[] args) {
        final byte ROWS = 10;
        final byte COLUMNS = 20;
        byte[][] matrix = new byte[ROWS][COLUMNS];
        byte counter = 0;
        boolean flag = false;

        System.out.println("Matrix:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = (byte) (Math.random() * 16); // от 0 до 15 включительно
                System.out.print(matrix[i][j] + " | ");
            }
            System.out.println();
        }

        System.out.println("\nRows where 5 appears three and more times (indices from 0):");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 5) {
                    counter++;
                }
            }
            if (counter >= 3) {
                System.out.print(i + " | ");
                flag = true;
            }
            counter = 0;
        }
        if (!flag) {
            System.out.print("no such rows");
        }
    }
}