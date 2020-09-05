package org.alphacat.leetcode.solution.mid.interview;

public class Interview13 {
	private boolean[][] visited;
	private int m;
	private int n;
	private int k;

	public int movingCount(int m, int n, int k) {
		initial(m, n, k);
		return DFS(0, 0);
	}

	private void initial(int m, int n, int k) {
		visited = new boolean[m][n];
		this.m = m;
		this.n = n;
		this.k = k;
	}

	private int DFS(int i, int j) {
		if (!isValid(i, j))
			return 0;
		visited[i][j] = true;
		return 1 + dfsOnDiffDireation(i, j);
	}

	private boolean isValid(int i, int j) {
		if (i >= m || i < 0)
			return false;
		if (j >= n || j < 0)
			return false;
		if (visited[i][j])
			return false;
		if (getSumByDigit(i) + getSumByDigit(j) > k)
			return false;
		return true;
	}

	public int getSumByDigit(int n) {
		int sum = 0;
		while (n > 0) {
			int temp = n % 10;
			sum += temp;
			n /= 10;
		}
		return sum;
	}

	private int dfsOnDiffDireation(int i, int j) {
		int a = DFS(i - 1, j);
		int b = DFS(i + 1, j);
		int c = DFS(i, j - 1);
		int d = DFS(i, j + 1);
		return a + b + c + d;
	}
}
