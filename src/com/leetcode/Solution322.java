package com.leetcode;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入: coins = [2], amount = 3
 * 输出: -1
 * 说明:
 * 你可以认为每种硬币的数量是无限的
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution322 {
    public int coinChange(int[] coins, int amount) {
        int Max = amount + 1;
        int dp[] = new int[Max];
        for (int i = 0;i<Max;i++){//初始化dp[i] = Max
            dp[i] = Max;
        }
        dp[0] = 0;//凑够0元，需要最少的硬币是0枚
        for (int i = 1; i <= amount; i++) {//i从1到amount，表示凑够1元到凑够amount元
            for (int j = 0; j < coins.length; j++) {//j从0到数组长度，数组中存放的是硬币的面值
                if (coins[j] <= i) {//当前硬币的面值小于需要凑的金额
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);//凑够i元需要最少的硬币数是min（当前的硬币数量，之前的硬币最小值+用一枚当前硬币）
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];//凑够amount元需要的最少硬币数如果大于amount
    }
}
