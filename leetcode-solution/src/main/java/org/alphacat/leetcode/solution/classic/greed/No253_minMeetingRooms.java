package org.alphacat.leetcode.solution.classic.greed;

import java.util.Arrays;
import java.util.PriorityQueue;

// https://leetcode-cn.com/problems/meeting-rooms-ii/
public class No253_minMeetingRooms {

    private int START_TIME = 0;
    private int END_TIME = 1;

    public int minMeetingRooms_minHeap(int[][] intervals) {
        if (intervals == null) {
            return 0;
        }
        int n = intervals.length;
        if (n == 0) {
            return 0;
        }
        Arrays.sort(intervals, ((o1, o2) -> {
            return o1[0] - o2[0];
        }));
        PriorityQueue<Integer> rooms = new PriorityQueue<>(n);
        rooms.offer(intervals[0][END_TIME]);
        for (int i = 1; i < n; ++i) {
            if (intervals[i][START_TIME] >= rooms.peek()) {
                rooms.poll();
            }
            rooms.offer(intervals[i][END_TIME]);
        }
        return rooms.size();
    }

    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null) {
            return 0;
        }
        int n = intervals.length;
        if (n == 0) {
            return 0;
        }
        int[] start = new int[n];
        int[] end = new int[n];
        for (int i = 0; i < n; ++i) {
            start[i] = intervals[i][START_TIME];
            end[i] = intervals[i][END_TIME];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int startPointer = 0;
        int endPointer = 0;
        int rooms = 0;
        while (startPointer < n) {
            if (start[startPointer] >= end[endPointer]) {
                ++endPointer;
            } else {
                ++rooms;
            }
            ++startPointer;
        }
        return rooms;
    }
}
