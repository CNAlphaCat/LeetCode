package org.alphacat.test.framework.interfaceimp;


import org.alphacat.test.framework.datastructure.TextCase;
import org.alphacat.test.framework.exchangefactory.FactorySelector;
import org.alphacat.test.framework.exchangefactory.TestHelperFactory;

import java.util.ArrayList;
import java.util.List;

public class LeetCodeTextCommonImp<O> {

    private String outputName;
    private FactorySelector fs;
    private TestHelperFactory<O> outputFactory;

    public LeetCodeTextCommonImp(String _outputType) {
        fs = new FactorySelector();
        outputName = _outputType;
        outputFactory = fs.getFactory(outputName);
    }

    public void outputMessage(TextCase textCase, O output) {
        List<String> inputString = textCase.inputStrings;
        printLine();
        System.out.println("以下用例可能有错误");
        System.out.println("输入：");
        for (String input : inputString) {
            System.out.println(input);
        }
        String userOutput = outputFactory.serialize(output);
        System.out.println("你的输出： " + userOutput);
        System.out.println("预期的输出： " + textCase.expectedOutputString);
        printLine();
    }

    public void printLine() {
        System.out.println("--------------------------------------------");
    }

    public void passMessage() {
        printLine();
        System.out.println("测试用例全部通过");
        printLine();
    }

    public boolean isEqual(O output, O expectedRes) {
        try {
            String outputS = outputFactory.serialize(output);
            String expectedOutputS = outputFactory.serialize(expectedRes);
            return isEqual(outputS, expectedOutputS);
        } catch (Exception exception) {

        }
        return output.equals(expectedRes);
    }

    public boolean isEqual(O output, String expectedRes) {
        try {
            if (output == null) {
                return isEqual("", expectedRes);
            }
            String outputS = outputFactory.serialize(output);
            return isEqual(outputS, expectedRes);
        } catch (Exception exception) {

        }
        return output.equals(expectedRes);
    }

    public boolean isEqual(String output, String expectedRes) {
        return output.equals(expectedRes);
    }


    public O changeOutput(String output) {
        return (O) outputFactory.deserialize(output);
    }

    public void addToList(List<String[]> list, String input, String output) {
        String[] temp = new String[2];
        temp[0] = input;
        temp[1] = output;
        list.add(temp);
    }

    public void addToList(List<String[]> list, String input_1, String input_2, String output) {
        String[] temp = new String[3];
        temp[0] = input_1;
        temp[1] = input_2;
        temp[2] = output;
        list.add(temp);
    }

    public void addToList(List<String[]> list, String input_1, String input_2, String input_3,
                          String output) {
        String[] temp = new String[4];
        temp[0] = input_1;
        temp[1] = input_2;
        temp[2] = input_3;
        temp[3] = output;
        list.add(temp);
    }

    public void addToList(List<String[]> list, String input_1, String input_2, String input_3
            , String input_4, String output) {
        String[] temp = new String[5];
        temp[0] = input_1;
        temp[1] = input_2;
        temp[2] = input_3;
        temp[3] = input_4;
        temp[4] = output;
        list.add(temp);
    }

    public List<String> getInputListString(String input) {
        List<String> list = new ArrayList<>(1);
        list.add(input);
        return list;
    }

    public List<String> getInputListString(String input_1, String input_2) {
        List<String> list = new ArrayList<>(2);
        list.add(input_1);
        list.add(input_2);
        return list;
    }

    public List<String> getInputListString(String input_1, String input_2, String input_3) {
        List<String> list = new ArrayList<>(3);
        list.add(input_1);
        list.add(input_2);
        list.add(input_3);
        return list;
    }

    public List<String> getInputListString(String input_1, String input_2, String input_3,
                                           String input_4) {
        List<String> list = new ArrayList<>(4);
        list.add(input_1);
        list.add(input_2);
        list.add(input_3);
        list.add(input_4);
        return list;
    }
}
