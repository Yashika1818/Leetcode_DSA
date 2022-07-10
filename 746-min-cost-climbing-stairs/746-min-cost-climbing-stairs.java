//memoization

class Solution {
    public int minCostClimbingStairs(int[] cost) {
       int[] dp=new int[cost.length];
        Arrays.fill(dp,-1);
    int ans1=helper(cost,0,dp);
    int ans2=helper(cost,1,dp);
        
        return Math.min(ans1,ans2);
    }
    
    public int helper(int[] cost,int i,int[] dp){
        
        if(i==cost.length)return 0;
        if(i>cost.length)return (int)1e9;
        if(dp[i]!=-1)return dp[i];
        int mini=(int)1e9;
        int ans1=cost[i]+helper(cost,i+1,dp);
        int ans2=cost[i]+helper(cost,i+2,dp);
        
        return dp[i]=Math.min(ans1,ans2);
    }
}