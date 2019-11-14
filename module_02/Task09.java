package by.yevstratyev.java_intro.module_02;

/*
 * Module 2. Algorithmization
 * Одномерные массивы
 * Задача 9
 * Условие:
 *  В массиве целых чисел с количеством элементов n найти наиболее часто встречающееся число.
 *  Если таких чисел несколько, то определить наименьшее из них.
 */

public class Task09 {
    public static void main(String[] args) {
        // Определение длины массива - от 2 до 20 элементов включительно.
        final byte N = (byte) (2 + (byte) (Math.random() * 19));
        byte[] array = new byte[N];

        byte repeatsCounter = 0;
        byte ctrl = 0;
        byte num = 0;

        // Заполнение массива числами от -10 до 10 включительно.
        for (int i = 0; i < array.length; i++) {
            array[i] = (byte) ((byte) (Math.random() * 21) - 10);
        }

        System.out.println("Initial array:");
        for (int element : array) {
            System.out.print(element + " | ");
        }

        // "Пузырьковая" сортировка элементов массива по возрастанию.
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    byte tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }

        System.out.println("\nSorted array:");
        for (int element : array) {
            System.out.print(element + " | ");
        }

        // Нахождение наиболее часто встречающегося числа,
        // и наименьшего, если таких несколько.
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] == array[i + 1]) {
                ctrl++;
            } else {
                ctrl = 0;
            }

            if (ctrl > repeatsCounter) {
                num = array[i];
                repeatsCounter = ctrl;
            }
        }

        if (repeatsCounter == 0) {
            System.out.println("\nThere are no repeated numbers");
        } else {
            System.out.println("\nResult: " + num);
        }
    }
}