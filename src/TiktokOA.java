import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TiktokOA {

        public static int findMinDiscards(int[] videoRatings) {
            int n = videoRatings.length;

            // Step 1: Find the LIS using binary search
            List<Integer> lis = new ArrayList<>();

            for (int rating : videoRatings) {
                int pos = Collections.binarySearch(lis, rating);
                if (pos < 0) pos = -(pos + 1); // If not found, find insertion point
                if (pos == lis.size()) {
                    lis.add(rating); // Extend LIS
                } else {
                    lis.set(pos, rating); // Replace to maintain LIS property
                }
            }

            // Length of LIS
            int lisLength = lis.size();

            // Step 2: Check coherence
            int minRemovals = n - lisLength;

            // If coherence can be achieved by removing only one element
            return minRemovals > 1 ? minRemovals - 1 : minRemovals;
        }

        public static void main(String[] args) {
//            int[] videoRatings = {2, 3, 7, 5, 4, 10};
            int[] videoRatings = {1, 10,4,5,3};
            System.out.println(findMinDiscards(videoRatings)); // Output: 1
        }
    }


