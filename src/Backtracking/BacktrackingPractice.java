package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class BacktrackingPractice {

    public static void main(String[] args) {
        int []arr = {1,2,3};
        List<Integer> path = new ArrayList<>();
        new BacktrackingPractice().backtrack(arr,0,path);
    }

    public void backtrack(int[] arr,int index,List<Integer>path){

        if(index == arr.length) {
            for(int x:path){
                System.out.print( x + " ");
            }
            System.out.println();
        }
        path.add(index);
        backtrack(arr,index + 1,path);
        path.remove(path.size()-1);
        backtrack(arr,index + 1,path);


    }

}
