package org.alphacat.leetcode.solution.mid.interview;

import java.util.LinkedList;
import java.util.List;

public class Interview08_07 {
    char[] charArrOfS;
    int n;
    List<String> list;

    public String[] permutation(String S) {
        initial(S);
        permute(0);
        String[] res = list.toArray(new String[list.size()]);
        return res;
    }

    private void permute(int begin) {
        if (begin == n - 1) {
            String tempS = new String(charArrOfS);
            list.add(tempS);
            return;
        }
        for (int i = begin; i < n; i++) {
            swap(begin, i);
            permute(begin + 1);
            swap(begin, i);
        }
    }

    private void swap(int i, int j) {
        char temp = charArrOfS[i];
        charArrOfS[i] = charArrOfS[j];
        charArrOfS[j] = temp;
    }

    private void initial(String S) {
        list = new LinkedList<>();
        charArrOfS = S.toCharArray();
        n = S.length();
    }
}
