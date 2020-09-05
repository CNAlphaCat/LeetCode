package org.alphacat.leetcode.solution.mid.no1to1000;

public class No200 {

    private char[][] grid;
    private int m;
    private int n;
    private boolean[][] visited;
    private int[][] directions;

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        initial(grid);

        int sum = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(i, j)) {
                    sum++;
                }
            }
        }
        return sum;
    }

    private boolean dfs(int x, int y) {
        if (!isValid(x, y)) {
            return false;
        }
        if (!isLand(x, y)) {
            return false;
        }
        if (visited[x][y]) {
            return false;
        }
        visited[x][y] = true;
        for (int[] direction : directions) {
            dfs(x + direction[0], y + direction[1]);
        }
        return true;
    }

    private boolean isValid(int i, int j) {
        if (i < 0 || i >= m) {
            return false;
        }
        if (j < 0 || j >= n) {
            return false;
        }
        return true;
    }

    private boolean isLand(int i, int j) {
        return grid[i][j] == '1';
    }

    private void initial(char[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];
        directions = getDirections();
    }

    private int[][] getDirections() {
        int[][] direction = new int[4][2];
        int[] up = {-1, 0};
        int[] down = {1, 0};
        int[] left = {0, -1};
        int[] right = {0, 1};
        direction[0] = up;
        direction[1] = down;
        direction[2] = left;
        direction[3] = right;
        return direction;
    }
}
