package br.com.hamamoto.backtracking;

import br.com.hamamoto.binary_tree.TreeNode;

import java.util.Objects;

/**
 * <a href="https://leetcode.com/problems/path-sum"> LeetCode problem </a> - Path Sum
 */
public class PathSumVerifier {
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
