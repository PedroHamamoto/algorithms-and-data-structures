package br.com.hamamoto;

import java.util.Objects;

/**
 *<a href="https://leetcode.com/problems/search-in-a-binary-search-tree"> LeetCode problem </a>
 * - Search in a binary tree
 * */
class BinaryTreeSearcher {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode searchBST(TreeNode root, int val) {
        return bst(root, val);
    }

    private TreeNode bst(TreeNode node, int target) {
        if (Objects.isNull(node)) {
            return null;
        }

        if (target > node.val) {
            return bst(node.right, target);
        } else if (target < node.val) {
            return bst(node.left, target);
        } else {
            return node;
        }
    }
}