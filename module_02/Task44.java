package by.yevstratyev.java_intro.module_02;

/*
 * Module 2. Algorithmization
 * Декомпозиция с использованием методов (подпрограммы)
 * Задача 10
 * Условие:
 *  Дано натуральное число N. Написать метод (методы) для формирования массива,
 *  элементами которого являются цифры числа N.
 */

public class Task44 {
    public static void main(String[] args) {
        Task44 solution = new Task44();
        int num = solution.generateRandomNum();
        int[] digitsArray = solution.createDigitsArray(num);

        System.out.println("Number = " + num);
        solution.printDigitsArray(digitsArray);
    }

    // От 1 до 1.000.000 включительно.
    public int generateRandomNum() {
        return (int) (1 + Math.random() * 1_000_000);
    }

    public int[] createDigitsArray(int num) {
        int[] digitsArray = new int[calcArrayLength(num)];
        for (int i = digitsArray.length - 1; i >= 0; i--, num /= 10) {
            digitsArray[i] = num % 10;
        }
        return digitsArray;
    }

    public void printDigitsArray(int[] digitsArray) {
        System.out.println("Digits:");
        for (int element : digitsArray) {
            System.out.print(element + " | ");
        }
    }

    private int calcArrayLength(int num) {
        int counter = 0;
        for (int i = num; i > 0; i /= 10) {
            counter++;
        }
        return counter;
    }
}