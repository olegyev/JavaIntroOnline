package by.yevstratyev.java_intro.module_02;

import java.math.BigDecimal; // Использовал класс BigDecimal для точного сравнения действительных чисел.

/*
 * Module 2. Algorithmization
 * Одномерные массивы. Сортировки
 * Задача 7
 * Условие:
 *  Пусть даны две неубывающие последовательности действительных чисел a(1) <= a(2) <= ... <= a(n)
 *  и b(1) <= b(2) <= ... <= b(m). Требуется указать те места, на которые нужно вставлять элементы
 *  последовательности b(1) <= b(2) <= ... <= b(m) в первую последовательность так, чтобы новая последовательность
 *  оставалась возрастающей.
 */

public class Task33 {
    public static void main(String[] args) {
        double[] arrayOne = generateRandomAscendingArray();
        System.out.println("Array one:");
        printArray(arrayOne);

        double[] arrayTwo = generateRandomAscendingArray();
        System.out.println("\nArray two:");
        printArray(arrayTwo);

        System.out.println();

        System.out.println("\nIndices for every single element of the second array:");
        findIndexForEverySingleElement(arrayOne, arrayTwo);

        System.out.println("\nIndices for all elements of the second array in a fully combined array:");
        findIndexForAllElements(arrayOne, arrayTwo);

        System.out.println("\nBinary search for every single element of the second array:");
        binarySearchForEverySingleElement(0, arrayOne.length - 1, arrayOne, arrayTwo, 0);
    }

    // Для каждого элемента второго массива по отдельности.
    public static void findIndexForEverySingleElement(double[] arrayOne, double[] arrayTwo) {
        BigDecimal numArrOne;
        BigDecimal numArrTwo;
        BigDecimal lastNumArrOne;

        int lastIndex = 0;
        for (int j = 0; j < arrayTwo.length; j++) {
            int i = lastIndex;
            while (i < arrayOne.length) {
                numArrOne = new BigDecimal(arrayOne[i]);
                numArrTwo = new BigDecimal(arrayTwo[j]);
                lastNumArrOne = new BigDecimal(arrayOne[arrayOne.length - 1]);
                if (numArrTwo.compareTo(numArrOne) < 0) {
                    System.out.println(arrayTwo[j] + " goes to the index " + i + " of the first array");
                    lastIndex = i;
                    break;
                } else if (numArrTwo.compareTo(lastNumArrOne) >= 0) {
                    System.out.println("All remaining elements of the second array go to the index " + arrayOne.length + " of the first array");
                    j = arrayTwo.length - 1;
                    break;
                }
                i++;
            }
        }
        lastNumArrOne = null;
    }

    // Индексы в полностью объединенном массиве для всех элементов второго массива.
    public static void findIndexForAllElements(double[] arrayOne, double[] arrayTwo) {
        BigDecimal numArrOne;
        BigDecimal numArrTwo;

        for (int i = 0, j = 0, k = 0; k < arrayOne.length + arrayTwo.length; k++) {
            if (j == arrayTwo.length) {
                break;
            } else if (i == arrayOne.length) {
                System.out.println("All remaining elements of the second array go to the end (from index " + k + ") of the fully combined array");
                break;
            }

            numArrOne = new BigDecimal(arrayOne[i]);
            numArrTwo = new BigDecimal(arrayTwo[j]);

            if (numArrTwo.compareTo(numArrOne) < 0) {
                System.out.println(arrayTwo[j] + " goes to the index " + k + " of the fully combined array");
                j++;
            } else {
                i++;
            }
        }
        numArrOne = null;
        numArrTwo = null;
    }

    // Поиск индексов для каждого элемента второго массива по отдельности с помощью бинарного поиска.
    public static void binarySearchForEverySingleElement(int first, int last, double[] arrayOne, double[] arrayTwo, int arrayTwoIndex) {
        if (arrayTwoIndex == arrayTwo.length) {
            return;
        }

        BigDecimal key = new BigDecimal(arrayTwo[arrayTwoIndex]);

        BigDecimal arrayOneLastElement = new BigDecimal(arrayOne[arrayOne.length - 1]);
        if (first == arrayOne.length - 1 && arrayOneLastElement.compareTo(key) <= 0) {
            System.out.println("All remaining elements of the second array go to the index " + (first + 1) + " of the first array");
            key = null;
            arrayOneLastElement = null;
            return;
        }

        int mid = first + (last - first) / 2;
        BigDecimal arrayOneMid = new BigDecimal(arrayOne[mid]);

        if (arrayOneMid.compareTo(key) <= 0) {
            BigDecimal arrayOneMidPlusOne = new BigDecimal(arrayOne[mid + 1]);
            if (arrayOneMid.compareTo(key) <= 0 && arrayOneMidPlusOne.compareTo(key) > 0) {
                System.out.println(arrayTwo[arrayTwoIndex] + " goes to the index " + (mid + 1) + " of the first array");
                arrayOneMidPlusOne = null;
                binarySearchForEverySingleElement(mid + 1, arrayOne.length - 1, arrayOne, arrayTwo, arrayTwoIndex + 1);
            } else {
                arrayOneMidPlusOne = null;
                binarySearchForEverySingleElement(mid + 1, arrayOne.length - 1, arrayOne, arrayTwo, arrayTwoIndex);
            }
        } else {
            if (mid == 0) {
                BigDecimal arrayOneZero = new BigDecimal(arrayOne[0]);
                if (arrayOneZero.compareTo(key) >= 0) {
                    System.out.println(arrayTwo[arrayTwoIndex] + " goes to the index " + 0 + " of the first array");
                    arrayOneZero = null;
                    binarySearchForEverySingleElement(0, arrayOne.length - 1, arrayOne, arrayTwo, arrayTwoIndex + 1);
                } else {
                    arrayOneZero = null;
                }
            } else {
                BigDecimal arrayOneMidMinusOne = new BigDecimal(arrayOne[mid - 1]);
                if (arrayOneMid.compareTo(key) >= 0 && arrayOneMidMinusOne.compareTo(key) <= 0) {
                    System.out.println(arrayTwo[arrayTwoIndex] + " goes to the index " + mid + " of the first array");
                    arrayOneMidMinusOne = null;
                    binarySearchForEverySingleElement(mid, arrayOne.length - 1, arrayOne, arrayTwo, arrayTwoIndex + 1);
                } else {
                    arrayOneMidMinusOne = null;
                    binarySearchForEverySingleElement(first, mid, arrayOne, arrayTwo, arrayTwoIndex);
                }
            }
        }
        key = null;
        arrayOneMid = null;
    }

    private static double[] generateRandomAscendingArray() {
        final int ARRAY_LENGTH = (int) (2 + Math.random() * 9); // от 2 до 10 включительно
        double[] array = new double[ARRAY_LENGTH];

        for (int i = 0; i < ARRAY_LENGTH; i++) {
            double num = Math. random() * 20 - 10; // от -10 до 10 исключительно
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

    private static void printArray(double[] array) {
        for (double element : array) {
            System.out.print(element + " | ");
        }
    }
}