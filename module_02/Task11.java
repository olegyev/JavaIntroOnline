package by.yevstratyev.java_intro.module_02;

/*
 * Module 2. Algorithmization
 * Массивы массивов
 * Задача 1
 * Условие:
 *  Дана матрица. Вывести на экран все нечетные столбцы,
 *  у которых первый элемент больше последнего.
 */

public class Task11 {
    public static void main(String[] args) {
        // Определение размера двумерного массива - от 2 до 10 элементов включительно в каждом измерении.
        final byte ROWS = (byte) (2 + (byte) (Math.random() * 9));
        final byte COLUMNS = (byte) (2 + (byte) (Math.random() * 9));
        byte[][] matrix = new byte[ROWS][COLUMNS];
        byte[] columnsIndices = new byte[COLUMNS / 2];

        // Заполнение двумерного массива числами от -10 до 10 включительно.
        System.out.println("Initial matrix:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = (byte) ((byte) (Math.random() * 21) - 10);
                System.out.print(matrix[i][j] + " | ");
            }
            System.out.println();
        }

        // Столбцы подсчитываются по индексу, начиная с 0.
        // Индексы искомых столбцов для более красивого вывода на консоль
        // сначала вносятся в массив.
        for (int j = 1, k = 0; j < matrix[0].length; j += 2) {
            if (matrix[0][j] > matrix[matrix.length - 1][j]) {
                columnsIndices[k] = (byte) j;
                k++;
            }
        }

        // Вывод искомых столбцов на консоль в виде матрицы.
        System.out.println("\nRequired columns:");
        if (columnsIndices[0] == 0) {
            System.out.println("no such columns");
        } else {
            for (byte[] rowIndex : matrix) {
                for (byte columnIndex : columnsIndices) {
                    if (columnIndex != 0) {
                        System.out.print(rowIndex[columnIndex] + " | ");
                    }
                }
                System.out.println();
            }
        }
    }
}