package org.alphacat.leetcode.solution.easy.no1201to1300;

import java.util.LinkedList;
import java.util.List;

public class No1213 {
	public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
		List<Integer> res = new LinkedList<Integer>();
		int i = 0, j = 0, z = 0;
		int l1 = arr1.length, l2 = arr2.length, l3 = arr3.length;
		while (i < l1 && j < l2 && z < l3) {
			int num1 = arr1[i];
			int num2 = arr2[j];
			int num3 = arr3[z];
			if (num1 == num2 && num2 == num3) {
				res.add(num1);
				i++;
				j++;
				z++;
			} else if (num1 < num2) {
				i++;
			} else if (num1 < num3) {
				i++;
			} else if (num2 < num1) {
				j++;
			} else if (num2 < num3) {
				j++;
			} else if (num3 < num1) {
				z++;
			} else if (num3 < num2) {
				z++;
			}
		}
		return res;
	}

}
