package by.yevstratyev.java_intro.module_02;

/*
 * Module 2. Algorithmization
 * Декомпозиция с использованием методов (подпрограммы)
 * Задача 12
 * Условие:
 *  Даны натуральные числа K и N. Написать метод (методы) формирования массива A,
 *  элементами которого являются числа, сумма цифр которых равна K и которые не больше N.
 */

public class Task46 {
    public static void main(String[] args) {
        Task46 solution = new Task46();
        final int K = solution.generateRandomNum();
        final int N = solution.generateRandomNum();

        try {
            int[] digitsSumArray = solution.createDigitsSumArray(K, N);
            System.out.println("Result for K = " + K + " and N = " + N + ":");
            solution.printArray(digitsSumArray);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    // От 1 до 100 включительно.
    public int generateRandomNum() {
        return (int) (1 + Math.random() * 100);
    }

    public int[] createDigitsSumArray(final int K, final int N) throws Exception {
        int index = 0;
        int[] digitsSumArray = new int[index];

        // Я не включал однозначные числа: например, 6 для K = 6.
        for (int i = 1; i * 10 < N; i++) {
            if (K >= N) {
                break;
            }

            for (int j = 0; j <= 9; j++) {
                if (i + j == K) {
                    digitsSumArray = addToArray(digitsSumArray, index++, i * 10 + j);
                }

                if (i * 10 + j > N) {
                    break;
                }
            }
        }

        if (digitsSumArray.length == 0) {
            throw new Exception("No such numbers for K = " + K + " and N = " + N + " were found.");
        }

        return digitsSumArray;
    }

    public void printArray(int[] array) {
        for (int element : array) {
            System.out.print(element + " | ");
        }
    }

    private int[] addToArray(int[] oldArray, int lastIndex, int numToAdd) {
        int[] newArray = new int[lastIndex + 1];

        for (int i = 0; i < oldArray.length; i++) {
            newArray[i] = oldArray[i];
        }
        newArray[lastIndex] = numToAdd;
        oldArray = null;

        return newArray;
    }
}