public class AllPossibleSubArrays {

    int arr[] = {1,1,1,1};
    static int c = 0;
    boolean minFlag = false, maxFlag = false;
    int minK = 1;
    int maxK = 1;
    public void allSubArrays(){


        for(int i = 0;i<arr.length;i++){
            for(int j = i;j<arr.length;j++){
                printArr(i,j);
            }
        }

    }
    public void printArr(int i , int j){
        for(int k  = i;k<=j;k++){
            if(arr[k] == minK) minFlag = true;
            if(arr[k] == maxK)  maxFlag = true;
            if(arr[k] < minK || arr[k] > maxK) {
                minFlag = false;
                maxFlag = false;
                break;
            }
        }
        if(minFlag && maxFlag) c++;
        minFlag = false;
        maxFlag = false;
    }
    public static void main(String args[]){
        AllPossibleSubArrays a = new AllPossibleSubArrays();
        a.allSubArrays();
        System.out.println(c);

    }
}
