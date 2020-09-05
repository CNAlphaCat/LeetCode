package org.alphacat.leetcode.solution.easy.no401to500;

public class No463 {

    private int[][] grid;
    private int[][] directions;
    private int m;
    private int n;
    private boolean[][] visited;

    public int islandPerimeter(int[][] grid) {
        initial(grid);
        int beginX = 0;
        int beginY = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    beginX = i;
                    beginY = j;
                    break;
                }
            }
        }
        return dfs(beginX, beginY);
    }

    private void initial(int[][] grid) {
        this.grid = grid;
        this.directions = getDirections();
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];
    }

    private boolean isLand(int x, int y) {
        return grid[x][y] == 1;
    }

    private boolean isBorder(int x, int y) {
        if (x < 0 || x >= m || y < 0 || y >= n) {
            return true;
        }
        return false;
    }

    private int dfs(int x, int y) {
        if (isBorder(x, y) || !isLand(x, y)) {
            return 1;
        }
        if (visited[x][y]) {
            return 0;
        }
        int sum = 0;
        visited[x][y] = true;
        for (int[] direction : directions) {
            sum += dfs(x + direction[0], y + direction[1]);
        }
        return sum;
    }

    private int[][] getDirections() {
        int[] up = {-1, 0};
        int[] down = {1, 0};
        int[] left = {0, -1};
        int[] right = {0, 1};
        int[][] direction = new int[4][2];
        direction[0] = up;
        direction[1] = down;
        direction[2] = left;
        direction[3] = right;
        return direction;
    }
}
