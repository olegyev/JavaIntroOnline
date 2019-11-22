package by.yevstratyev.java_intro.module_02;

/*
 * Module 2. Algorithmization
 * Декомпозиция с использованием методов (подпрограммы)
 * Задача 8
 * Условие:
 *  Задан массив D. Определить, например, следующие суммы:
 *  D[1] + D[2] + D[3], или D[3] + D[4] + D[5], или D[4] + D[5] + D[6].
 *  Пояснение. Составить метод (методы) для вычисления суммы трех последовательно
 *  расположенных элементов массива с номерами от k до m.
 */

public class Task42 {
    public static void main(String[] args) {
        Task42 solution = new Task42();
        int[] array = solution.generateRandomArray();
        int k = solution.generateRandomStartIndex(array);
        solution.printArray(array);

        int sum = solution.calcElementsSum(array, k);

        System.out.printf("Sum of elements with indices %d-%d-%d is %d.", k, k + 1, k + 2, sum);
    }

    public int[] generateRandomArray() {
        final int ARRAY_LENGTH = (int) (3 + Math.random() * 8); // от 3 до 10 включительно
        int[] array = new int[ARRAY_LENGTH];

        for (int i = 0; i < ARRAY_LENGTH; i++) {
            array[i] = (int) (Math.random() * 31) - 15; // от -15 до 15 включительно
        }

        return array;
    }

    public int generateRandomStartIndex(int[] array) {
        return (int) (Math.random() * (array.length - 2)); // от 0 до n-2 включительно
    }

    public void printArray(int[] array) {
        System.out.println("Array numbers:");
        for (int element : array) {
            System.out.print(element + " | ");
        }
        System.out.println();
    }

    public int calcElementsSum(int[] array, int k) {
        int sum = 0;
        int m = k + 2;

        for (int i = k; i <= m; i++) {
            sum += array[i];
        }

        return sum;
    }
}