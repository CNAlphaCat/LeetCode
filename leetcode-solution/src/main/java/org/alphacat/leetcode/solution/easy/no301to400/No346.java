package org.alphacat.leetcode.solution.easy.no301to400;

public class No346 {
	public class MovingAverage {
		/** Initialize your data structure here. */
		private IntCircularQueue q;

		public MovingAverage(int size) {
			q = new IntCircularQueue(size);
		}

		public double next(int val) {
			q.offer(val);
			int sum = q.getSum();
			int n = q.getCrrSize();
			double d1 = sum;
			double d2 = n;
			double res = d1 / d2;
			return res;
		}
	}

	class IntCircularQueue {
		int[] arr;
		int sum;
		int i;
		int j;
		int size;
		int crrSize;

		public IntCircularQueue(int n) {
			this.arr = new int[n];
			this.sum = 0;
			this.i = 0;
			this.j = 0;
			this.size = n;
			this.crrSize = 0;
		}

		public int getSum() {
			return this.sum;
		}

		public int getCrrSize() {
			return this.crrSize;
		}

		public void offer(int input) {
			if (isFull()) {
				poll();
			}
			this.arr[i] = input;
			this.sum = this.sum + input;
			this.i = (this.i + 1) % this.size;
			this.crrSize++;

		}

		public int poll() {
			int res = arr[j];
			this.j = (this.j + 1) % this.size;
			this.sum = this.sum - res;
			this.crrSize--;
			return res;
		}

		public int peek() {
			int res = arr[j];
			return res;
		}

		public boolean isFull() {
			if (this.crrSize == this.size)
				return true;
			return false;
		}
	}

}
