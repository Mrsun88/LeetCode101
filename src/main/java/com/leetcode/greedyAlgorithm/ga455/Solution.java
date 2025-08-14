package com.leetcode.greedyAlgorithm.ga455;

import java.util.Arrays;

/**
 * 455. 分发饼干
 */
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int ans = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int j = 0;
        for (int k : s) {
            if (j == g.length) break;
            if (g[j] <= k) {
                ans++;
                j++;
            }
        }
        return ans;
    }
}