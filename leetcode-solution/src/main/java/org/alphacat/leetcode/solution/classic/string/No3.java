package org.alphacat.leetcode.solution.classic.string;
import java.util.*;

public class No3 {
	 public int lengthOfLongestSubstring(String s) {
	        Set<Character> set = new HashSet<>();
	        int i=0,j=0,length=0;
	        int n=s.length();
	        char c;
	        while(i<n && j<n){
	            c=s.charAt(j);
	            if(!set.contains(c)){
	                set.add(c);
	                j++;
	                length=Math.max(length,j-i);
	            }
	            else{
	                c=s.charAt(i);
	                i++;
	                set.remove(c);
	            }
	        }
	        return length;
	    }
}
