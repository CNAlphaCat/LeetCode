package org.alphacat.leetcode.solution.classic.string;

import java.util.ArrayList;
import java.util.List;

public class No22 {

    int n;
    List<String> list;

    public List<String> generateParenthesis(int n) {
        initial(n);
        dfs("", 0, 0);
        return this.list;
    }

    private void dfs(String s, int left, int right) {
        if (left + right == 2 * n) {
            list.add(s);
            return;
        }
        if (right > left) {
            return;
        }
        if (left < n) {
            dfs(s + "(", left + 1, right);
        }
        if (right < n) {
            dfs(s + ")", left, right + 1);
        }
    }

    private void initial(int _n) {
        this.n = _n;
        this.list = new ArrayList<>();
    }

    public List<String> generateParenthesis_2(int n) {
        List<String> dpInitialState = new ArrayList<>();
        dpInitialState.add("");
        List<List<String>> dp = new ArrayList<>();
        dp.add(dpInitialState);
        for (int i = 1; i <= n; i++) {
            List<String> tempList = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                List<String> bracketInsideList = dp.get(j);
                List<String> bracketOutsideList = dp.get(i - 1 - j);
                for (String sInside : bracketInsideList) {
                    for (String sOutside : bracketOutsideList) {
                        String temp = "(" + sInside + ")" + sOutside;
                        tempList.add(temp);
                        dp.add(i, tempList);
                    }
                }
            }
        }
        return dp.get(n);
    }
}
