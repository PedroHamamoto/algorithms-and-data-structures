package br.com.hamamoto.arrays;

/**
 *<a href="https://leetcode.com/problems/number-of-students-unable-to-eat-lunch/"> LeetCode problem </a>
 * - Number of Students Unable to Eat Lunch
 * */
public class NumberOfStudentsUnableToEatLunch {

    public int countStudents(int[] students, int[] sandwiches) {
        int[] studentsSum = new int[2];

        for (int s: students) {
            studentsSum[s]++;
        }

        for (int i = 0; i < sandwiches.length; i++) {
            int s = sandwiches[i];

            if (studentsSum[s] > 0) {
                studentsSum[s]--;
            } else {
                return sandwiches.length - i;
            }
        }

        return 0;
    }

}
