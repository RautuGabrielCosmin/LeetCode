class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        char[] t1 = text1.toCharArray();
        char[] t2 = text2.toCharArray();

        int[] dp = new int[m + 1];

        for(int i = 1; i <= n; i++){
            int pre = dp[0];
            for(int j = 1; j <= m; j++){
                int temp = dp[j];
                if(t1[i - 1] == t2[j - 1]){
                    dp[j] = pre + 1;
                }else{
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
                pre = temp;
            }
        }
        return dp[m];
    }
}
