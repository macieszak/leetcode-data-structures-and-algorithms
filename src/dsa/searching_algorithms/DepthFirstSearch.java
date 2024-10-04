package dsa.searching_algorithms;

import java.util.List;

public class DepthFirstSearch {

    // Function to add an edge to the adjacency list
    public static void addEdgeDFS(List<List<Integer>> adj,
                                  int s, int t){
        // Add edge from vertex s to t
        adj.get(s).add(t);
        // Due to undirected Graph
        adj.get(t).add(s);
    }

    // Recursive function for DFS traversal
    static void DFSRec(List<List<Integer> > adj,
                       boolean[] visited, int s){
        // Mark the current vertex as visited
        visited[s] = true;

        // Print the current vertex
        System.out.print(s + " ");

        // Recursively visit all adjacent vertices that are
        // not visited yet
        for (int i : adj.get(s)) {
            if (!visited[i]) {
                DFSRec(adj, visited, i);
            }
        }
    }

    // Main DFS function that initializes the visited array
    public static void DFS(List<List<Integer>> adj, int s) {
        boolean[] visited = new boolean[adj.size()];
        // Call the recursive DFS function
        DFSRec(adj, visited, s);
    }

}
