package org.alphacat.leetcode.solution.classic.sort.quicksort;

import java.util.Arrays;

public class Offer40 {
	private int[] arr;
	private int k;
	private int length;
	private int[] res;

	public int[] getLeastNumbers(int[] arr, int k) {
		if (k == 0 || arr.length == 0) {
			return new int[0];
		}
		initial(arr, k);
		quickSort(0, this.length - 1);
		return res;
	}
	
	public int[] getLeastNumbers_2(int[] arr, int k) {
		if (k == 0 || arr.length == 0) {
			return new int[0];
		}
		Arrays.sort(arr);
		return Arrays.copyOfRange(arr, 0, k);
	}

	private void quickSort(int i, int j) {
		int part = partition(i, j);
		if (part == this.k - 1) {
			res = Arrays.copyOfRange(arr, 0, k);
			return;
		} else if (part > k - 1) {
			quickSort(i, part - 1);
		} else {
			quickSort(part + 1, j);
		}
	}

	private int partition(int l, int h) {
		int val = arr[l];
		int i = l, j = h + 1;
		while (true) {
			while (++i <= h && val > arr[i]) {

			}
			while (--j >= l && val < arr[j]) {

			}
			if (i >= j) {
				break;
			}
			swap(i, j);
		}
		swap(l, j);
		return j;
	}

	private void initial(int[] _arr, int _k) {
		this.arr = _arr;
		this.k = _k;
		this.length = _arr.length;
		this.res = new int[k];
	}

	private void swap(int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
