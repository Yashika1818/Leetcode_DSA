class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] dp=new int[nums.length+1][nums.length+2];
        for(int[] d:dp){
            Arrays.fill(d,-1);
        }
        for(int p=-1;p<nums.length;p++){
            dp[nums.length][p+1]=0;
        }
        for(int i=nums.length-1;i>=0;i--){
            for(int p=nums.length-1;p>=-1;p--){
                int take=Integer.MIN_VALUE;
        if(p==-1 || nums[p]<nums[i]){
            take=1+dp[i+1][i+1];
        }
        int notTake=dp[i+1][p+1];
        
         dp[i][p+1]=Math.max(take,notTake);
            }
        }
        return dp[0][0];
    }

}