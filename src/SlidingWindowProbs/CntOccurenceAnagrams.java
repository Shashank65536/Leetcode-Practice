package SlidingWindowProbs;

import java.util.*;

public class CntOccurenceAnagrams {

    Deque dq = new LinkedList();
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Set<Character> set = new HashSet<>();
        int maxLen = 0; int j = 0; int i = 0;
        while(j< s.length()){
            set.add(s.charAt(j));
            if(set.size() < k){
               j++;
            }else if(set.size() == k){
                while(j<s.length()){
                    if(set.contains(s.charAt(j))){
                        j++;
                        // set.remove(s.charAt(i));
                    }else{break;}
                }
                int index = j-1;
                maxLen = index - i +1;
                i = j;
                set = new HashSet<>();
            }

        }

        return maxLen;
    }
    public static void main(String[] args) {
        CntOccurenceAnagrams cntOccurenceAnagrams = new CntOccurenceAnagrams();

//        System.out.println(cntOccurenceAnagrams.lengthOfLongestSubstringKDistinct("eceba",2));

        LinkedList<Integer> ll = new LinkedList<>();
        PriorityQueue pq = new PriorityQueue<>((Integer a,Integer b) ->   b-a);




    }
}
