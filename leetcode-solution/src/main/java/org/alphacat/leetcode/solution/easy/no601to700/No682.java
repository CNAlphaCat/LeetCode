package org.alphacat.leetcode.solution.easy.no601to700;

import java.util.Stack;

public class No682 {

    public int calPoints(String[] ops) {
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        for (String op : ops) {
            if (op.equals("+")) {
                int firstPoint = stack.pop();
                int secondPoint = stack.peek();
                int point = firstPoint + secondPoint;
                sum += point;
                stack.add(firstPoint);
                stack.add(point);
                continue;
            } else if (op.equals("D")) {
                int point = stack.peek() * 2;
                sum += point;
                stack.add(point);
                continue;
            } else if (op.equals("C")) {
                sum -= stack.pop();
                continue;
            }
            int point = Integer.valueOf(op);
            stack.add(point);
            sum += point;
        }
        return sum;
    }
}
