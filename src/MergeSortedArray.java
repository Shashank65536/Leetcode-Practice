public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int index = m + n - 1;

        int x = m-1,y = n-1;
        System.out.print("hell");
        while(y>=0){
            if(nums1[y] >= nums2[y]){
                System.out.println(nums1[y]);
                nums1[index--] = nums1[y--];
            }else{
                nums1[index--] = nums2[y--];
            }
        }

    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int [] nums2 = {2,5,6};

        MergeSortedArray mergeSortedArray = new MergeSortedArray();
        mergeSortedArray.merge(nums1,3,nums2,3);
    }
}
