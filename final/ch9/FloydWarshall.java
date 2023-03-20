import java.util.*;
import java.io.*;

public class FloydWarshall {
    private static final int INF = 1000000000;
    // use 1.10^9 to avoid overflow

    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.out.println("Usage: java FloydWarshall <data-file>");
            return;
        }
        int[][] mat = buildMat(args[0]);
        print(mat);
        int numVs = mat.length;

        for (int k = 0; k < numVs; k++) {
            for (int i = 0; i < numVs; i++) {
                for (int j = 0; j < numVs; j++)
                    if (mat[i][j] > (mat[i][k] + mat[k][j]))
                        mat[i][j] = mat[i][k] + mat[k][j];
            }
            System.out.println("Update " + (k + 1) + ":");
            print(mat);
        }
    } // end of main()

    private static int[][] buildMat(String fnm)
    /*
     * Build an adjacency matrix.
     * Input data format:
     * - no. of vertices, no. of edges
     * - triple of numbers: one triple (u v, weight)
     * e.g.
     * 
     * 5 9
     * 
     * 0 1 2
     * 0 2 1
     * 0 4 3
     * 
     * 1 3 4
     * 
     * 2 1 1
     * 2 4 1
     * 
     * 3 0 1
     * 3 2 3
     * 3 4 5
     */
    {
        try {
            Scanner sc = new Scanner(new File(fnm));
            int numVs = sc.nextInt();
            int numEs = sc.nextInt();

            // infinities and 0's down diagonal
            int[][] mat = new int[numVs][];
            for (int i = 0; i < numVs; i++) {
                mat[i] = new int[numVs];
                for (int j = 0; j < numVs; j++)
                    mat[i][j] = INF;
                mat[i][i] = 0;
            }

            // add the actual data
            for (int i = 0; i < numEs; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                int weight = sc.nextInt();
                mat[u][v] = weight;
            }
            return mat;
        } catch (FileNotFoundException e) {
            System.out.println("Could not read " + fnm);
            return null;
        }
    } // end of buildMat()

    private static void print(int[][] mat) {
        int numVs = mat.length;

        System.out.print("     ");
        for (int i = 0; i < numVs; i++)
            System.out.printf(" %3d", i);
        System.out.println();
        System.out.println("-".repeat((numVs + 2) * 4));

        for (int i = 0; i < numVs; i++) {
            System.out.printf(" %3d:", i);
            for (int j = 0; j < numVs; j++)
                if (mat[i][j] == INF)
                    System.out.printf("   -");
                else
                    System.out.printf(" %3d", mat[i][j]);
            System.out.println();
        }
        System.out.println();
    } // end of print)

} // end of FloydWarshall class