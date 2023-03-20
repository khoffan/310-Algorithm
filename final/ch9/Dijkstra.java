
// Dijkstra.java
// Andrew Davison, ad@fivedots.coe.psu.ac.th, Dec. 2020

/* Dijkstra's SSSP Algorithm using a Priority Queue 

   Usage:
      > java Dijkstra adjs1.txt
      > java Dijkstra adjs2.txt
      > java Dijkstra adjs3.txt
*/

import java.io.*;
import java.util.*;

public class Dijkstra {
    private static final int INF = 1000000000;
    // use 10^9 to avoid overflow

    private static ArrayList<ArrayList<AdjNode>> adjList;

    private static int[] parent;
    // e.g. parent[i] == v
    // means that node v points to node i in the SPT

    private static int distTo[];
    // e.g. distTo[i] == d
    // means that distance to this i node
    // from the start node == d

    public static void main(String args[]) {
        if (args.length != 1) {
            System.out.println("Usage: java Dijkstra <data-file>");
            return;
        }
        adjList = build(args[0]);
        print(adjList);

        int startNode = 0; // we always start at node 0

        // initialize parent[]
        parent = new int[adjList.size()];
        for (int i = 0; i < parent.length; i++)
            parent[i] = -1; // -1 means "no parent"

        // Initialize distances as 'infinite' except for the start node
        distTo = new int[adjList.size()];
        for (int i = 0; i < distTo.length; i++)
            distTo[i] = INF;
        distTo[startNode] = 0; // distance to the start node is 0

        dijkstra(startNode);

        System.out.println("\nParents:");
        for (int i = 0; i < parent.length; i++)
            System.out.println("  " + i + ": " + parent[i]);

        System.out.println("\nShortest dists from " + startNode + ":");
        for (int i = 0; i < distTo.length; i++)
            System.out.println("  to " + i + " == " + distTo[i]);
    } // end of main()

    private static void dijkstra(int start) {
        boolean[] isProcessed = new boolean[adjList.size()];
        // set to true for a node when it has been
        // processed by the SPT algorithm;
        // was visited[]

        PriorityQueue<VDist> pq = new PriorityQueue<VDist>();
        // order is based on the distTo[] values
        // stored in the VDist objects

        pq.add(new VDist(start, 0)); // add start node

        while (!pq.isEmpty()) {
            System.out.println(pq);
            int v = pq.remove().getID(); // remove the min distance node
            if (isProcessed[v]) { // already processed?
                System.out.println("  Repeated v:" + v + "; ignored");
                continue;
            }
            isProcessed[v] = true;
            System.out.println("  Removed v:" + v);

            // relax neighbours of v;
            ArrayList<AdjNode> neighbours = adjList.get(v);
            for (AdjNode adj : neighbours) {
                int n = adj.getID();
                if (!isProcessed[n]) { // if neighbour n not already processed
                    int d = distTo[v] + adj.getWeight();
                    if (d < distTo[n]) { // update n if new distance is less
                        distTo[n] = d;
                        parent[n] = v;
                        pq.add(new VDist(n, distTo[n])); // add n to the queue
                        // note: may be adding a second VDist node for 'n'
                        System.out.println("  Added v:" + n);
                    }
                }
            }
        }
    } // end of dijkstra()

    private static ArrayList<ArrayList<AdjNode>> build(String fnm)
    /*
     * Build an adjacency list for a directed weighted graph.
     * 
     * Input data format:
     * - no. of vertices
     * - multiple lines, one for each vertex
     * - each line: no. of pairs, list of (vertex, weight) pairs
     * e.g.
     * 5
     * 3 0 2 1 3 2 1
     * 1 3 3
     * 3 0 3 1 2 4 2
     * 2 2 1 4 1
     * 1 1 1
     * 
     * If the weights are 0, it means the graph is unweighted.
     */
    {
        ArrayList<ArrayList<AdjNode>> adjList = new ArrayList<>();

        try {
            Scanner sc = new Scanner(new File(fnm));

            int numVs = sc.nextInt();
            // a list containing lists of (vertex, weight) pairs

            for (int i = 0; i < numVs; i++) { // for each vertex
                ArrayList<AdjNode> adjs = new ArrayList<>(); // create an adj list
                int numNeighbors = sc.nextInt(); // get no. of pairs
                for (int j = 0; j < numNeighbors; j++)
                    adjs.add(new AdjNode(sc.nextInt(), sc.nextInt()));
                // (vertex id, weight)
                adjList.add(adjs);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Could not read " + fnm);
        }

        return adjList;
    } // end of build()

    private static void print(ArrayList<ArrayList<AdjNode>> adjList) {
        System.out.println("Adj List:");
        for (int i = 0; i < adjList.size(); i++) { // for each vertex
            System.out.print(i + " :");
            ArrayList<AdjNode> adjs = adjList.get(i);
            for (AdjNode adj : adjs) {
                System.out.print(" " + adj);
            }
            System.out.println();
        }
        System.out.println();
    } // end of print()

} // end of Dijkstra class