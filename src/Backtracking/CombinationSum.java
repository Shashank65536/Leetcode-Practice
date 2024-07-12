package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {



        public List<List<Integer>> combinationSum(int[] candidates, int target) {

            List<List<Integer>> res = new ArrayList<>();
            List<Integer> path =  new ArrayList<>();
            helper1(candidates, 0, target, path,res);
            return res;

        }

        public void helper(int[] candidates, int idx, int target, List<Integer> path, List<List<Integer>> res){
//            Complexity is 2 ^ m+n where m = target and n  = len of candidates
            if(target == 0){
                res.add(path);
                path = new ArrayList<>();
                return;
            }
            if(target < 0 || idx == candidates.length)return;

            helper(candidates, idx + 1, target,new ArrayList<>(path),res);
            path.add(candidates[idx]);
            helper(candidates,idx, target - candidates[idx], new ArrayList<>(path),res);



        }


    public void helper1(int[] candidates, int idx, int target, List<Integer> path, List<List<Integer>> res){
        if(target == 0){
            List<Integer> result = new ArrayList<>(path);
            res.add(result);
            path = new ArrayList<>();
            return;
        }
        if(target < 0 || idx == candidates.length)return;

        helper1(candidates, idx + 1, target,path,res);
        path.add(candidates[idx]);
        helper1(candidates,idx, target - candidates[idx], path,res);
        path.remove(path.size()-1);

    }

//    for loop based recursion.
    public void helper2(int[] candidates, int pivot, int target, List<Integer> path, List<List<Integer>> res){

        if(target == 0){
            List<Integer> result = new ArrayList<>(path);
            res.add(result);
            path = new ArrayList<>();
            return;
        }
        for(int i = pivot;i< candidates.length;i++){
            path.add(candidates[i]);
            helper2(candidates,i, target - candidates[i],path,res);

            helper2(candidates,i, target,path, res);
            path.remove(path.size()-1);
        }

    }

    public static void main(String[] args) {
        int [] arr ={2,3,5};
        CombinationSum c = new CombinationSum();
        List<List<Integer>> x = c.combinationSum(arr,8);
    }

}
