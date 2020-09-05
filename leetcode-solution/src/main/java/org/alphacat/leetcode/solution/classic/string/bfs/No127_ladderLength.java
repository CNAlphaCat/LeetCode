package org.alphacat.leetcode.solution.classic.string.bfs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class No127_ladderLength {

    private String alternateSign = "*";
    private int NOT_FOUNT_NUM = 0;
    private int NOT_REACH_NUM = -1;
    private HashMap<String, List<String>> transitionMap;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashMap<String, List<String>> transitionMap = new HashMap<>();
        boolean isExist = false;
        for (String word : wordList) {
            int length = word.length();
            if (!isExist && word.equals(endWord)) {
                isExist = true;
            }
            for (int i = 0; i < length; ++i) {
                String alternateWord = word.substring(0, i) + alternateSign + word.substring(i + 1, length);
                List<String> tempList = transitionMap.getOrDefault(alternateWord, new LinkedList<>());
                tempList.add(word);
                transitionMap.put(alternateWord, tempList);
            }
        }
        if (!isExist) {
            return NOT_FOUNT_NUM;
        }
        this.transitionMap = transitionMap;

        Queue<Pair> queue_begin = new LinkedList<>();
        queue_begin.offer(new Pair(beginWord, 1));
        HashMap<String, Integer> visited_begin = new HashMap<>();
        visited_begin.put(beginWord, 1);

        Queue<Pair> queue_end = new LinkedList<>();
        queue_end.offer(new Pair(endWord, 1));
        HashMap<String, Integer> visited_end = new HashMap<>();
        visited_end.put(endWord, 1);

        while (!queue_begin.isEmpty() && !queue_end.isEmpty()) {
            int distance = visit(queue_begin, visited_begin, visited_end);
            if (distance != NOT_REACH_NUM) {
                return distance;
            }
            distance = visit(queue_end, visited_end, visited_begin);
            if (distance != NOT_REACH_NUM) {
                return distance;
            }
        }
        return NOT_FOUNT_NUM;
    }

    private int visit(Queue<Pair> queue, HashMap<String, Integer> visited
            , HashMap<String, Integer> anotherVisited) {
        Pair pair = queue.poll();
        String word = pair.word;
        int count = pair.count;
        int n = word.length();

        for (int i = 0; i < n; ++i) {
            String alternateWord = word.substring(0, i) + alternateSign + word.substring(i + 1, n);
            if (!transitionMap.containsKey(alternateWord)) {
                continue;
            }
            List<String> list = transitionMap.get(alternateWord);
            for (String adjacent : list) {
                if (anotherVisited.containsKey(adjacent)) {
                    return count + anotherVisited.get(adjacent);
                }
                if (!visited.containsKey(adjacent)) {
                    queue.offer(new Pair(adjacent, count + 1));
                    visited.put(adjacent, count + 1);
                }
            }
        }
        return NOT_REACH_NUM;
    }

    class Pair {
        String word;
        int count;

        public Pair(String _word, int _count) {
            word = _word;
            count = _count;
        }
    }
}
