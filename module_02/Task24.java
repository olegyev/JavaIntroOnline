package by.yevstratyev.java_intro.module_02;

/*
 * Module 2. Algorithmization
 * Массивы массивов
 * Задача 14
 * Условие:
 *  Сформировать случайную матрицу m x n, состоящую из нулей и единиц,
 *  причем в каждом столбце число единиц равно номеру столбца.
 */

public class Task24 {
    public static void main(String[] args) {
        // Определение размера матрицы, от 2 до 10 в каждом измерении включительно (число строк <= числа столбцов).
        byte m;
        byte n;
        do {
            m = (byte) (2 + (byte) (Math.random() * 9));
            n = (byte) (2 + (byte) (Math.random() * 9));
        } while (m <= n);
        byte[][] matrix = new byte[m][n];

        // Создание массива для рандомных индексов строк, в которые будут вносится единицы.
        byte[] randomRowIndicesArray = new byte[m];
        for (int i = 0; i < randomRowIndicesArray.length; i++) {
            randomRowIndicesArray[i] = (byte) i;
        }

        // Единицы вносятся по столбцам (номер столбца = его индексу); индексы строк генерируются рандомно.
        for (int j = 0; j < matrix[0].length; j++) {
            for (int k = 1; k < randomRowIndicesArray.length; k++) {
                byte rnd = (byte) (Math.random() * k);
                byte tmp = randomRowIndicesArray[k];
                randomRowIndicesArray[k] = randomRowIndicesArray[rnd];
                randomRowIndicesArray[rnd] = tmp;
            }

            for (int i = j; i > 0; i--) {
                byte index = randomRowIndicesArray[i];
                matrix[index][j] = 1;
            }
        }

        // Вывод матрицы на консоль.
        System.out.println("Required matrix:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " | ");
            }
            System.out.println();
        }
    }
}