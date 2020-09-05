package org.alphacat.leetcode.solution.mid.no1to1000;

import java.util.Stack;

public class No946 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
		Stack<Integer> stack = new Stack<Integer>();
		int j = 0, n = pushed.length, m = popped.length;
		for (int i = 0; i < n; ++i) {
			stack.add(pushed[i]);
			while (!stack.isEmpty() && j < m && stack.peek().equals(popped[j])) {
				stack.pop();
				j++;
			}
		}
		return stack.isEmpty();
    }
}
