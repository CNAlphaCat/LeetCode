package org.alphacat.test.framework.leetcodetest;


import org.alphacat.test.framework.datastructure.TextCase_2;
import org.alphacat.test.framework.interfaceimp.LeetCodeTest_2_Imp;
import org.alphacat.test.framework.interfaceimp.LeetCodeTextCommonImp;
import org.alphacat.test.framework.util.ClassHelper;

import java.util.List;

public interface LeetCodeTest_2<I1, I2, O> {

    default void test() {
        List<TextCase_2> list = getTestCase();
        boolean hasError = false;
        LeetCodeTextCommonImp commonImp = getCommonImp();
        for (TextCase_2<I1, I2> testcase : list) {
            I1 input_1 = testcase.input_1;
            I2 input_2 = testcase.input_2;
            O output = testTask(input_1, input_2);
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

    default LeetCodeTest_2_Imp getImp() {
        String inputT_1 = ClassHelper.getInterfaceTName(this, 0, 0);
        String inputT_2 = ClassHelper.getInterfaceTName(this, 0, 1);
        String outputT = ClassHelper.getInterfaceTName(this, 0, 2);
        LeetCodeTest_2_Imp<I1, I2, O> imp = new LeetCodeTest_2_Imp(inputT_1, inputT_2, outputT);
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
    O testTask(I1 input_1, I2 input_2);

    default List<TextCase_2> getTestCase() {
        LeetCodeTest_2_Imp lcTextImpInterface = getImp();
        List<String[]> list = getOriginalCase();
        return lcTextImpInterface.getTestCase(list);
    }

    default void addToList(List<String[]> list, String input_1, String input_2, String output) {
        LeetCodeTest_2_Imp imp = getImp();
        imp.addToList(list, input_1, input_2, output);
    }
}
