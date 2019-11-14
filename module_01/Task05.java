package by.yevstratyev.java_intro.module_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Module 1. Basics of software code development
 * Линейные программы
 * Задача 5
 * Условие:
 *   Дано натуральное число T, которое представляет длительность прошедшего времени в секундах.
 *   Вывести данное значение длительности в часах, минутах и секундах в следующей форме:
 *   HHч MMмин SSс.
 */

public class Task05 {
    public static void main(String[] args) {
        System.out.print("Enter seconds (negative numbers will be formatted): ");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int t = Integer.parseInt(reader.readLine());
            convertAndPrintTime(Math.abs(t));
        } catch (NumberFormatException e) {
            System.err.print("Error! Only an integer can be entered!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void convertAndPrintTime(int sec) {
        int hours = sec / (60 * 60);
        int minutes = (sec / 60) - (hours * 60); // также можно: (sec - 60 * 60 * hours) / 60;
        int seconds = sec % 60;

        System.out.printf("%02d%-2s%02d%-4s%02d%s", hours, "ч", minutes, "мин", seconds,"с");
    }
}