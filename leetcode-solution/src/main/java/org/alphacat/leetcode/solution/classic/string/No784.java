package org.alphacat.leetcode.solution.classic.string;

import java.util.LinkedList;
import java.util.List;

public class No784 {

    int n;

    public List<String> letterCasePermutation(String S) {
        initial(S);
        return letterCasePermutation(new LinkedList<>(), S.toCharArray(), 0);
    }

    private List<String> letterCasePermutation(List<String> ans, char[] chars, int i) {
        if (i == n) {
            String value = String.valueOf(chars);
            ans.add(value);
            return ans;
        }
        if (Character.isLetter(chars[i])) {
            chars[i] = Character.toLowerCase(chars[i]);
            ans = letterCasePermutation(ans, chars, i + 1);
            chars[i] = Character.toUpperCase(chars[i]);
            ans = letterCasePermutation(ans, chars, i + 1);
            return ans;
        }
        return letterCasePermutation(ans, chars, i + 1);
    }

    private void initial(String _S) {
        n = _S.length();
    }
}
