package org.alphacat.leetcode.solution.classic.dfs;

import java.util.List;

public class No339_depthSum {
	public int depthSum(List<NestedInteger> nestedList) {
		int res = depthSum(nestedList, 1);
		return res;
	}

	int depthSum(List<NestedInteger> nestedList, int depth) {
		int sum = 0;
		for (NestedInteger item : nestedList) {
			if (item.isInteger()) {
				sum = sum + item.getInteger() * depth;
			} else {
				sum = sum + depthSum(item.getList(), depth + 1);
			}
		}
		return sum;
	}

	public interface NestedInteger {
		// Constructor initializes an empty nested list.
		// public NestedInteger();

		// Constructor initializes a single integer.
		// public NestedInteger(int value);

		// @return true if this NestedInteger holds a single integer, rather than a
		// nested list.
		public boolean isInteger();

		// @return the single integer that this NestedInteger holds, if it holds a
		// single integer
		// Return null if this NestedInteger holds a nested list
		public Integer getInteger();

		// Set this NestedInteger to hold a single integer.
		public void setInteger(int value);

		// Set this NestedInteger to hold a nested list and adds a nested integer to it.
		public void add(NestedInteger ni);

		// @return the nested list that this NestedInteger holds, if it holds a nested
		// list
		// Return null if this NestedInteger holds a single integer
		public List<NestedInteger> getList();
	}

}
