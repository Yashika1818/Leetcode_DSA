//memoization with one call

class Solution {
    public int minCostClimbingStairs(int[] cost) {
       int[] dp=new int[cost.length+1];
        Arrays.fill(dp,-1);
    int ans1=helper(cost,-1,dp);
    
        
        return ans1;
    }
    
    public int helper(int[] cost,int i,int[] dp){
        
        if(i==cost.length)return 0;
        if(i>cost.length)return (int)1e9;
        if(dp[i+1]!=-1)return dp[i+1];
        int mini=(int)1e9;
        int ans1=0;
        ans1=Math.min(helper(cost,i+1,dp),helper(cost,i+2,dp));
       if(i>=0) ans1+=cost[i];
        
        
        return dp[i+1]=ans1;
    }
}