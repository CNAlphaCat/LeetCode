package org.alphacat.leetcode.solution.easy.no1301to1400;



import org.alphacat.test.framework.leetcodetest.LeetCodeTest_1;

import java.util.ArrayList;
import java.util.List;

public class No1370 implements LeetCodeTest_1<String, String> {

    @Override
    public String testTask(String s) {
        return sortString(s);
    }

    @Override
    public List<String[]> getOriginalCase() {
        List<String[]> list = new ArrayList<>();

        addToList(list, "aaaabbbbcccc", "abccbaabccba");
        addToList(list,"rat","art");
        addToList(list,"leetcode","cdelotee");
        addToList(list,"ggggggg","ggggggg");
        addToList(list,"spo","ops");

        return list;
    }


    private int indexLow;
    private int indexHigh;
    int[] alphabet;
    int n;
    private char finishFlag = 'F';

    public String sortString(String s) {
        initial(s);

        StringBuilder sb = new StringBuilder();
        char crrMinChar = 'a' - 1;
        char crrMaxChar = 'z' + 1;
        char crrChar;

        while (sb.length() < n) {
            crrChar = crrMinChar;
            while (true) {
                crrChar = findMin(crrChar);
                if (isFinish(crrChar)) {
                    break;
                }
                sb.append(crrChar);
            }
            crrChar = crrMaxChar;
            while (true) {
                crrChar = findMax(crrChar);
                if (isFinish(crrChar)) {
                    break;
                }
                sb.append(crrChar);
            }
        }
        return sb.toString();
    }

    private boolean isFinish(char c) {
        return c == finishFlag;
    }

    private char findMin(char crrChar) {
        int i = indexLow;
        while (i <= indexHigh && alphabet[i] == 0) {
            indexLow++;
            i++;
        }
        while (i <= indexHigh) {
            if (alphabet[i] > 0 && i > crrChar) {
                alphabet[i]--;
                return (char) i;
            }
            i++;
        }
        return finishFlag;
    }

    private char findMax(char crrChar) {
        int i = indexHigh;
        while (i >= indexLow && alphabet[i] == 0) {
            indexHigh--;
            i--;
        }
        while (i >= indexLow) {
            if (alphabet[i] > 0 && i < crrChar) {
                alphabet[i]--;
                return (char) i;
            }
            i--;
        }
        return finishFlag;
    }

    private void initial(String s) {
        indexLow = 'a';
        indexHigh = 'z';
        n = s.length();
        alphabet = new int[128];
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            alphabet[c]++;
        }
    }

}
