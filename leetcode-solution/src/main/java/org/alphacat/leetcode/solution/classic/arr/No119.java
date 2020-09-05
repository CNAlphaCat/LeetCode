package org.alphacat.leetcode.solution.classic.arr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class No119 {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>(rowIndex);
        long pre = 1;
        ans.add(1);
        for (int i = 1; i <= rowIndex / 2; i++) {
            long currentNum = pre * (rowIndex - i + 1) / i;
            ans.add((int) currentNum);
            pre = currentNum;
        }
        //利用对称性质
        for (int i = rowIndex / 2 + 1; i <= rowIndex; i++) {
            ans.add(ans.get(rowIndex - i));
        }
        return ans;
    }

    public List<Integer> getRow_2(int rowIndex) {
        List<Integer> ans = new ArrayList<>(rowIndex);
        for (int i = 0; i <= rowIndex / 2; i++) {
            ans.add((int) Combination(rowIndex, i));
        }
        //利用对称性质
        for (int i = rowIndex / 2 + 1; i <= rowIndex; i++) {
            ans.add(ans.get(rowIndex - i));
        }
        return ans;
    }

    private int Combination(int N, int k) {
        if (k > N / 2) {
            return Combination(N, N - k);
        }
        long res = 1;
        for (int i = 1; i <= k; i++) {
            res = res * (N - k + i) / i;
            //res *= (N - k + i) / i;这么写会出错
        }
        return (int) res;
    }

    static Map<String, Long> map = new HashMap<String, Long>();

    private static long Combination_2(int m, int n) {
        final int ERROR_NUM = -1;
        String key = m + "," + n;
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return m;
        }
        if (n > m / 2) {
            return Combination_2(m, m - n);
        }
        if (n > 1) {
            if (!map.containsKey(key)) {
                map.put(key, Combination_2(m - 1, n - 1) + Combination_2(m - 1, n));
            }
            return map.get(key);
        }
        return ERROR_NUM;
    }


    public List<Integer> getRow_3(int rowIndex) {
        List<Integer> ans = lessThanOneCase(rowIndex);
        if (rowIndex <= 1) {
            return ans;
        }
        for (int i = 2; i <= rowIndex; i++) {
            for (int j = i - 1; j > 0; j--) {
                ans.set(j, ans.get(j) + ans.get(j - 1));
            }
            ans.add(1);
        }
        return ans;
    }

    public List<Integer> getRow_4(int rowIndex) {
        List<Integer> ans = lessThanOneCase(rowIndex);
        if (rowIndex <= 1) {
            return ans;
        }
        int preNum = ans.get(1);
        for (int i = 2; i <= rowIndex; i++) {
            for (int j = 1; j <= i - 1; j++) {
                int tempNum = ans.get(j);
                int currentNum = preNum + tempNum;
                ans.set(j, currentNum);
                preNum = tempNum;
            }
            ans.add(1);
        }
        return ans;
    }

    private List<Integer> lessThanOneCase(int rowIndex) {
        List<Integer> list = new ArrayList<>(rowIndex);
        list.add(1);
        if (rowIndex == 0) {
            return list;
        }
        list.add(1);
        return list;
    }
}
