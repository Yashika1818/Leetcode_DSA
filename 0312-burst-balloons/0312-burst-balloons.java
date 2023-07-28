class Solution {
    public int maxCoins(int[] nums) {
        int[][] dp=new int[nums.length+1][nums.length+1];
        for(int i=nums.length-1;i>=0;i--){
            for(int j=0;j<nums.length;j++){
                if(i>j)continue;
                  int maxi=Integer.MIN_VALUE;
        for(int k=i;k<=j;k++){
            int mid=nums[k]*(i-1 == -1 ? 1 : nums[i-1])*(j+1 == nums.length ? 1 : nums[j+1]);
            int left=(k-1==-1? 0 :dp[i][k-1]);
            int right=dp[k+1][j];
            maxi=Math.max(maxi,mid+left+right);
        }
         dp[i][j]=maxi;
            }
        }
        return dp[0][nums.length-1];
    }

}