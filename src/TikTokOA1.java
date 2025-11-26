import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class TikTokOA1 {

    public static int findKthInteractionStrength(int[] engagementScores, int k) {
        int n = engagementScores.length;

        // Priority queue to store the k-largest elements
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // Use a set to store unique interaction strengths
        Set<Integer> uniqueResults = new HashSet<>();

        // Iterate over all possible starting points
        for (int i = 0; i < n; i++) {
            int currentOR = 0; // Reset OR for every new subarray
            for (int j = i; j < n; j++) {
                // Compute cumulative OR
                currentOR |= engagementScores[j];

                // Add to the set and maxHeap only if it's a new value
                if (uniqueResults.add(currentOR)) {
                    maxHeap.add(currentOR);
                    // Keep the heap size within k
                    if (maxHeap.size() > k) {
                        maxHeap.poll();
                    }
                }
            }
        }

        // Return the k-th largest element
        return maxHeap.peek();
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] engagementScores1 = {3, 2, 7, 1};
        int k1 = 5;
        System.out.println(findKthInteractionStrength(engagementScores1, k1)); // Output: 7

        // Test Case 2
        int[] engagementScores2 = {4, 1, 3, 2};
        int k2 = 2;
        System.out.println(findKthInteractionStrength(engagementScores2, k2)); // Output: 5

        int[] engagementScores3 = {5, 1, 2, 4,3};
        int k3 = 10;
        System.out.println(findKthInteractionStrength(engagementScores2, k2)); // Output: 5
    }
}
