class Solution {
    int n;
    int[][][] dp;

    public int solveForAlice(int[] piles, int person, int index, int m) {
        if (index >= n) return 0;

        if (dp[person][index][m] != -1) {
            return dp[person][index][m];
        }

        int result = (person == 1) ? -1 : Integer.MAX_VALUE;
        int stones = 0;

        for (int x = 1; x <= Math.min(2 * m, n - index); x++) {

            if (person == 1) { // Alice

                stones += piles[index + x - 1];

                result = Math.max(
                    result,
                    stones + solveForAlice(
                        piles,
                        0,
                        index + x,
                        Math.max(m, x)
                    )
                );

            } else { // Bob

                result = Math.min(
                    result,
                    solveForAlice(
                        piles,
                        1,
                        index + x,
                        Math.max(m, x)
                    )
                );
            }
        }

        return dp[person][index][m] = result;
    }

    public int stoneGameII(int[] piles) {
        n = piles.length;

        dp = new int[2][n][n + 1];

        for (int person = 0; person < 2; person++) {
            for (int i = 0; i < n; i++) {
                Arrays.fill(dp[person][i], -1);
            }
        }

        return solveForAlice(piles, 1, 0, 1);
    }
}