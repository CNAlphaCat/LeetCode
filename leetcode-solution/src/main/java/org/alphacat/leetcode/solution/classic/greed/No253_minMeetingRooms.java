package org.alphacat.leetcode.solution.classic.greed;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/meeting-rooms-ii/
 * 253. 会议室 II
 * ————————————————————————————————————————————————————————————————————————————
 * 题目描述：
 * 给定一个会议时间安排的数组，每个会议时间都会包括开始和结束的时间
 * [[s1,e1],[s2,e2],...] (si < ei)，
 * 为避免会议冲突，同时要考虑充分利用会议室资源，请你计算至少需要多少间会议室，才能满足这些会议安排。
 * ————————————————————————————————————————————————————————————————————————————
 * keyword:
 * 题解：
 * ————————————————————————————————————————————————————————————————————————————
 * 笔记：
 * ————————————————————————————————————————————————————————————————————————————
 * 相关题目：
 * ————————————————————————————————————————————————————————————————————————————
 */
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
