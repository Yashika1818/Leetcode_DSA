class Solution {
    public int minInsertions(String s) {
      StringBuilder rev=new StringBuilder(s);
       rev.reverse();
       String r=rev.toString();
       int[][] dp=new int[s.length()+1][s.length()+1];
       for(int[] d:dp){
           Arrays.fill(d,-1);
       }
       return s.length()-sol(s,r,s.length()-1,r.length()-1,dp); 
    }
     public int sol(String s,String r,int i1,int i2,int[][] dp){
        if(i1<0 || i2<0)return dp[i1+1][i2+1]= 0;
        if(dp[i1+1][i2+1]!=-1)return dp[i1+1][i2+1];
        int ans=0;
        if(s.charAt(i1)==r.charAt(i2)){
            ans=1+sol(s,r,i1-1,i2-1,dp);
        }else{
            ans=Math.max(sol(s,r,i1-1,i2,dp),sol(s,r,i1,i2-1,dp));
        }
        return dp[i1+1][i2+1]=ans;
    }
}