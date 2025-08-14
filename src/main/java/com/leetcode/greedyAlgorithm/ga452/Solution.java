package com.leetcode.greedyAlgorithm.ga452;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int findMinArrowShots(int[][] points) {
        if(points.length==0) return 0;
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));
        int ret = 1;
        int arrowPlace = points[0][1];
        for(int i = 1; i < points.length; i++) {
            if(points[i][1] <= arrowPlace) {
                arrowPlace = points[i][1];
                continue;
            }
            if(points[i][0] > arrowPlace) {
                arrowPlace = points[i][1];
                ret ++;
            }
        }
        return ret;
    }
}
