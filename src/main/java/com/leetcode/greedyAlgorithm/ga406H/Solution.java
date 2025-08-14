package com.leetcode.greedyAlgorithm.ga406H;

import java.util.Arrays;

public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a,b)->{
            return a[0] == b[0] ? a[1] - b[1] : b[0] - a[0];
        });
        int[][] ans = new int[people.length][2];
        for(int i = 0; i < people.length; i++) {
            insertToArray(ans, people[i][1], people[i]);
        }
        return ans;
    }

    private void insertToArray(int[][] target, int pos, int[] person) {
        for(int i = target.length - 1;  i > pos; i--) {
            target[i] = target[i - 1];
        }
        target[pos] = person;
    }
}
