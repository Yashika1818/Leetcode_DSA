class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] dp=new int[nums.length+1][nums.length+1];
        for(int[] d:dp){
            Arrays.fill(d,-1);
        }
        return sol(0,-1,nums,dp);
    }
    
    public int sol(int i,int p,int[] nums,int[][] dp){
        if(i==nums.length)return dp[i][p+1]=0;
        if(dp[i][p+1]!=-1)return dp[i][p+1];
        int take=0;
        if(p==-1 || nums[p]<nums[i]){
            take=1+sol(i+1,i,nums,dp);
        }
        int nottake=sol(i+1,p,nums,dp);
            
            return dp[i][p+1]=Math.max(take,nottake);
        
    }
}