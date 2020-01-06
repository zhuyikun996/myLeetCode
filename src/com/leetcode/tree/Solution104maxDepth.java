package com.leetcode.tree;

import com.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class Solution104maxDepth {
    public int maxDepth(TreeNode root) {
        //BFS
        if (root == null) return 0;
        int ans = 1;
        Queue<TreeNode> queue = new LinkedList<>();//记录每一层的数据
        queue.add(root);
        while (!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                TreeNode curNode = queue.poll();
                if (curNode.left != null ) queue.add(curNode.left);
                if (curNode.right != null ) queue.add(curNode.right);
            }
            ans++;
        }
        return ans;
    }
}
