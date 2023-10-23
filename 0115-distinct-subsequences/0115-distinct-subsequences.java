class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp=new int[s.length()+1][t.length()+1];
        for(int[] d:dp){
            Arrays.fill(d,-1);
        }
        return rec(s,t,0,0,dp);
    }
    public int rec(String s,String t,int i,int j,int[][] dp){
    if(j==t.length())return dp[i][j]=1;
    if(i==s.length())return dp[i][j]=0;
        if(dp[i][j]!=-1)return dp[i][j];
    int count=0;
    if(s.charAt(i)==t.charAt(j))
    count+=rec(s,t,i+1,j+1,dp);
    count+=rec(s,t,i+1,j,dp);
    return dp[i][j]=count;
    } 
}