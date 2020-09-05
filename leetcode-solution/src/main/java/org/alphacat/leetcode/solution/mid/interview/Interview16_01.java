package org.alphacat.leetcode.solution.mid.interview;

public class Interview16_01 {
    public int[] swapNumbers(int[] numbers) {
        numbers[0] += numbers[1];
        numbers[1] = numbers[0] - numbers[1];
        numbers[0] -= numbers[1];
        return numbers;
    }
}
