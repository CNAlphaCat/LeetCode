package org.alphacat.leetcode.solution.easy.no101to200;

import java.util.Stack;

public class No155 {
	class MinStack {
		Stack<Integer> s1;
		Stack<Integer> s2;

		/** initialize your data structure here. */
		public MinStack() {
			this.s1 = new Stack<Integer>();
			this.s2 = new Stack<Integer>();
		}

		public void push(int x) {
			s1.add(x);
			if (s2.isEmpty() || x <= s2.peek()) {
				s2.add(x);
			}
		}

		public void pop() {
			int res = s1.pop();
			if (s2.peek().equals(res)) {
				s2.pop();
			}
		}

		public int top() {
			return s1.peek();
		}

		public int getMin() {
			return s2.peek();
		}
	}
}
