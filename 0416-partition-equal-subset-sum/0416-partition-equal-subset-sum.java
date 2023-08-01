class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int n:nums){
            sum+=n;
        }
        Boolean[][] dp=new Boolean[nums.length+1][sum+1];
    
        if(sum%2==0)
        return recursion(nums,0,sum/2,0,dp);
        
        return false;
        
    }
    public boolean recursion(int[] nums,int i,int tar,int sum,Boolean[][] dp){
        if(i==nums.length && sum==tar)return dp[i][sum]=true;
        else if(i==nums.length)return dp[i][sum]=false;
        if(dp[i][sum]!=null)return dp[i][sum];
        boolean take=false;
        if(sum+nums[i] <=tar){
            take=recursion(nums,i+1,tar,sum+nums[i],dp);
        }
        
        boolean nottake=recursion(nums,i+1,tar,sum,dp);
        return dp[i][sum]=(take || nottake);
    }
}