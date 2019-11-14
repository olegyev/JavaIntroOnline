package by.yevstratyev.java_intro.module_03.task_16.logic;

import by.yevstratyev.java_intro.module_03.task_16.bean.Text;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexemeSorter {
    public Text sort(Text text, char target) {
        if (text == null || text.getContent().isEmpty()) {
            return null;
        }

        Pattern newSentence = Pattern.compile("[.?!]+(\\s+|$)");
        String[] sentences = newSentence.split(text.getContent());

        List<String> lexemes;
        StringBuilder result = new StringBuilder();
        for (String sentence : sentences) {
            lexemes = sortLexemes(sentence, target);
            for (int i = 0; i < lexemes.size() - 1; i++) {
                result.append(lexemes.get(i)).append(" ");
            }
            result.append(lexemes.get(lexemes.size() - 1));
            result.append("\n");
        }

        sentences = null;
        lexemes = null;

        return new Text(result.toString());
    }

    private static List<String> sortLexemes(String sentence, char target) {
        List<String> lexemes = new ArrayList<String>();
        Pattern letters = Pattern.compile("[a-zA-z&&[^_]]+");
        Matcher matcher = letters.matcher(sentence);
        while (matcher.find()) {
            lexemes.add(sentence.substring(matcher.start(), matcher.end()));
        }
        lexemes.sort(new CharEntriesComparator(target));
        return lexemes;
    }
}