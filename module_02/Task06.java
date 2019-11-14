package by.yevstratyev.java_intro.module_02;

/*
 * Module 2. Algorithmization
 * Одномерные массивы
 * Задача 6
 * Условие:
 *  Задана последовательность N вещественных чисел.
 *  Вычислить сумму чисел, порядковые номера которых
 *  являются простыми числами.
 */

public class Task06 {
    public static void main(String[] args) {
        final int N = 2 + (int) (Math.random() * 99); // от 2 до 100 включительно
        double[] array = new double[N];
        double sum = 0;
        boolean isPrime = true;

        System.out.print("Array numbers: ");
        for (int i = 0; i < array.length; i++) {
            array[i] = Math.random() * 200 - 100; // от -100 до 100 исключительно
            System.out.print(array[i] + " | ");
        }

        for (int i = 2; i < array.length; i++) {
            for (int j = 2; j <= (i / 2); j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
                isPrime = true;
            }
            if (isPrime) {
                // Порядковый номер = индекс элемента, т.е. a(0), a(1), a(2), ..., a(n).
                sum += array[i];
            }
        }
        System.out.print("\nThe sum is " + sum);
    }
}