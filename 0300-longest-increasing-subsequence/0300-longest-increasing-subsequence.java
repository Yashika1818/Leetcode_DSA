class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] dp=new int[nums.length+1][nums.length+1];
   
        for(int prev=nums.length-1;prev>=-1;prev--){
            for(int i=nums.length-1;i>=0;i--){
                int take=0,nottake=0;
        if(prev==-1 || nums[prev]<nums[i]){
            take=1+dp[i+1][i+1];
        }
        nottake=dp[prev+1][i+1];
        
        dp[prev+1][i]=Math.max(take,nottake);
            }
        }
        return dp[-1+1][0];
    }

}