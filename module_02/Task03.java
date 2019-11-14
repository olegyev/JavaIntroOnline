package by.yevstratyev.java_intro.module_02;

/*
 * Module 2. Algorithmization
 * Одномерные массивы
 * Задача 3
 * Условие:
 *  Дан массив действительных чисел, размерность которого N.
 *  Подсчитать, сколько в нем отрицательных, положительных
 *  и нулевых элементов.
 */

public class Task03 {
    public static void main(String[] args) {
        final int N = 2 + (int) (Math.random() * 99); // от 2 до 100 включительно
        double[] array = new double[N];
        int numOfNegatives = 0;
        int numOfPositives = 0;
        int numOfZeros = 0;

        System.out.println("Array length is " + N);
        System.out.print("Array numbers: ");
        for (int i = 0; i < array.length; i++) {
            array[i] = Math.random() * 200 - 100; // от -100 до 100 исключительно
            System.out.print(array[i] + " | ");
            if (array[i] < numOfZeros) {
                numOfNegatives++;
            } else if (array[i] > numOfZeros) {
                numOfPositives++;
            } else {
                numOfZeros++;
            }
        }

        System.out.println("\nNegative numbers: " + numOfNegatives);
        System.out.println("Positive numbers: " + numOfPositives);
        System.out.print("Zeros: " + numOfZeros);
    }
}