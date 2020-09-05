package org.alphacat.leetcode.solution.easy.interview;

import java.util.Stack;

public class Interview09 {
	class CQueue {
		private Stack<Integer> s1;
		private Stack<Integer> s2;

		public CQueue() {
			s1 = new Stack<Integer>();
			s2 = new Stack<Integer>();
		}

		public void appendTail(int value) {
			while (!s1.isEmpty()) {
				int temp = s1.pop();
				s2.add(temp);
			}
			s1.add(value);
			while (!s2.isEmpty()) {
				int temp = s2.pop();
				s1.add(temp);
			}
		}

		public int deleteHead() {
			if (s1.isEmpty())
				return -1;
			return s1.pop();
		}
	}

	class CQueue2 {
		private Stack<Integer> s1;
		private Stack<Integer> s2;

		public CQueue2() {
			s1 = new Stack<Integer>();
			s2 = new Stack<Integer>();
		}

		public void appendTail(int value) {
			s1.add(value);
		}

		public int deleteHead() {
			if (s1.isEmpty())
				return -1;
			while (!s1.isEmpty()) {
				int temp = s1.pop();
				s2.add(temp);
			}
			int res = s2.pop();
			while (!s2.isEmpty()) {
				int temp = s2.pop();
				s1.add(temp);
			}
			return res;
		}
	}
}
