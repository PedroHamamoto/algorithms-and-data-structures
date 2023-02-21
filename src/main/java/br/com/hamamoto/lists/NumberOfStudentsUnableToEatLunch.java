package br.com.hamamoto.lists;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 *<a href="https://leetcode.com/problems/number-of-students-unable-to-eat-lunch/description/"> LeetCode problem </a>
 * - Number of Students Unable to Eat Lunch.
 * */
class NumberOfStudentsUnableToEatLunch {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> queue = new ArrayDeque<>();

        for (int student : students) {
            queue.offer(student);
        }

        int i = 0;
        int currentStudent = 0;
        int count = 0;

        do {
            currentStudent = queue.poll();

            if (sandwiches[i] == currentStudent) {
                i++;
                count = 0;
            } else {
                queue.offer(currentStudent);
                count++;
            }
        } while (!queue.isEmpty() && count != queue.size());

        return queue.size();
    }
}