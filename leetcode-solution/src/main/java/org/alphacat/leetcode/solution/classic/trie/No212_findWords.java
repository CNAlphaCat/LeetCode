package org.alphacat.leetcode.solution.classic.trie;


import java.util.*;

/**
 * https://leetcode-cn.com/problems/word-search-ii/
 * 212. 单词搜索 II
 * ☆☆☆☆
 * 前缀树
 */
public class No212_findWords {

    private int n;
    private char[][] board;
    private int m;
    private int[][] directions;

    private TrieNode root;
    private int maxLength = 0;

    public List<String> findWords(char[][] board, String[] words) {
        List<String> list = new ArrayList<>();
        if (board == null) {
            return list;
        }
        int m = board.length;
        if (m == 0) {
            return list;
        }
        initial(m, board, words);

        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                findWords(i, j, new boolean[m][n], "", root, set);
            }
        }
        list = new ArrayList<>(set);
        return list;
    }

    private void findWords(int x, int y, boolean[][] visited, String word
            , TrieNode node, HashSet<String> set) {

        if (!checkBorder(x, y) || visited[x][y]) {
            return;
        }

        //剪枝优化
        if (word.length() >= maxLength) {
            return;
        }

        char c = board[x][y];

        if (!node.contains(c)) {
            return;
        }
        visited[x][y] = true;
        TrieNode next = node.get(c);

        word += c;

        if (next.isEnd()) {
            set.add(word);
            node.deleteLeaf();
        }

        for (int i = 0; i < directions.length; ++i) {
            int nextX = x + directions[i][0];
            int nextY = y + directions[i][1];
            findWords(nextX, nextY, visited, word, next, set);
        }

        visited[x][y] = false;
    }

    private boolean checkBorder(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    private void initial(int _m, char[][] _board, String[] words) {
        m = _m;
        n = _board[0].length;
        board = _board;
        directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        root = new TrieNode();
        for (String word : words) {
            root.addWord(word);
            maxLength = Math.max(maxLength, word.length());
        }
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
