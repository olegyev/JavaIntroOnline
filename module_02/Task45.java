package by.yevstratyev.java_intro.module_02;

/*
 * Module 2. Algorithmization
 * Декомпозиция с использованием методов (подпрограммы)
 * Задача 11
 * Условие:
 *  Написать метод (методы), определяющий, в каком из данных двух чисел больше цифр.
 */

public class Task45 {
    public static void main(String[] args) {
        int numOne = generateRandomNum();
        int numTwo = generateRandomNum();

        int[] numsLength = calcNumOfDigits(numOne, numTwo);
        int longerNum = compareLength(numsLength);

        if (longerNum == 1) {
            System.out.println(numOne + " has " + numsLength[0] + " digits and this is more than " + numTwo + " with " + numsLength[1] + " digits.");
        } else if (longerNum == -1) {
            System.out.println(numTwo + " has " + numsLength[1] + " digits and this is more than " + numOne + " with " + numsLength[0] + " digits.");
        } else {
            System.out.println("Numbers " +  numOne + " and " + numTwo + " have the same number of digits - " + numsLength[0] + ".");
        }
    }

    // От 1 до 1.000.000 включительно.
    public static int generateRandomNum() {
        return (int) (1 + Math.random() * 1_000_000);
    }

    public static int[] calcNumOfDigits(int numOne, int numTwo) {
        final int ARRAY_LENGTH = 2;
        int[] digitsCountArray = new int[ARRAY_LENGTH];
        int num;
        for (int i = 0; i < 2; i++) {
            int counter = 0;

            if (i == 0) {
                num = numOne;
            } else {
                num = numTwo;
            }

            while (num > 0) {
                counter++;
                num /= 10;
            }

            digitsCountArray[i] = counter;
        }

        return digitsCountArray;
    }

    public static int compareLength(int[] numOfDigits) {
        if (numOfDigits[0] > numOfDigits[1]) {
            return 1;
        } else if (numOfDigits[0] < numOfDigits[1]) {
            return -1;
        } else {
            return 0;
        }
    }
}