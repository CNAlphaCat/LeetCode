package org.alphacat.test.framework.exchangefactory;



import org.alphacat.test.framework.util.ClassHelper;

import java.util.HashMap;

public class FactorySelector {

    public TestHelperFactory getFactory(String classType) {

        HashMap<String, TestHelperFactory> map = getFactoryMap();
        if (map.containsKey(classType)) {
            return map.get(classType);
        }
        throw new NullPointerException("Not find a suitable factory");
    }

    private HashMap getFactoryMap() {
        HashMap<String, TestHelperFactory> map = new HashMap<>();

        String intArr_One_Class = ClassHelper.getIntArr_One_ClassTypeName();
        String String_Class = ClassHelper.getStringArr_ClassTypeName();
        String intArr_Two_Class = ClassHelper.getIntArr_Two_ClassTypeName();
        String charArr_Two_Class = ClassHelper.getCharArr_Two_ClassTypeName();
        String list_Int_Class = ClassHelper.getList_Int_ClassTypeName();
        String list_List_Int_ClassTypeName = ClassHelper.getList_List_Int_ClassTypeName();
        String treeNode_ClassTypeName = ClassHelper.getTreeNode_ClassTypeName();
        String string_ClassTypeName = ClassHelper.getString_ClassTypeName();
        String integer = ClassHelper.getInteger_ClassTypeName();

        map.put(intArr_One_Class, new IntArr_One_Factory());
        map.put(intArr_Two_Class, new IntArr_Two_Factory());
        map.put(String_Class, new StringArr_Factory());
        map.put(charArr_Two_Class, new CharArr_Two_Factory());
        map.put(list_Int_Class, new List_Int_Factory());
        map.put(list_List_Int_ClassTypeName, new List_List_Int_Factory());
        map.put(treeNode_ClassTypeName, new TreeNode_Factory());
        map.put(string_ClassTypeName, new String_Factory());
        map.put(integer, new Integer_Factory());

        return map;
    }

    private TestHelperFactory getFactory_old(String classType) {
        String intArr_One_Class = ClassHelper.getIntArr_One_ClassTypeName();
        String String_Class = ClassHelper.getStringArr_ClassTypeName();
        String intArr_Two_Class = ClassHelper.getIntArr_Two_ClassTypeName();
        String charArr_Two_Class = ClassHelper.getCharArr_Two_ClassTypeName();
        String list_Int_Class = ClassHelper.getList_Int_ClassTypeName();
        String list_List_Int_ClassTypeName = ClassHelper.getList_List_Int_ClassTypeName();
        String treeNode_ClassTypeName = ClassHelper.getTreeNode_ClassTypeName();
        String string_ClassTypeName = ClassHelper.getString_ClassTypeName();
        String integer = ClassHelper.getInteger_ClassTypeName();

        if (classType.equals(intArr_One_Class)) {
            return new IntArr_One_Factory();
        }
        if (classType.equals(intArr_Two_Class)) {
            return new IntArr_Two_Factory();
        }

        if (classType.equals(String_Class)) {
            return new StringArr_Factory();
        }

        if (classType.equals(charArr_Two_Class)) {
            return new CharArr_Two_Factory();
        }

        if (classType.equals(list_Int_Class)) {
            return new List_Int_Factory();
        }
        if (classType.equals(list_List_Int_ClassTypeName)) {
            return new List_List_Int_Factory();
        }

        if (classType.equals(treeNode_ClassTypeName)) {
            return new TreeNode_Factory();
        }

        if (classType.equals(string_ClassTypeName)) {
            return new String_Factory();
        }
        if (classType.equals(integer)) {
            return new Integer_Factory();
        }
        throw new NullPointerException("Not find a suitable factory");
    }
}
