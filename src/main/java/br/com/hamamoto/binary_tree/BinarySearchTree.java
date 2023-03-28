package br.com.hamamoto.binary_tree;

import java.util.*;

class BinarySearchTree {

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
     * <a href="https://leetcode.com/problems/insert-into-a-binary-search-tree"> Insert into a binary search tree </a>
     */
    private TreeNode insert(TreeNode root, int val) {
        if (Objects.isNull(root)) {
            return new TreeNode(val);
        }

        if (val > root.val) {
            root.right = insert(root.right, val);
        } else {
            root.left = insert(root.left, val);
        }

        return root;
    }

    /**
     * <a href="https://leetcode.com/problems/search-in-a-binary-search-tree"> LeetCode problem </a>
     * - Search in a binary tree
     */
    public TreeNode search(TreeNode node, int target) {
        if (Objects.isNull(node)) {
            return null;
        }

        if (target > node.val) {
            return search(node.right, target);
        } else if (target < node.val) {
            return search(node.left, target);
        } else {
            return node;
        }
    }

    /**
     *<a href="https://leetcode.com/problems/delete-node-in-a-bst/"> LeetCode problem </a> - Delete a node in BST
     * */
    public TreeNode remove(TreeNode root, int key) {
        if (Objects.isNull(root)) {
            return null;
        }

        if (key > root.val) {
            root.right = remove(root.right, key);
        } else if (key < root.val) {
            root.left = remove(root.left, key);
        } else {
            if (Objects.isNull(root.left)) {
                return root.right;
            } else if (Objects.isNull(root.right)) {
                return root.left;
            } else {
                var minimum = getMin(root.right);
                root.val = minimum.val;
                root.right = remove(root.right, minimum.val);
            }
        }

        return root;
    }

    /**
     *<a href="https://leetcode.com/problems/binary-tree-inorder-traversal"> LeetCode problem </a>
     * - Binary tree inorder traversal
     * */
    public List<Integer> inorderTraversal(TreeNode root) {
        return inorder(root, new ArrayList<Integer>());
    }

    private List<Integer> inorder(TreeNode root, List<Integer> traversed) {
        if (Objects.isNull(root)) {
            return traversed;
        }

        inorder(root.left, traversed);
        traversed.add(root.val);
        inorder(root.right, traversed);

        return traversed;
    }

    public TreeNode getMin(TreeNode root) {
        while (Objects.nonNull(root) && Objects.nonNull(root.left)) {
            root = root.left;
        }

        return root;
    }

    public TreeNode getMax(TreeNode root) {
        while (Objects.nonNull(root) && Objects.nonNull(root.right)) {
            root = root.right;
        }

        return root;
    }

    /**
     *<a href="https://leetcode.com/problems/binary-tree-level-order-traversal"> LeetCode problem </a>
     * - Binary tree level order traversal
     * */
    public List<List<Integer>> levelOrderTraversal(TreeNode root) {
        var levels = new ArrayList<List<Integer>>();

        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();

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
}