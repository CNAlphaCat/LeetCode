package org.alphacat.leetcode.solution.classic.trie;

public class No208_Trie {

    class Trie {

        private TrieNode root;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            root = new TrieNode();
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            int n = word.length();
            TrieNode cur = root;
            for (int i = 0; i < n; ++i) {
                char c = word.charAt(i);
                if (!cur.containsKey(c)) {
                    cur.put(c);
                }
                cur = cur.get(c);
            }
            cur.setEnd();
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            TrieNode node = searchPrefix(word);
            return node != null && node.isEnd();
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            return searchPrefix(prefix) != null;
        }

        private TrieNode searchPrefix(String word) {
            int n = word.length();
            TrieNode cur = root;
            for (int i = 0; i < n; ++i) {
                char c = word.charAt(i);
                if (!cur.containsKey(c)) {
                    return null;
                }
                cur = cur.get(c);
            }
            return cur;
        }
    }

    class TrieNode {

        private final int size = 26;

        private TrieNode links[];

        private boolean isEnd;

        private final int offset = 'a';

        public TrieNode() {
            links = new TrieNode[26];
            isEnd = false;
        }

        public boolean containsKey(char c) {
            return links[c - offset] != null;
        }

        public TrieNode get(char c) {
            return links[c - offset];
        }

        public void put(char c) {
            links[c - offset] = new TrieNode();
        }

        public void setEnd() {
            isEnd = true;
        }

        public boolean isEnd() {
            return this.isEnd;
        }
    }
}
