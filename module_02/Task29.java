package by.yevstratyev.java_intro.module_02;

/*
 * Module 2. Algorithmization
 * Одномерные массивы. Сортировки
 * Задача 3
 * Условие:
 *  Сортировка выбором.
 *  Дана последовательность чисел a(1) <= a(2) <= ... <= a(n).
 *  Требуется переставить элементы так, чтобы они были расположены по убыванию.
 *  Для этого в массиве, начиная с первого, выбирается наибольший элемент и ставится на первое место,
 *  а первый - на место наибольшего. Затем, начиная со второго, эта процедура повторяется.
 *  Написать алгоритм сортировки выбором.
 */

public class Task29 {
    public static void main(String[] args) {
        final int ARRAY_LENGTH = (int) (2 + Math.random() * 9); // от 2 до 10 включительно
        int[] array = new int[ARRAY_LENGTH];

        // Заполнение массива числами по возрастанию (от -10 до 10 включительно).
        for (int i = 0; i < ARRAY_LENGTH; i++) {
            int num = (int) (Math.random() * 21) - 10;
            if (i == 0) {
                array[i] = num;
            } else if (i > 0 && num >= array[i - 1]) {
                array[i] = num;
            } else {
                i--;
            }
        }

        System.out.println("Initial array:");
        for (int i : array) {
            System.out.print(i + " | ");
        }

        // Основная логика.
        System.out.println("\nSorted array:");
        for (int i = 0; i < ARRAY_LENGTH; i++) {
            int maxElement = array[i];
            int maxIndex = i;
            for (int j = i + 1; j < ARRAY_LENGTH; j++) {
                if (array[j] > maxElement) {
                    maxElement = array[j];
                    maxIndex = j;
                }
            }
            if (i != maxIndex) {
                int tmp = array[i];
                array[i] = array[maxIndex];
                array[maxIndex] = tmp;
            }
            System.out.print(array[i] + " | ");
        }
    }
}