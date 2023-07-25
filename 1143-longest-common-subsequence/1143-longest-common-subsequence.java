class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp=new int[text1.length()+1][text2.length()+1];
        for(int[] d:dp){
            Arrays.fill(d,-1);
        }
        return memoization(text1,text2,0,0,dp);
    }
    public int memoization(String text1,String text2,int i,int j,int[][] dp){
        if(i>=text1.length() || j>=text2.length())return dp[i][j]=0; //base cond
        if(dp[i][j]!=-1)return dp[i][j];
        int len=0;
        if(text1.charAt(i)==text2.charAt(j))
            len=1+memoization(text1,text2,i+1,j+1,dp);
        else
            len=Math.max(memoization(text1,text2,i+1,j,dp),memoization(text1,text2,i,j+1,dp));
        
        return dp[i][j]=len;
    }
}