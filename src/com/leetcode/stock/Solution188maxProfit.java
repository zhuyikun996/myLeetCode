package com.leetcode.stock;

import java.util.Arrays;

/**
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
 * <p>
 * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,4,1], k = 2
 * 输出: 2
 * 解释: 在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
 * 示例 2:
 * <p>
 * 输入: [3,2,6,5,0,3], k = 2
 * 输出: 7
 * 解释: 在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
 *      随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution188maxProfit {
    public int maxProfit(int k, int[] prices) {
        if (prices.length <= 1) return 0;
        int len = prices.length;
        if (k > len / 2) return infiniteTimes(prices);//当k大于len/2时，等效于交易无数次
        int[][][] maxProfit = new int[len][k + 1][2];//i天，k次交易，是否持有
        int ans = 0;

        for (int i = 0; i < len; i++) {//i天
            for (int j = 0; j <= k; j++) {//j次交易
                if (i == 0) {//初始化 i = 0： 最后一位为1时候，等于-prices[0]，最后一位为0时，等于0
                    maxProfit[i][j][0] = 0;
                    maxProfit[i][j][1] = -prices[0];
                } else if (j == 0) { //i天（i>0）,0次交易
                    maxProfit[i][j][0] = maxProfit[i - 1][j][0];//不持有：i-1天不持有
                    maxProfit[i][j][1] = Math.max(maxProfit[i - 1][j][1], maxProfit[i - 1][j][0] - prices[i]);//持有：max(保持i-1天持有，i-1天不持有但是i天买入)
                }
            }
        }
        for (int i = 1; i < len; i++) {//i天
            for (int j = 1; j <= k; j++) {//j次交易
                //i天，j次交易，当前不持有：1，i-1天完成j次交易，不持有.2,i-1天，完成j-1次交易，i天卖出（完成第j次交易）
                maxProfit[i][j][0] = Math.max(maxProfit[i - 1][j][0], maxProfit[i - 1][j - 1][1] + prices[i]);
                //i天，j次交易，持有。1，i-1天，j次交易，持有。2，i-1天，j次，不持有，但是买入
                maxProfit[i][j][1] = Math.max(maxProfit[i - 1][j][1], maxProfit[i - 1][j][0] - prices[i]);
            }
        }
        for (int n = 0; n <= k; n++) {
            ans = Math.max(maxProfit[len - 1][n][0], ans);
        }
        return ans;
    }

    private int infiniteTimes(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prices[i - 1];
            if (diff > 0) {
                profit += diff;
            }
        }
        return profit;
    }

}