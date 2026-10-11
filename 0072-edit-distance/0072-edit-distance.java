class Solution {
    public int minDistance(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();

        int[][] dp = new int[l1 + 1][l2 + 1];

        for (int i = 1; i <= l1; ++i) {
            dp[i][0] = i;
        }

        for (int j = 1; j <= l2; ++j) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= l1; ++i)
            for (int j = 1; j <= l2; ++j)
                if (word1.charAt(i - 1) == word2.charAt(j - 1))//same characters
                    dp[i][j] = dp[i - 1][j - 1];//no operation
                else
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1; //replace               //delete        //insert

        return dp[l1][l2];
    }
}
