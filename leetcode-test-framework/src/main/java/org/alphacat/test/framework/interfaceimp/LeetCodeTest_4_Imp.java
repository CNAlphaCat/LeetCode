package org.alphacat.test.framework.interfaceimp;


import org.alphacat.test.framework.datastructure.TextCase_4;
import org.alphacat.test.framework.exchangefactory.FactorySelector;
import org.alphacat.test.framework.exchangefactory.TestHelperFactory;

import java.util.ArrayList;
import java.util.List;

public class LeetCodeTest_4_Imp<I1, I2, I3, I4, O> {
    private LeetCodeTextCommonImp<O> imp;

    private String inputName_1;
    private String inputName_2;
    private String inputName_3;
    private String inputName_4;

    public LeetCodeTest_4_Imp(String _inputName_1, String _inputName_2, String _inputName_3
            , String _inputName_4, String _outputName) {
        imp = new LeetCodeTextCommonImp(_outputName);
        inputName_1 = _inputName_1;
        inputName_2 = _inputName_2;
        inputName_3 = _inputName_3;
        inputName_4 = _inputName_4;
    }

    public List<TextCase_4> getTestCase(List<String[]> originalCase) {
        List<TextCase_4> list = new ArrayList<>(originalCase.size());
        for (String[] strArr : originalCase) {
            TextCase_4<I1, I2, I3, I4> textCase = new TextCase_4<>();

            String inputString_1 = strArr[0];
            String inputString_2 = strArr[1];
            String inputString_3 = strArr[2];
            String inputString_4 = strArr[3];

            String expectedOutputString = strArr[4];

            textCase.inputStrings = imp.getInputListString(inputString_1, inputString_2, inputString_3, inputString_4);

            textCase.inputString_1 = inputString_1;
            textCase.inputString_2 = inputString_2;
            textCase.inputString_3 = inputString_3;
            textCase.inputString_4 = inputString_4;

            textCase.input_1 = changeInput_1(inputString_1);
            textCase.input_2 = changeInput_2(inputString_2);
            textCase.input_3 = changeInput_3(inputString_3);
            textCase.input_4 = changeInput_4(inputString_4);

            textCase.expectedOutputString = expectedOutputString;

            list.add(textCase);
        }
        return list;
    }

    public void addToList(List<String[]> list, String input_1, String input_2, String input_3
            , String input_4 ,String output) {
        imp.addToList(list, input_1, input_2,input_3,input_4, output);
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

    public I4 changeInput_4(String input) {
        TestHelperFactory<I4> inputFactory;
        FactorySelector fs = new FactorySelector();
        inputFactory = fs.getFactory(inputName_4);
        return (I4) inputFactory.deserialize(input);
    }
}
