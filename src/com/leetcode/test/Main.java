package com.leetcode.test;

import com.leetcode.Solution200;
import com.leetcode.Solution322;
import com.leetcode.Solution547findCircleNum;
import com.leetcode.stock.Solution123maxProfit;
import com.leetcode.stock.Solution188maxProfit;

public class Main {
    public static void main(String[] args) {
        int[][] nums = {
                {1,0,0,1},
                {0,1,1,0},
                {0,1,1,1},
                {1,0,1,1}};
        Solution547findCircleNum solution547findCircleNum = new Solution547findCircleNum();
        int ans = solution547findCircleNum.findCircleNum(nums);
        System.out.println(ans);
    }
}
