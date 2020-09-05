package org.alphacat.test.framework.leetcodetest;


import org.alphacat.test.framework.datastructure.TextCase_1;
import org.alphacat.test.framework.interfaceimp.LeetCodeTest_1_Imp;
import org.alphacat.test.framework.interfaceimp.LeetCodeTextCommonImp;
import org.alphacat.test.framework.util.ClassHelper;

import java.util.List;

public interface LeetCodeTest_1<I, O> {

    default void test() {
        List<TextCase_1> list = getTestCase();
        boolean hasError = false;
        LeetCodeTextCommonImp commonImp = getCommonImp();
        for (TextCase_1<I> testcase : list) {
            I input = testcase.input;
            O output = testTask(input);
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

    default LeetCodeTest_1_Imp getImp() {
        String inputT = ClassHelper.getInterfaceTName(this, 0, 0);
        String outputT = ClassHelper.getInterfaceTName(this, 0, 1);
        LeetCodeTest_1_Imp<I, O> imp = new LeetCodeTest_1_Imp(inputT, outputT);
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
    O testTask(I input);

    default List<TextCase_1> getTestCase() {
        LeetCodeTest_1_Imp<I, O> lcTextImpInterface = getImp();
        List<String[]> list = getOriginalCase();
        return lcTextImpInterface.getTestCase(list);
    }

    default void addToList(List<String[]> list, String input, String output) {
        LeetCodeTest_1_Imp<I, O> imp = getImp();
        imp.addToList(list, input, output);
    }
}
