package br.com.hamamoto.binary_tree;

/**
 * <a href="https://leetcode.com/problems/kth-smallest-element-in-a-bst> LeetCode problem </a>
 * - Kth Smallest Element in a BST
 */
public class KthSmallestElementInABST {
    int ans = Integer.MAX_VALUE;
    int visited = 1;

    public int kthSmallest(TreeNode root, int k) {
        if (root == null)
            return 0;

        kthSmallest(root.left, k);
        if (visited == k)
            ans = root.val;

        visited++;
        kthSmallest(root.right, k);

        return ans;g
    }
}
