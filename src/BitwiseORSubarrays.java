import java.util.PriorityQueue;
import java.util.Stack;
import java.util.TreeSet;

public class BitwiseORSubarrays {

    public static int bitwiseOrSubarrays(int[] arr, int k) {
        int n = arr.length;
        int result = 0;

        // Stack to store the OR value of each subarray.
        Stack<Integer> stack = new Stack<>();
        TreeSet<Integer> res = new TreeSet<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // Iterate through the array.
        for (int i = 0; i < n; i++) {
            // Compute the OR value for all subarrays ending at the current element.
            int orResult = 0;

            // Push the current element and the OR of previous subarrays into the stack.
            while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                orResult |= stack.pop();
            }

            // Update the OR value by including the current element.
            orResult |= arr[i];
            pq.add(orResult);

            if(pq.size() >k){
                pq.poll();
            }
            // Add the result to the final OR.
            result |= orResult;

            // Push the OR value of this subarray to the stack.
            stack.push(orResult);
        }

        return pq.peek();
    }

    public static void main(String[] args) {
        // Test case
        int[] arr = {3,2,7,1};
        int result = bitwiseOrSubarrays(arr,5);
        System.out.println("Bitwise OR of all subarrays: " + result);

        int[] arr1 = {4,1,3,2};
        int result1 = bitwiseOrSubarrays(arr,2);
        System.out.println("Bitwise OR of all subarrays: " + result);
    }
}
