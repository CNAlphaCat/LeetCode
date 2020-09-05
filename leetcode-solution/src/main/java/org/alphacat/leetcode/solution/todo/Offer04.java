package org.alphacat.leetcode.solution.todo;

public class Offer04 {

	public boolean findNumberIn2DArray(int[][] matrix, int target) {
		if (isNull(matrix))
			return false;
		int i = 0, j = matrix[0].length-1;
		int rows = matrix.length-1;
		int crr = 0;
		while(i<=rows && j>=0) {
			crr=matrix[i][j];
			if(crr==target) return true;
			else if(crr>target) j--;
			else i++;
		}
		return false;
	}

	public boolean findNumberIn2DArray_error(int[][] matrix, int target) {
		if (isNull(matrix))
			return false;
		int i = 0, j = 0, rows = matrix.length, columns = matrix[0].length;
		int crr = 0;
		boolean isLastRow, isLastColumns;
		while (i < rows || j < columns) {
			crr = matrix[i][j];
			if (crr == target)
				return true;
			if (crr > target)
				break;
			isLastRow = isLastRow(i, rows);
			isLastColumns = isLastColumns(j, columns);
			if (isLastRow && isLastColumns)
				break;
			if (isLastRow) {
				j++;
				continue;
			}
			if (isLastColumns) {
				i++;
				continue;
			}
			if (matrix[i + 1][j] > target && matrix[i][j + 1] > target)
				return false;
			if (matrix[i + 1][j] > matrix[i][j + 1])
				j++;
			else
				i++;
		}
		return false;
	}

	public boolean isNull(int[][] nums) {
		if (nums == null)
			return true;
		if (nums.length == 0)
			return true;
		if (nums[0].length == 0)
			return true;
		return false;
	}

	public boolean isLastRow(int i, int rows) {
		if (i == (rows - 1))
			return true;
		return false;
	}

	public boolean isLastColumns(int j, int c) {
		if (j == (c - 1))
			return true;
		return false;
	}
}
