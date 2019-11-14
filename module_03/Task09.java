package by.yevstratyev.java_intro.module_03;

/*
 * Module 3. Strings and basics of text processing
 * Работа со строкой как с объектом типа String или StringBuilder
 * Задача 4
 * Условие:
 *  С помощью функции копирования и операции конкатенации составить из частей слова
 *  "информатика" слово "торт".
 */

public class Task09 {
    public static void main(String[] args) {
        String source = "информатика";

        char t = source.charAt(source.indexOf('т')); // или: String t = "" + source.charAt(source.indexOf('т'));
        char o = source.charAt(source.indexOf('о'));
        char r = source.charAt(source.indexOf('р'));
        // или: String or = source.substring(source.indexOf('о'), source.indexOf('о') + 2);

        String result = "" + t + o + r + t;

        System.out.println(source + " -> " + result);
    }
}