package org.alphacat.test.framework.exchangefactory;

public interface TestHelperFactory<T> {
    T deserialize(String s);
    String serialize(T output);
}
