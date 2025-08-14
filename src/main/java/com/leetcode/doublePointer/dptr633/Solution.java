package com.leetcode.doublePointer.dptr633;

public class Solution {
    public boolean judgeSquareSum(int c) {
        int upper = (int)Math.sqrt(c) + 1;
        int lower = 0;
        while(lower <= upper) {
            int sum = lower * lower + upper * upper;
            if(sum > 0 && sum < c) { // sum > 0 防越界
                lower ++;
            }else if(sum == c) {
                return true;
            }else {
                upper --;
            }
        }
        return false;
    }

}
