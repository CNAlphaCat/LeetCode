package org.alphacat.test.framework.util;


import org.alphacat.leetcode.datastructure.TreeNode;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class ClassHelper {
    //https://blog.csdn.net/u011082160/article/details/101025884

    public static String getInterfaceTName(Object o, int typeIndex, int typeArgumentsIndex) {
        Type[] types = o.getClass().getGenericInterfaces();
        ParameterizedType parameterizedType = (ParameterizedType) types[typeIndex];
        Type type = parameterizedType.getActualTypeArguments()[typeArgumentsIndex];
        return type.getTypeName();
    }

    public static Class<?> getFinalInterfaceT(Object o, int typeIndex, int typeArgumentsIndex) {
        Type[] types = o.getClass().getGenericInterfaces();
        ParameterizedType parameterizedType = (ParameterizedType) types[typeIndex];
        Type type = parameterizedType.getActualTypeArguments()[typeArgumentsIndex];
        return checkType(type, typeArgumentsIndex);
    }

    public static String getClassName(Object o, int index) {
        Class<?> oClass=o.getClass();
        Type type = oClass.getGenericSuperclass();
        ParameterizedType parameterizedType = (ParameterizedType) type;
        Type actType = parameterizedType.getActualTypeArguments()[index];
        return actType.getTypeName();
    }

    public static String getFinalClassTName(Object o, int index) {
        Class<?> oClass = getFinalClassT(o, index);
        return oClass.getTypeName();
    }

    public static Class<?> getFinalClassT(Object o, int index) {
        Type type = o.getClass().getGenericSuperclass();
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type actType = parameterizedType.getActualTypeArguments()[index];
            return checkType(actType, index);
        } else {
            String className = type == null ? "null" : type.getClass().getName();
            throw new IllegalArgumentException("Expected a Class, ParameterizedType"
                    + ", but <" + type + "> is of type " + className);
        }
    }

    private static Class<?> checkType(Type type, int index) {
        if (type instanceof Class<?>) {
            return (Class<?>) type;
        } else if (type instanceof ParameterizedType) {
            ParameterizedType pt = (ParameterizedType) type;
            Type t = pt.getActualTypeArguments()[index];
            return checkType(t, index);
        } else {
            String className = type == null ? "null" : type.getClass().getName();
            throw new IllegalArgumentException("Expected a Class, ParameterizedType"
                    + ", but <" + type + "> is of type " + className);
        }
    }

    public static String getIntArr_One_ClassTypeName() {
        int[] arrOne = new int[0];
        Class<?> arrClass = arrOne.getClass();
        return arrClass.getTypeName();
    }

    public static String getIntArr_Two_ClassTypeName() {
        int[][] ints = new int[0][0];
        Class<?> intsClass = ints.getClass();
        return intsClass.getTypeName();
    }

    public static String getStringArr_ClassTypeName() {
        String[] s = new String[0];
        Class<?> sClass = s.getClass();
        return sClass.getTypeName();
    }

    public static String getString_ClassTypeName() {
        String s = new String();
        Class<?> sClass = s.getClass();
        return sClass.getTypeName();
    }

    public static String getCharArr_Two_ClassTypeName() {
        char[][] chars = new char[0][];
        Class<?> charsClass = chars.getClass();
        return charsClass.getTypeName();
    }

    public static String getList_Int_ClassTypeName() {
        return "java.util.List<java.lang.Integer>";
    }

    public static String getList_List_Int_ClassTypeName() {
        return "java.util.List<java.util.List<java.lang.Integer>>";
    }

    public static String getTreeNode_ClassTypeName() {
        TreeNode node = new TreeNode(0);
        Class<?> charsClass = node.getClass();
        return charsClass.getTypeName();
    }

    public static String getInteger_ClassTypeName() {
        Integer integer = new Integer(0);
        Class<?> charsClass = integer.getClass();
        return charsClass.getTypeName();
    }
}
