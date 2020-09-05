package org.alphacat.leetcode.solution.easy.no101to200;

import java.util.HashMap;
import java.util.Map.Entry;

public class No168 {
	public int singleNumber(int[] nums) {
		int res = nums[0];
		for (int i = 1; i < nums.length; ++i) {
			res = res ^ nums[i];
		}
		return res;
	}

	public int singleNumber_2(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int res = nums[0];
		for (int temp : nums) {
			if (map.containsKey(temp)) {
				map.replace(temp, 2);
			} else {
				map.put(temp, 1);
			}
		}
		for (Entry<Integer, Integer> entry : map.entrySet()) {
			int temp = entry.getValue();
			if (temp == 1) {
				res = entry.getKey();
				break;
			}
		}
		return res;
	}
}
