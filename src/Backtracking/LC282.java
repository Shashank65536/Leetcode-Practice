package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class LC282 {
    static List<List<Character>>res = new ArrayList<>();

    public void samplePermutations(String s,boolean[] arr,List<Character>list){

        for(int i = 0;i< s.length() ;i++){
            if(!arr[i]){
                System.out.println(s.charAt(i));
                list.add(s.charAt(i));
                arr[i] = true;
                samplePermutations(s,arr,list);
                list.remove(list.size()-1);
                arr[i]= false;
            }
        }
        res.add(new ArrayList<>(list));
    }


    public static void main(String[] args) {

        LC282 lc282 = new LC282();
        boolean arr[] = new boolean[3];
        List<Character> list = new ArrayList<>();
        lc282.samplePermutations("123",arr,list);
        System.out.println("");
    }

}
