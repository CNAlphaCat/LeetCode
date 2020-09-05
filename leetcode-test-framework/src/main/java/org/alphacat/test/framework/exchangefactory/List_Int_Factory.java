package org.alphacat.test.framework.exchangefactory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class List_Int_Factory implements TestHelperFactory<List<Integer>> {
    @Override
    public List<Integer> deserialize(String s) {
        if (s == null) {
            return new LinkedList<>();
        }
        TestHelperFactory<int[]> factory = new IntArr_One_Factory();
        int[] intArr = factory.deserialize(s);
        return initialList(intArr);
    }

    @Override
    public String serialize(List<Integer> output) {
        if (output == null) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Integer integer : output) {
            sb.append(integer);
            sb.append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }

    public List<Integer> initialList(int[] arr) {
        int n = arr.length;
        List<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            res.add(arr[i]);
        }
        return res;
    }
}
