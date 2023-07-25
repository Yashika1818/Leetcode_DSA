class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp=new int[text1.length()+1][text2.length()+1];
        for(int[] d:dp){
            Arrays.fill(d,-1);
        }
        
        for(int i=0;i<=text1.length();i++){
            dp[i][text2.length()]=0;
        }
        for(int j=0;j<=text2.length();j++){
            dp[text1.length()][j]=0;
        }
        for(int i=text1.length()-1;i>=0;i--){
            for(int j=text2.length()-1;j>=0;j--){
                int len=0;
        if(text1.charAt(i)==text2.charAt(j))
            len=1+dp[i+1][j+1];
        else
            len=Math.max(dp[i+1][j],dp[i][j+1]);
        
           dp[i][j]=len;
            }
        }
        return dp[0][0];
    }

}