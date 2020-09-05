package org.alphacat.test.framework.interfaceimp;


import org.alphacat.test.framework.datastructure.TextCase_2;
import org.alphacat.test.framework.exchangefactory.FactorySelector;
import org.alphacat.test.framework.exchangefactory.TestHelperFactory;

import java.util.ArrayList;
import java.util.List;

public class LeetCodeTest_2_Imp<I1, I2, O>{

    private LeetCodeTextCommonImp<O> imp;
    private String inputName_1;
    private String inputName_2;

    public LeetCodeTest_2_Imp(String _inputName_1, String _inputName_2, String _outputName) {
        imp = new LeetCodeTextCommonImp(_outputName);
        inputName_1 = _inputName_1;
        inputName_2 = _inputName_2;
    }

    public List<TextCase_2> getTestCase(List<String[]> originalCase) {
        List<TextCase_2> list = new ArrayList<>(originalCase.size());
        for (String[] strArr : originalCase) {
            TextCase_2<I1, I2> textCase = new TextCase_2<>();
            String inputString_1 = strArr[0];
            String inputString_2 = strArr[1];
            String expectedOutputString = strArr[2];

            textCase.inputStrings = imp.getInputListString(inputString_1, inputString_2);
            textCase.inputString_1 = inputString_1;
            textCase.inputString_2 = inputString_2;
            textCase.input_1 = changeInput_1(inputString_1);
            textCase.input_2 = changeInput_2(inputString_2);
            textCase.expectedOutputString = expectedOutputString;

            list.add(textCase);
        }
        return list;
    }

    public void addToList(List<String[]> list, String input_1, String input_2, String output) {
        imp.addToList(list, input_1, input_2, output);
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
}
