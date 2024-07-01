import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangle {


    public List<List<Integer>> generate(int numRows) {

        int[][] arr = new int[numRows][numRows];
        List<List<Integer>> res = new ArrayList<>();
        arr[0][0] = 1;

        for(int i = 1;i < numRows; i++){
            for(int j = 0;j<i+1;j++){
                if(j == 0 || j == i){
                    arr[i][j] = 1;
                }else{
                    arr[i][j] = arr[i-1][j] + arr[i-1][j-1];
                }

            }
        }

//        System.out.println(arr[0]);
        for(int i = 0;i< numRows;i++){
            List<Integer>temp = new ArrayList<>();
            for(int j = 0;j<i+1;j++){
                temp.add(arr[i][j]);
            }
            res.add(temp);

        }
        System.out.println(res);

        return null;
    }
}
