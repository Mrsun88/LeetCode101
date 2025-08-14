package com.leetcode.greedyAlgorithm.ga763;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, int[]> c2range = new HashMap<>(26);
        // 1. 计算26个字母的左右边界
        for(int i = 0; i < s.length(); i++) {
            int[] range = c2range.getOrDefault(s.charAt(i), new int[]{-1, -1});
            if(range[0] == -1) {
                range[0] = i;
                range[1] = i;
                c2range.put(s.charAt(i), range);
                continue;
            }
            range[0] = Math.min(range[0], i);
            range[1] = Math.max(range[1], i);
        }
        // 2. 根据左节点从小到大排序
        List<int[]> rangeList = c2range.values().stream().sorted((a, b) -> {
            return a[0] - b[0];
        }).toList();
        // 3.计算
        List<Integer> ans = new ArrayList<>();
        ans.add(rangeList.get(0)[1] + 1);
        int lastR = rangeList.get(0)[1];
        int lastL = 0;
        for(int i = 1; i < rangeList.size(); i++) {
            int[] r = rangeList.get(i);
            if(r[0] < lastR) {
                ans.set(ans.size() - 1, Math.max(ans.getLast(), r[1]-lastL+1));
                lastR = Math.max(lastR, r[1]);
            }else {
                lastL = r[0];
                lastR = r[1];
                ans.add(r[1] - r[0] + 1);
            }
        }
        return ans;
    }

}
