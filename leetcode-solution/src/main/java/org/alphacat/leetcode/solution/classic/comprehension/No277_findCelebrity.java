package org.alphacat.leetcode.solution.classic.comprehension;


public class No277_findCelebrity {

    private int NOT_FIND_NUM = -1;

    public int findCelebrity(int n) {
        int candidate = 0;
        for (int i = 1; i < n; ++i) {
            if (knows(candidate, i)) {
                candidate = i;
            }
        }

        for (int i = 0; i < n; ++i) {
            if (i == candidate) {
                continue;
            }

            if (knows(i, candidate) && !knows(candidate, i)) {
                continue;
            } else {
                return NOT_FIND_NUM;
            }
        }
        return candidate;
    }

    // Forward declaration of the knows API.
    boolean knows(int a, int b) {
        return true;
    }

}
