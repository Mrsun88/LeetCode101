package com.leetcode.greedyAlgorithm.ga135;

/**
 * 135. 分发糖果
 */
class Solution {
    public int candy(int[] ratings) {
        int ans =  0;
        for(int i = 0; i < ratings.length; i++) {
            int biggerNumL = 0;
            int biggerNumR = 0;
            // 左搜
            int last = ratings[i];
            for(int j = i - 1; j >= 0; j--) {
                if(last <= ratings[j]) {break;}
                biggerNumL ++;
                last = ratings[j];
            }
            // 右搜
            last = ratings[i];
            for(int j = i + 1; j < ratings.length; j++) {
                if(last <= ratings[j]) {break;}
                biggerNumR ++;
                last = ratings[j];
            }
            ans += Math.max(biggerNumL, biggerNumR);
        }
        return ans + ratings.length;
    }
}
