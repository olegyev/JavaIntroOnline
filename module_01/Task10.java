package by.yevstratyev.java_intro.module_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Module 1. Basics of software code development
 * Ветвления
 * Задача 4
 * Условие:
 *   Заданы размеры A, B прямоугольного отверстия и размеры x, y, z кирпича.
 *   Определить, пройдет ли кирпич через отверстие.
 */

public class Task10 {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Enter the rectangular hole sizes (two real numbers, e.g. 0.5):");
            double a = Double.parseDouble(reader.readLine());
            if (a <= 0) {
                throw new NumberFormatException();
            }
            double b = Double.parseDouble(reader.readLine());
            if (b <= 0) {
                throw new NumberFormatException();
            }
            System.out.println("Enter the brick sizes (three real numbers, e.g. 0.5):");
            double x = Double.parseDouble(reader.readLine());
            if (x <= 0) {
                throw new NumberFormatException();
            }
            double y = Double.parseDouble(reader.readLine());
            if (y <= 0) {
                throw new NumberFormatException();
            }
            double z = Double.parseDouble(reader.readLine());
            if (z <= 0) {
                throw new NumberFormatException();
            }

            if ((a >= x && b >= y) || (a >= y && b >= x)
                    || (a >= x && b >= z) || (a >= z && b >= x)
                        || (a >= z && b >= y) || (a >= y && b >= z)) {
                System.out.print("The brick goes into the hole");
            } else {
                System.out.print("The brick does not go into the hole");
            }

        } catch (NumberFormatException e) {
            System.err.print("Error! Only numbers, that are greater than zero, can be entered!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}