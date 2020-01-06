package com.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *给定一个整数 n，返回 n 皇后不同的解决方案的数量。
 *
 * 示例:
 *
 * 输入: 4
 * 输出: 2
 * 解释: 4 皇后问题存在如下两个不同的解法。
 * [
 *  [".Q..",  // 解法 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // 解法 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-queens-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution52totalNQueens {
    //dfs
//    int ans;
//    Set<Integer> colSet;
//    Set<Integer> sumSet;
//    Set<Integer> minusSet;
//
//    public int totalNQueens(int n) {
//        if (n < 1) return 0;
//        colSet = new HashSet<>();
//        sumSet = new HashSet<>();
//        minusSet = new HashSet<>();
//        dfs(n, 0);
//        return ans;
//    }
//
//    private void dfs(int n, int row) {
//        //递归的终止条件
//        if (row >= n) {
//            ans++;
//        }
//        for (int col = 0; col < n; col++) {
//            if (colSet.contains(col) || sumSet.contains(row + col) || minusSet.contains(row - col)) {
//                continue;
//            }
//            colSet.add(col);
//            sumSet.add(row + col);
//            minusSet.add(row - col);
//            dfs(n,row+1);
//            colSet.remove(col);
//            sumSet.remove(row + col);
//            minusSet.remove(row - col);
//        }
//    }

    //位运算解法
    int ans = 0;
    public int totalNQueens(int n){
       if (n < 1) return ans;
       dfs(n,0,0,0,0);
       return ans;
    }
    private void dfs(int n,int row,int col,int sum,int minus){
        //递归的终止条件
        if (row >= n){
            ans++;
            return;
        }
        //bits的每个二进制位，1表示可以放置的位置，0表示不可以放置的位置
        //col | sum | minus 结果为所有可以放置的位置，此时0可放置，1不可放置
        //~(col | sum | minus)取反后 1可放置 0不可放，但是之前多了32-N个1
        //(1<<n)-1 表示32-N个0，N个1的筛子
        // ~（col | sum| minus）&（1 << n）-1 筛选出之前0的位置，现在为1
        int bits = (~(col | sum | minus)) & ((1 << n)-1);
        while (bits > 0){
            int Q = bits & -bits;//a & -a表示取出最低位的1，这里放置Q
            dfs(n,row + 1,col|Q,(sum | Q) << 1,(minus | Q)>>1);
            bits = bits & bits-1;//去掉最后一个1
        }
    }


}
