package by.yevstratyev.java_intro.module_02;

/*
 * Module 2. Algorithmization
 * Одномерные массивы. Сортировки
 * Задача 4
 * Условие:
 *  Сортировка обменами.
 *  Дана последовательность чисел a(1) <= a(2) <= ... <= a(n).
 *  Требуется переставить числа в порядке убывания.
 *  Для этого сравниваются два соседних числа a(i) и a(i+1).
 *  Если a(i) < a(i+1), то делается перестановка.
 *  Так продолжается до тех пор, пока все элементы не станут расположены в порядке убывания.
 *  Составить алгоритм сортировки, подсчитывая при этом количество перестановок.
 */

public class Task30 {
    public static void main(String[] args) {
        final int ARRAY_LENGTH = (int) (2 + Math.random() * 9); // от 2 до 10 включительно
        int[] array = new int[ARRAY_LENGTH];
        int permutationsCounter = 0;

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
        for (int i = ARRAY_LENGTH - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] < array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                    permutationsCounter++;
                }
            }
        }

        System.out.println("\nSorted array:");
        for (int i : array) {
            System.out.print(i + " | ");
        }

        System.out.println("\nNumber of permutations: " + permutationsCounter);
    }
}