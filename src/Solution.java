/*
import java.util.*;

public class Solution {
    class task{
        int count;
        int nextAvail;
        public task(){
        }
    }
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for(var ele : tasks){
            hm.put(ele, hm.getOrDefault(ele, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(var ele : hm.values()){
            pq.add(ele);
        }

        Queue<task> q = new ArrayDeque<>();
        int time = 0;
        while(!pq.isEmpty() || !q.isEmpty()){
            time++;
            if(!pq.isEmpty()){
                task point = new task();
                point.count = pq.remove() - 1;
                point.nextAvail = time + n;
                if(point.count != 0) q.add(point);
            }
            if(!q.isEmpty() && q.peek().nextAvail == time){
                pq.add(q.remove().count);
            }
        }

        return time;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 3;
        int leastTime = solution.leastInterval(tasks, n);
        System.out.println("The least number of intervals needed to finish all tasks is: " + leastTime);
    }
}
*/
class Solution {

    static int c = 0;
    boolean minFlag = false, maxFlag = false;
    int minK=0,maxK = 0;
    public long countSubarrays(int[] nums, int minK, int maxK) {
        this.minK = minK;
        this.maxK = maxK;
        for(int i = 0;i<nums.length;i++){
            for(int j = i;j<nums.length;j++){
                printArr(i,j,nums);
            }
        }
        System.out.println(c);
        return c;

    }
    public void printArr(int i , int j, int[] arr){
        for(int k  = i;k<=j;k++){
            if(arr[k] == minK) minFlag = true;
            if(arr[k] == maxK)  maxFlag = true;
            if(arr[k] < minK || arr[k] > maxK) {
                minFlag = false;
                maxFlag = false;
                break;
            }
        }
        if(minFlag && maxFlag) c++;
        minFlag = false;
        maxFlag = false;
    }
    public static void main(String[] args) {
//        Solution solution = new Solution();
//        int nums[] = {1,1,1,1};
//        int minK = 1;
//        int maxK = 1;
//        solution.countSubarrays(nums,minK,maxK);
        String res = "";
        System.out.println(res + (char) ('a' + 1));
    }
}
