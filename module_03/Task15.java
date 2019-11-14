package by.yevstratyev.java_intro.module_03;

/*
 * Module 3. Strings and basics of text processing
 * Работа со строкой как с объектом типа String или StringBuilder
 * Задача 10
 * Условие:
 *  Строка X состоит из нескольких предложений, каждое из которых кончается точкой, восклицательным или вопросительным
 *  знаком. Определить количество предложений в строке X.
 */

public class Task15 {
    public static void main(String[] args) {
        String string = "This is a string. How many sentences does it contain? Let's find out.";
        System.out.println(string);

        System.out.println("The string contains " + countSentences(string) + " sentences.");
    }

    // Я не обрабатывал ситуации, когда предложение заканчивается многоточием (...), сочетанием вопросительного или восклицательного
    // знака с многоточием (?.. / !..), несколькими восклицательными (!!!) или вопросительными (???) знаками
    // или восклицательным и вопросительным знаком (!?), т.к. такие случаи исключены условиями задачи.
    public static int countSentences(String string) {
        int sentencesCounter = 0;

        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == '.' || string.charAt(i) == '?' || string.charAt(i) == '!') {
                sentencesCounter++;
            }
        }

        return sentencesCounter;
    }
}