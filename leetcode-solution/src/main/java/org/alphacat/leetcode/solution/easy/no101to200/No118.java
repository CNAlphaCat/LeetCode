package org.alphacat.leetcode.solution.easy.no101to200;

import java.util.ArrayList;
import java.util.List;

public class No118 {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        if (numRows == 0) {
            return ans;
        }
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        ans.add(firstRow);
        List<Integer> preRow = firstRow;
        for (int i = 2; i <= numRows; i++) {
            List<Integer> row = new ArrayList<>(i);
            row.add(1);
            for (int j = 1; j < i - 1; j++) {
                int num = preRow.get(j - 1) + preRow.get(j);
                row.add(num);
            }
            row.add(1);
            ans.add(row);
            preRow = row;
        }
        return ans;
    }
}
