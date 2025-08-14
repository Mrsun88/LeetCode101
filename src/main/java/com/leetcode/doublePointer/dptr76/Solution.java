package com.leetcode.doublePointer.dptr76;

import java.util.HashMap;
import java.util.Map;

/**
 * 解法思路：
 * 本题使用滑动窗口（双指针）结合哈希表统计字符频次，找到最短的覆盖子串。
 *
 * 1. 统计字符串 t 中每个字符出现的次数，存入 `map` 作为目标需求。
 * 2. 使用两个指针 l、r 表示滑动窗口的左右边界，初始均为 0。
 * 3. 遍历 s，右指针 r 逐步右移：
 *    - 如果当前字符在 `map` 中出现，则将其加入窗口计数 `count`。
 *    - 然后不断移动左指针 l 收缩窗口，直到窗口中对应字符的数量不再多余需求。
 * 4. 每次更新窗口后，调用 `checkIsValid` 判断窗口是否完全覆盖了 t：
 *    - 如果覆盖，并且当前窗口长度比之前记录的最优解更短，则更新最佳解的位置与长度。
 * 5. 遍历结束后，根据记录的最优位置返回结果子串，如果没有找到则返回空字符串。
 *
 * 时间复杂度：
 * - 最坏情况下 O(|s| × |t|)，因为每次右指针移动后都可能调用 `checkIsValid` 遍历 map。
 *
 * 空间复杂度：
 * - O(|字符集|)，哈希表存储窗口与目标字符的频次。
 */
public class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }

        int l = 0;
        int bestR = -1;
        int bestLength = 0x7fffffff;
        Map<Character, Integer> count = new HashMap<>();
        for(int r = 0; r < s.length(); r++) {
            Character c = s.charAt(r);
            if(map.containsKey(c)) {
                count.put(c, count.getOrDefault(c, 0) + 1);
                while(count.getOrDefault(s.charAt(l), 0x7fffffff) > map.getOrDefault(s.charAt(l), 0)) {
                    Integer x = count.getOrDefault(s.charAt(l), -1);
                    if(x != -1){
                        count.put(s.charAt(l), x - 1);
                    }
                    l++;
                }
                if(checkIsValid(count, map)) {
                    if(bestLength > r - l + 1) {
                        bestLength = r - l + 1;
                        bestR = r;
                    }
                }
            }
        }
        if(bestR == -1) return "";
        return s.substring(bestR - bestLength + 1, bestR + 1);
    }

    private boolean checkIsValid(Map<Character, Integer> count, Map<Character, Integer> map) {
        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            Character key = entry.getKey();
            Integer num = entry.getValue();
            if(!count.containsKey(key)) return false;
            if(count.get(key) < num) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        Solution solution = new Solution();
        System.out.println(solution.minWindow(s, t));
    }
}
