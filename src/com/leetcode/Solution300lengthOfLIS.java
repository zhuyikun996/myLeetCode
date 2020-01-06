package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * <p>
 * 示例:
 * <p>
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * 说明:
 * <p>
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n2) 。
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution300lengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        //dp解法 O（N^2）
        if (nums == null || nums.length < 1) return 0;
        int ans = 1;
        int len = nums.length;
        int[]dp = new int[len];//dp的index从0到len
        for (int i = 0;i<len;i++){
            dp[i] = 1;
        }
        for (int i = 1;i<len;i++){
            for (int j = 0;j<i;j++){
                if (nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            ans = Math.max(ans,dp[i]);
        }
        return ans;
        
        //维护一个数组
    }
}
