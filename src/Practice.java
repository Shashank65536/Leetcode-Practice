import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Practice {

    public void firstNonRepeatingChar(){


        String s = "shashank";

        System.out.println(s.charAt(0) - 'a');
    }

    public void longestConsecutiveSeq(){

        int nums[] = {1,2,0,1};

        int count = 1, maxCount = 1;
        Arrays.sort(nums);

        for(int i = 0;i< nums.length-1;i++){
            if(nums[i+1] == nums[i] + 1  ){
                count++;
            }else{

                if(maxCount < count)
                    maxCount = count;
                count  = 1;
            }
        }
        System.out.println(Math.max(count,maxCount));
    }

    public void longestConsecutiveSeq1(){
        int maxSeq = 0;
        int nums[] = {100,2,1,201,200,0,3,4};
        Set<Integer> sequences = new HashSet<>();

        for (int num : nums) {
            sequences.add(num);
        }
        for (int num : nums) {
            int nextInSeq = num + 1;
            int prevInSeq = num - 1;
            int currentSequence = 1;
            while (sequences.remove(prevInSeq--)) {
                currentSequence++;
            }
            while (sequences.remove(nextInSeq++)) {
                currentSequence++;
            }
            if (currentSequence > maxSeq) {
                maxSeq = currentSequence;
            }
        }
        System.out.println(maxSeq);
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int l = m-1;
        int j = n-1;
        int k = n-1;

        while(l >= 0 && j>=0 && k>=0){

            if(nums2[j] > nums1[k]){
                nums1[l] = nums2[j];
                j--;
            }else{
                nums1[l] = nums1[k];
                k--;
            }
            l--;
        }

        while(j>=0 && l>=0){
            nums1[l] = nums2[j];
            j--;

        }
        while(k>=0 && l>=0){
            nums1[l] = nums2[k];
            k--;
        }

    }

    public int majorityElement(int[] nums) {

        int candidate = 0,count  =0;

        for(int i=0;i<nums.length;i++){
            if(count == 0){
                candidate = nums[i];
                count++;
            }
            if(candidate != nums[i]){
                count--;
            }else{
                count++;
            }
        }
        return candidate;

    }

    public int[] productExceptSelf() {
        int[] nums = {1,2,3,4};
        int[] res = new int[nums.length];
        int prefix = 1;
        for(int i=0; i<nums.length;i++){
            res[i] = prefix;
            prefix *= nums[i];
        }
        int postfix = 1;
        for(int j=nums.length-1; j>=0;j--){
            res[j]*=postfix;
            postfix*=nums[j];
        }
        return res;
    }

    public static void main(String args[]){
        Practice p = new Practice();
        p.productExceptSelf();
//        p.firstNonRepeatingChar();
//        p.longestConsecutiveSeq1();

//        int nums1[] = {2,0};
//        int nums2[] = {1};
//
//        p.merge(nums1,2,nums2,1);

        int nums[] = {6,5,5};
        p.majorityElement(nums);
    }
}
