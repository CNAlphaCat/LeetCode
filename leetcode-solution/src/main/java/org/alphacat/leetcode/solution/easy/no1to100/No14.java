package org.alphacat.leetcode.solution.easy.no1to100;


public class No14 {
	public String longestCommonPrefix(String[] strs) {
		int n=strs.length;
		if(n==0) return "";
		int m=0;
		String s="";
		int j=0;
		char c=' ';
		boolean isContinue=true;
		while(isContinue) {
			for(int i=0;i<n;i++) {
				m=strs[i].length();
				if(j>=m){
					isContinue=false;
					break;
				}
				if(i==0) c=strs[i].charAt(j);
				if(i!=0 && c!=strs[i].charAt(j)) {
					isContinue=false;
					break;
				}
				if(i==n-1 && c==strs[i].charAt(j)) s=s+c;
			}
			j++;
		}
		return s;
	}
}
