package org.alphacat.leetcode.solution.easy.interview;

public class Interview29 {
	private boolean[][] isPrint;
	private int[][] matrix;
	private int[] res;
	private int n;
	private int m;
	private int i;
	private int j;
	private int count;
	private int sum;

	public int[] spiralOrder(int[][] matrix) {
		if(matrix.length==0) {
			return new int[0];
		}
		initial(matrix);
		while (this.count < this.sum) {
			Right();
			Down();
			Left();
			Up();
		}
		return res;
	}

	private void Right() {
		while (j < m && !isPrint[i][j]) {
			add();
			j++;
		}
		j--;
		i++;
	}

	private void add() {
		res[count] = matrix[i][j];
		isPrint[i][j] = true;
		count++;
	}

	private void Down() {
		while (i < n && !isPrint[i][j]) {
			add();
			i++;
		}
		i--;
		j--;
	}

	private void Left() {
		while (j >= 0 && !isPrint[i][j]) {
			add();
			j--;
		}
		j++;
		i--;
	}

	private void Up() {
		while (i >= 0 && !isPrint[i][j]) {
			add();
			i--;
		}
		i++;
		j++;
	}

	private void initial(int[][] matrix) {
		this.matrix = matrix;
		this.n = matrix.length;
		this.m = matrix[0].length;
		this.isPrint = new boolean[n][m];
		this.sum = m * n;
		this.res = new int[sum];
		this.i = 0;
		this.j = 0;
		this.count = 0;
	}
}
