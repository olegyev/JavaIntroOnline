package by.yevstratyev.java_intro.module_02;

import java.math.BigInteger;

/*
 * Module 2. Algorithmization
 * Декомпозиция с использованием методов (подпрограммы)
 * Задача 7
 * Условие:
 *  Написать метод (методы) для вычисления суммы факториалов всех нечетных чисел от 1 до 9.
 */

public class Task41 {
    public static void main(String[] args) {
        final int N = 9;
        Task41 solution = new Task41();
        try {
            BigInteger factorialsSum = solution.calcOddFactorialsSum(N);
            System.out.println("Result for " + N + " is " + factorialsSum);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    // Использовал BigInteger с расчетом на гипотетическую возможность внесения аргумента > 9.
    public BigInteger calcOddFactorialsSum(final int N) throws Exception {
        if (N < 1) {
            throw new Exception("Only natural number larger than 0 can be entered (factorial for 0 is 1).");
        }

        BigInteger factorial;
        BigInteger factorialsSum = new BigInteger("0");

        for (int i = 1; i <= N; i += 2) {
            factorial = BigInteger.valueOf(1);
            for (int j = 1; j <= i; j++) {
                factorial = factorial.multiply(BigInteger.valueOf(j));
            }
            factorialsSum = calcFactorialsSum(factorial, factorialsSum);
        }

        factorial = null;
        return factorialsSum;
    }

    private BigInteger calcFactorialsSum(BigInteger factorial, BigInteger factorialsSum) {
        return factorialsSum.add(factorial);
    }
}