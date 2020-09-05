package org.alphacat.leetcode.solution.mid.interview;

public class Interview12 {
	String word;
	char[][] board;
	boolean[][] visited;
	int n;
	int m;
	int l;

	public boolean exist(char[][] board, String word) {
		initial(board, word);
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				if (DFS(i, j, 0)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean DFS(int a, int b, int index) {
		if (!isValid(a, b, index))
			return false;
		if (index == l - 1) {
			return true;
		}
		visited[a][b] = true;
		boolean res = dfsInDiffDirection(a, b, index + 1);
		visited[a][b] = false;
		return res;
	}

	private boolean isValid(int a, int b, int index) {
		if (a >= n || a < 0)
			return false;
		if (b >= m || b < 0)
			return false;
		if (index >= l)
			return false;
		if (visited[a][b])
			return false;
		if (board[a][b] != word.charAt(index)) {
			return false;
		}
		return true;
	}

	private boolean dfsInDiffDirection(int a, int b, int index) {
		if (DFS(a + 1, b, index))
			return true;
		if (DFS(a - 1, b, index))
			return true;
		if (DFS(a, b - 1, index))
			return true;
		if (DFS(a, b + 1, index))
			return true;
		return false;
	}

	private void initial(char[][] board, String word) {
		int n = board.length;
		int m = board[0].length;
		this.word = word;
		this.board = board;
		this.visited = new boolean[n][m];
		this.n = n;
		this.m = m;
		this.l = word.length();
	}
}
