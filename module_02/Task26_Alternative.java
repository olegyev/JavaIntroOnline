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

// В данном варианте решения задачи программа выводит на консоль по одному магическому квадрату любого порядка.

public class Task26_Alternative {
    public static void main(String[] args) {
        int n;
        System.out.print("Please enter square size (natural number starting with 3): ");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                n = Integer.parseInt(reader.readLine());
                if (n != 1 && n < 3) {
                    System.out.print("Magic squares " + n + "x" + n + " do not exist! Enter again: ");
                } else if (n == 1) {
                    System.out.print("Your \"magic square\" includes only 1. Try again: ");
                } else {
                    break;
                }
            }

            System.out.println("Here is your magic square: ");

            printMagicSquareOnConsole(n);

        } catch (NumberFormatException e) {
            System.err.print("Only whole number can be entered!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printMagicSquareOnConsole(int n) {
        if (n % 2 != 0) {
            printMagicSquare(createOddMagicSquare(n));
        } else {
            if (n % 4 == 0) {
                printMagicSquare(createMagicSquareDivisibleByFour(n));
            } else {
                printMagicSquare(createEvenMagicSquare(n));
            }
        }
    }

    private static int[][] createOddMagicSquare(int n) {
        int[][] magicSquare = new int[n][n];
        int i = 0;
        int j = n / 2;
        for (int k = 1; k <= n * n; k++) {
            magicSquare[i][j] = k;
            if (k % n == 0) {
                i++;
            } else {
                i--;
                j++;
                if (i == -1) {
                    i = n - 1;
                }
                if (j >= n) {
                    j = 0;
                }
            }
        }
        return magicSquare;
    }

    private static int[][] createMagicSquareDivisibleByFour(int n) {
        int[][] magicSquare = new int[n][n];
        int i;
        int j;
        int k = 1;
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                magicSquare[i][j] = k;
                k++;
            }
        }
        j = 1;
        int m = n / 2 - 1;
        for (i = 0; i <= m; i++) {
            for (k = 0; k <= m / 2; k++) {
                if (j == m + 1) {
                    j = 1;
                } else if (j == m + 2) {
                    j = 0;
                }
                int s = (n - 1) - i;
                int t = (n - 1) - j;
                swapElements(i, j, s, t, magicSquare);
                swapElements(i, t, s, j, magicSquare);
                j += 2;
            }
        }
        return magicSquare;
    }

    private static int[][] createEvenMagicSquare(int n) {
        int[][] magicSquare = new int[n][n];
        int i;
        int j;
        int s;
        int t;
        int k = 1;
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                magicSquare[i][j] = k;
                k++;
            }
        }
        int r = ((n / 2 - 1) / 2) - 1;
        int m = (n / 2) - 1;
        for (i = 0; i <= m; i++) {
            j = i;
            for (k = 0; k <= r; k++) {
                if (j > m) {
                    j = 0;
                }
                s = (n - 1) - i;
                t = (n - 1) - j;
                swapElements(i, j, s, t, magicSquare);
                swapElements(i, t, s, j, magicSquare);
                j++;
            }
        }
        i = 0;
        j = r + 1;
        for (k = 0; k <= m; k++) {
            if (j > m) {
                j = 0;
            }
            s = (n - 1) - i;
            swapElements(i, j, s, j, magicSquare);
            i++;
            j++;
        }
        i = 0;
        j = r + 2;
        for (k = 0; k <= m; k++) {
            if (j > m) {
                j = 0;
            }
            t = (n - 1) - j;
            swapElements(i, j, i, t, magicSquare);
            i++;
            j++;
        }
        return magicSquare;
    }

    private static void swapElements(int a, int b, int c, int d, int[][] magicSquare) {
        int tmp = magicSquare[a][b];
        magicSquare[a][b] = magicSquare[c][d];
        magicSquare[c][d] = tmp;
    }

    private static void printMagicSquare(int[][] magicSquare) {
        for (int i = 0; i < magicSquare.length; i++) {
            for (int j = 0; j < magicSquare.length; j++) {
                System.out.print(magicSquare[i][j] + " | ");
            }
            System.out.println();
        }
    }
}