package br.com.hamamoto.binary_tree;

/**
 * <a href="https://leetcode.com/problems/count-complete-tree-nodes> LeetCode problem </a>
 * - Count Complete Tree Nodes
 */
public class CountCompleteTreeNodes {

    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

}
