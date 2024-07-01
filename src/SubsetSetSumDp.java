public class SubsetSetSumDp {
    public static void main(String args[]){

        int[] arr = {2,3,7,9,10};
        int sum  = 11;

        int[][]dp = new int[arr.length + 1][sum + 1];
        for (int i = 1; i <= arr.length; i++) {
            for (int j = 1; j <= sum; j++) {
                dp[i][j] = -1;
            }
        }
        int flag = isSubsetSumMemoization(arr,sum,arr.length,dp);

        boolean res = isSubsetSumRecursion(arr,sum,arr.length,false);
        System.out.println(flag);

        isSubSetSumDP(arr,sum);


    }
    public static int isSubsetSumMemoization(int[] arr, int sum, int index,int [][]dp) {
//        System.out.println(sum + " " + index + " "+ flag);
        if (sum == 0) return 1;
        if (index == 0 || sum < 0) return 0;
        if(dp[index][sum] != -1){
            return dp[index][sum];
        }


        if (isSubsetSumMemoization(arr, sum - arr[index-1], index-1,dp) == 1 || isSubsetSumMemoization(arr, sum, index-1,dp) ==1){
            return dp[index-1][sum] = 1;
        }
        return dp[index-1][sum] = 0;
    }


    public static boolean isSubsetSumRecursion(int[] arr, int sum, int index,boolean flag) {
        System.out.println(sum + " " + index + " "+ flag);
        if (sum == 0) return true;
        if (index == 0 || sum < 0) return false;

        return isSubsetSumRecursion(arr, sum - arr[index-1], index-1,true) || isSubsetSumRecursion(arr, sum, index-1,false);
    }

    public static  void isSubSetSumDP(int[] arr, int sum){

        int dp[][] = new int[arr.length+1][sum+1];

        for (int i = 0; i <= arr.length; i++) {
            for (int j = 0; j <= sum; j++) {
                dp[i][j] = -1;
            }
        }

        for(int j = 0;j<= arr.length;j++){
            dp[j][0] = 1;
        }
        for(int j = 1;j<= sum;j++){
            dp[0][j] = 0;
        }

        for (int i = 1; i <= arr.length; i++) {
            for (int j = 1; j <= sum; j++) {
                if(j-arr[i-1] > 0){
                    dp[i][j] = Math.max(dp[i-1][j-arr[i-1]],dp[i-1 ][j]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }

            }
        }

        System.out.println("array isSubset - " + dp[arr.length][sum]);


    }




}
