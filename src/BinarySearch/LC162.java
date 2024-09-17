package BinarySearch;

public class LC162 {

    //obvious approach is  to iterate and check previeous nd next index .
    //second appraoch is to find local maximum.
    //for log n require bin search.

//    for bin search
//    1. array sorted.
//    2. eliminate one half

    public int[] searchRange(int[] nums, int target) {

        int low = 0;

        int high = nums.length-1;
        int ans[]  = new int[2];
        boolean findFlag = false;
        while(low <= high){

            int mid = low + ((high - low)/2);

            if(nums[mid] == target){
                if(mid-1>=0 && nums[mid-1] < target){
                    ans[0] =  mid;
                    findFlag = true;
                    break;
                }else{
                    high = mid-1;
                }
            }else if(nums[mid] < target){
                low = mid + 1;
            }else{
                high  = mid -1;
            }
        }
        if (!findFlag){
            ans[0] = -1;
        }
        findFlag = false;

        while(low <= high){

            int mid = low + ((high - low)/2);

            if(nums[mid] == target){
                if(mid + 1 < nums.length && nums[mid+1] > target){
                    ans[1] =  mid;
                    findFlag = true;
                    break;
                }else{
                    low = mid+1;
                }
            }else if(nums[mid] < target){
                low = mid + 1;
            }else{
                high  = mid -1;
            }
        }
        if (!findFlag){
            ans[1] = -1;
        }
        return ans;
    }
    public static void main(String[] args) {
        LC162 solution = new LC162();

        // Test case: Target exists in the array
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] result = solution.searchRange(nums, target);

        // Print the result
        System.out.println("Output: [" + result[0] + ", " + result[1] + "]");
    }
}

