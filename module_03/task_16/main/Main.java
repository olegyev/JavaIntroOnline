package by.yevstratyev.java_intro.module_03.task_16.main;

import by.yevstratyev.java_intro.module_03.task_16.bean.Text;
import by.yevstratyev.java_intro.module_03.task_16.logic.LexemeSorter;
import by.yevstratyev.java_intro.module_03.task_16.logic.ParagraphSorter;
import by.yevstratyev.java_intro.module_03.task_16.logic.WordSorter;
import by.yevstratyev.java_intro.module_03.task_16.view.TextView;

/*
 * Module 3. Strings and basics of text processing
 * Работа с регулярными выражениями (Pattern, Matcher)
 * Задача 1
 * Условие:
 *  Создать приложение, разбирающее текст (текст хранится в строке) и позволяющее выполнять с текстом три различных операции:
 *  1) отсортировать абзацы по количеству предложений;
 *  2) в каждом предложении отсортировать слова по длине;
 *  3) отсортировать лексемы в предложении по убыванию количества вхождений заданного символа, в случае равенства -
 *     по алфавиту.
 */

public class Main {
    public static void main(String[] args) {
        Text text = new Text("A mutable sequence of characters. This class provides an API compatible with StringBuffer, " +
                "but with no guarantee of synchronization. This class is designed for use as a drop-in replacement for " +
                "StringBuffer in places where the string buffer was being used by a single thread (as is generally the " +
                "case). Where possible, it is recommended that this class be used in preference to StringBuffer as it " +
                "will be faster under most implementations." +
                "\nThe principal operations on a StringBuilder are the append and insert methods, which are overloaded so " +
                "as to accept data of any type. Each effectively converts a given datum to a string and then appends or " +
                "inserts the characters of that string to the string builder. The append method always adds these " +
                "characters at the end of the builder; the insert method adds the characters at a specified point." +
                "\nFor example, if z refers to a string builder object whose current contents are \"start\", then the " +
                "method call z.append(\"le\") would cause the string builder to contain \"startle\", whereas " +
                "z.insert(4, \"le\") would alter the string builder to contain \"starlet\".");

        TextView view = new TextView();

        // Класс ParagraphSorter сортирует абзацы по количеству предложений в возрастающем порядке.
        System.out.println("Paragraphs sorted in ascending order according to a number of sentences:");
        ParagraphSorter paragraphs = new ParagraphSorter();
        Text sortedParagraphs = paragraphs.sort(text);
        view.print(sortedParagraphs);

        // Класс WordSorter сортирует слова из каждого предложения по длине в возрастающем порядке.
        System.out.println("\nWords of every sentence sorted in ascending order according to their length:");
        WordSorter words = new WordSorter();
        Text sortedWords = words.sort(text);
        view.print(sortedWords);

        // Класс LexemeSorter сортирует лексемы из каждого предложения по убыванию количества вхождений заданного символа,
        // а в случае равенства - по алфавиту.
        System.out.println("\nLexemes of every sentence sorted in descending order according to the number of char entries, " +
                "as well as in the alphabetical order:");
        LexemeSorter lexemes = new LexemeSorter();
        Text sortedLexemes = lexemes.sort(text, 'a');
        view.print(sortedLexemes);
    }
}