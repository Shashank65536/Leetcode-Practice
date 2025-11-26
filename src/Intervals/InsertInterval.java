package Intervals;

import java.util.*;

public class InsertInterval {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;
        int n = intervals.length;

        // Step 1: Add all intervals that end before newInterval starts
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // Step 2: Merge overlapping intervals
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval); // Add the merged interval

        // Step 3: Add remaining intervals
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        // Convert result list to array
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        // Example 1
        int[][] intervals1 = { {1, 3}, {6, 9} };
        int[] newInterval1 = {2, 5};
        System.out.println("Input: " + Arrays.deepToString(intervals1) + ", New Interval: " + Arrays.toString(newInterval1));
        int[][] result1 = insert(intervals1, newInterval1);
        System.out.println("Output: " + Arrays.deepToString(result1));

        // Example 2
        int[][] intervals2 = { {1,2}, {3,5}, {6,7}, {8,10}, {12,16} };
        int[] newInterval2 = {4, 8};
        System.out.println("\nInput: " + Arrays.deepToString(intervals2) + ", New Interval: " + Arrays.toString(newInterval2));
        int[][] result2 = insert(intervals2, newInterval2);
        System.out.println("Output: " + Arrays.deepToString(result2));
    }
}
