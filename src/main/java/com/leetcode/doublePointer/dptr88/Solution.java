package com.leetcode.doublePointer.dptr88;

import java.util.Arrays;

public class Solution {
    public void merge(int[] nums1, int n, int[] nums2, int m) {
        int i = 0, j = 0, pos = 0;
        int[] ret = new int[nums1.length];
        while(i != n && j != m) {
            if(nums1[i] < nums2[j]) {
                ret[pos++] = nums1[i++];
            }else {
                ret[pos++] = nums2[j++];
            }
        }
        while(i != n) {
            ret[pos++] = nums1[i++];
        }
        while(j != m) {
            ret[pos++] = nums2[j++];
        }
        System.arraycopy(ret, 0, nums1, 0, ret.length);
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        Solution s = new Solution();
        s.merge(nums1, 3, nums2, 3);
        for (int i : nums1) {
            System.out.printf("%d ", i);
        }
    }
}
