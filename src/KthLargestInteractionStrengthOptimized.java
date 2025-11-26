import java.util.*;

public class KthLargestInteractionStrengthOptimized {

    public static int findKthInteractionStrength(int[] engagementScores, int k) {
        int n = engagementScores.length;

        // Max heap to store the top k largest unique OR values
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        TreeSet<Integer> uniqueResults = new TreeSet<>();

        // Perform simple OR operations on all subarrays
        for (int i = 0; i < n; i++) {
            int currentOR = 0;
            for (int j = i; j < n; j++) {
                currentOR |= engagementScores[j]; // Compute cumulative OR
                uniqueResults.add(currentOR);

                // Add to the set to ensure uniqueness
//                if (uniqueResults.add(currentOR)) {
//                    minHeap.add(currentOR);
//
//                    // If the heap exceeds size k, remove the smallest element
//                    if (minHeap.size() > k) {
//                        minHeap.poll();
//                    }
//                }
            }
        }

        // Return the kth largest value
        return k>uniqueResults.size() ? (int)uniqueResults.toArray()[uniqueResults.size()-1]:(int)uniqueResults.toArray()[uniqueResults.size()-k];
//        return 0;
    }

    public static void main(String[] args) {
//        // Example 1
        int[] engagementScores1 = {3, 2, 7, 1};
        int k1 = 5;
        System.out.println(findKthInteractionStrength(engagementScores1, k1)); // Output: 7

//         Example 2
        int[] engagementScores2 = {4, 1, 3, 2};
        int k2 = 2;
        System.out.println(findKthInteractionStrength(engagementScores2, k2)); // Output: 5
    }
}
