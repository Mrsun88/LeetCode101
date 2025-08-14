package com.leetcode.greedyAlgorithm.ga435;

import java.util.Arrays;

/**
 * 435
 * 1. 左节点从小到大排序
 * 2. 右节点取min去max
 */
public class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b)->{  // 左节点比较
            return a[0] - b[0];
        });
        int ans = 0;
        int lastR = intervals[0][1];
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] < lastR) {
                ans ++;
                lastR = Math.min(intervals[i][1], lastR);
            } else {
                lastR = intervals[i][1];
            }
        }
        return ans;
    }
}
