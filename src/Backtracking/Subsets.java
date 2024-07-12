package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public static void main(String[] args) {
        int arr[] = {1,2,3};

        Subsets s = new Subsets();
        List<Integer>path = new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
//        list = s.tryRecurse(arr, 0,path, list);
        list = s.forLoopRecursion(arr, 0,path, list);
        System.out.println(list);

    }

    public List<List<Integer>> tryRecurse(int arr[], int index, List<Integer>path,List<List<Integer>> res ){

        if(index == arr.length){
            res.add(new ArrayList<>(path));
            path = new ArrayList<>();
            return res;
        };
        path.add(arr[index]);
        tryRecurse(arr, index +1,path,res);
        path.remove(path.size()-1);
        tryRecurse(arr, index+1,path,res);
        return res;

//        tryRecurse(arr,index,);
    }

    public List<List<Integer>> forLoopRecursion(int arr[], int index, List<Integer> path,List<List<Integer>> res){

        res.add(new ArrayList<>(path));
        //base condition
        if(index == arr.length){

            return res;
        }


        //recursion logic

        for(int i = index;i< arr.length;i++){
            path.add(arr[i]);
            forLoopRecursion(arr,i+1,path,res);
            path.remove(path.size()-1);

        }
        return res;
    }
}
