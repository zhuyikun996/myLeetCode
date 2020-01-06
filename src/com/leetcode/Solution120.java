package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 *
 * 例如，给定三角形：
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 *
 * 说明：
 *
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() < 1) return 0;
        int len = triangle.size();//层数
        List<Integer> ans = new ArrayList<>(triangle.get(len - 1));//结果是ans.get(0)
        for (int i = len - 2; i >= 0; i--) {//从倒数第二层开始遍历，i表示层数
            for (int j = 0; j < triangle.get(i).size(); j++) {//遍历第i层
                int l = ans.get(j);
                int r = ans.get(j + 1);
                int min = 0;//min代表j和j+1位置上较小值
                if (l < r) {
                    min = l;
                } else {
                    min = r;
                }
                //ans的更新规则：第j位置上放置j和j+1较小值min和原始数组triangle[i][j]的和
                //这样可以保证从最底层往上扫描的时候，每提升一层压缩1位，最终ans的
                ans.set(j, min+triangle.get(i).get(j));
            }
        }
        return ans.get(0);//状态压缩，最后0的位置为最终结果
    }

}
