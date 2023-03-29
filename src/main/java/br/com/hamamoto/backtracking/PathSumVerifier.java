package br.com.hamamoto.backtracking;

import java.util.Objects;

public class PathSumVerifier {

    static class TreeNode {
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

    /**
     * <a href="https://leetcode.com/problems/path-sum"> LeetCode problem </a> - Path Sum
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (Objects.isNull(root))
            return false;

        targetSum -= root.val;

        if (isLeaf(root))
            return targetSum == 0;

        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
    }

    private boolean isLeaf(TreeNode node) {
        return Objects.isNull(node.left) && Objects.isNull(node.right);
    }
}
