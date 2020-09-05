package org.alphacat.leetcode.solution.classic.string.bfs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class No127_ladderLength_beginToEnd {

    private String alternateSign = "*";
    private int NOT_FOUNT_NUM = 0;

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

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(beginWord, 1));

        HashMap<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            String word = pair.word;
            int count = pair.count;
            int n = word.length();
            for (int i = 0; i < n; ++i) {
                String tempWord = word.substring(0, i) + alternateSign + word.substring(i + 1, n);
                if (!transitionMap.containsKey(tempWord)) {
                    continue;
                }
                List<String> tempList = transitionMap.get(tempWord);
                for (String adjacentWord : tempList) {
                    if (adjacentWord.equals(endWord)) {
                        return count + 1;
                    }
                    if (!visited.containsKey(adjacentWord)) {
                        visited.put(adjacentWord, true);
                        queue.offer(new Pair(adjacentWord, count + 1));
                    }
                }
            }
        }
        return NOT_FOUNT_NUM;
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
