package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    public static void main(String[] args) {
        String s = "cdd";
        PalindromePartitioning p = new PalindromePartitioning();
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();
        List<List<String>> result = new ArrayList<>();
        List<List<String>> res = p.helper2(s,0,sb,list,result);
        System.out.println(res);

    }

//    public List<List<String>> helper(String s, int pivot, StringBuilder pathString, List<String>res,List<List<String>> finalPath){
//
//        boolean f = checkPalindrome(pathString,0,0);
//        if(f){
//            if (!pathString.isEmpty()){
//                res.add(new StringBuilder(pathString).toString());
//                pathString = new StringBuilder();
//
//            }
//
//        };
//        if(pivot == s.length()){
//            if(!res.isEmpty() &&!res.get(0).isEmpty()){
//                finalPath.add(new ArrayList<>(res));
//                res.clear();
//                pathString = new StringBuilder();
//            }
//
//            return finalPath;
//        }
//        for(int i = pivot;i< s.length();i++){
//            pathString.append(s.charAt(i));
//            helper(s,i+1,pathString,res,finalPath);
////            pathString.deleteCharAt(pathString.length()-1);
//
//        }
//        return finalPath;
//
//    }
//
//    public List<List<String>> helper1(String s, int pivot, StringBuilder pathString, List<String> res, List<List<String>> finalPath) {
//        boolean f = checkPalindrome(pathString,0,0);
//        if (f) {
//            res.add(new StringBuilder(pathString).toString());
//            pathString.setLength(0);  // Clear the StringBuilder to reuse it
//        }
//        if (pivot == s.length()) {
//            finalPath.add(new ArrayList<>(res));
//            res.clear();  // Clear res for the next path
//            return finalPath;
//        }
//        for (int i = pivot; i < s.length(); i++) {
//            pathString.append(s.charAt(i));
//            helper1(s, i + 1, pathString, res, finalPath);
//            pathString.setLength(pathString.length() - 1);  // Backtrack by removing the last character added
//        }
//        return finalPath;
//    }

    public List<List<String>> helper2(String s, int pivot, StringBuilder pathString, List<String> res, List<List<String>> finalPath) {


        if (pivot == s.length()) {
            finalPath.add(new ArrayList<>(res));
//            res.clear();  // Clear res for the next path
            res = new ArrayList<>();
            return finalPath;
        }
        for (int i = pivot; i < s.length(); i++) {
            if(checkPalindrome(s, pivot, i)){
//                pathString.append(s.substring(pivot,i+1));
                res.add(s.substring(pivot,i+1));
                helper2(s, i + 1, pathString, res, finalPath);
                res.remove(res.size()-1);
//                pathString.setLength(pathString.length() - 1);
            }
        }
        return finalPath;
    }


    public boolean checkPalindrome(String s, int start, int end){

        if(s.isEmpty())return false;

        while(start <= end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }


}
