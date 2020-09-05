package org.alphacat.test.framework.leetcodetest;


import org.alphacat.test.framework.datastructure.TextCase_4;
import org.alphacat.test.framework.interfaceimp.LeetCodeTest_4_Imp;
import org.alphacat.test.framework.interfaceimp.LeetCodeTextCommonImp;
import org.alphacat.test.framework.util.ClassHelper;

import java.util.List;

public interface LeetCodeTest_4<I1, I2, I3, I4, O> {
    default void test() {
        List<TextCase_4> list = getTestCase();
        boolean hasError = false;
        LeetCodeTextCommonImp commonImp = getCommonImp();
        for (TextCase_4<I1, I2, I3, I4> testcase : list) {
            I1 input_1 = testcase.input_1;
            I2 input_2 = testcase.input_2;
            I3 input_3 = testcase.input_3;
            I4 input_4 = testcase.input_4;

            O output = testTask(input_1, input_2, input_3,input_4);
            boolean isEqual = commonImp.isEqual(output, testcase.expectedOutputString);
            if (!isEqual) {
                hasError = true;
                commonImp.outputMessage(testcase, output);
                continue;
            }
        }
        if (!hasError) {
            commonImp.passMessage();
        }
    }

    default LeetCodeTest_4_Imp getImp() {
        String inputT_1 = ClassHelper.getInterfaceTName(this, 0, 0);
        String inputT_2 = ClassHelper.getInterfaceTName(this, 0, 1);
        String inputT_3 = ClassHelper.getInterfaceTName(this, 0, 2);
        String inputT_4 = ClassHelper.getInterfaceTName(this, 0, 3);

        String outputT = ClassHelper.getInterfaceTName(this, 0, 4);

        LeetCodeTest_4_Imp<I1, I2, I3, I4, O> imp = new LeetCodeTest_4_Imp(inputT_1, inputT_2, inputT_3, inputT_4, outputT);
        return imp;
    }

    default LeetCodeTextCommonImp getCommonImp() {
        String outputT = ClassHelper.getInterfaceTName(this, 0, 1);
        LeetCodeTextCommonImp commonImp = new LeetCodeTextCommonImp(outputT);
        return commonImp;
    }

    //原始样例数据
    List<String[]> getOriginalCase();

    //和测试主程序进行一次组合即可
    O testTask(I1 input_1, I2 input_2, I3 input_3, I4 input_4);

    default List<TextCase_4> getTestCase() {
        LeetCodeTest_4_Imp lcTextImpInterface = getImp();
        List<String[]> list = getOriginalCase();
        return lcTextImpInterface.getTestCase(list);
    }

    default void addToList(List<String[]> list, String input_1, String input_2, String input_3
            , String input_4, String output) {
        LeetCodeTest_4_Imp imp = getImp();
        imp.addToList(list, input_1, input_2, input_3, input_4, output);
    }
}
