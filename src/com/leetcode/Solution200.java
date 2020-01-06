package com.leetcode;

import java.util.Set;

/**
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。
 * 一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。
 * 你可以假设网格的四个边均被水包围。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 * <p>
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 * <p>
 * 输出: 3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-islands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution200 {
    //染色方法

    //并查集
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        UnionFind unionFind = new UnionFind(grid);
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') {
                    continue;
                }
                //grid[i][j] = 1,扩散
                for (int index = 0; index < 4; index++) {
                    int x = i + dx[index];
                    int y = j + dy[index];
                    if (x >= 0 && y >= 0 && x < m && y < n && grid[x][y] == '1') {
                        unionFind.union(i * n + j, x * n + y);
                    }
                }
            }
        }
        return unionFind.count;
    }

    /**
     * 创建 并查集
     */
    class UnionFind {
        int[] roots;//存放指向关系 roots[a] = b 表示a的父亲节点为b ：a -> b
        int count = 0;//父节点的个数

        public UnionFind(char[][] grid) {
            int m = grid.length;//行数
            int n = grid[0].length;//列数
            roots = new int[m * n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1') {
                        roots[i * n + j] = i * n + j;
                        count++;
                    }
                }
            }
        }

        private int find(int i) {
            int root = i;
            while (root != roots[root]) {
                root = roots[root];
            }
            while (i != roots[i]) {
                int parent = roots[i];
                roots[i] = root;
                i = parent;
            }
            return root;
        }

        public void union(int x, int y) {
            int xRoot = find(x);
            int yRoot = find(y);
            if (xRoot != yRoot) {
                roots[yRoot] = xRoot;
                count--;
            }
        }
    }
}
