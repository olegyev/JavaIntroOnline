package by.yevstratyev.java_intro.module_02;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * Module 2. Algorithmization
 * Массивы массивов
 * Задача 8
 * Условие:
 *  В числовой матрице поменять местами два любых столбца,
 *  т.е. все элементы одного столбца поставить на соответствующие
 *  им позиции другого, а элементы второго переместить в первый.
 *  Номера столбцов вводит пользователь с клавиатуры.
 */

public class Task18 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Определение размера двумерного массива - от 2 до 10 элементов включительно в каждом измерении.
            final byte ROWS = (byte) (2 + (byte) (Math.random() * 9));
            final byte COLUMNS = (byte) (2 + (byte) (Math.random() * 9));
            byte[][] matrix = new byte[ROWS][COLUMNS];
            byte firstColumnToMove;
            byte secondColumnToMove;

            // Ввод номеров столбцов для замены.
            while(true) {
                System.out.print("Please enter index of the first column (whole number from 0 to " + (COLUMNS - 1) + "): ");
                firstColumnToMove = scanner.nextByte();
                System.out.print("Please enter index of the second column (whole number from 0 to " + (COLUMNS - 1) + "): ");
                secondColumnToMove = scanner.nextByte();
                if (firstColumnToMove < 0 || secondColumnToMove < 0
                        || firstColumnToMove >= COLUMNS || secondColumnToMove >= COLUMNS
                            || firstColumnToMove == secondColumnToMove) {
                    System.err.println("You've entered wrong or equal number/-s. Please enter again!");
                } else {
                    break;
                }
            }

            // Заполнение двумерного массива числами от -10 до 10 включительно.
            System.out.println("\nInitial matrix:");
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[i][j] = (byte) ((byte) (Math.random() * 21) - 10);
                    System.out.print(matrix[i][j] + " | ");
                }
                System.out.println();
            }

            // Замена столбцов и вывод модифицированного двумерного массива.
            System.out.println("\nModified matrix:");
            for (int i = 0; i < matrix.length; i++) {
                byte tmp = matrix[i][secondColumnToMove];
                matrix[i][secondColumnToMove] = matrix[i][firstColumnToMove];
                matrix[i][firstColumnToMove] = tmp;
                for (int j = 0; j < matrix[0].length; j++) {
                    System.out.print(matrix[i][j] + " | ");
                }
                System.out.println();
            }

        } catch (InputMismatchException e) {
            System.err.println("Error! Only whole numbers can be entered!");
        }
    }
}