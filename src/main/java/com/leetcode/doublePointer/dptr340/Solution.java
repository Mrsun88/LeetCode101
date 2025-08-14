package com.leetcode.doublePointer.dptr340;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(k==0)return 0;
        int maxLength = -1;
        int l = 0, r= 0;
        Map<Character, Integer> map = new HashMap<>();
        int nowK = 0;
        for(r = 0; r <s.length(); r++){
            Character c = s.charAt(r);
            if(map.getOrDefault(c, 0) == 0){
                nowK ++;
            }
            map.put(c, map.getOrDefault(c, 0) + 1);
            while(nowK > k) {
                int last = map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                l++;
                if(last == 1) nowK -= 1;
            }
            if(nowK <= k) {
                maxLength = Math.max(maxLength, r - l + 1);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String s = "aba";
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstringKDistinct(s, 1));
    }
}
