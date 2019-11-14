package by.yevstratyev.java_intro.module_02;

/*
 * Module 2. Algorithmization
 * Одномерные массивы. Сортировки
 * Задача 5
 * Условие:
 *  Сортировка вставками.
 *  Дана последовательность чисел a(1), a(2), ..., a(n). Требуется переставить числа в порядке возрастания.
 *  Делается это следующим образом. Пусть a(1), a(2), ..., a(i) - упорядоченная последовательность,
 *  т.е. a(1) <= a(2) <= ... <= a(i). Берется следующее число a(i+1) и вставляется в последовательность так,
 *  чтобы новая последовательность тоже была возрастающей. Процесс производится до тех пор, пока все элементы
 *  от i+1 до n не будут перебраны. Примечание. Место помещения очередного элемента в отсортированную часть
 *  производить с помощью двоичного поиска. Двоичный поиск оформить в виде отдельной функции.
 */

public class Task31 {
    public static void main(String[] args) {
        // Определение длины массива (от 2 до 10 включительно).
        final int ARRAY_LENGTH = (int) (2 + Math.random() * 9);
        int[] array = new int[ARRAY_LENGTH];

        // Заполнение массива числами (от -10 до 10 включительно).
        System.out.println("Initial array:");
        for (int i = 0; i < ARRAY_LENGTH; i++) {
            array[i] = (int) (Math.random() * 21) - 10;
            System.out.print(array[i] + " | ");
        }

        // Основная логика.
        for (int i = 1; i < ARRAY_LENGTH; i++) {
            int[] arrayFragment = new int[i + 1];
            for (int j = 0; j <= i; j++) {
                arrayFragment[j] = array[j];
            }
            int insertIndex = binarySearch(arrayFragment, array[i]);
            for (int j = insertIndex; j < i; j++) {
                int tmp = array[j];
                array[j] = array[i];
                array[i] = tmp;
            }
        }

        System.out.println("\nSorted array:");
        for (int i : array) {
            System.out.print(i + " | ");
        }
    }

    private static int binarySearch(int[] arrayFragment, int key) {
        int first = 0;
        int last = arrayFragment.length - 1;

        // Т.к. в данной задаче осуществляется сортировка массива и исключена вероятность отсутствия в нем элемента key,
        // можно задать вечный цикл - он так или иначе прервется при выявлении нужного индекса для вставки.
        while (true) {
            int mid = first + (last - first) / 2;

            if (arrayFragment[mid] <= key) {
                first = mid + 1;
                if (arrayFragment[mid] <= key && arrayFragment[mid + 1] >= key) {
                    return mid + 1;
                }
            } else {
                last = mid;
                if (mid == 0 && arrayFragment[0] >= key) {
                    return 0;
                } else if (arrayFragment[mid] >= key && arrayFragment[mid - 1] <= key) {
                    return mid;
                }
            }
        }
    }
}