package org.alphacat.leetcode.solution.easy.no701to800;

import java.util.Stack;

public class No716 {
	public class MaxStack {
		Stack<Integer> s;
		int max;

		/** initialize your data structure here. */
		public MaxStack() {
			s = new Stack<Integer>();
		}

		public void push(int x) {
			if (s.isEmpty()) {
				max = x;
			}
			max = Math.max(x, max);
			s.push(x);
		}

		public int pop() {
			int res = s.pop();
			if (res == max && !s.isEmpty()) {
				max = findMax();
			}
			return res;
		}

		public int top() {
			int res = s.peek();
			return res;
		}

		public int peekMax() {
			return max;
		}

		public int popMax() {
			Stack<Integer> temp = new Stack<Integer>();
			int res = max;
			while (!s.isEmpty()) {
				int num = s.pop();
				if (num == max) {
					break;
				}
				temp.push(num);
			}
			while (!temp.isEmpty()) {
				int numTemp = temp.pop();
				s.push(numTemp);
			}
			if (!s.isEmpty()) {
				max = findMax();
			}
			return res;
		}

		private int findMax() {
			int res = s.peek();
			Stack<Integer> sCopy = (Stack<Integer>)s.clone();
			while (!sCopy.isEmpty()) {
				int num = sCopy.pop();
				res = Math.max(res, num);
			}
			return res;
		}
	}
}
