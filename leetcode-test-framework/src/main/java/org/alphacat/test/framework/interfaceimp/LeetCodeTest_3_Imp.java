package org.alphacat.test.framework.interfaceimp;


import org.alphacat.test.framework.datastructure.TextCase_3;
import org.alphacat.test.framework.exchangefactory.FactorySelector;
import org.alphacat.test.framework.exchangefactory.TestHelperFactory;

import java.util.ArrayList;
import java.util.List;

public class LeetCodeTest_3_Imp<I1, I2, I3, O> {
    private LeetCodeTextCommonImp<O> imp;
    
    private String inputName_1;
    private String inputName_2;
    private String inputName_3;

    public LeetCodeTest_3_Imp(String _inputName_1, String _inputName_2, String _inputName_3,
                              String _outputName) {
        imp = new LeetCodeTextCommonImp(_outputName);
        inputName_1 = _inputName_1;
        inputName_2 = _inputName_2;
        inputName_3 = _inputName_3;
    }

    public List<TextCase_3> getTestCase(List<String[]> originalCase) {
        List<TextCase_3> list = new ArrayList<>(originalCase.size());
        for (String[] strArr : originalCase) {
            TextCase_3<I1, I2, I3> textCase = new TextCase_3<>();

            String inputString_1 = strArr[0];
            String inputString_2 = strArr[1];
            String inputString_3 = strArr[2];

            String expectedOutputString = strArr[3];

            textCase.inputStrings = imp.getInputListString(inputString_1, inputString_2, inputString_3);

            textCase.inputString_1 = inputString_1;
            textCase.inputString_2 = inputString_2;
            textCase.inputString_3 = inputString_3;

            textCase.input_1 = changeInput_1(inputString_1);
            textCase.input_2 = changeInput_2(inputString_2);
            textCase.input_3 = changeInput_3(inputString_3);

            textCase.expectedOutputString = expectedOutputString;

            list.add(textCase);
        }
        return list;
    }

    public void addToList(List<String[]> list, String input_1, String input_2, String input_3,
                          String output) {
        imp.addToList(list, input_1, input_2,input_3, output);
    }

    public I1 changeInput_1(String input) {
        TestHelperFactory<I1> inputFactory;
        FactorySelector fs = new FactorySelector();
        inputFactory = fs.getFactory(inputName_1);
        return (I1) inputFactory.deserialize(input);
    }

    public I2 changeInput_2(String input) {
        TestHelperFactory<I2> inputFactory;
        FactorySelector fs = new FactorySelector();
        inputFactory = fs.getFactory(inputName_2);
        return (I2) inputFactory.deserialize(input);
    }

    public I3 changeInput_3(String input) {
        TestHelperFactory<I3> inputFactory;
        FactorySelector fs = new FactorySelector();
        inputFactory = fs.getFactory(inputName_3);
        return (I3) inputFactory.deserialize(input);
    }
}
