import java.util.*;

public class Graph {

    public static void main(String[] args) {
        int n = 10;
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(1);
        graph[0].add(2);
        graph[1].add(0);
        graph[1].add(2);
        graph[1].add(3);
        graph[2].add(0);
        graph[2].add(1);
        graph[2].add(4);
        graph[2].add(5);
        graph[2].add(6);
        graph[3].add(1);
        graph[3].add(4);
        graph[3].add(7);
        graph[4].add(2);
        graph[4].add(3);
        graph[4].add(5);
        graph[4].add(6);
        graph[4].add(7);
        graph[5].add(2);
        graph[5].add(4);
        graph[5].add(6);
        graph[6].add(2);
        graph[6].add(4);
        graph[6].add(5);
        graph[6].add(8);
        graph[6].add(9);
        graph[7].add(3);
        graph[7].add(4);
        graph[7].add(9);
        graph[8].add(6);
        graph[8].add(9);
     

        graph[9].add(8);

        boolean[] visited = new boolean[n];
        Graph traversal = new Graph();

        System.out.println("DFS traversal:");
        traversal.DFS(0, graph, visited);

        Arrays.fill(visited, false); // reset visited array

        System.out.println("\nBFS traversal:");
        traversal.BFS(0, graph, visited);
    }

    public void DFS(int start, List<Integer>[] graphs, boolean[] visited) {
        visited[start] = true;
        System.out.print(start + " ");
        for (int neighbor : graphs[start]) {
            if (!visited[neighbor]) {
                DFS(neighbor, graphs, visited);
            }
        }
    }
    
    public void BFS(int start, List<Integer>[] graphs, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.offer(start);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");
            for (int neighbor : graphs[node]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }
    }
}
