import java.util.*;

class YashOA {

    public static boolean ThreeSum(int[] arr) {
        int target = arr[0]; // The first element in the array
        Arrays.sort(arr, 1, arr.length); // Sort the array excluding the first element

        // Traverse through the array starting from index 1
        for (int i = 1; i < arr.length - 2; i++) {
            int left = i + 1;
            int right = arr.length - 1;

            // Use two pointers to find the remaining two numbers
            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];

                if (sum == target) {
                    return true; // Found the triplet that sums to the target
                } else if (sum < target) {
                    left++; // Move the left pointer to increase the sum
                } else {
                    right--; // Move the right pointer to decrease the sum
                }
            }
        }

        return false; // No triplet found
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] arr = Arrays.stream(s.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(ThreeSum(arr));
    }
}
