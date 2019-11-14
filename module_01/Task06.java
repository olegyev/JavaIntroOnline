package by.yevstratyev.java_intro.module_01;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * Module 1. Basics of software code development
 * Линейные программы
 * Задача 6
 * Условие:
 *   Для данной области составить линейную программу, которая печатает true,
 *   если точка с координатами (x, y) принадлежит закрашенной области,
 *   и false - в противном случае.
 */

public class Task06 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Please enter x (e.g. 0,5): ");
            double x = scanner.nextDouble();
            System.out.print("Please enter y (e.g. 0,5): ");
            double y = scanner.nextDouble();

            boolean flag = y >= -3 && y <= 0 && x >= -4 && x <= 4 || y <= 4 && y >= 0 && x >= -2 && x <= 2;
            System.out.println(flag);
        } catch (InputMismatchException e) {
            System.err.print("Error! Only numbers can be entered!");
        }
    }
}