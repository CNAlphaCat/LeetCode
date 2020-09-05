package org.alphacat.leetcode.solution.mid.no1to1000;

import java.util.LinkedList;
import java.util.List;

public class No54 {
	private boolean[][] isPrint;
	private int[][] matrix;
	private List<Integer> res;
	private int n;
	private int m;
	private int i;
	private int j;
	private int count;
	private int sum;

	public List<Integer> spiralOrder(int[][] matrix) {
		if (matrix.length == 0) {
			return new LinkedList<Integer>();
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

	private void add() {
		res.add(matrix[i][j]);
		isPrint[i][j] = true;
		count++;
	}

	private void initial(int[][] matrix) {
		this.matrix = matrix;
		this.n = matrix.length;
		this.m = matrix[0].length;
		this.isPrint = new boolean[n][m];
		this.sum = m * n;
		this.res = new LinkedList<Integer>();
		this.i = 0;
		this.j = 0;
		this.count = 0;
	}
}
