package by.yevstratyev.java_intro.module_03;

/*
 * Module 3. Strings and basics of text processing
 * Работа со строкой как с массивом символов
 * Задача 5
 * Условие:
 *  Удалить в строке все лишние пробелы, то есть серии подряд идущих пробелов
 *  заменить на одиночные пробелы. Крайние пробелы в строке удалить.
 */

public class Task05 {
    public static void main(String[] args) {
        Task05 solution = new Task05();
        System.out.println("Initial string:");
        String string = "     String   with    redundant spaces. It looks      bad.              ";
        System.out.println(string);

        System.out.println("\nFirst algorithm (avoid repeating sequences and concatenate) without trim:");
        String firstAlg = solution.avoidRepeatingSequences(string, ' ');
        System.out.println(firstAlg);
        System.out.println("With trim:");
        System.out.println(solution.trim(firstAlg));

        System.out.println("\nSecond algorithm (permute and cut repeating sequences) without trim:");
        String secondAlg = solution.cutRepeatingSequences(string, ' ');
        System.out.println(secondAlg);
        System.out.println("With trim:");
        System.out.println(solution.trim(secondAlg));

        System.out.println("\nTrimmed initial string without removing repeating sequences:");
        System.out.println(solution.trim(string));
    }

    // Первый алгоритм создает новый (изначально пустой) массив символов, куда копируется вся строка за исключением
    // идущих подряд символов. Главный недостаток (с учетом запрета на использование классов ArrayList и StringBuilder) -
    // в методе concat() создается много промежуточных массивов символов, ссылки на которые нельзя обнулить,
    // т.к. они указывают на возвращаемый ("сконкатенированный") массив. Собственно конкатенацию строк решил
    // не использовать, т.к. это слишком очевидный и не более эффективный вариант.
    public String avoidRepeatingSequences(String string, char target) {
        char[] chars = string.toCharArray();
        char[] newChars = {};
        int ctrl = 0;
        int index = 0;

        for (char element : chars) {
            if (element == target) {
                ctrl++;
            } else {
                ctrl = 0;
            }

            if (ctrl < 2) {
                newChars = concat(newChars, element, index++);
            }
        }

        chars = null;

        return new String(newChars);
    }

    // Второй алгоритм переставляет все идущие подряд символы (в нашем случае пробелы) в конец массива символов.
    // Затем все эти лишние символы, переставленные в конец массива, обрезаются.
    // Главный недостаток (с учетом запрета на использование классов ArrayList и StringBuilder) -
    // довольно большое количество перестановок.
    public String cutRepeatingSequences(String string, char target) {
        char[] chars = string.toCharArray();
        int ctrl = 0;
        int removedSpacesCounter = 0;

        for (int i = 0; i < chars.length - removedSpacesCounter; i++) {
            if (chars[i] == target) {
                ctrl++;
                if (ctrl > 1) {
                    removedSpacesCounter++;
                    for (int j = chars.length - removedSpacesCounter; j > i; j--) {
                        swap(chars, i, j);
                    }

                    if (chars[i] == target) {
                        i--;
                    }
                }
            } else {
                ctrl = 0;
            }
        }

        char[] newChars = reduce(chars, removedSpacesCounter);
        chars = null;

        return new String(newChars);
    }

    // Алгоритм для удаления "крайних" пробелов с обеих сторон строки.
    public String trim(String string) {
        char[] initChars = string.toCharArray();
        int firstIndex = 0;
        int lastIndex = initChars.length - 1;

        while (initChars[firstIndex] == ' ' || initChars[lastIndex] == ' ') {
            if (initChars[firstIndex] != ' ') {
                firstIndex--;
            } else if (initChars[lastIndex] != ' ' ) {
                lastIndex++;
            }

            firstIndex++;
            lastIndex--;
        }

        int length = lastIndex - firstIndex + 1;
        char[] trimmedChars = new char[length];

        for (int i = firstIndex, j = 0; i <= lastIndex; i++, j++) {
            trimmedChars[j] = initChars[i];
        }

        initChars = null;

        return new String(trimmedChars);
    }

    private char[] concat(char[] oldChars, char charToAdd, int index) {
        char[] newChars = new char[index + 1];

        for (int i = 0; i < oldChars.length; i++) {
            newChars[i] = oldChars[i];
        }
        newChars[newChars.length - 1] = charToAdd;

        oldChars = null;

        return newChars;
    }

    private void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }

    private char[] reduce(char[] oldChars, int removedSpacesCounter) {
        char[] newChars = new char[oldChars.length - removedSpacesCounter];

        for (int i = 0; i < newChars.length; i++) {
            newChars[i] = oldChars[i];
        }

        oldChars = null;

        return newChars;
    }
}