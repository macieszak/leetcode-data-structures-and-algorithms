package dsa.searching_algorithms;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearch {

    // BFS from given source s
    public static void bfs(List<List<Integer>> adj, int s, boolean[] visited) {

        // Create a queue for BFS
        Queue<Integer> q = new LinkedList<>();

        // Mark the source node as visited and
        // enqueue it
        visited[s] = true;
        q.offer(s);

        // Iterate over the queue
        while (!q.isEmpty()) {

            // Dequeue a vertex from queue and print it
            int curr = q.poll();
            System.out.print(curr + " ");

            // Get all adjacent vertices of the dequeued
            // vertex. If an adjacent has not been visited,
            // mark it visited and enqueue it
            for (int x : adj.get(curr)) {
                if (!visited[x]) {
                    visited[x] = true;
                    q.offer(x);
                }
            }
        }
    }

    public static void addEdge(List<List<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

}
