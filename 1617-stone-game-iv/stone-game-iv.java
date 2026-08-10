class Solution {

    Boolean[] dp;

    public boolean solveForAlice(int n) {

        if (n == 0)
            return false;

        if (dp[n] != null)
            return dp[n];

        for (int i = 1; i * i <= n; i++) {

            if (solveForAlice(n - i * i) == false) {
                return dp[n] = true;
            }
        }

        return dp[n] = false;
    }

    public boolean winnerSquareGame(int n) {

        dp = new Boolean[n + 1];

        return solveForAlice(n);
    }
}