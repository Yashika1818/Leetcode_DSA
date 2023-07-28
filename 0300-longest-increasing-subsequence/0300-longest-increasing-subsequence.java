class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] dp=new int[nums.length+1][nums.length+2];
        for(int[] d:dp){
            Arrays.fill(d,-1);
        }
        return recursion(nums,0,-1,dp);
    }
    public int recursion(int[] nums,int i,int p,int[][] dp){
        if(i==nums.length)return dp[i][p+1]=0;
        if(dp[i][p+1]!=-1)return dp[i][p+1];
        int take=Integer.MIN_VALUE;
        if(p==-1 || nums[p]<nums[i]){
            take=1+recursion(nums,i+1,i,dp);
        }
        int notTake=recursion(nums,i+1,p,dp);
        
        return dp[i][p+1]=Math.max(take,notTake);
    }
}