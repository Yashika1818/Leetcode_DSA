class Solution {
    public int candy(int[] ratings) {
        int dp[]=new int[ratings.length];
        Arrays.fill(dp,1);
        for(int i=0;i<ratings.length;i++){
            
            if(i-1>=0 && ratings[i-1]<ratings[i]){
                dp[i]+=dp[i-1];
            }
            
        }
        
            for(int i=ratings.length-1;i>=0;i--){
            
            if(i+1 <ratings.length && ratings[i+1]<ratings[i]){
                dp[i]=Math.max(dp[i],dp[i+1]+1);
            }
            
        }
        
        int ans=0;
        for(int i=0;i<dp.length;i++){
            ans+=dp[i];
        }
        return ans;
    }
}