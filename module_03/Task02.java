package by.yevstratyev.java_intro.module_03;

/*
 * Module 3. Strings and basics of text processing
 * Работа со строкой как с массивом символов
 * Задача 2
 * Условие:
 *  Замените в строке все вхождения 'word' на 'letter'.
 */

public class Task02 {
    public static void main(String[] args) {
        System.out.println("Initial string:");
        String string = "Wow! We have first word, second word and third word. These words are in this string.";
        System.out.println(string);

        try {
            System.out.println("Modified string:");
            string = replace(string, "word", "letter");
            System.out.println(string);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    // Алгоритм чувствителен к регистру.
    public static String replace(String string, String target, String replacement) throws Exception {
        if (target.isEmpty()) {
            throw new Exception("Please fill the string or indicate the character/-s to be replaced.");
        }

        char[] allChars = string.toCharArray();
        char[] trgChars = target.toCharArray();
        char[] replChars = replacement.toCharArray();

        for (int i = 0, flag = 0; i < allChars.length; i++) {
            if (allChars[i] == trgChars[flag]) {
                flag++;
            } else {
                flag = 0;
            }

            if (flag == trgChars.length) {
                int firstIndex = i - trgChars.length + 1;
                allChars = modifyChars(allChars, trgChars.length, replChars, firstIndex);
                flag = 0;
                i = replChars.length > trgChars.length ? i + replChars.length - trgChars.length
                                                       : i - (trgChars.length - replChars.length);
            }
        }

        string = null;
        target = null;
        replacement = null;
        trgChars = null;
        replChars = null;

        return new String(allChars);
    }

    private static char[] modifyChars(char[] oldAllChars, int trgCharsLength, char[] replChars, int firstIndex) {
        char[] newAllChars;

        if (replChars.length > trgCharsLength) {
            newAllChars = new char[oldAllChars.length + replChars.length - trgCharsLength];
        } else if (replChars.length < trgCharsLength) {
            newAllChars = new char[oldAllChars.length - (trgCharsLength - replChars.length)];
        } else {
            newAllChars = new char[oldAllChars.length];
        }

        for (int i = 0, j = 0; i < newAllChars.length; i++, j++) {
            if (i == firstIndex) {
                for (char replChar : replChars) {
                    newAllChars[i] = replChar;
                    i++;
                }
                j = replChars.length > trgCharsLength ? i - (replChars.length - trgCharsLength)
                                                      : i + trgCharsLength - replChars.length;
            }

            if (i != newAllChars.length) {
                newAllChars[i] = oldAllChars[j];
            }
        }

        oldAllChars = null;
        replChars = null;

        return newAllChars;
    }
}