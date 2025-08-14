package com.leetcode.greedyAlgorithm.ga122;

public class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0;
        int lastMin = 0x7fffffff;
        for (int price : prices) {
            if (price >= lastMin) {
                ans += price - lastMin;
            }
            lastMin = price;
        }
        return ans;
    }
}
