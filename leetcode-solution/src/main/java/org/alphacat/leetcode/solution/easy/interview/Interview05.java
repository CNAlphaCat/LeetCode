package org.alphacat.leetcode.solution.easy.interview;

public class Interview05 {
	public String replaceSpace(String s) {
		int n = s.length();
		char[] arr = new char[n * 3];
		int size = 0;
		char c;
		for (int i = 0; i < n; i++) {
			c = s.charAt(i);
			if (c == ' ') {
				arr[size] = '%';
				size++;
				arr[size] = '2';
				size++;
				arr[size] = '0';
			} else {
				arr[size] = c;
			}
			size++;
		}
		String res = new String(arr, 0, size);
		return res;
	}
}
