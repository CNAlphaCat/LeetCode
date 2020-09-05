package org.alphacat.test.framework.exchangefactory;

public class StringArr_Factory implements TestHelperFactory<String[]> {

    @Override
    public String[] deserialize(String s) {
        if (s == null) {
            return new String[0];
        }
        String temp1 = s.replace("\"", "");
        String temp2 = temp1.replace("[", "");
        String temp3 = temp2.replace("]", "");
        String[] res = temp3.split(",");
        return res;
    }

    @Override
    public String serialize(String[] output) {
        if (output == null) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (String s : output) {
            sb.append(s);
            sb.append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }
}
