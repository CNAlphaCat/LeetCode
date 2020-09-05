package org.alphacat.test.framework.interfaceimp;


import org.alphacat.test.framework.datastructure.TextCase_1;
import org.alphacat.test.framework.exchangefactory.FactorySelector;
import org.alphacat.test.framework.exchangefactory.TestHelperFactory;

import java.util.ArrayList;
import java.util.List;

public class LeetCodeTest_1_Imp<I, O> {

    private String inputType;
    private String outputType;
    LeetCodeTextCommonImp<O> imp;

    public LeetCodeTest_1_Imp(String _inputType, String _outputType) {
        inputType = _inputType;
        outputType = _outputType;
        imp = new LeetCodeTextCommonImp<>(outputType);
    }


    public List<TextCase_1> getTestCase(List<String[]> originalCase) {
        List<TextCase_1> list = new ArrayList<>(originalCase.size());
        for (String[] strArr : originalCase) {
            TextCase_1<I> textCase = new TextCase_1<>();
            String inputString = strArr[0];
            String expectedOutputString = strArr[1];
            textCase.inputStrings = imp.getInputListString(inputString);
            textCase.inputString = inputString;
            textCase.input = changeInput(inputString);
            textCase.expectedOutputString = expectedOutputString;
            list.add(textCase);
        }
        return list;
    }

    public void addToList(List<String[]> list, String input, String output) {
        imp.addToList(list, input, output);
    }

    public I changeInput(String input) {
        TestHelperFactory<I> inputFactory;
        FactorySelector fs = new FactorySelector();
        inputFactory = fs.getFactory(inputType);
        return (I) inputFactory.deserialize(input);
    }
}
