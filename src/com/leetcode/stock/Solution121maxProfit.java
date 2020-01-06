package com.leetcode.stock;

import java.awt.event.MouseAdapter;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * <p>
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 注意你不能在买入股票前卖出股票。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * 示例 2:
 * <p>
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution121maxProfit {
//    public int maxProfit(int[] prices) {
//        if (prices.length < 1) return 0;
//        int ans = 0;
//        int min = prices[0];
//        for (int i = 1; i< prices.length;i++){
//            min = min > prices[i]? prices[i]:min;
//            ans = prices[i] - min > ans ? prices[i] - min : ans;
//        }
//        return ans;
//    }

    //dp
    public int maxProfit(int[] prices) {
        if (prices.length < 1) return 0;
        int ans = 0;
        int len = prices.length;
        int[][][] maxProfit = new int[len][2][2];//len-1天，交易次数，是否持有股票
        maxProfit[0][0][0] = 0;//0天，0次买卖，不持有
        maxProfit[0][0][1] = -prices[0];//0天，0次买卖，持有
        maxProfit[0][1][0] = 0;//0天，1次买卖，不持有
        maxProfit[0][1][1] = -prices[0];//0天，1次买卖，持有
        for (int i = 1; i < len; i++) {
            maxProfit[i][0][0] = maxProfit[i - 1][0][0];//i天，0次买卖，不持有
            maxProfit[i][0][1] = Math.max(maxProfit[i-1][0][1],maxProfit[i-1][0][0] - prices[i]);//i天，0次买卖，持有:1,i-1天0次买卖持有。2,i-1天交易0次，i天买入
            maxProfit[i][1][0] = Math.max(maxProfit[i-1][0][1]+prices[i],maxProfit[i-1][1][0]);//i天交易一次，不持有：1，i-1天持有，0次买卖，i天卖出。2，i-1天交易一次，卖出，不持有
            maxProfit[i][1][1] = Math.max(maxProfit[i-1][1][0]-prices[i],maxProfit[i-1][1][1]);//i天交易一次，持有：1，i-1天不持有，1次买卖，i天买入。2，i-1天交易一次，持有
        }
        int temp = Math.max(ans,maxProfit[len-1][0][0]);
        ans = Math.max(temp,maxProfit[len-1][1][0]);
        return ans;
    }
}
