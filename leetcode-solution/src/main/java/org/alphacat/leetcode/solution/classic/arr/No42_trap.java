package org.alphacat.leetcode.solution.classic.arr;

import java.util.Stack;

public class No42_trap {

    public int trap(int[] height) {
                /*
            使用双指针（左右两边各两个指针）

            我们使用一根一根柱子计算装水量的方法

            left 表示左边当前遍历的柱子（即左边我们需要计算能够装多少水的柱子）
            left_max 表示 left 的左边最高的柱子长度（不包括 left）
            right 表示右边当前遍历的柱子
            right_max 表示 right 的右边最高的柱子长度（不包括 right）

            我们有以下几个公式：
            当 left_max < right_max 的话，那么我们就判断 left_max 是否比 left 高
                因为根据木桶效应，一个桶装水量取决于最短的那个木板，这里也一样，柱子能否装水取决于左右两边的是否都存在比它高的柱子
                因为 left_max < right_max 了，那么我们只需要比较 left_max 即可
                    如果 left_max > left，那么装水量就是 left_max - left
                    如果 left_max <= left，那么装水量为 0，即 left 装不了水
            当 left_max >= right_max 的话，同理如上，比较 right_max 和 right

            ？？？？ 为什么 right_max 和 left 隔这么远我们还可以使用 right_max 来判断？
            前提：left_max < right_max
            right_max 虽然跟 left 离得远，但有如下两种情况：
            1、left 柱子和 right_max 柱子之间，没有比 right_max 柱子更高的柱子了，
            那么情况如下：  left 能否装水取决于 left_max 柱子是否比 left 高
                            |
                |           |
                |   |       |
                ↑   ↑       ↑
               l_m  l      r_m

            2、left 柱子和 right_max 柱子之间存在比 right_max 柱子更高的柱子
            那么情况如下：因为存在了比 right_max 更高的柱子，那么我们仍然只需要判断 left_max 是否比 left 高，因为右边已经存在比 left 高的柱子
                        |
                        |   |
                |       |   |
                |   |   |   |
                ↑   ↑   ↑   ↑
               l_m  l  mid  r_m

            初始化指针：
            left = 1;
            right = len - 2;
            left_max = 0;
            right_max = len - 1;
            （因为第一个柱子和最后一个柱子肯定不能装水，因为不作为装水柱子，而是作为左边最高柱子和右边最高柱子）
        */
        int left_max = 0;
        int left = 1;
        int n = height.length;
        int right = n - 2;
        int right_max = n - 1;
        int sum = 0;
        while (left <= right) {
            if (height[left_max] < height[right_max]) {
                if (height[left_max] > height[left]) {
                    sum += height[left_max] - height[left];
                } else {
                    left_max = left;
                }
                left++;
                continue;
            }

            if (height[right_max] > height[right]) {
                sum += height[right_max] - height[right];
            } else {
                right_max = right;
            }
            right--;
        }
        return sum;
    }

    public int trap_2(int[] height) {
        //[0,1,0,2,1,0,1,3,2,1,2,1]

        if (height == null || height.length == 0) {
            return 0;
        }

        int n = height.length;
        int[] highest = new int[n];
        highest[0] = height[0];

        int max = height[0];
        for (int i = 1; i < n - 1; i++) {
            highest[i] = Math.max(height[i], max);
            max = Math.max(height[i], max);
        }
        highest[n - 1] = height[n - 1];
        //[0,1,1,2,2,2,2,3,3,3,3,3]

        max = height[n - 1];
        for (int i = n - 2; i > 0; i--) {
            highest[i] = Math.min(highest[i], max);
            highest[i] = Math.max(height[i], highest[i]);
            max = Math.max(max, height[i]);
        }
        //[0,1,1,2,2,2,2,3,2,2,2,3]
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += highest[i] - height[i];
        }
        return sum;
    }

    public int trap_3(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        int index = 0;
        int n = height.length;
        while (index < n) {
            while (!stack.isEmpty() && height[index] > height[stack.peek()]) {

                int pitHeight = height[stack.peek()];
                stack.pop();//这里是一个“坑”

                //要找“坑”前面的那个腔
                if (stack.isEmpty()) {
                    break;//意思就是两堵墙中间没有”坑“
                }

                int preIndex = stack.peek();

                int wallHeight = Math.min(height[index], height[preIndex]);

                //这是隐含的一步，官方题解没有写出来
                //因为如果“坑”的值跟预料的“墙”的高度一样，说明目前找到的还不是“墙”，还得继续往前找
                if (wallHeight == pitHeight) {
                    continue;
                }

                int distance = index - preIndex - 1;
                sum += distance * (wallHeight - pitHeight);
            }
            stack.push(index);
            index++;
        }
        return sum;
    }
}
