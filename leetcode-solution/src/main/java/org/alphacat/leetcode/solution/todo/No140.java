package org.alphacat.leetcode.solution.todo;

import java.util.*;

public class No140 {

    private TrieNode root;
    private HashMap<String, List<String>> map;

    public List<String> wordBreak(String s, List<String> wordDict) {
        initial(wordDict);
        return wordBreak("", s);
    }

    private void initial(List<String> wordDict) {
        root = new TrieNode();
        map = new HashMap<>();
        for (String word : wordDict) {
            root.addWord(word);
        }
    }

    private List<String> wordBreak(String preWord, String remains) {
        if (remains.length() == 0) {
            List<String> ans = new ArrayList<>(1);
            ans.add(preWord);
            return ans;
        }
        if (map.containsKey(remains)) {
            return map.get(remains);
        }

        int n = remains.length();

        List<String> ans = new LinkedList<>();

        for (int i = 0; i < n; ++i) {
            String curWord = remains.substring(0, i + 1);
            if (root.searchWord(curWord)) {
                String nextRemains = remains.substring(i + 1, n);
                List<String> subProblem = wordBreak(curWord, nextRemains);
                for (String sub : subProblem) {
                    if (preWord.length() == 0) {
                        ans.add(sub);
                    } else {
                        ans.add(preWord + " " + sub);
                    }
                }
            }
        }
        map.put(remains, ans);
        return ans;
    }

    class TrieNode {

        private HashMap<Character, TrieNode> map;
        private boolean isEnd;

        public TrieNode() {
            map = new HashMap<>();
        }

        public boolean contains(char c) {
            return map.containsKey(c);
        }

        public TrieNode get(char c) {
            return map.get(c);
        }

        public void put(char c) {
            if (!map.containsKey(c)) {
                map.put(c, new TrieNode());
            }
        }

        public void setEnd() {
            isEnd = true;
        }

        public boolean isEnd() {
            return isEnd;
        }

        public TrieNode searchPrefix(String word) {
            int n = word.length();
            TrieNode node = this;
            for (int i = 0; i < n; ++i) {
                char c = word.charAt(i);
                if (!node.contains(c)) {
                    return null;
                }
                node = node.get(c);
            }
            return node;
        }

        public boolean searchWord(String word) {
            TrieNode node = searchPrefix(word);
            return node != null && node.isEnd();
        }

        public boolean startWith(String word) {
            return searchPrefix(word) != null;
        }

        public void addWord(String word) {
            TrieNode node = this;
            int n = word.length();

            for (int i = 0; i < n; ++i) {
                char c = word.charAt(i);
                node.put(c);
                node = node.get(c);
            }
            node.setEnd();
        }

        public void deleteLeaf() {

            HashMap<Character, TrieNode> map = this.map;

            if (map.size() == 1) {
                for (Map.Entry<Character, TrieNode> entry : map.entrySet()) {
                    char c = entry.getKey();
                    TrieNode next = map.get(c);
                    if (next.isEmpty()) {
                        map.remove(c);
                    }
                    break;
                }
            }
        }

        public boolean isEmpty() {
            HashMap<Character, TrieNode> map = this.map;
            return map.size() == 0;
        }

    }
}
