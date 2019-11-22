package by.yevstratyev.java_intro.module_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Module 2. Algorithmization
 * Массивы массивов
 * Задача 16
 * Условие:
 *  Магическим квадратом порядка n называется квадратная матрица размером nxn,
 *  составленная из чисел 1, 2, 3, ..., n^2 так, что суммы по каждому столбцу,
 *  каждой строке и каждой из двух больших диагоналей равны между собой. Построить такой квадрат.
 *  Пример магического квадрата порядка 3:
 *          6 1 8
 *          7 5 3
 *          2 9 4
 */

// Программа выводит на консоль все возможные магические квадраты заданного порядка.
// Программа осуществляет все возможные перестановки чисел в одномерном массиве [1 ... n^2].
// После каждой перестановки элементы одномерного массива в соответствии с расположением их индексов
// в матрице проверяются на равенство магической константе по строкам, столбцам и двум большим диагоналям.
// Пример расположения индексов массива в матрице 3х3 (числа означают индексы одномерного массива длиной 9):
//          0 1 2
//          3 4 5
//          6 7 8
// Быстро и уверенно программа работает для квадрата 3x3 (время выполнения ок. 1500 миллисекунд).
// Для выявления всех магических квадратов большего порядка простым перебором, как в данной программе,
// потребуется гораздо больше времени в силу огромного количества возможных перестановок
// (например, для квадрата 4х4 существует 16! = 20 922 789 888 000 вариантов, на перебор которых при мощности моего
// компьютера уйдет около трех лет).
// В классе by.yevstratyev.java_intro.module_02.Task26_Alternative
// представлена программа для вывода одного магического квадрата любого порядка.

public class Task26 {
    private static int n;
    private static int magicConstant;
    private static int magicCounter;
    private static boolean isMagic;

    public static void main(String[] args) {
        Task26 solution = new Task26();
        System.out.print("Please enter square size (natural number starting with 3): ");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            solution.printAllMagicSquaresOnConsole(Integer.parseInt(reader.readLine()));
        } catch (NumberFormatException e) {
            System.err.print("Only whole number can be entered!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printAllMagicSquaresOnConsole(int n) {
        Task26.n = n;
        if (n != 1 && n < 3) {
            System.err.print("Magic squares " + n + "x" + n + " do not exist!");
        } else if (n == 1) {
            System.err.print("Your \"magic square\" includes only 1.");
        } else {
            magicConstant = (n * ((int) Math.pow(n, 2) + 1)) / 2;
            int[] array = new int[(int) Math.pow(n, 2)];

            for (int i = 0; i < array.length; i++) {
                array[i] = i + 1;
            }

            System.out.println("\nMagic squares " + n + "x" + n + ":");

            permuteArrayElements(array, array.length);

            System.out.println("We've found " + magicCounter + " magic squares " + n + "x" + n + ".");
        }
    }

    private void permuteArrayElements(int[] array, int arrayLength) {
        if (arrayLength == 1) {
            checkIfMagic(array);
        } else {
            for (int i = 0; i < arrayLength - 1; i++) {
                permuteArrayElements(array, arrayLength - 1);
                if (arrayLength % 2 == 0) {
                    swapArrayElements(array, i, arrayLength - 1);
                } else {
                    swapArrayElements(array, 0, arrayLength - 1);
                }
            }
            permuteArrayElements(array, arrayLength - 1);
        }
    }

    private void swapArrayElements(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    private void checkIfMagic(int[] array) {
       checkRows(array);
        if (isMagic) {
            checkColumns(array);
            if (isMagic) {
                checkMainDiagonal(array);
                if (isMagic) {
                    checkAntiDiagonal(array);
                    if (isMagic) {
                        printMagicSquare(array);
                        magicCounter++;
                    }
                }
            }
        }
    }

    private void checkRows(int[] rows) {
        for (int k = 0; k <= rows.length - n; k += n) {
            int sum = 0;
            for (int i = k; i < k + n; i++) {
                sum += rows[i];
            }
            isMagic = sum == magicConstant;
            if (!isMagic) {
                return;
            }
        }
    }

    private void checkColumns(int[] columns) {
        for (int k = 0; k < n; k++) {
            int sum = 0;
            for (int i = k; i < columns.length; i += n) {
                sum += columns[i];
            }
            isMagic = sum == magicConstant;
            if (!isMagic) {
                return;
            }
        }
    }

    private void checkMainDiagonal(int[] mainDiagonal) {
        int sum = 0;
        for (int i = 0; i < mainDiagonal.length; i += n + 1) {
            sum += mainDiagonal[i];
        }
        isMagic = sum == magicConstant;
    }

    private void checkAntiDiagonal(int[] antiDiagonal) {
        int sum = 0;
        for (int i = n - 1; i <= n * (n - 1); i += n - 1) {
            sum += antiDiagonal[i];
        }
        isMagic = sum == magicConstant;
    }

    private void printMagicSquare(int[]array) {
        int[][] magicSquare = new int[n][n];
        int k = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                magicSquare[i][j] = array[k];
                System.out.print(magicSquare[i][j] + " | ");
                k++;
            }
            System.out.println();
        }
        System.out.println();
    }
}