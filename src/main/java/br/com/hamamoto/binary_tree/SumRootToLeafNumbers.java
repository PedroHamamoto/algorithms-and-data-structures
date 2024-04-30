package br.com.hamamoto.binary_tree;

/**
 * <a href="https://leetcode.com/problems/sum-root-to-leaf-numbers> LeetCode problem </a>
 * - Sum Root to Leaf Numbers
 */
public class SumRootToLeafNumbers {

    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }

    private int sumNumbers(TreeNode node, int currentSum) {
        if (node == null)
            return 0;

        currentSum = currentSum * 10 + node.val;

        if (node.left == null && node.right == null)
            return currentSum;

        return sumNumbers(node.left, currentSum) + sumNumbers(node.right, currentSum);
    }

}
