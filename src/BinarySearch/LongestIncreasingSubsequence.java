package BinarySearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        List<Integer> sub = new ArrayList<>();
        for (int num : nums) {
            int pos = Collections.binarySearch(sub, num);
            if (pos < 0) {
                pos = -(pos + 1);  // Convert to insertion point if not found
            }
            if (pos == sub.size()) {
                // If num is greater than all elements, extend the subsequence
                sub.add(num);
            } else {
                // Replace the element to maintain the smallest possible values
                sub.set(pos, num);
            }
        }
        return sub.size();  // Length of the longest increasing subsequence
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println("Length of LIS: " + lis.lengthOfLIS(nums));  // Output: 4
    }
}
