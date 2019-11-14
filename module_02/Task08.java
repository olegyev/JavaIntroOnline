package by.yevstratyev.java_intro.module_02;

/*
 * Module 2. Algorithmization
 * Одномерные массивы
 * Задача 8
 * Условие:
 *  Дана последовательность целых чисел a(1), a(2), ..., a(n).
 *  Образовать новую последовательность, выбросив из исходной
 *  те члены, которые равны min(a(1), a(2), ..., a(n)).
 */

public class Task08 {
    public static void main(String[] args) {
        final int ARRAY_LENGTH = 2 + (int) (Math.random() * 9); // от 2 до 10 включительно
        int[] array = new int[ARRAY_LENGTH];
        int[] modifiedArray;
        int min = Integer.MAX_VALUE;
        int minCounter = 0;

        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 21) - 10; // от -10 до 10 включительно
            if (array[i] < min) {
                min = array[i];
            }
        }

        System.out.println("Array numbers:");
        for (int element : array) {
            System.out.print(element + " | ");
        }
        System.out.println("\nMinimum number: " + min);

        // Алгоритм сдвигает все вхождения минимального числа в конец массива,
        // сохраняя при этом порядок следования других чисел.
        // При формировании нового массива вхождения минимального числа будут обрезаны.

        for (int i = 0; i < array.length - minCounter; i++) {
            if (array[i] == min) {
                minCounter++;
                for (int j = array.length - minCounter; j > i; j--) {
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
                if (array[i] == min) {
                    i--;
                }
            }
        }

        modifiedArray = new int[array.length - minCounter];

        if (modifiedArray.length == 0) {
            System.out.println("All numbers in the original array were equal");
        } else {
            for (int i = 0; i < modifiedArray.length; i++) {
                modifiedArray[i] = array[i];
            }

            System.out.println("Modified array:");
            for (int element : modifiedArray) {
                System.out.print(element + " | ");
            }
        }
    }
}