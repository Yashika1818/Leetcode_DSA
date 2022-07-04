//memoization 
class Solution {
    public int wiggleMaxLength(int[] nums) {
        int[][][] dp=new int[nums.length+1][nums.length+1][3];
        for(int[][] d:dp){
            for(int[] row:d){
                Arrays.fill(row,-1);
            }
        }
        return helper(0,-1,2,nums,dp);  
    }
    
    public int helper(int i,int prev_i,int check,int[] nums, int[][][] dp){
        if(i==nums.length){
            return 0;
        }
        if(dp[i][prev_i+1][check]!=-1)return dp[i][prev_i+1][check];
        int not_take=helper(i+1,prev_i,check,nums,dp);
        int take=0;
        //take
        if(prev_i==-1 || (nums[i]-nums[prev_i]>0 && check==0 ) ){
            take=1+helper(i+1,i,1,nums,dp);
        }
        if(prev_i==-1 || (nums[i]-nums[prev_i]<0 && check==1) ){
            take=Math.max(take,1+helper(i+1,i,0,nums,dp));
        }
        return dp[i][prev_i+1][check]=Math.max(not_take,take);
        
    }
}