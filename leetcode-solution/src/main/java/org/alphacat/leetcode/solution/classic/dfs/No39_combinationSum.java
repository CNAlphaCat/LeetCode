package org.alphacat.leetcode.solution.classic.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/combination-sum/
 * 39. 组合总和
 * keyword:回溯，剪枝，dfs
 * 题解：https://leetcode-cn.com/problems/combination-sum/solution/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-m-2/
 */
public class No39_combinationSum {

    private int[] candidates;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return new ArrayList<>();
        }
        initial(candidates, target);
        List<List<Integer>> ans = new ArrayList<>();
        dfs(0, ans, new LinkedList<>(), target);
        return ans;
    }

    private void initial(int[] _candidates, int _target) {
        Arrays.sort(_candidates);
        candidates = _candidates;
    }

    private void dfs(int searchBegin, List<List<Integer>> ans, LinkedList<Integer> curList, int remains) {
        if (remains == 0) {
            LinkedList<Integer> tempList = new LinkedList<>(curList);
            ans.add(tempList);
            return;
        }
        for (int i = searchBegin; i < candidates.length; ++i) {

            //剪枝
            int nextRemains = remains - candidates[i];
            if (nextRemains < 0) {
                break;
            }
            curList.addLast(candidates[i]);
            dfs(i, ans, curList, nextRemains);
            curList.removeLast();
        }
    }
}
