package by.yevstratyev.java_intro.module_02;

/*
 * Module 2. Algorithmization
 * Одномерные массивы. Сортировки
 * Задача 2
 * Условие:
 *  Даны две последовательности a(1) <= a(2) <= ... <= a(n) и b(1) <= b(2) <= ... <= b(m).
 *  Образовать из них новую последовательность чисел так, чтобы она тоже была неубывающей.
 *  Примечание. Дополнительный массив не использовать.
 */

public class Task28 {
    public static void main(String[] args) {
        final int ARRAY_ONE_LENGTH = (int) (2 + Math.random() * 9); // от 2 до 10 включительно
        final int ARRAY_TWO_LENGTH = (int) (2 + Math.random() * 9); // от 2 до 10 включительно

        int[] arrayOne = fillArray(ARRAY_ONE_LENGTH);
        System.out.println("Array one:");
        printArray(arrayOne);

        int[] arrayTwo = fillArray(ARRAY_TWO_LENGTH);
        System.out.println("\nArray two:");
        printArray(arrayTwo);

        int[] resultingArray = new int[ARRAY_ONE_LENGTH + ARRAY_TWO_LENGTH];

        // Основная логика.
        for (int i = 0, j = 0, k = 0; k < resultingArray.length; k++) {
            if (i > ARRAY_ONE_LENGTH - 1) {
                resultingArray[k] = arrayTwo[j];
                j++;
            } else if (j > ARRAY_TWO_LENGTH - 1) {
                resultingArray[k] = arrayOne[i];
                i++;
            } else if (arrayOne[i] < arrayTwo[j]) {
                resultingArray[k] = arrayOne[i];
                i++;
            } else {
                resultingArray[k] = arrayTwo[j];
                j++;
            }
        }

        System.out.println("\nResulting array:");
        printArray(resultingArray);
    }

    private static int[] fillArray(final int ARRAY_LENGTH) {
        int[] array = new int[ARRAY_LENGTH];
        for (int i = 0; i < ARRAY_LENGTH; i++) {
            int num = (int) (Math.random() * 21) - 10; // от -10 до 10 включительно
            if (i == 0) {
                array[i] = num;
            } else if (i > 0 && num >= array[i - 1]) {
                array[i] = num;
            } else {
                i--;
            }
        }
        return array;
    }

    private static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " | ");
        }
    }
}