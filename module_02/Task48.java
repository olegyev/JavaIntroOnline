package by.yevstratyev.java_intro.module_02;

/*
 * Module 2. Algorithmization
 * Декомпозиция с использованием методов (подпрограммы)
 * Задача 14
 * Условие:
 *  Натуральное число, в записи которого n цифр, называется числом Армстронга,
 *  если сумма его цифр, возведенных в степень n, равна самому числу.
 *  Найти все числа Армстронга от 1 до k. Для решения задачи использовать декомпозицию.
 */

public class Task48 {
    public static void main(String[] args) {
        Task48 solution = new Task48();
        long k = solution.generateRandomNum();
        System.out.println("Armstrong numbers from 1 to " + k + ":");
        try {
            solution.findArmstrongNums(k);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    // До 9 разрядов - от 1 до 999.999.999 включительно.
    public long generateRandomNum() {
        return (long) (1 + Math.random() * 999_999_999L);
    }

    public void findArmstrongNums(long k) throws Exception {
        if (k < 1) {
            throw new Exception("Upper number is less than 1.");
        }

        int n = 1;

        for (long i = 1; i <= k; i++) {
            if (i == raiseToPower(10, n)) {
                n++;
            }

            if (isArmstrong(i, n)) {
                printArmstrong(i);
            }
        }
    }

    private boolean isArmstrong(long num , int n) {
        long sum = 0;
        long cutNum = num;

        while (cutNum > 0) {
            sum += raiseToPower(cutNum % 10, n);
            cutNum /= 10;
        }

        return sum == num;
    }

    private long raiseToPower(long num, int n) {
        long raisedNum = num;

        for (int i = 1; i < n; i++) {
            raisedNum *= num;
        }

        return raisedNum;
    }

    private void printArmstrong(long num) {
        System.out.println(num);
    }
}