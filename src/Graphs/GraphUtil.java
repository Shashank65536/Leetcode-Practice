package Graphs;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Stack;

public class GraphUtil {
    private int V; // Number of vertices
    private LinkedList<Integer>[] adj; // Adjacency lists

    // Constructor
    public GraphUtil(int V) {
        this.V = V;
        adj = new LinkedList[V];
        for (int i = 0; i < V; ++i)
            adj[i] = new LinkedList<>();
    }

    // Method to add an edge into the graph
    public void addEdge(int v, int w) {
        adj[v].add(w); // For directed graph
         adj[w].add(v); // Uncomment for undirected graph
    }

    // BFS traversal from a given source s
    public void BFS(int s) {
        boolean[] visited = new boolean[V];
        LinkedList<Integer> queue = new LinkedList<>();


        visited[s] = true;
        queue.add(s);

        while (!queue.isEmpty()) {
            s = queue.poll();

            for (int n : adj[s]) {
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    // DFS traversal from a given source v
    public void DFSUtil(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");

        for (int n : adj[v]) {
            if (!visited[n]) {
                DFSUtil(n, visited);
            }
        }
    }

    public void DFSStack(int source){
        boolean visited[] = new boolean[V];

        Stack<Integer> stack = new Stack<>();

        stack.push(source);
        visited[source] = true;
        while(!stack.isEmpty()){
            int x = stack.pop();

            ListIterator<Integer> listIterator = adj[x].listIterator(0);
            while(listIterator.hasNext()){
                int next = listIterator.next();
                if(!visited[next]){
                    visited[x] = true;
                    stack.push(next);
                }

            }

        }


    }

    public void DFS(int v) {
        boolean[] visited = new boolean[V];
        DFSUtil(v, visited);
    }

    public static void main(String[] args) {
            GraphUtil graph = new GraphUtil(5);
            graph.addEdge(0, 1);
            graph.addEdge(0, 4);
            graph.addEdge(1, 2);
            graph.addEdge(1, 3);
            graph.addEdge(1, 4);
            graph.addEdge(2, 3);
            graph.addEdge(3, 4);

        graph.DFSStack(3);
        for(int i =0 ;i< 7;i++){
            for(int x: graph.adj[i]){
                System.out.println(x);
            }
        }
    }
}


