package org.alphacat.leetcode.solution.classic.bit;

import java.math.BigInteger;

public class No67 {
	private BigInteger zero;
	
	public String addBinary(String a, String b) {

		int l1 = a.length(), l2 = b.length();
		if (l2 > l1) {
			return addBinary(b, a);// �㷨����ǳ�����ı�֤l1>l2����·��
		}
		StringBuilder res = new StringBuilder();
		StringBuilder sb = new StringBuilder();
		int differ = l1 - l2;
		for (int i = 0; i < differ; ++i) {
			sb.append("0");// ���ַ���b��a����һ���������ڲ���
		}
		sb.append(b);
		b = sb.toString();
		int carry = 0;// carry�÷��Ǿ��裬��ȻҪд�൱����жϲ���ʵ���������
		for (int i = l1 - 1; i >= 0; --i) {
			if (a.charAt(i) == '1') {
				carry++;
			}
			if (b.charAt(i) == '1') {
				carry++;
			}
			if (carry % 2 == 0) {
				res.append("0");
			} else {
				res.append("1");
			}
			carry /= 2;
		}
		if (carry == 1) {
			res.append("1");
		}
		res.reverse();
		return res.toString();
	}

	public String addBinary_2(String a, String b) {
		BigInteger x = new BigInteger(a, 2);
		BigInteger y = new BigInteger(b, 2);
		this.zero= new BigInteger("0", 2);
		BigInteger tempX, carry;
		while (!isEqualZero(y)) {
			tempX = x.xor(y);// ��򣬵�λ����һ����ʱ�����0
			BigInteger temp = x.and(y);// a&bֻ�е�����һ����ʱ��ŵ���1
			carry = temp.shiftLeft(1);
			x = tempX;
			y = carry;
		}
		return x.toString(2);
	}

	private boolean isEqualZero(BigInteger x) {

		if (x.compareTo(this.zero) == 0) {
			return true;
		}
		return false;
	}
}
