//Memoization(optimized)

class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()==0){
            return s2.equals(s3);
        }
        if(s2.length()==0){
            return s1.equals(s3);
        }
        if(s1.length()+s2.length() !=s3.length())return false;
        int[][] dp=new int[s1.length()][s2.length()];
      
            for(int[] row:dp){
                Arrays.fill(row,-1);
            }
        
        k=0;
        return helper(s1,s2,s3,0,0,dp);
    }
    int k=0;
    public boolean helper(String s1,String s2,String s3,int i,int j,int[][] dp){
        if(i==s1.length() &&  j<s2.length()){
          
            if((s2.substring(j)).equals(s3.substring(k))){
                
                return true;
            }
            
            return false;
        }
         if(j==s2.length() && i<s1.length()){
         
         if(s1.substring(i).equals(s3.substring(k)))return true;
            
            return false;         
            
            
        }
        if(dp[i][j]!=-1)return dp[i][j]==1 ? true :false;
        
        boolean ans=false;
           if(s2.charAt(j)==s3.charAt(k)){
            k=k+1;
            ans=ans | helper(s1,s2,s3,i,j+1,dp);
            k=k-1;
        }
        if(s1.charAt(i)==s3.charAt(k)){
         k=k+1;
             ans|=helper(s1,s2,s3,i+1,j,dp) ;
              k=k-1;
        }
         if(ans==true){
             dp[i][j] = 1;
         }else{
              dp[i][j] = 0;
         }
        return  ans;
    }
    
}