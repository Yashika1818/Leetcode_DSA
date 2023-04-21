class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] dp=new int[nums.length+1][nums.length+1];
        for(int[] d:dp){
            Arrays.fill(d,-1);
        }
        for(int p=-1;p<nums.length;p++){
            dp[nums.length][p+1]=0;
        }
        for(int i=nums.length-1;i>=0;i--){
            for(int p=i-1;p>=-1;p--){
                int take=0;
                if(p==-1 || nums[p]<nums[i]){
                    take=1+dp[i+1][i+1];
                }
                int nottake=dp[i+1][p+1];

                 dp[i][p+1]=Math.max(take,nottake);
                
            }
        }
        return dp[0][0];
    }
    
//     public int sol(int i,int p,int[] nums,int[][] dp){
//         if(i==nums.length)return dp[i][p+1]=0;
//         if(dp[i][p+1]!=-1)return dp[i][p+1];
//         int take=0;
//         if(p==-1 || nums[p]<nums[i]){
//             take=1+sol(i+1,i,nums,dp);
//         }
//         int nottake=sol(i+1,p,nums,dp);
            
//             return dp[i][p+1]=Math.max(take,nottake);
        
//     }
}