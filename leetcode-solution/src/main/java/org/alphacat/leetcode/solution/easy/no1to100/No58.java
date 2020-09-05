package org.alphacat.leetcode.solution.easy.no1to100;

public class No58 {
	public int lengthOfLastWord(String s) {
		if(s==null) return 0;
		if(s.length()==0) return 0;
		String[] sArr=s.split(" ");
		int n=sArr.length;
		if(n==0) return 0;
		int res=sArr[n-1].length();
		return res;
    }
}
