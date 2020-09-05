package org.alphacat.leetcode.solution.classic.design.heap;

import java.util.PriorityQueue;

public class No295_MedianFinder {

    class MedianFinder {

        /**
         * initialize your data structure here.
         */

        PriorityQueue<Integer> min;
        PriorityQueue<Integer> max;
        int count;

        public MedianFinder() {
            min = new PriorityQueue<>();
            max = new PriorityQueue<>((x, y) -> y - x);
            count = 0;
        }

        public void addNum(int num) {

            max.offer(num);
            min.offer(max.poll());

            ++count;

            if ((count & 1) == 1) {
                max.offer(min.poll());
            }
        }

        public double findMedian() {
            if ((count & 1) == 0) {
                return (min.peek() + max.peek()) * 1.0 / 2;
            }
            return (double) max.peek();
        }
    }
}
