package br.com.hamamoto.binary_tree;


import java.util.Arrays;

/**
 *<a href="https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/"> LeetCode problem </a>
 * - Construct Binary Tree from Preorder and Inorder Traversal
 * */
class TreeBuilder {

    class TreeNode {
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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0)
            return null;

        var root = new TreeNode(preorder[0]);

        int mid = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (root.val == inorder[i]) {
                mid = i;
                break;
            }
        }

        root.left = buildTree(
                Arrays.copyOfRange(preorder, 1, mid + 1),
                Arrays.copyOfRange(inorder, 0, mid)
        );
        root.right = buildTree(
                Arrays.copyOfRange(preorder, mid + 1, preorder.length),
                Arrays.copyOfRange(inorder, mid + 1, inorder.length)
        );

        return root;
    }
}