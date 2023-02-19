package ch6;

public class Knapsack {
    static int knapsack(int w, int n, int[] weight, int[] value) {
        int[][] dp = new int[n + 1][w + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= w; j++) {
                if (weight[i - 1] <= j) {
                    dp[i][j] = Math.max(value[i - 1] + dp[i - 1][j - weight[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // print the table
        System.out.println("Table:");
        System.out.print("  Wt.\t");
        for (int i = 0; i <= w; i++) {
            System.out.print(i + "\t");
        }
        System.out.println();

        for (int i = 0; i <= n; i++) {
            System.out.print("Item " + i + ":\t");
            for (int j = 0; j <= w; j++) {
                System.out.print(dp[i][j] + "\t");
            }
            System.out.println();
        }

        return dp[n][w];
    }

    public static void main(String[] args) {
        int[] weight = { 5, 4, 7, 5, 3 };
        int[] value = { 11, 13, 14, 12, 9 };
        int w = 10;
        int n = weight.length;
        System.out.println("Max value that can be achieved: " + knapsack(w, n, weight, value));
    }
}
