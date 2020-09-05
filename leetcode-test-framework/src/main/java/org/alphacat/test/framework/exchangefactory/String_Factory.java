package org.alphacat.test.framework.exchangefactory;

public class String_Factory implements TestHelperFactory<String> {

    @Override
    public String deserialize(String s) {
        return s;
    }

    @Override
    public String serialize(String output) {
        return output;
    }
}
