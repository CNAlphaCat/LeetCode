package org.alphacat.leetcode.solution.easy.no1to100;

import java.util.Stack;

public class No20 {
	public boolean isValid(String s) {
		if(s=="" || s==null) return true;
		int n=s.length();
		Stack<Character> stack=new Stack<Character>();
		Character c;
		for(int i=0;i<n;i++) {
			c=s.charAt(i);
			if(!isBrackets(c)) return false;
			if(!stack.isEmpty() && isCouple(stack.peek(), c)) {
				stack.pop();
			}
			else {
				stack.add(c);
			}
		}
		if(!stack.isEmpty()) return false;
		return true;
	}
	
	boolean isBrackets(Character c) {
		if(c=='(' || c=='[' || c=='{') return true;
		if(c==')' || c==']' || c=='}') return true;
		return false;
	}
	
	boolean isCouple(Character c1, Character c2) {
		if(c1=='(' && c2==')') return true;
		if(c1=='[' && c2==']')  return true;
		if(c1=='{' && c2=='}')  return true;
		return false;
	}
}
