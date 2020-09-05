package org.alphacat.leetcode.solution.classic.design;

import java.util.LinkedList;
import java.util.Queue;

public class No933 {
    class RecentCounter {
        private Queue<Integer> queue;

        public RecentCounter() {
            queue = new LinkedList<>();
        }

        public int ping(int t) {
            queue.add(t);
            while (queue.peek() < t - 3000) {
                queue.poll();
            }
            return queue.size();
        }
    }

    class RecentCounter_2 {
        private int[] pingTime;

        public RecentCounter_2() {
            int size = 1000000001;
            pingTime = new int[size];
        }

        public int ping(int t) {
            pingTime[t] = 1;
            return getCount(t);
        }

        private int getCount(int t) {
            int begin = t - 3000 > 0 ? t - 3000 : 0;
            int count = 0;
            for (int i = begin; i <= t; i++) {
                if (pingTime[i] > 0) {
                    count++;
                }
            }
            return count;
        }
    }
}
