package by.yevstratyev.java_intro.module_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Module 1. Basics of software code development
 * Циклы
 * Задача 8
 * Условие:
 *   Даны два числа. Определить цифры, входящие в запись как первого, так и второго числа.
 */

public class Task19 {
    private static int minDigitsSeries = 0;
    private static boolean isZero = false;

    public static void main(String[] args) {
        long numOne;
        long numTwo;
        boolean flag = false;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Please enter first number (whole number): ");
            String strOne = reader.readLine();
            System.out.print("Please enter second number (whole number): ");
            String strTwo = reader.readLine();

            // Нули перед числом в строке ввода игнорируются:
            // 0000023 = 23 (сравниваем числа, а не содержимое строк).
            // Повторяющиеся числа выводятся в порядке возрастания и
            // без дублирования (см. методы ниже - строки и массивы не использованы).

            numOne = Math.abs(Long.parseLong(strOne));
            while (numOne > 0) {
                byte digit = (byte) (numOne % 10);
                numOne /= 10;
                numTwo = Math.abs(Long.parseLong(strTwo));
                while (numTwo > 0) {
                    if (digit == numTwo % 10 ) {
                        if (digit == 0) {
                            isZero = true;
                            break;
                        } else {
                            collectDigits(digit);
                            flag = true;
                            break;
                        }
                    }
                    numTwo /= 10;
                }
            }

            numOne = Math.abs(Long.parseLong(strOne));
            numTwo = Math.abs(Long.parseLong(strTwo));

            System.out.print("Duplicate digits: ");
            if ((numOne == 0 && ((Long) numTwo).toString().contains("0"))
                    || (numTwo == 0 && ((Long) numOne).toString().contains("0"))) {
                System.out.print(0 + " | ");
            } else if (!isZero && !flag) {
                System.out.println("there are no duplicate digits");
            } else {
                sortInAscendingOrder(minDigitsSeries);
            }

        } catch (NumberFormatException e) {
            System.err.println("Error! Only whole numbers can be entered!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Метод собирает повторяющиеся цифры в одном числе без дублирования.
    private static void collectDigits(byte digit) {
        while (true) {
            byte check = (byte) (minDigitsSeries % 10);
            if (check != digit) {
                minDigitsSeries = (minDigitsSeries * 10) + digit;
                break;
            }
            minDigitsSeries /= 10;
        }
    }

    // Метод для сортировки повторяющихся цифр, собранных в одном числе в предыдущем методе,
    // в возрастающем порядке.
    private static void sortInAscendingOrder(int minDigitsSeries) {
        if (isZero) {
            System.out.print(0 + " | ");
        }

        if (minDigitsSeries != 0 && minDigitsSeries < 10) {
            System.out.print(minDigitsSeries + " | ");
        } else {
            while (minDigitsSeries > 0) {
                byte digit = (byte) (minDigitsSeries % 10);
                int temp = minDigitsSeries / 10;
                while (temp > 0) {
                    byte check = (byte) (temp % 10);
                    if (check < digit) {
                        digit = check;
                    }
                    temp /= 10;
                }
                System.out.print(digit + " | ");
                minDigitsSeries = reduceNumber(minDigitsSeries, digit);
            }
        }
    }

    // Метод для изъятия выведенной на консоль цифры из числа,
    // содержащего повторяющиеся цифры.
    private static int reduceNumber(int minDigitsSeries, byte digit) {
        int newNumber = 0;
        while (minDigitsSeries > 0) {
            byte check = (byte) (minDigitsSeries % 10);
            if (check != digit) {
                newNumber = (newNumber * 10) + check;
            }
            minDigitsSeries /= 10;
        }
        return newNumber;
    }
}