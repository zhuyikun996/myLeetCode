package com.leetcode.tree;

import com.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution111minDepth {
    public int minDepth(TreeNode root) {
        //BFS
        int ans = 0;
        boolean isLeafNode = false;
        if (root == null) return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty() && !isLeafNode) {
            int curLevelSize = queue.size();
            ans++;
            for (int i = 0; i < curLevelSize; i++) {
                TreeNode curNode = queue.poll();
                if (curNode.left != null) queue.add(curNode.left);
                if (curNode.right != null) queue.add(curNode.right);
                if (curNode.left == null && curNode.right == null) {
                    isLeafNode = true;
                    break;
                }
            }
        }
        return ans;
    }
}
