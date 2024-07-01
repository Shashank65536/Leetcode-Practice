public class MatrixTraversal {



    public static void main(String args[]){

//        int[][] arr = {
//                {0, 1, 0},
//                {0, 0, 1},
//                {1, 1, 1},
//                {0, 0, 0}
//        };
//
//        MatrixTraversal m = new MatrixTraversal();
//        m.traverseArray(arr);
//        for(int i = 0;i< arr.length;i++){
//            for(int j =0;j<arr[0].length;j++){
//
//                System.out.print(arr[i][j] + " ");
//            }
//            System.out.println( );
//        }

        int[][] arr = {
                {9, 6},
                {3, 0}
        };
        MatrixTraversal m = new MatrixTraversal();
        m.imageColor(arr);

    }
    public void traverseArray(int[][] arr){

        int[][]dir = {
                {0,1},
                {0,-1},
                {-1,0},
                {1,0},
                {-1,1},
                {-1,-1},
                {1,-1},
                {1,1}
        };
//        System.out.println(dir[6][1]);

        int m = arr.length;
        int n = arr[0].length;
        for(int i = 0;i< arr.length;i++){
            int count = 0;
            for(int j =0;j<arr[0].length;j++){
                for(int[]d:dir){
                    int r = i + d[0];
                    int c  = j + d[1];
                    if((r >= 0 && r<m) && (c >= 0 && c<n)){
                        if(arr[r][c] == 1 || arr[r][c] == 2) {
                            count++;
                        }
                    }
                }
                if((count < 2 || count >3) &&arr[i][j] == 1){
                    arr[i][j]=2;
                }else if(count > 3){
                    arr[i][j]  = 0;
                }else if(count == 3 && arr[i][j] == 0){
                    arr[i][j] = 3;
                }
                System.out.println(count);
                count = 0;
            }
        }
    }


    public void imageColor(int[][] arr){

        int[][] dir = {
                {0, 1},
                {0, -1},
                {-1, 0},
                {1, 0},
                {-1, 1},
                {-1, -1},
                {1, -1},
                {1, 1}
        };
        int[][] t = new int[arr.length][arr[0].length];

        int m = arr.length;
        int n = arr[0].length;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                int count = 0;
                int sum = 0;
                for (int[] d : dir) {
                    int r = i + d[0];
                    int c = j + d[1];
                    if ((r >= 0 && r < m) && (c >= 0 && c < n)) {
                        count++;
                        sum += arr[r][c];
                    }
                }
                int avg = (count == 0) ? 0 : sum / count;  // To handle division by zero
                t[i][j] = (arr[i][j] + avg) / 2;
            }
        }
        // Optional: To copy the result back to the original array
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = t[i][j];
            }
        }
    }



}