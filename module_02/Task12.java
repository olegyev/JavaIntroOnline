package by.yevstratyev.java_intro.module_02;

/*
 * Module 2. Algorithmization
 * Массивы массивов
 * Задача 2
 * Условие:
 *  Дана квадратная матрица. Вывести на экран элементы, стоящие на диагонали.
 */

public class Task12 {
    public static void main(String[] args) {
        final byte SIZE = (byte) (2 + (byte) (Math.random() * 9)); // от 2 до 10 включительно
        byte[][] matrix = new byte[SIZE][SIZE];

        // Заполнение двумерного массива числами от -10 до 10 включительно.
        System.out.println("Initial matrix: ");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = (byte) ((byte) (Math.random() * 21) - 10);
                System.out.print(matrix[i][j] + " | ");
            }
            System.out.println();
        }

        System.out.println("\nMain diagonal \\:");
        for (int i = 0; i < matrix.length; i++) {
            System.out.print(matrix[i][i] + " | ");
        }

        System.out.println("\n\nAntidiagonal /:");
        for (int i = 0; i < matrix.length; i++) {
            System.out.print(matrix[(matrix.length - 1) - i][i] + " | ");
        }
    }
}