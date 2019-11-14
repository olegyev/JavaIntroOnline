package by.yevstratyev.java_intro.module_02;

/*
 * Module 2. Algorithmization
 * Декомпозиция с использованием методов (подпрограммы)
 * Задача 1
 * Условие:
 *  Написать методы (методы) для нахождения наибольшего общего делителя
 *  и наименьшего общего кратного двух натуральных чисел:
 *                           A * B
 *          НОК(A, B) = ----------------
 *                          НОД(A, B)
 */

public class Task35 {
    public static void main(String[] args) {
        int a = generateRandomNum();
        int b = generateRandomNum();

        int gcd = calcGcd(a, b);
        int lcm = calcLcm(a, b);

        System.out.println("Greatest Common Divisor of " + a + " and " + b + " is " + gcd);
        System.out.println("Least Common Multiple of " + a + " and " + b + " is " + lcm);
    }

    public static int generateRandomNum() {
        return (int) (1 + (Math.random() * 100)); // от 1 до 100 включительно
    }

    // Least Common Multiple.
    public static int calcLcm(int a, int b) {
        return a / calcGcd(a, b) * b;
    }

    // Greatest Common Divisor (в предыдущей задаче применил рекурсивный метод, здесь - итеративный).
    public static int calcGcd(int a, int b) {
        int tmp = a % b;
        while (tmp != 0) {
            a = b;
            b = tmp;
            tmp = a % b;
        }
        return b;
    }
}