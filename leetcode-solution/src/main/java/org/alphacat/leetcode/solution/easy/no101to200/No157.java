package org.alphacat.leetcode.solution.easy.no101to200;

public class No157 {
	int read4(char[] buf) {
		return 0;
	}

	public int read(char[] buf, int n) {
		int count=0;
		int temp;
		char[] tempArr=new char[4];
		int tempIndex=0;
		while(count<n) {
			temp=read4(tempArr);
			if(temp==0) break;
			while(tempIndex<temp && count<n) {
				buf[count]=tempArr[tempIndex];
				tempIndex++;
				count++;
			}
			tempIndex=0;
		}
		return count;
	}
}
