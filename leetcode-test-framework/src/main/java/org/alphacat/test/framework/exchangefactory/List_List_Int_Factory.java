package org.alphacat.test.framework.exchangefactory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class List_List_Int_Factory implements TestHelperFactory<List<List<Integer>>> {
    @Override
    public List<List<Integer>> deserialize(String s) {
        if (s == null) {
            return new LinkedList<>();
        }
        TestHelperFactory<int[][]> factory = new IntArr_Two_Factory();
        int[][] intArr = factory.deserialize(s);
        return initialList(intArr);
    }

    @Override
    public String serialize(List<List<Integer>> output) {
        if (output == null) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (List<Integer> integerList : output) {
            TestHelperFactory factory = new List_Int_Factory();
            String tempS = factory.serialize(integerList);
            sb.append(tempS);
            sb.append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }

    private List<List<Integer>> initialList(int[][] arr) {
        List<List<Integer>> res = new ArrayList<>();
        int n = arr.length;
        List_Int_Factory factory = new List_Int_Factory();
        for (int i = 0; i < n; ++i) {
            int[] temp = arr[i];
            List<Integer> l = factory.initialList(temp);
            res.add(l);
        }
        return res;
    }
}
