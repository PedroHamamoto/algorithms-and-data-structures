package br.com.hamamoto.tree;

/**
 * <a href="https://leetcode.com/problems/maximum-depth-of-n-ary-tree> LeetCode problem </a>
 * - Maximum Depth of N-ary Tree
 */
public class MaximumDepthOfNaryTree {

    public int maxDepth(Node root) {
        if (root == null)
            return 0;

        var depth = 0;

        for (var child : root.children) {
            depth = Math.max(depth, maxDepth(child));
        }


        return depth + 1;
    }

}
