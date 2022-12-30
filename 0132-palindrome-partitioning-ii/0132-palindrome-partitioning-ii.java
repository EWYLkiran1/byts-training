class Solution {
    public int minCut(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int[] cutsDp = new int[s.length() + 1];
        Arrays.setAll(cutsDp, index -> Integer.MAX_VALUE);
        cutsDp[s.length()] = -1;

        for(int i = s.length() - 1; i >= 0; i--)
            for(int j = i; j < s.length(); j++)
                if(s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1] == true)) {
                    dp[i][j] = true;
                    cutsDp[i] = Math.min(cutsDp[i], 1 + cutsDp[j + 1]);
                }
        return cutsDp[0];
    }
}
