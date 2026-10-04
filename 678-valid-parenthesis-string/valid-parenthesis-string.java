class Solution {
    Boolean[][] dp;

    public boolean checkValidString(String s) {
        int n = s.length();
        dp = new Boolean[n][n + 1];

        return solve(s, 0, 0);
    }

    public boolean solve(String s, int index, int balance) {

        if (balance < 0) {
            return false;
        }

        if (index == s.length()) {
            return balance == 0;
        }

        if (dp[index][balance] != null) {
            return dp[index][balance];
        }

        char c = s.charAt(index);
        boolean result;

        if (c == '(') {
            result = solve(s, index + 1, balance + 1);
        }
        else if (c == ')') {
            result = solve(s, index + 1, balance - 1);
        }
        else {
            result =
                solve(s, index + 1, balance + 1) || // '('
                solve(s, index + 1, balance - 1) || // ')'
                solve(s, index + 1, balance);       // empty
        }

        return dp[index][balance] = result;
    }
}