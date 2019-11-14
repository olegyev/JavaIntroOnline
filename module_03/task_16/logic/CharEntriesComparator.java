package by.yevstratyev.java_intro.module_03.task_16.logic;

import java.util.Comparator;

public class CharEntriesComparator implements Comparator<String> {
    private char target;

    public CharEntriesComparator(char target) {
        this.target = target;
    }

    @Override
    public int compare(String s1, String s2) {
        int entriesInWordOne = countTargetEntries(s1);
        int entriesInWordTwo = countTargetEntries(s2);

        if (entriesInWordOne < entriesInWordTwo) {
            return 1;
        } else if (entriesInWordOne > entriesInWordTwo) {
            return -1;
        } else {
            return s1.compareToIgnoreCase(s2);
        }
    }

    private int countTargetEntries(String string) {
        int entriesCounter = 0;

        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == target) {
                entriesCounter++;
            }
        }

        return entriesCounter;
    }
}