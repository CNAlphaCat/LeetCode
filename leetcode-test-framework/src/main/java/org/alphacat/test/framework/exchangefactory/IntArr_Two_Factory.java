package org.alphacat.test.framework.exchangefactory;

import java.util.LinkedList;
import java.util.Queue;

public class IntArr_Two_Factory implements TestHelperFactory<int[][]> {
    @Override
    public int[][] deserialize(String s) {
        if (s == null) {
            return new int[0][];
        }
        Queue<int[]> queue = new LinkedList<int[]>();
        s = s.substring(0, s.length() - 1);
        s = s.substring(1, s.length());
        int maxM = 0;
        TestHelperFactory<int[]> factory = new IntArr_One_Factory();
        while (s.length() > 0) {
            int b = s.indexOf("[");
            int e = s.indexOf("]");
            String temp = s.substring(b, e + 1);
            int[] intArr = factory.deserialize(temp);
            maxM = Math.max(intArr.length, maxM);
            queue.add(intArr);
            s = s.substring(e + 1, s.length());
        }
        int m = maxM;
        int n = queue.size();
        int[][] res = new int[n][m];
        for (int i = 0; i < n; ++i) {
            res[i] = queue.poll();
        }
        return res;
    }

    @Override
    public String serialize(int[][] output) {
        if (output == null) {
            return "[]";
        }
        IntArr_One_Factory intArr_one_factory = new IntArr_One_Factory();
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int[] ints : output) {
            String tempS = intArr_one_factory.serialize(ints);
            sb.append(tempS);
            sb.append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        return null;
    }
}
