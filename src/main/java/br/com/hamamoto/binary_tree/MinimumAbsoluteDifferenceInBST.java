package br.com.hamamoto.binary_tree;

/**
 * <a href="https://leetcode.com/problems/minimum-absolute-difference-in-bst> LeetCode problem </a>
 * - Minimum Absolute Difference in BST
 */
public class MinimumAbsoluteDifferenceInBST {

    private int min = Integer.MAX_VALUE;
    private int previousValue = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode node) {
        if (node.left != null)
            getMinimumDifference(node.left);

        min = Math.min(min, Math.abs(node.val - previousValue));

        previousValue = node.val;
        if (node.right != null)
            getMinimumDifference(node.right);

        return min;
    }

}
