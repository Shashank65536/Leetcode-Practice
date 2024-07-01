public class MissingNumber {

    public int missingNumber(int[] nums) {
        int x = nums.length + 1;
        x = x * -1;

        for(int i =0;i< nums.length;i++){
            int t = nums[i] == x ? 0 : Math.abs(nums[i]);
            if(t > 0){
                if(nums[t-1] == 0  ){
                    nums[t-1] = x;
                }else{
                    nums[t-1]  *= -1;
                }

            }
        }



        int index = -1;
        for(int i = 0 ;i<nums.length;i++){

            if(nums[i]>=0){
                index = i;
                break;
            }
        }
        return ++index;

    }

    public static void main(String[] args) {
        MissingNumber m  = new MissingNumber();
        int arr[] = {3,0,1};
        int x  =m.missingNumber(arr);
        System.out.println(x);
    }
}
