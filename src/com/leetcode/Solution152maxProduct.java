package com.leetcode;

public class Solution152maxProduct {
    public int maxProduct(int[] nums) {
        if (nums.length < 1) return 0;
        int ans = nums[0];
        int curMax = nums[0];
        int curMin = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int curNum = nums[i];
            curMax = curMax * curNum;
            curMin = curMin * curNum;
            int tempMax = max(curNum, curMax, curMin);
            int tempMin = min(curNum, curMax, curMin);
            ans = max(ans, tempMax, tempMin);
            curMax = tempMax;
            curMin = tempMin;
        }
        return ans;
    }

    private int max(int a, int b, int c) {
        return (a>b)?(a>c?a:c):(b>c?b:c);
    }
    private int min(int a, int b, int c) {
        return (a<b)?(a<c?a:c):(b<c?b:c);
    }
}
