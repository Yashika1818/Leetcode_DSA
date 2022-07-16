class Solution {
    int mod=(int)1e9+7;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
      int[][][] memo=new int[m][n][maxMove+1];
        for(int[][] d:memo){
            for(int[] dp:d){
                Arrays.fill(dp,-1);
            }
        }
        int count=dfs(m,n,maxMove,startRow,startColumn,memo);
        return count;
    }
    
    public int dfs(int m, int n, int maxMove, int i, int j,int[][][] dp){
        if(maxMove<0 )return 0;
        if((i<0 || j<0 || i>=m || j>=n ) && maxMove>=0)return 1;
       if(dp[i][j][maxMove]!=-1)return dp[i][j][maxMove];
        int c1=0;
        int h=dfs(m,n,maxMove-1,i+1,j,dp);
          int v=dfs(m,n,maxMove-1,i-1,j,dp);
          int d=dfs(m,n,maxMove-1,i,j-1,dp);
          int r=dfs(m,n,maxMove-1,i,j+1,dp);
        c1=((h+v)%mod+(d+r)%mod)%mod;
        return dp[i][j][maxMove]=c1;
    }
}