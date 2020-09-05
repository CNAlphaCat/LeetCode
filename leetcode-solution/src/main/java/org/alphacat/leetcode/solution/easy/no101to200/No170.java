package org.alphacat.leetcode.solution.easy.no101to200;

import java.util.HashMap;
import java.util.Map;

public class No170 {
	class TwoSum {
		/** Initialize your data structure here. */
		private HashMap<Integer, Integer> map;

		public TwoSum() {
			map = new HashMap<Integer, Integer>();
		}

		/** Add the number to an internal data structure.. */
		public void add(int number) {
			if(!map.containsKey(number)) {
				map.put(number, 1);
			}
			else {
				int n=map.get(number);
				map.replace(number, n+1);
			}
		}

		/** Find if there exists any pair of numbers which sum is equal to the value. */
		public boolean find(int value) {
			int temp;
			int crr;
			boolean isContainKey;
			for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
				crr=entry.getKey();
				temp=value-crr;
				isContainKey=map.containsKey(temp);
				if(isContainKey  && temp!=crr) {
					return true;
				}
				if(isContainKey && temp==crr && map.get(crr)>1) {
					return true;
				}
			}
			return false;
		}
	}

}
