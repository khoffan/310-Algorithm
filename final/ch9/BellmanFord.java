// BellmanFord.java
// Andrew Davison, ad@fivedots.coe.psu.ac.th, Dec. 2020

/* Find all the shortest distances from src to the 
   other vertices using Bellman-Ford algorithm. 

   Also detects negative weight cycles.

   Usage:
      > java BellmanFord spData1.txt
      > java BellmanFord spData2.txt

      > java BellmanFord spData3.txt
           - has a negative cycle

*/

import java.io.*;
import java.util.*;

public class BellmanFord {

  private static final int INF = 1000000000;
  // use 1.10^9 to avoid overflow

  private static int numVerts = 0; // set inside buildEdges()

  public static void main(String[] args) {
    if (args.length != 1) {
      System.out.println("Usage: java BellmanFord <data-file>");
      return;
    }
    ArrayList<Edge> edges = buildEdges(args[0]);
    System.out.println("No. of vertices: " + numVerts);

    System.out.println("Edges: " + edges);

    int startNode = 0;

    // initialize parent[]
    int[] parent = new int[numVerts];
    for (int i = 0; i < parent.length; i++)
      parent[i] = -1; // not connected

    // Initialize distances as 'infinite' except for start node
    int[] distTo = new int[numVerts];
    for (int i = 0; i < distTo.length; i++)
      distTo[i] = INF;
    distTo[startNode] = 0;
    System.out.println("\nDists: " + Arrays.toString(distTo));

    // Relax all edges numVerts-1 times
    for (int i = 0; i < numVerts - 1; i++) {
      for (Edge e : edges) {
        int u = e.getFrom();
        int v = e.getTo();
        int weight = e.getWeight();
        if (distTo[u] + weight < distTo[v]) {
          distTo[v] = distTo[u] + weight;
          parent[v] = u;
        }
      }
      System.out.println("  " + (i + 1) +
          ". Dists: " + Arrays.toString(distTo));
    }

    /*
     * Check for negative-weight cycles.
     * The above step guarantees shortest distances if
     * the graph doesn't contain a negative weight cycle.
     * 
     * If we get a shorter path here, then there's a cycle.
     */
    for (Edge e : edges) {
      int u = e.getFrom();
      int v = e.getTo();
      int weight = e.getWeight();
      if ((distTo[u] != INF) &&
          (distTo[u] + weight < distTo[v]))
        System.out.println("Negative weight cycle involving v:" + u +
            " and v:" + v);
    }

    System.out.println("\nParents:");
    for (int i = 0; i < parent.length; i++)
      System.out.println("  " + i + ": " + parent[i]);

    System.out.println("\nShortest dists from " + startNode + ":");
    for (int i = 0; i < distTo.length; i++)
      System.out.println("  to " + i + " == " + distTo[i]);
  } // end of main()

  private static ArrayList<Edge> buildEdges(String fnm)
  /*
   * Input data format:
   * - no. of vertices, no. of edges
   * - triple of numbers: one triple (u v, weight)
   * e.g.
   * 5 5
   * 
   * 0 1 1
   * 0 2 10
   * 
   * 1 3 2
   * 
   * 2 3 -10
   * 
   * 3 4 3
   * 
   */
  {
    ArrayList<Edge> edges = new ArrayList<>();
    try {
      Scanner sc = new Scanner(new File(fnm));
      numVerts = sc.nextInt(); // saved as a global var
      int numEs = sc.nextInt();
      for (int i = 0; i < numEs; i++)
        edges.add(new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt()));
      // from, to, weight
    } catch (FileNotFoundException e) {
      System.out.println("Could not read " + fnm);
    }

    return edges;
  } // end of buildEdges()

} // end of BellmanFord class
