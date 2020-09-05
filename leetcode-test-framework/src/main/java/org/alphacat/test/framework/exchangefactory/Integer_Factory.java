package org.alphacat.test.framework.exchangefactory;

public class Integer_Factory implements TestHelperFactory<Integer> {
    @Override
    public Integer deserialize(String s) {
        return Integer.parseInt(s);
    }

    @Override
    public String serialize(Integer output) {
        if (output == null) {
            return "";
        }
        return String.valueOf(output);
    }
}
