package br.com.hamamoto.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/problems/k-closest-points-to-origin"> LeetCode problem </a> -
 * K closest points to origin
 */
class KClosestPointsToOriginFinder {

    static class Point {
        final int x;
        final int y;
        final int distance;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
            this.distance = x * x + y * y;
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        var heap = new PriorityQueue<>(Comparator.comparingInt((Point o) -> o.distance));

        for (int[] point : points) {
            heap.offer(new Point(point[0], point[1]));
        }

        int[][] result = new int[k][2];

        for (int i = 0; i < k; i++) {
            var point = heap.poll();
            result[i][0] = point.x;
            result[i][1] = point.y;
        }

        return result;
    }
}