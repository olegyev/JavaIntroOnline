package by.yevstratyev.java_intro.module_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Module 2. Algorithmization
 * Декомпозиция с использованием методов (подпрограммы)
 * Задача 6
 * Условие:
 *  Написать метод (методы), проверяющий, являются ли данные три числа взаимно простыми.
 */

public class Task40 {
    public static void main(String[] args) {
        int a;
        int b;
        int c;
        Task40 solution = new Task40();

        System.out.println("Please enter three whole numbers:");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("a = ");
            a = Integer.parseInt(reader.readLine());

            System.out.print("b = ");
            b = Integer.parseInt(reader.readLine());

            System.out.print("c = ");
            c = Integer.parseInt(reader.readLine());

            if (a == 0 && b == 0 && c == 0) {
                System.out.println("All numbers are equal to zero. Unable to find Greatest Common Divisor.");
            } else {
                boolean result = solution.areCoprime(a, b, c);
                if (result) {
                    System.out.printf("Numbers %d, %d, %d are co-prime.", a, b, c);
                } else {
                    System.out.printf("Numbers %d, %d, %d are NOT co-prime.", a, b, c);
                }
            }

        } catch (NumberFormatException e) {
            System.err.println("Error! Only whole numbers can be entered!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean areCoprime(int a, int b, int c) {
        int gcd = Math.abs(a);
        for (int i = 1; i < 3; i++) {
            gcd = calcGcd(gcd, Math.abs(b));
            b = c;
        }
        return gcd == 1;
    }

    private int calcGcd(int a, int b) {
        return b == 0 ? a : calcGcd(b, a % b);
    }
}