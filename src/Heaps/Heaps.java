package Heaps;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class Heaps {

    public static void main(String[] args) {
        int arr [] = {1,2,3,4,5,6};

        Heaps h =  new Heaps();

        System.out.println(h.findKthLargest(arr,3));

    }

    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> q = new PriorityQueue<>();
        int i = 0;
        while(q.size()<=k && i< nums.length){
            q.add(nums[i++]);
            if(q.size()>k){
                q.remove();
            }
        }
        check(q);

        return q.remove();
    }
    public void check(PriorityQueue<Integer>q){
        while(q.size() >=0){
            System.out.println(q.remove());
        }
    }
}