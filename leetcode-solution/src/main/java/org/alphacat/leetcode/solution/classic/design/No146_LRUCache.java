package org.alphacat.leetcode.solution.classic.design;

import java.util.HashMap;

public class No146_LRUCache {

    class LRUCache {

        private HashMap<Integer, LinkList> listMap;

        private LinkList head;
        private LinkList tail;

        private int maxSize;

        private int NOT_FOUND_NUM = -1;

        public LRUCache(int capacity) {
            listMap = new HashMap<>();

            head = new LinkList(NOT_FOUND_NUM, NOT_FOUND_NUM);
            tail = new LinkList(NOT_FOUND_NUM, NOT_FOUND_NUM);
            head.post = tail;
            tail.pre = head;

            maxSize = capacity;
        }

        public int get(int key) {
            if (!listMap.containsKey(key)) {
                return NOT_FOUND_NUM;
            }
            LinkList current = listMap.get(key);
            moveToHead(current);
            return current.value;
        }

        public void put(int key, int value) {
            if (listMap.containsKey(key)) {
                LinkList current = listMap.get(key);
                moveToHead(current);
                current.value = value;
                return;
            }
            LinkList current = new LinkList(key, value);
            addToHead(current);
            listMap.put(key, current);
            if (listMap.size() > maxSize) {
                int tailKey = getTailKey();
                listMap.remove(tailKey);
                removeTail();
            }
        }

        private int getTailKey() {
            LinkList tailList = tail.pre;
            return tailList.key;
        }

        private void removeTail() {
            LinkList tailList = tail.pre;
            removeList(tailList);
        }

        private void moveToHead(LinkList list) {
            removeList(list);
            addToHead(list);
        }

        private void addToHead(LinkList list) {
            LinkList next = head.post;

            head.post = list;
            list.pre = head;

            list.post = next;
            next.pre = list;
        }

        private void removeList(LinkList list) {
            LinkList pre = list.pre;
            LinkList post = list.post;
            pre.post = post;
            post.pre = pre;
        }
    }

    class LinkList {
        int key;
        int value;
        LinkList pre;
        LinkList post;

        public LinkList(int _key, int _value) {
            key = _key;
            value = _value;
        }
    }
}
