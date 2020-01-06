package com.leetcode.tree;

import com.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 手写代码需要注意点：
 * 1.List<List<Integer>> ans = new ArrayList<>(); List => ArrayList
 * 2. Queue<TreeNode> queue = new LinkedList<>(); Queue => LinkedList
 * 3. queue.isEmpty()是个方法
 */
public class Solution102levelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<TreeNode> queue = new LinkedList<>();//记录每一层中的节点，每一层进入之后，被弹出，下一层再进入
        queue.add(root);//从root层开始
        while (!queue.isEmpty()) {
            int curLevelSize = queue.size();
            List<Integer> curLevelList = new ArrayList<>();
            for (int i = 0; i < curLevelSize; i++) {
                TreeNode curNode = queue.poll();
                curLevelList.add(curNode.val);
                if (curNode.left != null) queue.add(curNode.left);
                if (curNode.right != null) queue.add(curNode.right);
            }
            ans.add(curLevelList);
        }
        return ans;
    }
}
