package com.leetcode.doublePointer.dptr524;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public String findLongestWord(String s, List<String> d) {
        d.sort((a, b)->{
            return a.length() - b.length() == 0 ? a.compareTo(b) : -(a.length() - b.length());
        });

        for(String word:d){
            int sp = 0, wp = 0;
            while(wp != word.length() && sp != s.length()) {
                if(s.charAt(sp) == word.charAt(wp)) {
                    sp ++;wp++;
                }else  sp++;
            }
            if(wp == word.length()) {
                return word;
            }
        }
        return "";
    }

    public static void main(String[] args) {
        String s = "abpcplea";
        List<String> d = Arrays.asList(new String[]{"ale", "apple", "monkey", "plea"});
        Solution solution = new Solution();
        System.out.println(solution.findLongestWord(s, d));
    }
}
