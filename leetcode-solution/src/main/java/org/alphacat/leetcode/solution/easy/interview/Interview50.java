package org.alphacat.leetcode.solution.easy.interview;

import java.util.HashMap;
import java.util.Map;

public class Interview50 {
	public char firstUniqChar(String s) {
		char res = ' ';
		if(s.isEmpty()) return res;
		int n=s.length();
		Map<Character, Integer> map=new HashMap<Character, Integer>();
		char c;
		int count=0;
		for(int i=0;i<n;i++) {
			c=s.charAt(i);
			if(map.containsKey(c)) {
				count=map.get(c)+1;
				map.put(c, count);
			}
			else {
				map.put(c, 1);
			}
		}
		for(int i=0;i<n;i++) {
			c=s.charAt(i);
			count=map.get(c);
			if(count==1) return c;
		}
		return res;
	}
}
