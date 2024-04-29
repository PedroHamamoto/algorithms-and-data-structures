package br.com.hamamoto.binary_tree;

/**
 * <a href="https://leetcode.com/problems/symmetric-tree> LeetCode problem </a>
 * - Symmetric Tree
 */
public class SymmetricTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;

        if (left == null ^ right == null)
            return false;

        if (left.val != right.val)
            return false;

        return isSymmetric(left.right, right.left) && isSymmetric(left.left, right.right);
    }
}
