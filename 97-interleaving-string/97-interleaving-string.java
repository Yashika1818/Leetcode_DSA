//Tabulation 2D(optimized)

class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()==0){
            return s2.equals(s3);
        }
        if(s2.length()==0){
            return s1.equals(s3);
        }
        if(s1.length()+s2.length() !=s3.length())return false;
        boolean[][] dp=new boolean[s1.length()+1][s2.length()+1];
      dp[s1.length()][s2.length()]=true;
       for(int j=0;j<=s2.length();j++){
           dp[s1.length()][j]= s2.substring(j).equals(s3.substring(s1.length()+j)) ;
       }
       for(int i=0;i<=s1.length();i++){
           dp[i][s2.length()]= s1.substring(i).equals(s3.substring(i+s2.length())) ;
       }
   
        for(int i=s1.length()-1;i>=0;i--){
            for(int j=s2.length()-1;j>=0;j--){
                 boolean ans=false;
           if(s2.charAt(j)==s3.charAt(i+j)){
          
            ans=ans | dp[i][j+1];
           
           }
           if(s1.charAt(i)==s3.charAt(i+j)){
           
             ans|=dp[i+1][j] ;
             
            }
                
                dp[i][j]=ans;
            }
        }
 
        return dp[0][0];
    }
  
}