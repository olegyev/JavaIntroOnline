package by.yevstratyev.java_intro.module_02;

/*
 * Module 2. Algorithmization
 * Одномерные массивы. Сортировки
 * Задача 8
 * Условие:
 *  Даны дроби p(1)/q(1), p(2)/q(2), ..., p(n)/q(n) (p(i), q(i) - натуральные).
 *  Составить программу, которая приводит эти дроби к общему знаменателю
 *  и упорядочивает их в порядке возрастания.
 */

public class Task34 {
    public static void main(String[] args) {
        final int N = (int) (2 + (Math.random() * 9)); // от 2 до 10 включительно
        int[] numArray = new int[N];
        int[] denArray = new int[N];
        int[] multipliers = new int[N];
        int lcm = 0;

        System.out.println("Initial numbers:");
        for (int i = 0; i < N; i++) {
            numArray[i] = (int) (1 + (Math.random() * 10)); // от 1 до 10 включительно
            denArray[i] = (int) (1 + (Math.random() * 10)); // от 1 до 10 включительно
            System.out.print(numArray[i] + "/" + denArray[i] + " | ");
        }

        Task34 solution = new Task34();
        for (int i = 0; i + 1 < N; i++) {
            if (i == 0) {
                lcm = solution.calcLcm(denArray[i], denArray[i + 1]);
            } else {
                lcm = solution.calcLcm(lcm, denArray[i + 1]);
            }
        }

        System.out.println("\n\nFractional numbers with a common denominator:");
        for (int i = 0; i < N; i++) {
            multipliers[i] = lcm / denArray[i];
            numArray[i] *= multipliers[i];
            denArray[i] *= multipliers[i];
            System.out.print(numArray[i] + "/" + denArray[i] + " | ");
        }

        for (int step = N / 2; step >= 1; step /= 2) {
            for (int inc = 0; inc < step; inc++) {
                for (int i = inc; i < N - step; i += step) {
                    for (int j = i + step; j - step >= 0; j -= step) {
                        if (numArray[j - step] > numArray[j]) {
                            int tmp = numArray[j];
                            numArray[j] = numArray[j - step];
                            numArray[j - step] = tmp;

                            tmp = multipliers[j];
                            multipliers[j] = multipliers[j - step];
                            multipliers[j - step] = tmp;
                        } else {
                            break;
                        }
                    }
                }
            }
        }

        System.out.println("\n\nFractional numbers in ascending order:");
        for (int i = 0; i < N; i++) {
            System.out.print(numArray[i] / multipliers[i] + "/" + denArray[i] / multipliers[i] + " | ");
        }
    }

    // Least Common Multiple.
    private int calcLcm(int a, int b) {
        return a / calcGcd(a, b) * b;
    }

    // Greatest Common Divisor.
    private int calcGcd(int a, int b) {
        return b == 0 ? a : calcGcd(b,a % b);
    }
}