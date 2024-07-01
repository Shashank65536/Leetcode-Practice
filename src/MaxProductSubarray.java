import java.util.ArrayList;
import java.util.List;

public class MaxProductSubarray {


    public static void main(String args[]){
        MaxProductSubarray m = new MaxProductSubarray();
        List<Integer> products = new ArrayList<>();
        int [] arr = {2,3,-2,4};
        m.calculateProducts(arr,arr.length-1,arr.length - 1, 1, products);
        System.out.println(products);

    }

    public int maxProduct(int[] nums){
        return 0;
    }

    public  void calculateProducts(int[] arr, int start, int end, int product, List<Integer> products) {
        if (start < 0) {
            return;
        }

        // Calculate the product for the current subarray
        product *= arr[end];
        products.add(product);

        // If end reaches the start, move the start one step to the left and reset end to start
        if (end == 0) {
            calculateProducts(arr, start - 1, start - 1, 1, products);
        } else {
            // Move the end one step to the left
            calculateProducts(arr, start, end - 1, product, products);
        }
    }
}
