package com.leetcode;

import javax.swing.*;
import java.util.*;

/**
 * for 选择 in 选择列表:
 * # 做选择
 * 将该选择从选择列表移除
 * 路径.add(选择)
 * backtrack(路径, 选择列表)
 * # 撤销选择
 * 路径.remove(选择)
 * * 将该选择再加入选择列表
 * <p>
 * 作者：labuladong
 * 链接：https://leetcode-cn.com/problems/n-queens/solution/hui-su-suan-fa-xiang-jie-by-labuladong/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Solution51solveNQueens {
    List<List<String>> ans;
    Set<Integer> colSet;
    Set<Integer> sumSet;
    Set<Integer> minusSet;

    public List<List<String>> solveNQueens(int n) {
        if (n < 1) return ans;
        ans = new ArrayList<>();//结果
        sumSet = new HashSet<>();//记录坐标和
        minusSet = new HashSet<>();//记录坐标差
        colSet = new HashSet<>();//记录列标
        List<String> onePattern = new ArrayList<>();//一种棋子的摆放结果
        dfs(n, 0, onePattern);
        return ans;
    }

    private void dfs(int n, int row, List<String> onePattern) {
        //递归终止条件
        if (row >= n) {
            List<String> pattern = new ArrayList<>(onePattern);//复制一份摆放结果
            ans.add(pattern);
        }
        //col表示列：从0到n
        for (int col = 0; col < n; col++) {
            if (colSet.contains(col) || sumSet.contains(row + col) || minusSet.contains(row - col)) {
                continue;//当前位置被其他皇后攻击
            }
            //记录当前位置
            colSet.add(col);
            sumSet.add(row + col);
            minusSet.add(row - col);
            //把当前的摆放方式放到onePattern中
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < n; i++) {
                if (i == col) {
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }
            onePattern.add(sb.toString());//此时sb表示row这层的摆放方式
            //递归 到下一row中
            dfs(n, row + 1, onePattern);
            //当程序运行到这里的时候，已经从dfs中返回，进入回溯过程，需要将当前的记录清除掉
            colSet.remove(col);
            sumSet.remove(row + col);
            minusSet.remove(row - col);
            onePattern.remove(sb.toString());
        }
    }
}
