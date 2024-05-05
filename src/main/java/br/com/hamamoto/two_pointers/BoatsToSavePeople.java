package br.com.hamamoto.two_pointers;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/boats-to-save-people> LeetCode problem </a>
 * - Boats to Save People
 */
public class BoatsToSavePeople {

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        var left = 0;
        var right = people.length - 1;
        var boats = 0;

        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                left++;
            }

            right--;
            boats++;
        }

        return boats;
    }

}
