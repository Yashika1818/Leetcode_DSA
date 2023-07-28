class Solution {
    public int maxCoins(int[] nums) {
        int[][] dp=new int[nums.length+2][nums.length+2];
        for(int[] d:dp){
            Arrays.fill(d,-1);
        }
        return recursion(nums,0,nums.length-1,dp);
    }
    public int recursion(int[] nums,int i,int j,int[][] dp){
        if(i>j)return 0;
        if(dp[i+1][j+1]!=-1)return dp[i+1][j+1];
        int maxi=Integer.MIN_VALUE;
        for(int k=i;k<=j;k++){
            int mid=nums[k]*(i-1 == -1 ? 1 : nums[i-1])*(j+1 == nums.length ? 1 : nums[j+1]);
            int left=recursion(nums,i,k-1,dp);
            int right=recursion(nums,k+1,j,dp);
            maxi=Math.max(maxi,mid+left+right);
        }
        return dp[i+1][j+1]=maxi;
    }
}