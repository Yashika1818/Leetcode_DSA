//tabulation
class Solution {
    public int wiggleMaxLength(int[] nums) {
        int[][][] dp=new int[nums.length+1][nums.length+1][3];
   
        for(int i=nums.length-1;i>=0;i--){
            for(int j=i-1;j>=-1;j--){
                for(int k=2;k>=0;k--){
        int not_take=dp[i+1][j+1][k];
        int take=0;
        
        if(k==2 || (nums[i]-nums[j+1]>0 && k==0) ){
            take=1+dp[i+1][i][1];
        }
        if(k==2 || (nums[i]-nums[j+1]<0 && k==1) ){
            take=Math.max(take,1+dp[i+1][i][0]);
        }
                
     dp[i][j+1][k]=  Math.max(not_take,take);
      
                }
            }
        }
    
        return dp[0][0][2];  
    }
    
 
}