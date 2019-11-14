package by.yevstratyev.java_intro.module_02;

/*
 * Module 2. Algorithmization
 * Декомпозиция с использованием методов (подпрограммы)
 * Задача 13
 * Условие:
 *  Два простых числа называются "близнецами", если они отличаются друг от друга на 2
 *  (например, 41 и 43). Найти и напечатать все пары "близнецов" из отрезка [n, 2n],
 *  где n - заданное натуральное число больше 2. Для решения задачи использовать декомпозицию.
 */

public class Task47 {
    public static void main(String[] args) {
        int n = generateRandomNum();
        System.out.println("Prime pairs:");
        try {
            findPrimePairs(n);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    // От 3 до 500 включительно.
    public static int generateRandomNum() {
        return (int) (3 + (Math.random() * 498));
    }

    public static void findPrimePairs(int n) throws Exception {
        if (n < 3) {
            throw new Exception("Number is less than 3.");
        }

        int counter = 0;
        int i = (n % 2 == 0) ? (n + 1) : n;

        // Цикл "прокручивает" заданное число до первой пары "близнецов".
        while (!(isPrime(i) && isPrime(i + 2))) {
            i += 2;
        }

        // Далее цикл с шагом 6 проверяет все последующие пары.
        while ((i + 2) < (2 * n)) {
            if (isPrime(i) && isPrime(i + 2)) {
                printPrimePair(i, i + 2);
                counter++;
            }
            i += 6;
        }

        if (counter == 1) {
            System.out.println(counter + " prime pair on the segment [" + n + ", " + (2 * n) + "].");
        } else {
            System.out.println(counter + " prime pairs on the segment [" + n + ", " + (2 * n) + "].");
        }

    }

    private static boolean isPrime(int n) {
        boolean isPrime = true;

        for (int i = 2; i <= (n / 2); i++) {
            if (n % i == 0) {
                isPrime = false;
                break;
            }
        }

        return isPrime;
    }

    private static void printPrimePair(int a, int b) {
        System.out.println("[" + a + ", " + b + "]");
    }
}