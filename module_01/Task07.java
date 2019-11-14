package by.yevstratyev.java_intro.module_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Module 1. Basics of software code development
 * Ветвления
 * Задача 1
 * Условие:
 *   Даны два угла треугольника (в градусах). Определить, существует ли такой треугольник,
 *   и если да, то будет ли он прямоугольным.
 */

public class Task07 {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Please enter the first angle: ");
            int angleOne = Integer.parseInt(reader.readLine());
            System.out.print("Please enter the second angle: ");
            int angleTwo = Integer.parseInt(reader.readLine());

            checkTriangle(angleOne, angleTwo);
        } catch (NumberFormatException e) {
            System.err.print("Error! Only integers can be entered!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void checkTriangle(int angleOne, int angleTwo) {
        if (angleOne > 0 && angleTwo > 0 && (angleOne + angleTwo) < 180) {
            System.out.println("Triangle exists");
            if (angleOne == 90 || angleTwo == 90 || (angleOne + angleTwo) == 90) {
                System.out.print("Triangle is right-angled");
            } else {
                System.out.print("Triangle is not right-angled");
            }
        } else {
            System.out.print("Triangle does not exist");
        }
    }
}