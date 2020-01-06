package com.leetcode.stock;

import java.util.Arrays;

/**
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 * <p>
 * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,3,5,0,0,3,1,4]
 * 输出: 6
 * 解释: 在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
 *      随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
 * 示例 2:
 * <p>
 * 输入: [1,2,3,4,5]
 * 输出: 4
 * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。  
 *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。  
 *      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 * 示例 3:
 * <p>
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这个情况下, 没有交易完成, 所以最大利润为 0。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution123maxProfit {
    public int maxProfit(int[] prices) {
        if (prices.length < 1) return 0;
        int len = prices.length;
        int[][][] maxProfit = new int[len][3][2];//天，交易次数,完整买卖算一次，是否持有股票
        int ans = 0;

        maxProfit[0][0][0] = 0;//0天，之前交易0次，不持有股票
        maxProfit[0][0][1] = -prices[0];//0天，之前交易0次，持有股票，买入price[0]
        maxProfit[0][1][0] = 0;//0天，之前交易1次，现在不持有股票
        maxProfit[0][1][1] = -prices[0];//0天，之前交易1次，现在持有股票，买入price[0]
        maxProfit[0][2][0] = 0;//0天，之前交易2次，现在不持有股票
        maxProfit[0][2][1] = -prices[0];//0天，之前交易2次，现在持有股票，买入price[0]

        for (int i = 1; i < len; i++) {
            maxProfit[i][0][0] = maxProfit[i - 1][0][0];//i天，之前0次操作，现在不持有
            maxProfit[i][0][1] = Math.max(maxProfit[i - 1][0][1], maxProfit[i - 1][0][0] - prices[i]);//i天，之前0次操作，现在持有

            maxProfit[i][1][0] = Math.max(maxProfit[i - 1][1][0], maxProfit[i - 1][0][1] + prices[i]);//i天，之前1次买卖，现在不持有
            maxProfit[i][1][1] = Math.max(maxProfit[i - 1][1][1], maxProfit[i - 1][1][0] - prices[i]);//i天，之前1次买卖，现在持有

            maxProfit[i][2][0] = Math.max(maxProfit[i - 1][2][0], maxProfit[i - 1][1][1] + prices[i]);//i天，之前2次买卖，现在不持有，持有的就不用看了，因为持有的profit不可能大于最后卖出的
        }
        //只需要比较 maxProfit[len-1][0][0]、maxProfit[len-1][1][0]、maxProfit[len-1][2][0]
        //最后一次交易，已经交易0次，1次，2次，手中不持有股票
        int temp = Math.max(maxProfit[len - 1][0][0], maxProfit[len - 1][1][0]);
        ans = Math.max(temp, maxProfit[len - 1][2][0]);
        return ans;
    }

}
