public class DuplicateElementInarray {

    public int findDuplicate() {
        int nums[] = {1,3,4,2,2};
        for(int i=0;i<nums.length;i++) {
            int ind = Math.abs(nums[i]);
            if(nums[ind] < 0) {
                return ind;
            }
            nums[ind] = -nums[ind];
        }
        return -1;
    }
        public int findDuplicateXOR() {
            int nums[] = {1, 3, 4, 2, 2};
            int xor = 0;
            int duplicate = 0;

            // XOR all the array elements
            for (int num : nums) {
                xor ^= num;
            }

            // XOR with all numbers from 1 to nums.length-1 (since there are nums.length elements)
            for (int i = 1; i < nums.length; i++) {
                xor ^= i;
            }

            // After this, xor contains the duplicate number because every number except the duplicate
            // has been XORed twice (once in the array, once in the loop) and thus cancelled out.
            duplicate = xor;

            return duplicate;
        }




    public static void main(String args[]){
        DuplicateElementInarray d= new DuplicateElementInarray();
        d.findDuplicate();
        d.findDuplicateXOR();
    }
}
