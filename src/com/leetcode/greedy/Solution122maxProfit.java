package com.leetcode.greedy;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * <p>
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [7,1,5,3,6,4]
 * 输出: 7
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 解题思路：
 * <p>
 * 盈利 = sum(高点 - 地点)
 */
public class Solution122maxProfit {
    public int maxProfit(int[] prices) {
        int low = prices[0];
        int high = prices[0];
        int ans = 0;
        int index = 0;
        while (index < prices.length - 1){
            //先算low点
            while (index < prices.length - 1 && prices[index] >= prices[index+1]) index++;
            low = prices[index];
            //再算hight点
            while (index < prices.length-1 && prices[index] <= prices[index+1]) index++;
            high = prices[index];
            ans += high - low;
        }
        return ans;
    }
}
