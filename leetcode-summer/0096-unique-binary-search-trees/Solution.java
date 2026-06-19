class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;

        for (int nodes = 2; nodes <= n; nodes++) {
            for (int root = 1; root <= nodes; root++) {
                int leftNodes = root - 1;
                int rightNodes = nodes - root;

                dp[nodes] += dp[leftNodes] * dp[rightNodes];
            }
        }

        return dp[n];
    }
}