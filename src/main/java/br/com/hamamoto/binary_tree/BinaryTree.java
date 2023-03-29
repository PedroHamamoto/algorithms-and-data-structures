package br.com.hamamoto.binary_tree;

import java.util.*;

public class BinaryTree {

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
     * <a href="https://leetcode.com/problems/binary-tree-level-order-traversal"> LeetCode problem </a>
     * - Binary tree level order traversal
     */
    public List<List<Integer>> levelOrderTraversal(BinarySearchTree.TreeNode root) {
        var levels = new ArrayList<List<Integer>>();

        Deque<BinarySearchTree.TreeNode> queue = new ArrayDeque<>();

        if (Objects.nonNull(root))
            queue.add(root);

        while (!queue.isEmpty()) {
            var level = new ArrayList<Integer>();

            var levelLength = queue.size();

            for (int i = 0; i < levelLength; i++) {
                var current = queue.removeFirst();
                level.add(current.val);

                if (Objects.nonNull(current.left))
                    queue.add(current.left);
                if (Objects.nonNull(current.right))
                    queue.add(current.right);
            }

            levels.add(level);
        }

        return levels;
    }

    /**
     * <a href="https://leetcode.com/problems/binary-tree-right-side-view"> LeetCode problem </a>
     * - Binary tree right side view
     */
    public List<Integer> rightSideView(BinarySearchTree.TreeNode root) {
        var rightSide = new ArrayList<Integer>();

        Deque<BinarySearchTree.TreeNode> queue = new ArrayDeque<>();

        if (Objects.nonNull(root))
            queue.add(root);

        while (!queue.isEmpty()) {
            var levelLength = queue.size();
            rightSide.add(queue.peekLast().val);

            for (int i = 0; i < levelLength; i++) {
                var current = queue.removeFirst();

                if (Objects.nonNull(current.left))
                    queue.add(current.left);
                if (Objects.nonNull(current.right))
                    queue.add(current.right);
            }
        }

        return rightSide;
    }

    /**
     * <a href="https://leetcode.com/problems/binary-tree-inorder-traversal"> LeetCode problem </a>
     * - Binary tree inorder traversal
     */
    public List<Integer> inorderTraversal(BinarySearchTree.TreeNode root) {
        return inorder(root, new ArrayList<Integer>());
    }

    private List<Integer> inorder(BinarySearchTree.TreeNode root, List<Integer> traversed) {
        if (Objects.isNull(root)) {
            return traversed;
        }

        inorder(root.left, traversed);
        traversed.add(root.val);
        inorder(root.right, traversed);

        return traversed;
    }
}
