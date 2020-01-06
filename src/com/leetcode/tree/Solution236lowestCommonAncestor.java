package com.leetcode.tree;

import com.leetcode.common.TreeNode;

public class Solution236lowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p.val == root.val || q.val == root.val) return root;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        return left == null ? right : (right == null ? left : root);
    }
}
