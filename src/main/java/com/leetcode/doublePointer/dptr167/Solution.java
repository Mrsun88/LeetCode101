package com.leetcode.doublePointer.dptr167;

/**
 * 双指针
 */
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[0]; // 理论上不会走到这里
    }
}

/**
 * 二分
 */
class _Solution {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int left = i + 1, right = numbers.length - 1;
            int need = target - numbers[i];
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (numbers[mid] == need) {
                    return new int[]{i + 1, mid + 1};
                } else if (numbers[mid] < need) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return new int[0];
    }
}

