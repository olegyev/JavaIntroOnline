package by.yevstratyev.java_intro.module_03;

/*
 * Module 3. Strings and basics of text processing
 * Работа со строкой как с массивом символов
 * Задача 1
 * Условие:
 *  Дан массив названий переменных в camelCase.
 *  Преобразовать названия в snake_case.
 */

public class Task01 {
    public static void main(String[] args) {
        final int ARRAY_LENGTH = 4;
        String[] strings = new String[ARRAY_LENGTH];
        strings[0] = "camelCase";
        strings[1] = "snakeCase";
        strings[2] = "stringWithMoreThanTwoWords";
        strings[3] = "oneMoreName";

        System.out.println("Initial strings:");
        for (String element : strings) {
            System.out.println(element);
        }

        convertCamelToSnake(strings);

        System.out.println("\nModified strings:");
        for (String element : strings) {
            System.out.println(element);
        }
    }

    public static void convertCamelToSnake(String[] strings) {
        for (int i = 0; i < strings.length; i++) {
            strings[i] = modifyString(strings[i].toCharArray());
        }
    }

    private static String modifyString(char[] chars) {
        final int A = 65;
        final int Z = 90;

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= A && chars[i] <= Z)  { // или: if (Character.isUpperCase(chars[i])) {...}
                chars = modifyChars(chars, i);
            }
        }
        return new String(chars);
    }

    private static char[] modifyChars(char[] oldChars, int index) {
        final int TO_LOWER_CASE = 32;
        char[] newChars = new char[oldChars.length + 1];

        for (int i = 0, j = 0; i < newChars.length; i++, j++) {
            newChars[i] = oldChars[j];
            if (i == index) {
                newChars[i] = '_';
                oldChars[j] += TO_LOWER_CASE; // или: oldChars[j] = Character.toLowerCase(oldChars[j]);
                j--;
            }
        }
        oldChars = null;

        return newChars;
    }
}