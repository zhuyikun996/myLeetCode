package com.leetcode.common;

/**
 * 并查集
 */
public class UnionAndFind {
    private int[] roots;

    public UnionAndFind(int N) {
        roots = new int[N];
        for (int i = 0; i < N; i++) {
            roots[i] = i;
        }
    }
    private int findRoot(int i){
        int root = i;
        //找到集合的root
        while (root != roots[root]) {
            root = roots[root];
        }
        //路径压缩
        while (i != roots[i]) {
            int tmp = roots[i];//tmp为i的父节点
            roots[i] = root;//把i指向集合的root
            i = tmp;//再从i的父节点继续压缩
        }
        return root;
    }
    public boolean connected (int p,int q){
        return findRoot(p) == findRoot(q);
    }
    public void union(int p,int q){
        int qroot = findRoot(q);
        int proot = findRoot(p);
        roots[proot] = qroot;
    }
}
