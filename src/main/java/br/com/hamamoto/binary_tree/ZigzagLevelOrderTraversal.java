package br.com.hamamoto.binary_tree;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal> LeetCode problem </a>
 * - Binary Tree Zigzag Level Order Traversal
 */
public class ZigzagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        var levels = new ArrayList<List<Integer>>();

        if (root != null)
            queue.offer(root);

        while (!queue.isEmpty()) {
            var level = new ArrayList<Integer>();
            var levelSize = queue.size();


            for (int i = 0; i < levelSize; i++) {
                var node = queue.poll();
                level.add(node.val);

                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }

            if (levels.size() % 2 == 1)
                Collections.reverse(level);

            levels.add(level);
        }

        return levels;
    }

}
