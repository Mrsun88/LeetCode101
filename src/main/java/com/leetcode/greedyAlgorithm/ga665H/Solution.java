package com.leetcode.greedyAlgorithm.ga665H;

/**
 * 只有一个降序对或者没有降序对时有效
 * 对于nums[i+1] 和 nums[i]降序对, 两种改法:
 * 1. 增大后一个
 * 2. 减小前一个
 */
public class Solution {
    public boolean checkPossibility(int[] nums) {
        int count = 0; // 修改次数
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                count++;
                if (count > 1) return false;
                if (i > 0 && nums[i - 1] > nums[i + 1]) {
                    nums[i + 1] = nums[i]; // 改后一个
                } else {
                    nums[i] = nums[i + 1]; // 改当前
                }
            }
        }
        return true;
    }
}
