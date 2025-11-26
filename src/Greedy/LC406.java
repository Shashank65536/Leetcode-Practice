package Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class LC406 {


    public int[][] reconstructQueue(int[][] people) {

        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);

        PriorityQueue<int[]> heap =  new PriorityQueue<>((a, b)-> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);

        List<int []> result = new ArrayList<>();

        for(int [] p : people){

            result.add(p[1], p);

        }



        return result.toArray(new int [0][]);

    }
    public int[][] reconstructQueue1(int[][] people) {

        PriorityQueue<int[]> heap =  new PriorityQueue<>((a,b)-> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);

        for(int[]p:people){
            heap.add(p);
        }

        List<int[]>res = new ArrayList<>();
        List<int[]>res1 = new ArrayList<>();
        while(!heap.isEmpty()){
            int[] x = heap.poll();
            res.add(x);
            res1.add(x[1],x);
        }

        return res.toArray(new int [people.length][2]);




    }

    public static void main(String[] args) {

        LC406 obj = new LC406();
        int[][] people = {
                {7, 0},
                {4, 4},
                {7, 1},
                {5, 0},
                {6, 1},
                {5, 2}
        };

        obj.reconstructQueue1(people);
    }
}
