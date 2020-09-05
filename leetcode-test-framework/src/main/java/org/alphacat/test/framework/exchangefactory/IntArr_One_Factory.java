package org.alphacat.test.framework.exchangefactory;

public class IntArr_One_Factory implements TestHelperFactory<int[]> {

    @Override
    public int[] deserialize(String s) {
        if (s == null) {
            return new int[0];
        }
        String temp1 = s.replace("[", "");
        String temp2 = temp1.replace("]", "");
        if (temp2.length() == 0) {
            return new int[0];
        }
        String[] s2 = temp2.split(",");
        int n = s2.length;
        int[] res = new int[n];
        for (int i = 0; i < n; ++i) {
            res[i] = Integer.parseInt(s2[i]);
        }
        return res;
    }

    @Override
    public String serialize(int[] output) {
        if (output == null) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i : output) {
            sb.append(i);
            sb.append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }
}
